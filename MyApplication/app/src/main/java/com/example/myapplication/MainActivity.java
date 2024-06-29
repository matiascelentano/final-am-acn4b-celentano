package com.example.myapplication;

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
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.AlbumAdapter;
import com.example.myapplication.adapter.ArtistAdapter;
import com.example.myapplication.adapter.PlaylistAdapter;
import com.example.myapplication.adapter.SongAdapter;
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
        initMainActivityRecyclerViewers();
    }
    private void initMainActivityRecyclerViewers(){
        //RecyclerView Seccion Playlists
        RecyclerView playlistSectionRecyclerView = findViewById(R.id.playlistRecyclerView);
        playlistSectionRecyclerView.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL,false));
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(Playlists.getPlaylists());
        playlistSectionRecyclerView.setAdapter(playlistAdapter);

        //RecyclerView Seccion Artistas
        RecyclerView artistSectionRecycleView = findViewById(R.id.artistsRecyclerView);
        artistSectionRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArtistAdapter artistAdapter = new ArtistAdapter(ArtistList.getArtists());
        artistSectionRecycleView.setAdapter(artistAdapter);

        //RecyclerView Seccion Album
        RecyclerView albumSectionRecyclerView = findViewById(R.id.albumRecyclerView);
        albumSectionRecyclerView.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL,false));
        AlbumAdapter albumAdapter = new AlbumAdapter(Albums.getAlbums());
        albumSectionRecyclerView.setAdapter(albumAdapter);
    }
}