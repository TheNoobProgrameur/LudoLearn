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

public class ResultatMathsActivity extends AppCompatActivity {

    private String choixCalcul;
    private int nbErreurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_maths);
        nbErreurs = getIntent().getIntExtra("nbErreurs", 0);
        afficherResultats();
    }

    private void afficherResultats() {
        choixCalcul = getIntent().getStringExtra("choixCalculs");
        TextView textCategorie = (TextView) findViewById(R.id.nomTypeCalcul);
        switch(choixCalcul){
            case "division":
                textCategorie.setText("Catégorie: Division");
                break;

            case "addition":
                textCategorie.setText("Catégorie: Addition");
                break;

            case "soustraction":
                textCategorie.setText("Catégorie: Soustraction");
                break;

            case "multiplication":
                textCategorie.setText("Catégorie: Multiplication");
                break;
            default:
                textCategorie.setText("IL Y A UN PROBLEME DE PARAMETRE DU TYPE DE CALCUL");
                break;

        }

        TextView textErreur = (TextView) findViewById(R.id.nbErreurs);
        textErreur.setText(Integer.toString(nbErreurs) + " erreurs");
    }

    public void reessayerCalcul(View view) {
        Intent intent = new Intent(this, CalculsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("choixCalculs", choixCalcul);
        startActivity(intent);
    }

    private void createNotification(){
        //Récupération du notification Manager
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        int nbErreurs = getIntent().getIntExtra("nbErreurs", 0);
        switch(choixCalcul){
            case "division":
                Notification noti = new Notification.Builder(this)
                        .setContentTitle("LudoLearn")
                        .setContentText("Voici ton score en Division : " + (5-nbErreurs) + "/5")
                        .setSmallIcon(R.drawable.dessin_ecole)
                        .build();

                noti.vibrate = new long[] {0,200,100,200,100,200};
                notificationManager.notify(0,noti);
                break;

            case "addition":
                noti = new Notification.Builder(this)
                        .setContentTitle("LudoLearn")
                        .setContentText("Voici ton score en Addition : " + (5-nbErreurs) + "/5")
                        .setSmallIcon(R.drawable.dessin_ecole)
                        .build();

                noti.vibrate = new long[] {0,200,100,200,100,200};
                notificationManager.notify(0,noti);
                break;

            case "soustraction":
                noti = new Notification.Builder(this)
                        .setContentTitle("LudoLearn")
                        .setContentText("Voici ton score en Soustraction : " + (5-nbErreurs) + "/5")
                        .setSmallIcon(R.drawable.dessin_ecole)
                        .build();

                noti.vibrate = new long[] {0,200,100,200,100,200};
                notificationManager.notify(0,noti);
                break;

            case "multiplication":
                noti = new Notification.Builder(this)
                        .setContentTitle("LudoLearn")
                        .setContentText("Voici ton score en Multiplication : " + (5-nbErreurs) + "/5")
                        .setSmallIcon(R.drawable.dessin_ecole)
                        .build();

                noti.vibrate = new long[] {0,200,100,200,100,200};
                notificationManager.notify(0,noti);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MathsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        createNotification();
    }

    public void retour(View view){
        Intent intent = new Intent(this, MathsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        createNotification();
    }
}