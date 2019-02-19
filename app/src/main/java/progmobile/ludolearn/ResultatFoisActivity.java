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

public class ResultatFoisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_fois);
        int nbErreurs = getIntent().getIntExtra(TableMultiplicationActivity.NBERREURS, 0);
        TextView text = (TextView) findViewById(R.id.nbErreurs);
        text.setText(text.getText()+ Integer.toString(nbErreurs));
    }

    public void retour(View view){
        Intent intent = new Intent(this, MathsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        createNotification();
    }

    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();
    }

    private void createNotification(){

        //Récupération du notification Manager
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (getIntent().getStringExtra("activity").equals("fois")){
            int nbErreurs = getIntent().getIntExtra(TableMultiplicationActivity.NBERREURS, 0);
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("LudoLearn")
                    .setContentText("Voici ton score en Multiplication : " + (5-nbErreurs) + "/5")
                    .setSmallIcon(R.drawable.dessin_ecole)
                    .build();

            noti.vibrate = new long[] {0,200,100,200,100,200};
            notificationManager.notify(0,noti);
        } else if (getIntent().getStringExtra("activity").equals("plus")){
            int nbErreurs = getIntent().getIntExtra(TableMultiplicationActivity.NBERREURS, 0);
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("LudoLearn")
                    .setContentText("Voici ton score en Addition : " + (5-nbErreurs) + "/5")
                    .setSmallIcon(R.drawable.dessin_ecole)
                    .build();

            noti.vibrate = new long[] {0,200,100,200,100,200};
            notificationManager.notify(0,noti);
        } else if (getIntent().getStringExtra("activity").equals("moins")) {
            int nbErreurs = getIntent().getIntExtra(TableMultiplicationActivity.NBERREURS, 0);
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("LudoLearn")
                    .setContentText("Voici ton score en Soustraction : " + (5-nbErreurs) + "/5")
                    .setSmallIcon(R.drawable.dessin_ecole)
                    .build();

            noti.vibrate = new long[] {0,200,100,200,100,200};
            notificationManager.notify(0,noti);
        } else if (getIntent().getStringExtra("activity").equals("divise")){
            int nbErreurs = getIntent().getIntExtra(TableMultiplicationActivity.NBERREURS, 0);
            Notification noti = new Notification.Builder(this)
                    .setContentTitle("LudoLearn")
                    .setContentText("Voici ton score en Division : " + (5-nbErreurs) + "/5")
                    .setSmallIcon(R.drawable.dessin_ecole)
                    .build();

            noti.vibrate = new long[] {0,200,100,200,100,200};
            notificationManager.notify(0,noti);
        }
    }
}
