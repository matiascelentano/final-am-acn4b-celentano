package com.example.soundwaves.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soundwaves.R;
import com.example.soundwaves.Song;

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
        songImage.setImageResource(song.getImage());
        songTitle.setText(song.getName());
        songArtist.setText(song.getArtist());
        songAlbum.setText(song.getAlbumName());
    }
}
