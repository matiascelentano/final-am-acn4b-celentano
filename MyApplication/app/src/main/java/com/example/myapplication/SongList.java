package com.example.myapplication;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class SongList {
    public static ArrayList<Song> getSongs(){
        int d1 = R.drawable.album_cover2;
        int d2 = R.drawable.album_cover;
        Song song1 = new Song(1,"Emotion Engine","dazegxd", "vKiss",250,d1,"emotion_engine");
        Song song2 = new Song(2,"Crescendolls","Daft Punk", "Discovery",250,d2,"crescendolls");
        Song song3 = new Song(3,"Emotion Engine","dazegxd", "vKiss",250,d1,"emotion_engine");
        Song song4 = new Song(4,"Crescendolls","Daft Punk", "Discovery",250,d2,"crescendolls");
        Song song5 = new Song(4,"Emotion Engine","dazegxd", "vKiss",250,d1,"crescendolls");
        Song song6 = new Song(4,"Crescendolls","Daft Punk", "Discovery",250,d2,"crescendolls");
        Song song7 = new Song(4,"Emotion Engine","dazegxd", "vKiss",250,d1,"crescendolls");
        Song song8 = new Song(4,"Crescendolls","Daft Punk", "Discovery",250,d2,"crescendolls");
        Song song9 = new Song(4,"Emotion Engine","dazegxd", "vKiss",250,d1,"crescendolls");
        Song song10 = new Song(4,"Crescendolls","Daft Punk", "Discovery",250,d2,"crescendolls");
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        songs.add(song10);
        return songs;
    }
}
