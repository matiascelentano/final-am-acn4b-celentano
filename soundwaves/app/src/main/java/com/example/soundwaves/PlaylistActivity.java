package com.example.soundwaves;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundwaves.adapter.SongAdapter;
import com.google.android.material.button.MaterialButton;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_playlist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        if(intent.hasExtra("id")){
            Playlist playlist = Playlists.findPlaylist(intent.getIntExtra("id",0));
            if(playlist != null){
                ImageView playlistImage = findViewById(R.id.playlistImage);
                playlistImage.setImageResource(playlist.getImg());
                TextView playlistTitle = findViewById(R.id.playlistTitle);
                playlistTitle.setText(playlist.getName());
                initRecyclerView(playlist);
            }
        }
        //Boton Play/Pause
        MaterialButton buttonPlayPause = findViewById(R.id.buttonPlayPause);
        //Preparando Exoplayer
        ExoPlayer player = createExoPlayerPlaylist();
        player.addListener(new Player.Listener(){
            @Override
            //Probando conseguir informacion de la cancion a partir de la metadata
            public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                Log.i("song", "cancion: " + mediaMetadata.title);
            }
            @Override
            //TODO: Implementar funcion para que se resetee la playlist al terminar de reproducir todos los items en el player
            public void onIsPlayingChanged(boolean isPlaying) {
                if (isPlaying) {

                } else {
                    buttonPlayPause.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.play_button, null));
                }
            }
        });
        //Listener en boton play/pause para reproducir/pausar cancion y cambiar de icono
        buttonPlayPause.addOnCheckedChangeListener((materialButton, b) -> {
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
    public ExoPlayer createExoPlayerPlaylist(){
        ExoPlayer player = new ExoPlayer.Builder(this).build();
        MediaItem song1 = MediaItem.fromUri(Uri.parse("asset:///emotion_engine.mp3"));
        MediaItem song2 = MediaItem.fromUri(Uri.parse("asset:///crescendolls.mp3"));
        player.addMediaItem(song1);
        player.addMediaItem(song2);
        player.prepare();
        return player;
    }
    private void initRecyclerView(Playlist playlist){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SongAdapter songAdapter = new SongAdapter(playlist.getSongs());
        recyclerView.setAdapter(songAdapter);
    }
}