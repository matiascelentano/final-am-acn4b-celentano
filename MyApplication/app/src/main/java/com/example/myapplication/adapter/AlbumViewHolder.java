package com.example.myapplication.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Album;
import com.example.myapplication.R;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    private final ImageView albumImage;
    private final TextView albumName;
    public AlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        albumImage = itemView.findViewById(R.id.albumImageRecycler);
        albumName = itemView.findViewById(R.id.albumTitle);
    }
    public void render(Album album){
        albumImage.setImageResource(album.getImg());
        albumName.setText(album.getName());
    }
}
