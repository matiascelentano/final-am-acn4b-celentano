package com.example.soundwaves.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundwaves.Playlist;
import com.example.soundwaves.R;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {
    private final ImageView playlistImage;
    private final TextView playlistName;
    public PlaylistViewHolder(@NonNull View itemView) {
        super(itemView);
        playlistImage = itemView.findViewById(R.id.playlistRecyclerImage);
        playlistName = itemView.findViewById(R.id.playlistRecyclerTitle);
    }
    public void render(Playlist album){
        playlistImage.setImageResource(album.getImg());
        playlistName.setText(album.getName());
    }
}
