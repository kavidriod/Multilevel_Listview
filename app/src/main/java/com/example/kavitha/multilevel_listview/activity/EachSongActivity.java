package com.example.kavitha.multilevel_listview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.kavitha.multilevel_listview.R;
import com.example.kavitha.multilevel_listview.helper.Api;
import com.example.kavitha.multilevel_listview.helper.ApiService;
import com.example.kavitha.multilevel_listview.model.SongBySongAndAlbumId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EachSongActivity extends AppCompatActivity {

    String song_Id,album_Id;
    TextView song_title,album_name,duration;
    SongBySongAndAlbumId songBySongAndAlbumId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_song);


        song_title =  (TextView) findViewById(R.id.song_title);
        album_name =  (TextView) findViewById(R.id.album_name);
        duration =  (TextView) findViewById(R.id.duration);



        Intent intent = getIntent();
        if (intent != null){
            song_Id = intent.getStringExtra("SONG_ID");
            album_Id = intent.getStringExtra("ALBUM_ID");
        }


        ApiService apiService = Api.getRetrofit().create(ApiService.class);

        Call<SongBySongAndAlbumId> songBySongAndAlbumIdCall = apiService.getSongBySongAndAlbumId(album_Id,song_Id);

        songBySongAndAlbumIdCall.enqueue(new Callback<SongBySongAndAlbumId>() {
            @Override
            public void onResponse(Call<SongBySongAndAlbumId> call, Response<SongBySongAndAlbumId> response) {
                songBySongAndAlbumId = response.body();

                song_title.setText(songBySongAndAlbumId.getName());
                album_name.setText(songBySongAndAlbumId.getAlbum());
                duration.setText(songBySongAndAlbumId.getDuration());
            }

            @Override
            public void onFailure(Call<SongBySongAndAlbumId> call, Throwable t) {

            }
        });
    }

}
