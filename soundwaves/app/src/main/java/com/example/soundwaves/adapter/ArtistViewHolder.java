package com.example.soundwaves.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.soundwaves.Artist;
import com.example.soundwaves.MainActivity;
import com.example.soundwaves.R;

import org.json.JSONException;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    private final ImageView artistImage;
    private final TextView artistName;
    public ArtistViewHolder(@NonNull View itemView) {
        super(itemView);
        artistImage = itemView.findViewById(R.id.artistImage);
        artistName = itemView.findViewById(R.id.artistName);
    }
    public void render(Artist artist, Context context){
       //TODO: setear imagen a ImageView
        Glide.with(context)
                .asBitmap()
                .load(artist.getImg())
                .into(artistImage);
        artistName.setText(artist.getName());
    }
}
