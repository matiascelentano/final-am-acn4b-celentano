package com.example.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.*;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.MetadataRetriever;

import com.google.android.material.button.MaterialButton;

import java.util.Arrays;


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
        //Preparando Exoplayer
        ExoPlayer player = new ExoPlayer.Builder(this).build();
        MediaItem song1 = MediaItem.fromUri(Uri.parse("asset:///daft_punk_crescendolls.mp3"));
        player.setMediaItem(song1);
        player.prepare();
        //Probando conseguir informacion de la cancion a partir de la metadata
        //MediaMetadata mediaMetadata = player.getMediaMetadata();
       // Log.i("song", "cancion: " + mediaMetadata.title);
        player.addListener(new Player.Listener() {
                   @Override
                   public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                       //Now get posted values like this
                       Log.i("song", "cancion: " + mediaMetadata.title);
                   }
               }
        );

        //Listener en boton play/pause para reproducir/pausar cancion y cambiar de icono
        MaterialButton buttonPlayPause = findViewById(R.id.buttonPlayPause);
        buttonPlayPause.addOnCheckedChangeListener((materialButton, b) -> {
            Log.i("blah", "funciona: " + b);
            if (b) {
                materialButton.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.pause_button, null));
                player.play();
            } else if (!b && player.isPlaying()) {
                materialButton.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.play_button, null));
                player.pause();
            } else {
                materialButton.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.play_button, null));
            }
        });
    }
}