package progmobile.ludolearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import progmobile.ludolearn.bd.Question;

public class IntrusActivity extends AppCompatActivity {

    public ArrayList<Integer> intList = new ArrayList<Integer>();
    public List<Question> listeQuestion;
    public int nQuestion=1;
    public ArrayList<RadioButton> listeRadioBouton = new ArrayList<RadioButton>();
    public int boutonVrai;
    public static int nbErreurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrus);

        nbErreurs = 0;

        Question question = new Question(
                "Comiques",
                "Coluche",
                "Fernandel",
                "Dany Boon",
                "Raymond Devos",
                "Intrus");
        question.save();

        Question question2 = new Question(
                "Gastronomie",
                "Cassoulet",
                "Fèves au lard",
                "Chili con carne",
                "Couscous",
                "Intrus");
        question2.save();

        Question question3 = new Question(
                "Prénoms",
                "Camille",
                "Dominique",
                "Claude",
                "Bernard",
                "Intrus");
        question3.save();

        Question question4 = new Question(
                "Informatique",
                "Disque dur",
                "Clé USB",
                "Cd-rom",
                "Carte mère",
                "Intrus");
        question4.save();

        Question question5 = new Question(
                "Sportifs",
                "Vincent Moscato",
                "Éric Cantona",
                "Joël Cantona",
                "Zinédine Zidane",
                "Intrus");
        question5.save();

        Question question6 = new Question(
                "Italie",
                "Florence",
                "Turin",
                "Milan",
                "Capri",
                "Intrus");
        question6.save();

        Question question7 = new Question(
                "Fruits et légumes",
                "Pomme",
                "Kiwi",
                "Tomate",
                "Poivron",
                "Intrus");
        question7.save();

        Question question8 = new Question(
                "Flics de choc",
                "G. I. G. N.",
                "R. A. I. D.",
                "G. I. P. N.",
                "B. R. I. G. A. D.",
                "Intrus");
        question8.save();

        Question question9 = new Question(
                "Jeux télévisés",
                "Slam",
                "Mot de passe",
                "Motus",
                "Les 12 coups de midi",
                "Intrus");
        question9.save();

        Question question10 = new Question(
                "Séries policières françaises",
                "Les Cordier, juge et flic",
                "Navarro",
                "Julie Lescaut",
                "Marc Éliott",
                "Intrus");
        question10.save();

        // Générer ma liste aléatoire de chiffres sans doublons
        int i=0;
        while (i<10){
            int val = new Random().nextInt(10);
            if (!intList.contains(val)){
                intList.add(val);
                i++;
            }
        }

        //Affichage de ma question
        listeQuestion = Question.listAll(Question.class);

        TextView numeroQuestion = (TextView) findViewById(R.id.textViewNumeroQuestion);
        numeroQuestion.setText(nQuestion + "/10");
        TextView text = (TextView) findViewById(R.id.textViewQuestion);
        text.setText(listeQuestion.get(intList.get(nQuestion-1)).getIntitule());
        RadioButton boutonR1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton boutonR2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton boutonR3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton boutonR4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        listeRadioBouton.add(boutonR1);
        listeRadioBouton.add(boutonR2);
        listeRadioBouton.add(boutonR3);
        listeRadioBouton.add(boutonR4);

        Collections.shuffle(listeRadioBouton);
        for (int k =0 ; k<listeRadioBouton.size(); k++){
            if (k==0){
                listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse1());
            } else if (k==1){
                listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse2());
            } else if (k==2){
                listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse3());
            } else {
                listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseVrai());
                boutonVrai=listeRadioBouton.get(k).getId();
            }
        }

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(nQuestion);
    }

    public void valider(View view) {

        RadioButton boutonR1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton boutonR2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton boutonR3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton boutonR4 = (RadioButton) findViewById(R.id.radioButton4);

        if(boutonR1.isChecked()){
            if(boutonR1.getId() !=  boutonVrai)
                nbErreurs++;
        }
        else if (boutonR2.isChecked()){
            if(boutonR2.getId() !=  boutonVrai)
                nbErreurs++;
        }
        else if (boutonR3.isChecked()){
            if(boutonR3.getId() !=  boutonVrai)
                nbErreurs++;
        }else if (boutonR4.isChecked()){
            if(boutonR4.getId() !=  boutonVrai)
                nbErreurs++;
        }else{
            nbErreurs++;
        }

        System.out.println(nbErreurs);

        nQuestion++;

        if (nQuestion <11){
            listeRadioBouton.clear();
            TextView text = (TextView) findViewById(R.id.textViewQuestion);
            text.setText(listeQuestion.get(intList.get(nQuestion-1)).getIntitule());
            TextView numeroQuestion = (TextView) findViewById(R.id.textViewNumeroQuestion);
            numeroQuestion.setText(nQuestion + "/10");

            listeRadioBouton.add(boutonR1);
            listeRadioBouton.add(boutonR2);
            listeRadioBouton.add(boutonR3);
            listeRadioBouton.add(boutonR4);

            Collections.shuffle(listeRadioBouton);
            for (int k =0 ; k<listeRadioBouton.size(); k++){
                if (k==0){
                    listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse1());
                } else if (k==1){
                    listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse2());
                } else if (k==2){
                    listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseFausse3());
                } else {
                    listeRadioBouton.get(k).setText(listeQuestion.get(intList.get(nQuestion-1)).getReponseVrai());
                    boutonVrai=listeRadioBouton.get(k).getId();
                }
            }

            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(nQuestion);
        }else {
            Question.deleteAll(Question.class);
            Intent intent = new Intent(this, ResultatIntrusActivity.class);
            startActivity(intent);
        }
    }
}
