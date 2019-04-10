package progmobile.ludolearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import progmobile.ludolearn.bd.Joueur;

import java.util.List;

public class ConnexionActivity extends AppCompatActivity {

    public boolean existe = false;
    public static String nomUser = null;
    public static Bitmap photo;
    public static int progression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
    }

    public void connexion(View view) {
        EditText mail = (EditText) findViewById(R.id.editTextConnexionMail);
        EditText mdp = (EditText) findViewById(R.id.editTextConnexionMdp);

        String valMail, valMdp;

        valMail = mail.getText().toString();
        valMdp = mdp.getText().toString();

        if (valMail.equals("") || valMdp.equals("")) {
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show();
        }

        List<Joueur> liste = Joueur.listAll(Joueur.class);

        for (int i = 0; i<liste.size(); i++ ) {
            if (liste.get(i).getAdresseMail().equals(valMail) && liste.get(i).getMotDePasse().equals(valMdp)) {
                nomUser = liste.get(i).getPrenom() + " !";
                photo = liste.get(i).getPhoto(this);
                progression = liste.get(i).getProgression();
                Intent intent = new Intent(this, choixExerciceActivity.class);
                startActivity(intent);
                existe = true;
            }
        }
        if (!existe){
            Toast.makeText(this, "Erreur dans la saisie des informations !", Toast.LENGTH_SHORT).show();
        }

    }

}
