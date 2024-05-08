package com.example.myapplication;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class SongList {
    public static ArrayList<Song> getSongs(){
        int ram = R.drawable.album_cover;
        int vkiss = R.drawable.album_cover2;
        int discovery = R.drawable.album_cover3;
        int colorandshape = R.drawable.album_cover4;
        int audioslave = R.drawable.album_cover5;
        //creando canciones
        Song song1 = new Song(1,"Emotion Engine","Dazegxd", "vKiss",250,vkiss,"emotion_engine");
        Song song2 = new Song(2,"Crescendolls","Daft Punk", "Discovery",250,discovery,"crescendolls");
        Song song3 = new Song(3,"Like a Stone","Audioslave", "Audioslave",250,audioslave,"emotion_engine");
        Song song4 = new Song(4,"Instant Crush","Daft Punk", "Random Access Memory",250,ram,"crescendolls");
        Song song5 = new Song(5,"Everlong","Foo Fighters", "The Colour and The Shape",250,colorandshape,"crescendolls");
        Song song6 = new Song(6,"Emotion Engine","Dazegxd", "vKiss",250,vkiss,"emotion_engine");
        Song song7 = new Song(7,"Crescendolls","Daft Punk", "Discovery",250,discovery,"crescendolls");
        Song song8 = new Song(8,"Like a Stone","Audioslave", "Audioslave",250,audioslave,"emotion_engine");
        Song song9 = new Song(9,"Instant Crush","Daft Punk", "Random Access Memory",250,ram,"crescendolls");
        Song song10 = new Song(10,"Everlong","Foo Fighters", "The Colour and The Shape",250,colorandshape,"crescendolls");
        //Creando arraylist de canciones
        ArrayList<Song> songs = new ArrayList<>();
        //Agregando canciones a arraylist
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
