package com.example.myapplication.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Album;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder>{
    private ArrayList<Album> albums;
    public AlbumAdapter(ArrayList<Album> albums) {
        this.albums = albums;
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
        holder.render(item);
    }
    @Override
    public int getItemCount() {
        return albums == null ? 0 : albums.size();
    }

}
