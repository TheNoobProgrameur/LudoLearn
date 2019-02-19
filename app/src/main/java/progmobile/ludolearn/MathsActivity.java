package progmobile.ludolearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MathsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
    }

    public void plus(View view){
        Intent intent = new Intent(this, CalculsActivity.class);
        intent.putExtra("choixCalculs", "addition");
        startActivity(intent);
    }

    public void moins(View view){
        Intent intent = new Intent(this, CalculsActivity.class);
        intent.putExtra("choixCalculs", "soustraction");
        startActivity(intent);
    }

    public void fois(View view){
        Intent intent = new Intent(this, ChoixTableMultiplication.class);
        startActivity(intent);
    }

    public void divise(View view) {
        Intent intent = new Intent(this, CalculsActivity.class);
        intent.putExtra("choixCalculs", "division");
        startActivity(intent);
    }

}
