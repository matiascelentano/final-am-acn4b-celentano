package com.example.myapplication;

public class Song {
    private Integer id;
    private String name;
    private String artist;
    private String albumName;
    private Integer duration;
    private String image;
    private String fileName;
    private String directoryPath;
    //Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getDirectoryPath() {
        return directoryPath;
    }
    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = "asset:///"+ this.getFileName();
    }

    public Song(Integer id, String name,String artist, String albumName, Integer duration,String image, String fileName) {
        setId(id);
        setName(name);
        setArtist(artist);
        setAlbumName(albumName);
        setDuration(duration);
        setFileName(fileName);
        setDirectoryPath(fileName);
    }

}
