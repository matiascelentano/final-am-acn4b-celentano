package com.example.myapplication;

import java.util.ArrayList;

public class Playlists {
    public static ArrayList<Playlist> getPlaylists(){
        int ram = R.drawable.album_cover;
        int vkiss = R.drawable.album_cover2;
        int discovery = R.drawable.album_cover3;
        int colorandshape = R.drawable.album_cover4;
        int audioslave = R.drawable.album_cover5;

        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist playlist1 = new Playlist(1,"Mi Playlist 1",vkiss,SongList.getSongs());
        Playlist playlist2 = new Playlist(2,"Mi Playlist 2",ram,SongList.getSongs());
        Playlist playlist3 = new Playlist(3,"Mi Playlist 3",discovery,SongList.getSongs());
        Playlist playlist4 = new Playlist(4,"Mi Playlist 4",colorandshape,SongList.getSongs());
        Playlist playlist5 = new Playlist(5,"Mi Playlist 5",audioslave,SongList.getSongs());
        Playlist playlist6 = new Playlist(6,"Mi Playlist 6",ram,SongList.getSongs());

        playlists.add(playlist1);
        playlists.add(playlist2);
        playlists.add(playlist3);
        playlists.add(playlist4);
        playlists.add(playlist5);
        playlists.add(playlist6);


        return playlists;
    }
}
