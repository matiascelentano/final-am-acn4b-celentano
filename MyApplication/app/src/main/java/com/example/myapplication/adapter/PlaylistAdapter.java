package com.example.myapplication.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Playlist;
import com.example.myapplication.R;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder>{
    private ArrayList<Playlist> playlists;
    public PlaylistAdapter(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_main_playlist_recycler, parent, false);
        return new PlaylistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        Playlist item = playlists.get(position);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(view -> {
            int position1 = (int) view.getTag();
            Log.i("playlist", "Position: " + position);
        });
        holder.render(item);
    }
    @Override
    public int getItemCount() {
        return playlists == null ? 0 : playlists.size();
    }

}
