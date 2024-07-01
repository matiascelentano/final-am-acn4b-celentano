package com.example.soundwaves;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_artist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setArtist(27);
        getAlbums(27);
    }
    public void setArtist(int id){
        String urlArtist = "https://api.deezer.com/artist/"+ id;
        StringRequest albumRequest = new StringRequest(Request.Method.GET, urlArtist, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ArrayList<Album> topAlbums = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(response);
                    TextView nombreArtista = findViewById(R.id.artistActivityName);
                    nombreArtista.setText(jsonObject.getString("name"));
                    Log.d("artista", ""+jsonObject.getString("name"));
                    //Iniciando RecyclerView seccion de Albums
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
    public void getAlbums(int id){
        String urlTopAlbums = "https://api.deezer.com/artist/"+ id + "/albums";
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
    public void initRecyclerViewAlbum(ArrayList<Album> topAlbums){
        RecyclerView albumRecyclerView = findViewById(R.id.artistActivityAlbumRecyclerView);
        albumRecyclerView.setLayoutManager(new GridLayoutManager(ArtistActivity.this, 2));
        AlbumAdapter albumAdapter = new AlbumAdapter(topAlbums, ArtistActivity.this);
        albumRecyclerView.setAdapter(albumAdapter);
    }
}