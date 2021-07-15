package com.example.music_player_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Song> songList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        songAdapter = new SongAdapter(songList, this);
        recyclerView.setAdapter(songAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildRecyclerViewData() {
        songList.add(new Song(R.drawable.circles, "Circles", R.raw.circles, "03:35"));
        songList.add(new Song(R.drawable.pompeii, "Pompeii", R.raw.pompeii, "03:52"));
        songList.add(new Song(R.drawable.putitallonme, "Put It All On Me", R.raw.putitallonme, "03:37"));
        songList.add(new Song(R.drawable.shapeofyou, "Shape Of You", R.raw.shapeofyou, "04:23"));
        songList.add(new Song(R.drawable.somethingjustlikethis, "Something Just Like This", R.raw.somethingjustlikethis, "04:07"));
        songList.add(new Song(R.drawable.sunflower, "Sunflower", R.raw.sunflower, "02:41"));
        songList.add(new Song(R.drawable.thelazysong, "The Lazy Song", R.raw.thelazysong, "03:28"));
        songList.add(new Song(R.drawable.uptownfunk, "Uptown Funk", R.raw.uptownfunk, "04:30"));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(int position, Song song, int button) {

        switch (button) {
            case 1:
                if (mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(this, song.getMp3());
                }
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer.pause();
                break;
            case 3:
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                break;
            case 4:
                songList.remove(position);
                songAdapter.notifyDataSetChanged();
                break;
        }
    }
}