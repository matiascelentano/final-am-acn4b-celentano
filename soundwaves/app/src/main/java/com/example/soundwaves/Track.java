package com.example.soundwaves;

public class Track {
    private int id;
    private String title;
    private String album;
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Track(int id, String title, String album, String image) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.image = image;
    }
}
