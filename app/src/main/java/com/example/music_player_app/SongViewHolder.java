package com.example.music_player_app;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;
    private TextView mTvName;
    private TextView mTvDuration;
    private ItemClickListener itemClickListener;
    private Button mBtnPlay;
    private Button mBtnPause;
    private Button mBtnStop;
    private Button mBtnDelete;

    public SongViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvName = itemView.findViewById(R.id.tvSongName);
        mTvDuration = itemView.findViewById(R.id.tvSongDuration);
        mBtnPlay = itemView.findViewById(R.id.btnPlay);
        mBtnPause = itemView.findViewById(R.id.btnPause);
        mBtnStop = itemView.findViewById(R.id.btnStop);
        mBtnDelete = itemView.findViewById(R.id.btnDelete);

    }

    public void setData(Song song) {
        mIvImage.setImageResource(song.getImage());
        mTvName.setText(song.getName());
        mTvDuration.setText(song.getDuration());
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), song, 1);
                mBtnPlay.setVisibility(View.GONE);
                mBtnPause.setVisibility(View.VISIBLE);
            }
        });
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), song, 2);
                mBtnPause.setVisibility(View.GONE);
                mBtnPlay.setVisibility(View.VISIBLE);
            }
        });
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), song, 3);
                mBtnPause.setVisibility(View.GONE);
                mBtnPlay.setVisibility(View.VISIBLE);
            }
        });
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), song, 4);
            }
        });
    }
}
