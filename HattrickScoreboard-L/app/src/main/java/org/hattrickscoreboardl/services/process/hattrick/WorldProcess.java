package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.world.Country;
import org.hattrick.models.world.Cup;
import org.hattrick.models.world.Language;
import org.hattrick.models.world.League;
import org.hattrick.models.world.Region;
import org.hattrick.models.world.WorldDetails;
import org.hattrick.models.world.WorldLanguage;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.world.HCountry;
import org.hattrickscoreboardl.database.models.world.HCup;
import org.hattrickscoreboardl.database.models.world.HLanguage;
import org.hattrickscoreboardl.database.models.world.HRegion;
import org.hattrickscoreboardl.database.models.world.HWorldLeague;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

import java.util.ArrayList;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class WorldProcess extends HProcess {

    static final String TAG = (WorldProcess.class).getSimpleName();

    public WorldProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);


        HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG);

        //Check if need update
        if(update != null ){
            if(isUpToDate(update.getFetchedDate(), Validity.WORLD)){
                fireSuccess();
                return;
            }
        }else
        {
            update = new HUpdate();
        }


        ////////////////////////////////////
        // WORLD DETAILS

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(WorldDetails.class, null);
        WorldDetails worlds = (WorldDetails) getResource(TAG, hparam);
        if(worlds == null){
            return;
        }


        for(int i=0; i<worlds.getLeagueList().size();i++) {

            League w = worlds.getLeagueList().get(i);

            //Save or update world
            HWorldLeague world = HWorldLeague.findOne(HWorldLeague.class, "LEAGUE_ID = ?", String.valueOf(w.getLeagueID()));
            if(world == null){
                world = new HWorldLeague();
            }

            world.setActiveTeams(w.getActiveTeams());
            world.setActiveUsers(w.getActiveUsers());
            world.setContinent(w.getContinent());
            world.setCountryID(w.getCountry().getCountryID());
            world.setCupMatchDate(w.getCupMatchDate());
            world.setEconomyDate(w.getEconomyDate());
            world.setEnglishName(w.getEnglishName());
            world.setLeagueID(w.getLeagueID());
            world.setLeagueName(w.getLeagueName());
            world.setMatchRound(w.getMatchRound());
            world.setNationalTeamId(w.getNationalTeamId());
            world.setNumberOfLevels(w.getNumberOfLevels());
            world.setSeason(w.getSeason());
            world.setSeasonOffset(w.getSeasonOffset());
            world.setSeriesMatchDate(w.getSeriesMatchDate());
            world.setShortName(w.getShortName());
            world.setTrainingDate(w.getTrainingDate());
            world.setFetchedDate(HattrickDate.getDateTime());
            world.setU20TeamId(w.getU20TeamId());
            world.setWaitingUsers(w.getWaitingUsers());
            world.setZoneName(w.getZoneName());
            world.save();

            //Save country
            Country c = w.getCountry();
            HCountry country = HCountry.findOne(HCountry.class, "COUNTRY_ID = ?", String.valueOf(c.getCountryID()));
            if(country == null){
                country = new HCountry();
            }
            country.setCountryID(c.getCountryID());
            country.setCountryName(c.getCountryName());
            country.setCurrencyName(c.getCurrencyName());
            country.setCurrencyRate(c.getCurrencyRate());
            country.setDateFormat(c.getDateFormat());
            country.setTimeFormat(c.getTimeFormat());
            country.save();

            //Regions
            //remove
            HRegion.deleteAll(HRegion.class, "COUNTRY_ID = ?", c.getCountryID() + "");

            ArrayList<Region> regions = c.getRegionList();

            //Save new
            for(int j=0;j<regions.size();j++){

                Region r = regions.get(j);
                HRegion region = new HRegion();
                region.setLeagueID(w.getLeagueID());
                region.setCountryID(c.getCountryID());
                region.setRegionID(r.getRegionID());
                region.setRegionName(r.getRegionName());
                region.save();
            }

            //Cups
            //remove
            HCup.deleteAll(HCup.class,"LEAGUE_ID = ?", w.getLeagueID()+"");

            ArrayList<Cup> cp = w.getCupList();

            //Save new
            for(int j=0;j<cp.size();j++){

                Cup cc = cp.get(j);
                HCup cup = new HCup();
                cup.setCupID(cc.getCupID());
                cup.setCupLeagueLevel(cc.getCupLeagueLevel());
                cup.setCupLevel(cc.getCupLevel());
                cup.setCupLevelIndex(cc.getCupLevelIndex());
                cup.setCupName(cc.getCupName());
                cup.setLeagueID(w.getLeagueID());
                cup.setMatchRound(cc.getMatchRound());
                cup.setMatchRoundsLeft(cc.getMatchRoundsLeft());
                cup.save();
            }

        }

        ////////////////////////////////////
        // WORLD LANGUAGE

        hparam = new HattrickParam(WorldLanguage.class, null);
        WorldLanguage languages = (WorldLanguage) getResource(TAG, hparam);
        if(languages == null){
            return;
        }

        for(int i=0; i< languages.getLanguageList().size();i++) {

            Language l = languages.getLanguageList().get(i);

            //Save or update language
            HLanguage lang = HLanguage.findOne(HLanguage.class, "LANGUAGE_ID = ?", String.valueOf(l.getLanguageID()));
            if(lang == null){
                lang = new HLanguage();
            }

            lang.setLanguageID(l.getLanguageID());
            lang.setLanguageName(l.getLanguageName());
            lang.save();

        }

        //Save updater
        update.setProcessName(TAG);
        update.setFetchedDate(HattrickDate.getDateTime());
        update.save();

        fireSuccess();
    }


}
