package com.example.myapplication;

public class Song {
    private Integer id;
    private String name;
    private String albumName;
    private Integer duration;
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

    public Song(Integer id, String name, String albumName, Integer duration, String fileName) {
        setId(id);
        setName(name);
        setAlbumName(albumName);
        setDuration(duration);
        setFileName(fileName);
        setDirectoryPath(fileName);
    }

}
