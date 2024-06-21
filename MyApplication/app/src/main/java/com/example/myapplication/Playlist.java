package com.example.myapplication;

public class Playlist {
    private Integer id;
    private String name;
    private int img;
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

    public Playlist(Integer id, String name, int img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }
}
