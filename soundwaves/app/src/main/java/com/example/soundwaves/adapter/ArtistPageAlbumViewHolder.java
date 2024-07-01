package com.example.soundwaves.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.soundwaves.Album;
import com.example.soundwaves.R;

public class ArtistPageAlbumViewHolder extends RecyclerView.ViewHolder{
    private final ImageView albumImage;
    private final TextView albumName;
    public ArtistPageAlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        albumImage = itemView.findViewById(R.id.albumImageRecycler);
        albumName = itemView.findViewById(R.id.albumTitle);
    }
    public void render(Album album, Context context){
        Glide.with(context)
                .asBitmap()
                .load(album.getImg())
                .into(albumImage);
        albumName.setText(album.getName());
    }
}
