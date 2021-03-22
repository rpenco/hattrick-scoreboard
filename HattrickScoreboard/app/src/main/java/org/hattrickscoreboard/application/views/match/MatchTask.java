package org.hattrickscoreboard.application.views.match;

import android.content.Context;

import org.hattrick.constants.HMatchStatus;
import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.downloader.MatchDownloader;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Booking;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Injury;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.models.match.Referee;
import org.hattrickscoreboard.database.models.match.Scorer;
import org.hattrickscoreboard.database.models.match.Substitution;
import org.hattrickscoreboard.database.relations.RMatch;
import org.hattrickscoreboard.database.tables.match.BookingsTable;
import org.hattrickscoreboard.database.tables.match.EventsTable;
import org.hattrickscoreboard.database.tables.match.InjuriesTable;
import org.hattrickscoreboard.database.tables.match.LineupTable;
import org.hattrickscoreboard.database.tables.match.RefereesTable;
import org.hattrickscoreboard.database.tables.match.ScorersTable;
import org.hattrickscoreboard.database.tables.match.SubstitutionsTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class MatchTask extends AsyncFragmentTask implements UpdateListener {

    static final String TAG = (MatchTask.class).getSimpleName();

    public MatchTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RMatch doInBackground(Object... params) {

        int matchID = (int) params[0];
        String sourceSystem = (String) params[1];

        // Else bug on orientation change...
        if (matchID == 0)
            return null;

        // For download or update if need
        MatchDownloader downloader = new MatchDownloader(context, request,
                param, bdd, this);

        Match match = downloader.getMatch(matchID, sourceSystem);
        if (match == null) {
            return null;
        }

        DTeam homeTeam = downloader.getTeam(match.getHomeTeamID());
        DTeam awayTeam = downloader.getTeam(match.getAwayTeamID());

        // match exist
        if (match != null && homeTeam != null && awayTeam != null) {

            // Return infos
            RMatch mResult = new RMatch();
            mResult.setMatch(match);
            mResult.setTeamHome(homeTeam);
            mResult.setTeamAway(awayTeam);

            DLive live = downloader.getLive(match);

            // Live exist
            if (live != null) {

                // Ongoing match
                if (HMatchStatus.ONGOING.equals(live.getMatchStatus())) {

                    String whereClause = LineupTable.COL_MATCH_ID + "="
                            + match.getMatchID() + " AND "
                            + LineupTable.COL_SOURCE_SYSTEM + "='"
                            + match.getSourceSystem() + "'";

                    ArrayList<Event> events = new ArrayList<>();

                    // Get events
                    events = bdd.readAll(EventsTable.class, Event.class,
                            whereClause + " ORDER BY " + EventsTable.COL_MINUTE
                                    + " DESC");

                    mResult.setEvents(events);
                    mResult.setLive(live);
                }

            } else {

                // If match finished
                if (HMatchStatus.FINISHED.equals(match.getStatus())) {

                    ArrayList<LineUp> homeLineUp = downloader.getLineUp(match,
                            match.getHomeTeamID());

                    ArrayList<LineUp> awayLineUp = downloader.getLineUp(match,
                            match.getAwayTeamID());

                    ArrayList<Booking> bookings = new ArrayList<>();
                    ArrayList<Injury> injuryies = new ArrayList<>();
                    ArrayList<Event> events = new ArrayList<>();
                    ArrayList<Referee> referees = new ArrayList<>();
                    ArrayList<Scorer> scorers = new ArrayList<>();
                    ArrayList<Substitution> substitutions = new ArrayList<>();

                    // no-lineup ? No events, injuries, warning...
                    if (homeLineUp != null && awayLineUp != null) {

                        String whereClause = LineupTable.COL_MATCH_ID + "="
                                + match.getMatchID() + " AND "
                                + LineupTable.COL_SOURCE_SYSTEM + "='"
                                + match.getSourceSystem() + "'";

                        // Get bookings
                        bookings = bdd.readAll(BookingsTable.class,
                                Booking.class, whereClause);

                        // Get injuries
                        injuryies = bdd.readAll(InjuriesTable.class,
                                Injury.class, whereClause);

                        // Get events
                        events = bdd.readAll(EventsTable.class, Event.class,
                                whereClause + " ORDER BY "
                                        + EventsTable.COL_MINUTE + " DESC");

                        // Get referees
                        Referee referees1 = (Referee) bdd.read(
                                RefereesTable.class,
                                RefereesTable.COL_REFEREE_ID + "="
                                        + match.getReferee());
                        Referee referees2 = (Referee) bdd.read(
                                RefereesTable.class,
                                RefereesTable.COL_REFEREE_ID + "="
                                        + match.getRefereeAssistant1());
                        Referee referees3 = (Referee) bdd.read(
                                RefereesTable.class,
                                RefereesTable.COL_REFEREE_ID + "="
                                        + match.getRefereeAssistant2());

                        if (referees1 != null) {
                            referees = new ArrayList<Referee>();
                            referees.add(referees1);
                            referees.add(referees2);
                            referees.add(referees3);
                        }
                        // Get scorers
                        scorers = bdd.readAll(ScorersTable.class, Scorer.class,
                                whereClause);

                        // Get substitutions
                        substitutions = bdd.readAll(SubstitutionsTable.class,
                                Substitution.class, whereClause);

                    }

                    // Can be null if match upcoming/ongoing or not full
                    // download
                    mResult.setHomeLineup(homeLineUp);
                    mResult.setAwayLineup(awayLineUp);
                    mResult.setBookings(bookings);
                    mResult.setInjuryies(injuryies);
                    mResult.setReferees(referees);
                    mResult.setScorers(scorers);
                    mResult.setSubstitutions(substitutions);
                    mResult.setEvents(events);
                }
            }

            return mResult;
        }

        return null;

    }

}
