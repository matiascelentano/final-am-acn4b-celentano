package com.example.soundwaves;

import java.util.ArrayList;

public class ArtistList {
    public static ArrayList<Artist> getArtists(){
        int ram = R.drawable.album_cover;
        int vkiss = R.drawable.album_cover2;
        int discovery = R.drawable.album_cover3;
        int colorandshape = R.drawable.album_cover4;
        int audioslave = R.drawable.album_cover5;

        Artist artist1 = new Artist(1,"Artista Prueba 1", "https://e-cdns-images.dzcdn.net/images/artist/f2bc007e9133c946ac3c3907ddc5d2ea/500x500-000000-80-0-0.jpg");
        Artist artist2 = new Artist(2,"Artista Prueba 2", "https://e-cdns-images.dzcdn.net/images/cover/a7a16b8f63b1ec0e9fbd327619966737/500x500-000000-80-0-0.jpg");
        Artist artist3 = new Artist(3,"Artista Prueba 3", "https://e-cdns-images.dzcdn.net/images/artist/b20b2bf997dba1ea0f7b126c70ded9ca/500x500-000000-80-0-0.jpg");
        Artist artist4 = new Artist(4,"Artista Prueba 4", "https://e-cdns-images.dzcdn.net/images/artist/ab53202f61b37edfde6d03e21fb4b64e/250x250-000000-80-0-0.jpg");
        Artist artist5 = new Artist(5,"Artista Prueba 5", "https://e-cdns-images.dzcdn.net/images/cover/266f01f1c7a04843d11cd08f9c07d11f/250x250-000000-80-0-0.jpg");
        Artist artist6 = new Artist(6,"Artista Prueba 6", "https://e-cdns-images.dzcdn.net/images/artist/84ff06f377b881b355e0959f750f5a1b/250x250-000000-80-0-0.jpg");

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
