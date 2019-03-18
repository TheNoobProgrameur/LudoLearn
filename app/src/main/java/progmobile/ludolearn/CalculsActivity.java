package progmobile.ludolearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CalculsActivity extends AppCompatActivity {

    public static final String NBERREURS = "nbErreurs";
    public int reponse1;
    public int reponse2;
    public int reponse3;
    public int reponse4;
    public int reponse5;
    public boolean champsComplets = false;   // UTILISE POUR EVITER L'APPUI SUR LE BOUTON AVEC DES CHAMPS SANS REPONSE
    Boolean verificationReponse = false;    // VERIFIE QUE LA CORRECTION A ETE AFFICHEE AVANT DE POUVOIR VOIR SON RESULTAT
    public String choixCalculs = ""; // CATEGORIE DE CALCUL CHOISIE
    public int nbErreurs = 0;

    public TextView operation1;
    public TextView operation2;
    public TextView operation3;
    public TextView operation4;
    public TextView operation5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculs);

        choixCalculs = getIntent().getStringExtra("choixCalculs");
        operation1 = (TextView) findViewById(R.id.operation1);
        operation2 = (TextView) findViewById(R.id.operation2);
        operation3 = (TextView) findViewById(R.id.operation3);
        operation4 = (TextView) findViewById(R.id.operation4);
        operation5 = (TextView) findViewById(R.id.operation5);

        if(choixCalculs.equals("addition")) initAdditions();
        else if(choixCalculs.equals("soustraction")) initSoustractions();
        else if(choixCalculs.equals("division")) initDivision();
        else initMultiplication();
    }

    private void initSoustractions() {
        Random random = new Random();
        int randNum = random.nextInt(100)+1;
        int randNum2 = random.nextInt(100)+1;
        while (randNum2>randNum){
            randNum2 = random.nextInt(100)+1;
        }
        reponse1 = randNum - randNum2;
        operation1.setText(randNum + " - " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        while (randNum2>randNum){
            randNum2 = random.nextInt(100)+1;
        }
        reponse2 = randNum - randNum2;
        operation2.setText(randNum + " - " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        while (randNum2>randNum){
            randNum2 = random.nextInt(100)+1;
        }
        reponse3 = randNum - randNum2;
        operation3.setText(randNum + " - " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        while (randNum2>randNum){
            randNum2 = random.nextInt(100)+1;
        }
        reponse4 = randNum - randNum2;
        operation4.setText(randNum + " - " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        while (randNum2>randNum){
            randNum2 = random.nextInt(100)+1;
        }
        reponse5 = randNum - randNum2;
        operation5.setText(randNum + " - " + randNum2 + " = ");
    }

    private void initAdditions() {
        Random random = new Random();
        int randNum = random.nextInt(100)+1;
        int randNum2 = random.nextInt(100)+1;
        reponse1 = randNum + randNum2;
        operation1.setText(randNum + " + " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        reponse2 = randNum + randNum2;
        operation2.setText(randNum + " + " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        reponse3 = randNum + randNum2;
        operation3.setText(randNum + " + " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        reponse4 = randNum + randNum2;
        operation4.setText(randNum + " + " + randNum2 + " = ");

        randNum = random.nextInt(100) + 1;
        randNum2 = random.nextInt(100)+1;
        reponse5 = randNum + randNum2;
        operation5.setText(randNum + " + " + randNum2 + " = ");
    }

    private void initDivision() {
        Random random = new Random();
        int randNum =0;
        int randNum2 =1 ;
        while ( randNum%randNum2 !=0 || randNum2>randNum){
            randNum = random.nextInt(10)+1;
            randNum2 = random.nextInt(10)+1;
        }
        reponse1 = randNum / randNum2;
        operation1.setText(randNum + " / " + randNum2 + " = ");


        randNum =0;
        randNum2 =1;
        while ( randNum%randNum2 !=0 || randNum2>randNum){
            randNum = random.nextInt(10)+1;
            randNum2 = random.nextInt(10)+1;
        }
        reponse2 = randNum / randNum2;
        operation2.setText(randNum + " / " + randNum2 + " = ");

        randNum =0;
        randNum2 =1;
        while ( randNum%randNum2 !=0 || randNum2>randNum){
            randNum = random.nextInt(10)+1;
            randNum2 = random.nextInt(10)+1;
        }
        reponse3 = randNum / randNum2;
        operation3.setText(randNum + " / " + randNum2 + " = ");

        randNum =0;
        randNum2 =1;
        while ( randNum%randNum2 !=0 || randNum2>randNum){
            randNum = random.nextInt(10)+1;
            randNum2 = random.nextInt(10)+1;
        }
        reponse4 = randNum / randNum2;
        operation4.setText(randNum + " / " + randNum2 + " = ");

        randNum =0;
        randNum2 =1;
        while ( randNum%randNum2 !=0 || randNum2>randNum){
            randNum = random.nextInt(10)+1;
            randNum2 = random.nextInt(10)+1;
        }
        reponse5 = randNum / randNum2;
        operation5.setText(randNum + " / " + randNum2 + " = ");
    }

    private void initMultiplication() {
        int table = getIntent().getIntExtra("table", 1);
        Random random = new Random();
        int randNum = random.nextInt(10) + 1;
        reponse1 = randNum * table;
        operation1.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse2 = randNum * table;
        operation2.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse3 = randNum * table;
        operation3.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse4 = randNum * table;
        operation4.setText(randNum + " x " + table + " = ");

        randNum = random.nextInt(10) + 1;
        reponse5 = randNum * table;
        operation5.setText(randNum + " x " + table + " = ");
    }

    public void valider(View v){
        if(verifChamps()){
            if(!verificationReponse){
                verifierReponses();
                verificationReponse = true;
                Button b = findViewById(R.id.boutonValiderCalculs);
                b.setText("Afficher ton score");
            }
            else{
                Intent intent = new Intent(this, ResultatMathsActivity.class);
                intent.putExtra("nbErreurs", nbErreurs);
                intent.putExtra("choixCalculs",choixCalculs);
                startActivity(intent);
            }
        }
        else Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show();

    }

    // VERIFIE QUE TOUTE LES REPONSES SONT ENTREES
    public Boolean verifChamps(){
        EditText rep1 = (EditText) findViewById(R.id.rep1);
        EditText rep2 = (EditText) findViewById(R.id.rep2);
        EditText rep3 = (EditText) findViewById(R.id.rep3);
        EditText rep4 = (EditText) findViewById(R.id.rep4);
        EditText rep5 = (EditText) findViewById(R.id.rep5);

        if (rep1.getText().toString().equals("") || rep2.getText().toString().equals("") || rep3.getText().toString().equals("") || rep4.getText().toString().equals("") || rep5.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    // VERIFIE SI LES REPONSES SONT CORRECTES
    public void verifierReponses(){
        EditText rep1 = (EditText) findViewById(R.id.rep1);
        EditText rep2 = (EditText) findViewById(R.id.rep2);
        EditText rep3 = (EditText) findViewById(R.id.rep3);
        EditText rep4 = (EditText) findViewById(R.id.rep4);
        EditText rep5 = (EditText) findViewById(R.id.rep5);

        if (Integer.parseInt(rep1.getText().toString()) == reponse1){
            rep1.setBackgroundColor(ContextCompat.getColor(this, R.color.correct));
        }
        else{
            nbErreurs++;
            rep1.setText(reponse1 + "");
            rep1.setBackgroundColor(ContextCompat.getColor(this, R.color.incorrect));
        }

        if (Integer.parseInt(rep2.getText().toString()) == reponse2){
            rep2.setBackgroundColor(ContextCompat.getColor(this, R.color.correct));
        }
        else{
            nbErreurs++;
            rep2.setText(reponse2 + "");
            rep2.setBackgroundColor(ContextCompat.getColor(this, R.color.incorrect));
        }

        if (Integer.parseInt(rep3.getText().toString()) == reponse3){
            rep3.setBackgroundColor(ContextCompat.getColor(this, R.color.correct));
        }
        else{
            nbErreurs++;
            rep3.setText(reponse3 + "");
            rep3.setBackgroundColor(ContextCompat.getColor(this, R.color.incorrect));
        }

        if (Integer.parseInt(rep4.getText().toString()) == reponse4){
            rep4.setBackgroundColor(ContextCompat.getColor(this, R.color.correct));
        }
        else{
            nbErreurs++;
            rep4.setText(reponse4 + "");
            rep4.setBackgroundColor(ContextCompat.getColor(this, R.color.incorrect));
        }

        if (Integer.parseInt(rep5.getText().toString()) == reponse5){
            rep5.setBackgroundColor(ContextCompat.getColor(this, R.color.correct));
        }
        else{
            nbErreurs++;
            rep5.setText(reponse5 + "");
            rep5.setBackgroundColor(ContextCompat.getColor(this, R.color.incorrect));
        }
        rep1.setInputType(InputType.TYPE_NULL);
        rep2.setInputType(InputType.TYPE_NULL);
        rep3.setInputType(InputType.TYPE_NULL);
        rep4.setInputType(InputType.TYPE_NULL);
        rep5.setInputType(InputType.TYPE_NULL);
    }
}