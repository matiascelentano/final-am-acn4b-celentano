package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MaterialButton buttonPlayPause = findViewById(R.id.buttonPlayPause);
        MediaPlayer song = MediaPlayer.create(this, R.raw.test_sample);
        buttonPlayPause.addOnCheckedChangeListener((materialButton, b) -> {
            Log.i("blah", "funciona: " + b);
            if(b){
                materialButton.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.pause_button, null));
                song.start();
            }else if(!b && song.isPlaying()) {
                materialButton.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.play_button, null));
                song.pause();
            }else{
                materialButton.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.play_button, null));
            }
        });
        song.setOnCompletionListener(mediaPlayer -> {
            buttonPlayPause.setChecked(false);
        });
    }
}