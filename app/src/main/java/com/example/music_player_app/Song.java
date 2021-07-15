package com.example.music_player_app;

public class Song {
    private int image;
    private String name;
    private int mp3;
    private String duration;
    private boolean isPlaying = false;

    public Song(int image, String name, int mp3, String duration) {
        this.image = image;
        this.name = name;
        this.mp3 = mp3;
        this.duration = duration;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public int getMp3() {
        return mp3;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
