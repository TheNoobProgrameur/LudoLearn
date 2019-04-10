package progmobile.ludolearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progression);

        TextView niveau = (TextView) findViewById(R.id.niveau);
        ProgressBar progressBar = (ProgressBar)  findViewById(R.id.progressBar);
        TextView points = (TextView) findViewById(R.id.points);

        niveau.setText(niveau.getText() + String.valueOf(ConnexionActivity.progression/100));

        int variable = ConnexionActivity.progression;
        int reste = variable%100;

        progressBar.setProgress(reste);

        points.setText(String.valueOf(reste)+points.getText());

        System.out.println(variable);
        System.out.println(reste);
    }
}
