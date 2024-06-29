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
        initRecyclerViewPlaylist();
        initRecyclerViewArtist();
        initRecyclerViewAlbum();
    }
    private void initRecyclerViewPlaylist(){
        RecyclerView recyclerView = findViewById(R.id.playlistRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(Playlists.getPlaylists());
        recyclerView.setAdapter(playlistAdapter);
    }
    private void initRecyclerViewArtist(){
        RecyclerView recyclerView = findViewById(R.id.artistsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ArtistAdapter artistAdapter = new ArtistAdapter(ArtistList.getArtists());
        recyclerView.setAdapter(artistAdapter);
    }
    private void initRecyclerViewAlbum(){
        RecyclerView recyclerView = findViewById(R.id.albumRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL,false));
        AlbumAdapter albumAdapter = new AlbumAdapter(Albums.getAlbums());
        recyclerView.setAdapter(albumAdapter);
    }
}