package com.example.myapplication;

import java.util.ArrayList;

public class Albums {
    public static ArrayList<Album> getAlbums(){
        int ram = R.drawable.album_cover;
        int vkiss = R.drawable.album_cover2;
        int discovery = R.drawable.album_cover3;
        int audioslave = R.drawable.album_cover5;

        ArrayList<Album> albums = new ArrayList<>();
        Album album1 = new Album(1,"vKISS",vkiss);
        Album album2 = new Album(2,"Random Access Memory",ram);
        Album album3 = new Album(3,"Discovery",discovery);
        Album album4 = new Album(4,"Audioslave",audioslave);
        Album album5 = new Album(5,"Audioslave",audioslave);
        Album album6 = new Album(6,"Audioslave",audioslave);

        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);
        albums.add(album6);

        return albums;
    }
}
