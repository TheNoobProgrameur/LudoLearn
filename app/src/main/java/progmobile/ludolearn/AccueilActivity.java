package progmobile.ludolearn;

/**
 * Created by Norman on 31/01/2019.
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AccueilActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private boolean son;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.michael_curtis_no);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        son=true;
    }

    public void pause(View view){
        ImageView img = (ImageView) findViewById(R.id.imagehautparleur);
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            img.setImageResource(R.drawable.loudspeakeroff);
            son=false;
        } else {
            mediaPlayer.start();
            img.setImageResource(R.drawable.loudspeaker);
            son=true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (son==true){
            mediaPlayer.start();
        }
    }


    public void jouer(View view){
        Intent intent = new Intent(this, choixConnectionActivity.class);
        startActivity(intent);
    }
}