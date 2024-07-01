package com.example.soundwaves.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundwaves.Playlist;
import com.example.soundwaves.PlaylistAdapterItemOnClickListener;
import com.example.soundwaves.R;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder>{
    private ArrayList<Playlist> playlists;
    private PlaylistAdapterItemOnClickListener itemOnClickListener;
    public PlaylistAdapter(ArrayList<Playlist> playlists, PlaylistAdapterItemOnClickListener itemOnClickListener) {
        this.playlists = playlists;
        this.itemOnClickListener = itemOnClickListener;
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
        Playlist playlist = playlists.get(position);
        holder.itemView.setTag(playlist.getId());
        holder.itemView.setOnClickListener(view -> itemOnClickListener.onPlaylistItemClickListener(playlist, position));
        holder.render(playlist);
    }
    @Override
    public int getItemCount() {
        return playlists == null ? 0 : playlists.size();
    }
}
