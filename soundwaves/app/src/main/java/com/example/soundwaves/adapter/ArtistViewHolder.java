package com.example.soundwaves.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundwaves.Artist;
import com.example.soundwaves.R;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    private final ImageView artistImage;
    private final TextView artistName;
    public ArtistViewHolder(@NonNull View itemView) {
        super(itemView);
        artistImage = itemView.findViewById(R.id.artistImage);
        artistName = itemView.findViewById(R.id.artistName);
    }
    public void render(Artist artist){
        artistImage.setImageResource(artist.getImg());
        artistName.setText(artist.getName());
    }
}
