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

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder>{
    private ArrayList<Album> albums;
    private Context context;
    public AlbumAdapter(ArrayList<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_main_album_recycler, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album item = albums.get(position);
        holder.itemView.setTag(item.getId());
        holder.itemView.setOnClickListener(view -> {
            int id1 = (int) view.getTag();
            Log.i("album", "ID: " + id1);
        });
        holder.render(item, context);
    }
    @Override
    public int getItemCount() {
        return albums == null ? 0 : albums.size();
    }

}
