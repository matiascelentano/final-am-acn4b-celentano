package com.example.soundwaves;

import java.util.ArrayList;

public class Playlist {
    private Integer id;
    private String name;
    private int img;
    private ArrayList<Song>songs;
    public Integer getId() {
        return id;
    }
    //Getter & Setter
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int imgFileName) {
        this.img = imgFileName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Playlist(Integer id, String name, int img,ArrayList<Song>songs) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.songs = songs;
    }
}
