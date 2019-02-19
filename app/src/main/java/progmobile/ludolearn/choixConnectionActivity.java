package progmobile.ludolearn;

/**
 * Created by Norman on 31/01/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class choixConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_connection);
    }

    public void connexion(View view){
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }

    public void inscription(View view){
        Intent intent = new Intent(this, inscriptionActivity.class);
        startActivity(intent);
    }

    public void choixExercices(View view){
        Intent intent = new Intent(this, choixExerciceActivity.class);
        startActivity(intent);
        ConnexionActivity.nomUser = null;
        ConnexionActivity.photo = null;
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}
