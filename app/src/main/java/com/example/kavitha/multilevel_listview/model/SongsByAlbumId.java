package com.example.kavitha.multilevel_listview.model;

import java.util.List;

/**
 * Created by Kavitha on 14-06-2017.
 */

public class SongsByAlbumId {

    private int id;
    private String  album;
    private List<Songs> songs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }
}
