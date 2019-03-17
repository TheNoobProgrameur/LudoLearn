package progmobile.ludolearn;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import progmobile.ludolearn.bd.Joueur;
import progmobile.ludolearn.bd.Resultat;

public class ResultatCultureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_culture);
        int erreurTotal = 0;
        int questionTotal = 0;
        TextView textScore = (TextView) findViewById(R.id.nbErreursAnglais);
        int nbQuestions = CultureActivity.nbQuestionsAnglais;
        int nbErreurs = nbQuestions - CultureActivity.nbErreursAnglais;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursArtsPlastiques);
        nbQuestions = CultureActivity.nbQuestionsArtsPlastiques;
        nbErreurs = nbQuestions - CultureActivity.nbErreursArtsPlastiques;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursFrancais);
        nbQuestions = CultureActivity.nbQuestionsFrancais;
        nbErreurs = nbQuestions - CultureActivity.nbErreursFrancais;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursHistoireGeo);
        nbQuestions = CultureActivity.nbQuestionsHistoireGeo;
        nbErreurs = nbQuestions - CultureActivity.nbErreursHistoireGeo;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursMaths);
        nbQuestions = CultureActivity.nbQuestionsMaths;
        nbErreurs = nbQuestions - CultureActivity.nbErreursMaths;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursSciences);
        nbQuestions = CultureActivity.nbQuestionsSciences;
        nbErreurs = nbQuestions - CultureActivity.nbErreursSciences;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursSport);
        nbQuestions = CultureActivity.nbQuestionsSport;
        nbErreurs = nbQuestions - CultureActivity.nbErreursSport;
        questionTotal += nbQuestions;
        erreurTotal += nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));

        int scoreFinale = erreurTotal;


        if (ConnexionActivity.nomUser == null) {

            Resultat resultatFinal = new Resultat("Inconu", scoreFinale, "CultureG");
            resultatFinal.save();
        }
        else {
            Resultat resultatFinal = new Resultat(ConnexionActivity.nomUser, scoreFinale, "CultureG");
            resultatFinal.save();
        }


        textScore = (TextView) findViewById(R.id.Resultat);
        textScore.setText(textScore.getText() + "\n"+TabScor());
    }

    public void retour(View view){
        createNotification();
        Intent intent = new Intent(this, choixExerciceActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public String TabScor(){

        String message = "";


        ArrayList<Resultat> res = (ArrayList) Resultat.listAll(Resultat.class);

        int i = 0;

        Iterator<Resultat> itResultat = res.iterator();

        while (itResultat.hasNext() && i < 6 ){
            Resultat resCourant = itResultat.next();
            if(resCourant.getNomJeu().equals("CultureG")){
                message += resCourant.toString()+"\n";
                i++;
            }

        }

        return message;
    }

    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();
    }

    private void createNotification(){

        //Récupération du notification Manager
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("LudoLearn")
                .setContentText("Voici ton score en culture générale: " + (10-CultureActivity.nbErreursSport-CultureActivity.nbErreursSciences-CultureActivity.nbErreursMaths-CultureActivity.nbErreursHistoireGeo-CultureActivity.nbErreursFrancais-CultureActivity.nbErreursArtsPlastiques-CultureActivity.nbErreursAnglais) + "/10")
                .setSmallIcon(R.drawable.dessin_ecole)
                .build();

        noti.vibrate = new long[] {0,200,100,200,100,200};
        notificationManager.notify(0,noti);

    }


    public void reessayer(View view) {
        Intent intent = new Intent(this, CultureActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
