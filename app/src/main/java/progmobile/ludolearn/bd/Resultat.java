package progmobile.ludolearn.bd;

/**
 * Created by abert on 17/03/2019.
 */

import android.support.annotation.NonNull;

import com.orm.SugarRecord;

public class Resultat extends SugarRecord<Resultat>{

    private String nomJouer;
    private int resultat;
    private String nomJeu;

    public  Resultat(){};

    public Resultat(String nomJouer, int resultat, String nomJeu){
        this.nomJouer = nomJouer;
        this.resultat = resultat;
        this.nomJeu = nomJeu;
    }


    public String toString(){
        return nomJouer+" : "+Integer.toString(resultat);
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public String getNomJouer() {
        return nomJouer;
    }

    public void setNomJouer(String nomJouer) {
        this.nomJouer = nomJouer;
    }

    public String getNomJeu() {
        return nomJeu;
    }

    public void setNomJeu(String nomJeu) {
        this.nomJeu = nomJeu;
    }

}
