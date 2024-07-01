package com.example.soundwaves.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.soundwaves.R;
import com.example.soundwaves.Track;

public class ArtistActivityTrackViewHolder extends RecyclerView.ViewHolder{
    private final ImageView trackImage;
    private final TextView trackName;
    private final TextView trackAlbum;
    public ArtistActivityTrackViewHolder(@NonNull View itemView) {
        super(itemView);
        trackImage = itemView.findViewById(R.id.artistTrackImage);
        trackName = itemView.findViewById(R.id.artistTrackTitle);
        trackAlbum = itemView.findViewById(R.id.artistTrackAlbum);
    }
    public void render(Track track, Context context){
        Glide.with(context)
                .asBitmap()
                .load(track.getImage())
                .into(trackImage);
        trackName.setText(track.getTitle());
        trackAlbum.setText(track.getAlbum());
    }
}
