package progmobile.ludolearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import progmobile.ludolearn.bd.Joueur;

import java.util.ArrayList;
import java.util.List;

public class inscriptionActivity extends AppCompatActivity {

    public ImageView img;
    public Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        img=(ImageView) findViewById(R.id.image);

        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photo= (Bitmap) data.getExtras().get("data");
        img.setImageBitmap(photo);
    }

    public void valider(View view){

        EditText nom = (EditText) findViewById(R.id.editTextNom);
        EditText prenom = (EditText) findViewById(R.id.editTextPrenom);
        EditText mail = (EditText) findViewById(R.id.editTextInscriptionMail);
        EditText mdp = (EditText) findViewById(R.id.editTextInscriptionMdp);

        String valNom, valPrenom, valMail, valMdp;

        valNom = nom.getText().toString();
        valPrenom = prenom.getText().toString();
        valMail = mail.getText().toString();
        valMdp = mdp.getText().toString();

        List<Joueur> listeInscrits = Joueur.listAll(Joueur.class);
        ArrayList<String> listeInscritsMail = new ArrayList<String>();
        for (Joueur joueur : listeInscrits){
            listeInscritsMail.add(joueur.getAdresseMail());
        }

        if (valNom.equals("") || valPrenom.equals("") || valMail.equals("") || valMdp.equals("")) {
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show();
        } else if (listeInscritsMail.contains(valMail)){
            Toast.makeText(this, "Cette adresse mail existe déjà !", Toast.LENGTH_SHORT).show();
        } else {
            Joueur joueur = new Joueur(valNom, valPrenom, valMail, valMdp);
            joueur.save();
            joueur.setPhoto(photo, this);
            joueur.save();
            Intent intent = new Intent(this, ConnexionActivity.class);
            startActivity(intent);
        }
    }
}
