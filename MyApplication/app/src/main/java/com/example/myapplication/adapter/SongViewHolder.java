package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.Song;

public class SongViewHolder extends RecyclerView.ViewHolder {
    private final ImageView songImage;
    private final TextView songTitle;
    private final TextView songArtist;
    private final TextView songAlbum;
    public SongViewHolder(@NonNull View itemView) {
        super(itemView);
        songImage = itemView.findViewById(R.id.songImage);
        songTitle = itemView.findViewById(R.id.songTitle);
        songArtist = itemView.findViewById(R.id.songArtist);
        songAlbum = itemView.findViewById(R.id.songAlbum);
    }
    public void render(Song song){
        int id1 = R.drawable.album_cover;
        int id2 = R.drawable.album_cover2;
        int randomNum = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
        if(randomNum == 1){
            songImage.setImageResource(id1);
        }else {
            songImage.setImageResource(id2);
        }
        songTitle.setText(song.getName());
        songArtist.setText(song.getArtist());
        songAlbum.setText(song.getAlbumName());
    }
}
