package com.example.soundwaves.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundwaves.Artist;
import com.example.soundwaves.R;

import java.util.ArrayList;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistViewHolder>{
    private ArrayList<Artist> artists;
    public ArtistAdapter(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_main_artists_recycler, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        Artist item = artists.get(position);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(view -> {
            int position1 = (int) view.getTag();
            Log.i("artista", "Position: " + position);
        });
        holder.render(item);
    }
    @Override
    public int getItemCount() {
        return artists == null ? 0 : artists.size();
    }

}
