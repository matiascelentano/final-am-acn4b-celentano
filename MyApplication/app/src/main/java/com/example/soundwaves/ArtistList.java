package com.example.soundwaves;

import java.util.ArrayList;

public class ArtistList {
    public static ArrayList<Artist> getArtists(){
        int ram = R.drawable.album_cover;
        int vkiss = R.drawable.album_cover2;
        int discovery = R.drawable.album_cover3;
        int colorandshape = R.drawable.album_cover4;
        int audioslave = R.drawable.album_cover5;

        Artist artist1 = new Artist(1,"Artista Prueba 1", ram);
        Artist artist2 = new Artist(2,"Artista Prueba 2", vkiss);
        Artist artist3 = new Artist(3,"Artista Prueba 3", discovery);
        Artist artist4 = new Artist(4,"Artista Prueba 4", audioslave);
        Artist artist5 = new Artist(5,"Artista Prueba 5", colorandshape);
        Artist artist6 = new Artist(6,"Artista Prueba 6", ram);

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);
        artists.add(artist5);
        artists.add(artist6);

        return artists;
    }
}
