package com.example.soundwaves;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.soundwaves.adapter.AlbumAdapter;
import com.example.soundwaves.adapter.ArtistAdapter;
import com.example.soundwaves.adapter.PlaylistAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PlaylistAdapterItemOnClickListener {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
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
        getTopArtists();
        getTopAlbums();
        initMainActivityRecyclerViewers();
    }
    private void initMainActivityRecyclerViewers(){
        //RecyclerView Seccion Playlists
        RecyclerView playlistSectionRecyclerView = findViewById(R.id.playlistRecyclerView);
        playlistSectionRecyclerView.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL,false));
        PlaylistAdapter playlistAdapter = new PlaylistAdapter(Playlists.playlists, this);
        playlistSectionRecyclerView.setAdapter(playlistAdapter);
    }

    @Override
    public void onItemClickListener(Playlist playlist, int position) {
        Intent intent = new Intent(this, PlaylistActivity.class);
        intent.putExtra("id",playlist.getId());
        startActivity(intent);
    }
    public void getTopArtists(){
        String urlTopArtists = "https://api.deezer.com/chart/0/artists";
        StringRequest request = new StringRequest(Request.Method.GET, urlTopArtists, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ArrayList<Artist> topArtists = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray result = jsonObject.getJSONArray("data");
                    for (int i = 0; i < result.length(); i++){
                        JSONObject item = result.getJSONObject(i);
                        Log.i("artista","" + item.getInt("id") + " " + item.getString("name") + " " + item.getString("picture_big"));
                        topArtists.add(new Artist(item.getInt("id"),item.getString("name"),item.getString("picture_big")));
                    }
                    //Iniciando RecyclerView seccion de artistas
                    initRecyclerViewArtist(topArtists);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
    public void getTopAlbums(){
        String urlTopAlbums = "https://api.deezer.com/chart/0/albums";
        StringRequest albumRequest = new StringRequest(Request.Method.GET, urlTopAlbums, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ArrayList<Album> topAlbums = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray result = jsonObject.getJSONArray("data");
                    Log.d("albums", "onResponse: ENTRO A LA FUNCION");
                    for (int j = 0; j < result.length(); j++){
                        JSONObject item = result.getJSONObject(j);
                        topAlbums.add(new Album(item.getInt("id"),item.getString("title"),item.getString("cover_medium")));
                        Log.i("album","" + topAlbums.size());
                    }
                    //Iniciando RecyclerView seccion de Albums
                    initRecyclerViewAlbum(topAlbums);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorVolley", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(albumRequest);
    }

    public void initRecyclerViewArtist(ArrayList<Artist> topArtists){
        RecyclerView artistSectionRecycleView = findViewById(R.id.artistsRecyclerView);
        artistSectionRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        ArtistAdapter artistAdapter = new ArtistAdapter(topArtists, MainActivity.this);
        artistSectionRecycleView.setAdapter(artistAdapter);
    }
    public void initRecyclerViewAlbum(ArrayList<Album> topAlbums){
        RecyclerView albumRecyclerView = findViewById(R.id.albumRecyclerView);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        AlbumAdapter albumAdapter = new AlbumAdapter(topAlbums, MainActivity.this);
        albumRecyclerView.setAdapter(albumAdapter);
    }

}