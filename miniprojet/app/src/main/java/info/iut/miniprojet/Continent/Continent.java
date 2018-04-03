package info.iut.miniprojet.Continent;

/**
 * Created by dqminh on 27/03/2018.
 */

public class Continent {

    private String nom;

    public Continent(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString(){
        return nom;
    }
}
