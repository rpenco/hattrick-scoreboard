package org.hattrickscoreboard.application.views.players;

import android.util.Log;

import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;

import java.util.ArrayList;

public class PlayersFunction {

    static String TAG = (PlayersFunction.class).getSimpleName();

    ArrayList<DPlayer> players;

    int totalTSI;
    double totalSalary;
    ArrayList<Integer> totalNationalities = new ArrayList<Integer>();
    ArrayList<DPlayer> totalInjuries = new ArrayList<DPlayer>();
    ArrayList<DPlayer> totalSpeciality = new ArrayList<DPlayer>();
    ArrayList<DPlayer> totalReds = new ArrayList<DPlayer>();
    ArrayList<DPlayer> totalYellows = new ArrayList<DPlayer>();

    int averageTSI;
    double averageSalary;
    double averageAgeYears;
    double averageAgeDays;
    double averageForme;
    double averageEndurance;
    double averageExperience;

    private DTeam team;

    public PlayersFunction(ArrayList<DPlayer> playersList, DTeam team) {
        this.players = playersList;
        this.team = team;
        perform();
    }

    public int getTotalTSI() {
        return totalTSI;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public ArrayList<Integer> getTotalNationalities() {
        return totalNationalities;
    }

    public ArrayList<DPlayer> getTotalInjuries() {
        return totalInjuries;
    }

    public ArrayList<DPlayer> getTotalSpeciality() {
        return totalSpeciality;
    }

    public ArrayList<DPlayer> getTotalReds() {
        return totalReds;
    }

    public ArrayList<DPlayer> getTotalYellows() {
        return totalYellows;
    }

    public int getAverageTSI() {
        return averageTSI;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public double getAverageAgeYears() {
        return averageAgeYears;
    }

    public double getAverageAgeDays() {
        return averageAgeDays;
    }

    public double getAverageForme() {
        return averageForme;
    }

    public double getAverageEndurance() {
        return averageEndurance;
    }

    public double getAverageExperience() {
        return averageExperience;
    }

    void perform() {

        // All players - trainer
        int nbPlayers = players.size() - 1;
        int totalAgeYears = 0;
        int totalAgeDays = 0;
        int totalForme = 0;
        int totalEndurance = 0;
        int totalExperience = 0;

        // All
        for (DPlayer player : players) {

            // Pass trainer..
            if (player.getPlayerID() == team.getTrainerID()) {
                Log.i(TAG, "Trainer found: " + player.getFirstname() + " "
                        + player.getLastName());
                continue;
            }

            if (!totalNationalities.contains(player.getCountryID())) {
                totalNationalities.add(player.getCountryID());
            }

            // totalTSI
            totalTSI += player.getTSI();

            // totalSalary
            totalSalary += player.getSalary();

            // totalAgeYears
            totalAgeYears += player.getAge();

            // totalAgeDays
            totalAgeDays += player.getAgeDays();

            // totalForme
            totalForme += player.getForm();

            // totalEndurance
            totalEndurance += player.getStaminaSkill();

            // totalExperience
            totalExperience += player.getExperience();

            // totalInjuries
            if (player.getInjuryLevel() > -1) {
                totalInjuries.add(player);
            }

            // totalSpeciality
            if (player.getSpecialty() != 0) {
                totalSpeciality.add(player);
            }

            // totalYellows
            if (player.getCards() > 0 && player.getCards() < 3) {
                totalYellows.add(player);
            }

            // totalReds
            if (player.getCards() == 3) {
                totalReds.add(player);
            }

        }

        // Average

        // averageTSI;
        averageTSI = Math.round(totalTSI / nbPlayers);

        // averageSalary;
        averageSalary = Math.round(totalSalary / nbPlayers);

        // averageAgeYears;
        averageAgeYears = Math.round(totalAgeYears / nbPlayers);

        // averageAgeDays;
        averageAgeDays = Math.round(totalAgeDays / nbPlayers);

        // averageForme;
        averageForme = Math.round(totalForme / nbPlayers);

        // averageEndurance;
        averageEndurance = Math.round(totalEndurance / nbPlayers);

        // averageExperience;
        averageExperience = Math.round(totalExperience / nbPlayers);

    }

}