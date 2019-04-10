package progmobile.ludolearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class choixExerciceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_exercice);
        TextView text = (TextView) findViewById(R.id.textViewPersonne);
        Button progresion = (Button) findViewById(R.id.boutonProgression);
        ImageView img = (ImageView) findViewById(R.id.imageViewPhoto);
        if (ConnexionActivity.nomUser == null) {
            ConnexionActivity.nomUser = "toi !";
            text.setText(text.getText() + ConnexionActivity.nomUser);
            progresion.setVisibility(View.INVISIBLE);

        } else if (ConnexionActivity.nomUser != "toi !") {
            text.setText(text.getText() + ConnexionActivity.nomUser);
            progresion.setVisibility(View.VISIBLE);
            progresion.setText("Niveau : " + String.valueOf(ConnexionActivity.progression/100));
        }else{
            progresion.setVisibility(View.INVISIBLE);
        }

        if (ConnexionActivity.photo != null) {
            img.setImageBitmap(ConnexionActivity.photo);
        }
    }

    public void maths(View view){
        Intent intent = new Intent(this, MathsActivity.class);
        startActivity(intent);
    }

    public void culture(View view){
        Intent intent = new Intent(this, CultureActivity.class);
        startActivity(intent);
    }

    public void pendu(View view){
        Intent intent = new Intent(this, PenduActivity.class);
        startActivity(intent);
    }

    public void intrus(View view){
        Intent intent = new Intent(this, IntrusActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AccueilActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void progressionPage(View view){
        Intent intent = new Intent(this, ProgressionActivity.class);
        startActivity(intent);
    }

}
