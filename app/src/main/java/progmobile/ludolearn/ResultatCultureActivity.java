package progmobile.ludolearn;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultatCultureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_culture);

        TextView textScore = (TextView) findViewById(R.id.nbErreursAnglais);
        int nbQuestions = CultureActivity.nbQuestionsAnglais;
        int nbErreurs = nbQuestions - CultureActivity.nbErreursAnglais;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursArtsPlastiques);
        nbQuestions = CultureActivity.nbQuestionsArtsPlastiques;
        nbErreurs = nbQuestions - CultureActivity.nbErreursArtsPlastiques;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursFrancais);
        nbQuestions = CultureActivity.nbQuestionsFrancais;
        nbErreurs = nbQuestions - CultureActivity.nbErreursFrancais;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursHistoireGeo);
        nbQuestions = CultureActivity.nbQuestionsHistoireGeo;
        nbErreurs = nbQuestions - CultureActivity.nbErreursHistoireGeo;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursMaths);
        nbQuestions = CultureActivity.nbQuestionsMaths;
        nbErreurs = nbQuestions - CultureActivity.nbErreursMaths;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursSciences);
        nbQuestions = CultureActivity.nbQuestionsSciences;
        nbErreurs = nbQuestions - CultureActivity.nbErreursSciences;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
        textScore = (TextView) findViewById(R.id.nbErreursSport);
        nbQuestions = CultureActivity.nbQuestionsSport;
        nbErreurs = nbQuestions - CultureActivity.nbErreursSport;
        textScore.setText(textScore.getText() + Integer.toString(nbErreurs) +"/"+ Integer.toString(nbQuestions));
    }

    public void retour(View view){
        createNotification();
        Intent intent = new Intent(this, choixExerciceActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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



}
