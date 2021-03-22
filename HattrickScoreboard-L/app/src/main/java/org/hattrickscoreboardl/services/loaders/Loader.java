package org.hattrickscoreboardl.services.loaders;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class Loader {

    double nbLoadStart = 0;
    double nbLoadFinished = 0;


    public double getNbLoadStart(){
        return nbLoadStart;
    }

    public double getNbLoadFinished(){
        return nbLoadFinished;
    }

    public void reset(){
        nbLoadFinished = nbLoadStart = 0;
    }

    public double getProgress(){
        return (nbLoadFinished / nbLoadStart);
    }

    public void addLoad(){
        nbLoadStart++;
    }

    public void addLoad(int nb){
        nbLoadStart += nb;
    }

    public void addFinishLoad(){
        nbLoadFinished++;
    }

    public void addFinishLoad(int nb){
        nbLoadFinished += nb;
    }


    @Override
    public String toString() {
        return "Loading: " + String.format("%.2f", ((getProgress() * 100))) + "%, " + getNbLoadFinished() + "/" + getNbLoadStart();
    }
}
