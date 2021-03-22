package org.hattrickscoreboardl.utils.statistics;

import org.hattrick.constants.player.HSpecialtyID;
import org.hattrickscoreboardl.database.models.players.HPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by romain
 * on 10/12/2014.
 */
public class PlayersStats {

    static String TAG = (PlayersStats.class).getSimpleName();


    public static List<HPlayer> Top11(List<HPlayer> players){

        Collections.sort(players, new Comparator<HPlayer>() {
            public int compare(HPlayer o1, HPlayer o2) {
                if (o1.getTSI() == o2.getTSI())
                    return 0;
                return o1.getTSI() < o2.getTSI() ? -1 : 1;
            }
        });

        return players.subList(0, ((players.size() < 11 )? players.size() : 11));
    }

    ///////////////////////
    // TSI

    public static int TSITotal(List<HPlayer> players){
        int res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getTSI();
            }
        }
        return res;
    }

    ///////////////////////
    // SALARY

    public static double SalaryTotal(List<HPlayer> players){
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getSalary();
            }
        }
        return res;
    }

    ///////////////////////
    // INJURIES

    public static List<HPlayer> InjuriesBruised(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {
                //Bruised
                if(player.getInjuryLevel() == 0){
                    res.add(player);
                }
            }
        }
        return res;
    }

    public static List<HPlayer> InjuriesBadly(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {
                //Bruised
                if(player.getInjuryLevel() > 0){
                    res.add(player);
                }
            }
        }
        return res;
    }

    ///////////////////////
    // CARDS

    public static List<HPlayer> YellowCards(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {
                //Bruised
                if(player.getCards() > 0 && player.getCards() < 3){
                    res.add(player);
                }
            }
        }
        return res;
    }

    public static List<HPlayer> RedCards(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {
                //Bruised
                if(player.getCards() == 3){
                    res.add(player);
                }
            }
        }
        return res;
    }

    ///////////////////////
    // YEARS OLD

    public static int AgeAverage(List<HPlayer> players){
        int res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += (player.getAge() * 110 + player.getAgeDays());
            }
            return (res/players.size()) / 110;
        }
        return 0;
    }

    public static int AgeDayAverage(List<HPlayer> players){
        int res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += (player.getAge() * 110 + player.getAgeDays());
            }
            return (res/players.size()) % 110;
        }
        return 0;
    }

    ///////////////////////
    // AVERAGE PLAYER

    public static double KeeperAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getKeeperSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double DefenderAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getDefenderSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double PlaymakerAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getPlaymakerSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double WingerAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getWingerSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double PassingAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getPassingSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double ScorerAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getScorerSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double SetPiecesAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getSetPiecesSkill();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double AggressivenessAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getAggressiveness();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double AgreabilityAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getAgreeability();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double HonestyAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getHonesty();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double StarsAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getLastMatchRating();
            }
            return (res/players.size());
        }
        return 0;
    }

    public static double StarsEndOfGameAverage(List<HPlayer> players) {
        double res = 0;
        if(players != null) {
            for (HPlayer player : players) {
                res += player.getLastMatchRatingEndOfGame();
            }
            return (res/players.size());
        }
        return 0;
    }

    ///////////////////////
    // Skills

   public static List<HPlayer> Technicians(List<HPlayer> players){
       ArrayList<HPlayer> res = new ArrayList<HPlayer>();
       if(players != null) {
           for (HPlayer player : players) {

               if(player.getSpecialty() == HSpecialtyID.TECHNICAL){
                   res.add(player);
               }
           }
       }
       return res;
   }

    public static List<HPlayer> Unpredictables(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {

                if(player.getSpecialty() == HSpecialtyID.UNPREDICTABLE){
                    res.add(player);
                }
            }
        }
        return res;
    }

    public static List<HPlayer> Powerfull(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {

                if(player.getSpecialty() == HSpecialtyID.POWERFUL){
                    res.add(player);
                }
            }
        }
        return res;
    }

    public static List<HPlayer> HeadPlayers(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {

                if(player.getSpecialty() == HSpecialtyID.HEAD_SPECIALIST){
                    res.add(player);
                }
            }
        }
        return res;
    }

    public static List<HPlayer> QuickPlayers(List<HPlayer> players){
        ArrayList<HPlayer> res = new ArrayList<HPlayer>();
        if(players != null) {
            for (HPlayer player : players) {

                if(player.getSpecialty() == HSpecialtyID.QUICK){
                    res.add(player);
                }
            }
        }
        return res;
    }

}
