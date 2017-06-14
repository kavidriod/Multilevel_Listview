package com.example.kavitha.multilevel_listview.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kavitha.multilevel_listview.adapter.EachAlbumAdapter;
import com.example.kavitha.multilevel_listview.helper.*;

import com.example.kavitha.multilevel_listview.R;
import com.example.kavitha.multilevel_listview.helper.ConnectionDetector;
import com.example.kavitha.multilevel_listview.model.Songs;
import com.example.kavitha.multilevel_listview.model.SongsByAlbumId;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EachAlbumActivity extends ListActivity {

    ConnectionDetector connectionDetector;
    ListView listView;
    // Alert dialog manager
    AlertDialogManager alert = new AlertDialogManager();
    String album_Id;
    SongsByAlbumId songsByAlbumId;
    List<Songs> songsList;

    EachAlbumAdapter eachAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_album);


        connectionDetector = new ConnectionDetector(getApplicationContext());
        if (!connectionDetector.isConnected()){
            // Internet Connection is not present
            alert.showDialog(EachAlbumActivity.this, "Internet Connection Error",
                    "Please connect to working Internet connection", false);
            // stop executing code by return
            return;
        }

        listView = getListView();

        ApiService apiService = Api.getRetrofit().create(ApiService.class);


        Intent intent = getIntent();
        if (intent != null){
            album_Id = intent.getStringExtra("ALBUM_ID");
        }

        Call<SongsByAlbumId> songsByAlbumIdCall = apiService.getSongsByAlbumId(album_Id);
        songsByAlbumIdCall.enqueue(new Callback<SongsByAlbumId>() {
            @Override
            public void onResponse(Call<SongsByAlbumId> call, Response<SongsByAlbumId> response) {
                songsByAlbumId = response.body();
                songsList = songsByAlbumId.getSongs();

                eachAlbumAdapter = new EachAlbumAdapter(getApplicationContext(),songsList,songsByAlbumId.getId());
                listView.setAdapter(eachAlbumAdapter);
            }

            @Override
            public void onFailure(Call<SongsByAlbumId> call, Throwable t) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),EachSongActivity.class);

                String album_Id = ((TextView)view.findViewById(R.id.album_id)).getText().toString();
                String song_Id = ((TextView)view.findViewById(R.id.song_id)).getText().toString();

                intent.putExtra("ALBUM_ID",album_Id);
                intent.putExtra("SONG_ID",song_Id);

                startActivity(intent);
            }
        });
    }

}
