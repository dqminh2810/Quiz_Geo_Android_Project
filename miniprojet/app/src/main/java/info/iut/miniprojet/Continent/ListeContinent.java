package info.iut.miniprojet.Continent;

import java.util.ArrayList;

/**
 * Created by dqminh on 27/03/2018.
 */

public class ListeContinent {

    private ArrayList<Continent> listeContinent;

    public ListeContinent() {
        listeContinent =new ArrayList<Continent>();
    }
    public int size() {
        return listeContinent.size();
    }

    public Continent get(int position) {
        return listeContinent.get(position);
    }

    public void construireListe(){
        listeContinent.add(new Continent("ALL"));
        listeContinent.add(new Continent("ASIA"));
        listeContinent.add(new Continent("AMERICA"));
        listeContinent.add(new Continent("EUROPE"));
    }


}
