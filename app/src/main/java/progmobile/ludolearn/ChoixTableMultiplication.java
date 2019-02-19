package progmobile.ludolearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class ChoixTableMultiplication extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_table_multiplication);

        NumberPicker choixNum = (NumberPicker) findViewById(R.id.table);
        choixNum.setMinValue(0);
        choixNum.setMaxValue(10);

    }

    public void valider(View view){
        NumberPicker choixNum = (NumberPicker) findViewById(R.id.table);
        Intent intent = new Intent(this,CalculsActivity.class);
        intent.putExtra("choixCalculs", "multiplication");
        intent.putExtra("table", choixNum.getValue());
        startActivity(intent);
    }
}
