package com.example.kavitha.multilevel_listview.helper;



import com.example.kavitha.multilevel_listview.model.Album;
import com.example.kavitha.multilevel_listview.model.SongBySongAndAlbumId;
import com.example.kavitha.multilevel_listview.model.SongsByAlbumId;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;
import java.util.List;

/**
 * Created by Kavitha on 08-06-2017.
 */

public interface ApiService {

    @GET("albums.php")
    Call<List<Album>> getListOfAlbums();


    @GET("album_tracks.php")
    Call<SongsByAlbumId> getSongsByAlbumId(@Query("id") String albumId);


    @GET("track.php")
    Call<SongBySongAndAlbumId> getSongBySongAndAlbumId(@Query("album") String albumId,@Query("song") String songId);
}
