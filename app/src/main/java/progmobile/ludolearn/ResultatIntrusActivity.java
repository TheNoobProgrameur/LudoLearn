package progmobile.ludolearn;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import progmobile.ludolearn.bd.Joueur;

public class ResultatIntrusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_intrus);

        TextView textScore = (TextView) findViewById(R.id.nbErreurs);
        int nbErreurs = IntrusActivity.nbErreurs;
        int resultat = 10-nbErreurs;
        textScore.setText(textScore.getText() + Integer.toString(resultat) +"/10");

        //Progression
        List<Joueur> liste = Joueur.listAll(Joueur.class);
        for (int i = 0; i<liste.size(); i++ ) {
            if (liste.get(i).getPrenom().equals(ConnexionActivity.nomUser.split(" ")[0])) {
                int addProgression = resultat;
                ConnexionActivity.progression = ConnexionActivity.progression+addProgression;
                liste.get(i).setProgression(ConnexionActivity.progression);
                liste.get(i).save();
                Toast.makeText(ResultatIntrusActivity.this, "Votre niveau a augmenté de " + addProgression + " points" , Toast.LENGTH_LONG).show();
            }
        }
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
                .setContentText("Voici ton score au jeu de l'intrus: " + (10-IntrusActivity.nbErreurs + "/10"))
                .setSmallIcon(R.drawable.dessin_ecole)
                .build();

        noti.vibrate = new long[] {0,200,100,200,100,200};
        notificationManager.notify(0,noti);

    }

    public void reessayer(View view) {
        Intent intent = new Intent(this, IntrusActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
