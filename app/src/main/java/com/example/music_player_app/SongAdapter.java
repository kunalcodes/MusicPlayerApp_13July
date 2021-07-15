package com.example.music_player_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private ArrayList<Song> songList;
    private ItemClickListener itemClickListener;

    public SongAdapter(ArrayList<Song> songArrayList, ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
        this.songList = songArrayList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new SongViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
      Song song = songList.get(position);
      holder.setData(song);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
