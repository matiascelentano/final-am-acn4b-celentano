package com.example.soundwaves.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundwaves.Album;
import com.example.soundwaves.R;

import java.util.ArrayList;

public class ArtistActivityTrackAdapter extends RecyclerView.Adapter<ArtistActivityTrackViewHolder>{
    private ArrayList<Album> tracks;
    private Context context;
    public ArtistActivityTrackAdapter(ArrayList<Album> albums, Context context) {
        this.tracks = albums;
        this.context = context;
    }
    @NonNull
    @Override
    public ArtistActivityTrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_artist_track, parent, false);
        return new ArtistActivityTrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistActivityTrackViewHolder holder, int position) {
        Album item = tracks.get(position);
        holder.itemView.setTag(item.getId());
        holder.itemView.setOnClickListener(view -> {
            int id1 = (int) view.getTag();
            Log.i("track", "ID: " + id1);
        });
        holder.render(item, context);
    }
    @Override
    public int getItemCount() {
        return tracks == null ? 0 : tracks.size();
    }
}
