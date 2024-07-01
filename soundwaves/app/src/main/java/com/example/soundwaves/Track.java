package com.example.soundwaves;

public class Track {
    private int id;
    private String title;
    private String album;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Track(int id, String title, String album) {
        this.id = id;
        this.title = title;
        this.album = album;
    }
}
