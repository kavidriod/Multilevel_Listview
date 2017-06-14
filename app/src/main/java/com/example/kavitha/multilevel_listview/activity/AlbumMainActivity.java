package com.example.kavitha.multilevel_listview.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.kavitha.multilevel_listview.adapter.AlbumMainAdapter;
import com.example.kavitha.multilevel_listview.R;
import com.example.kavitha.multilevel_listview.helper.AlertDialogManager;
import com.example.kavitha.multilevel_listview.helper.Api;
import com.example.kavitha.multilevel_listview.helper.ApiService;
import com.example.kavitha.multilevel_listview.helper.ConnectionDetector;
import com.example.kavitha.multilevel_listview.model.Album;

public class AlbumMainActivity extends ListActivity {



    ConnectionDetector connectionDetector;
    ListView listView;
    List<Album> albumsList;
    AlbumMainAdapter albumMainAdapter;
    // Alert dialog manager
    AlertDialogManager alert = new AlertDialogManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_main);

        connectionDetector = new ConnectionDetector(getApplicationContext());


        if (!connectionDetector.isConnected()){
            // Internet Connection is not present
            alert.showDialog(AlbumMainActivity.this, "Internet Connection Error",
                    "Please connect to working Internet connection", false);
            // stop executing code by return
            return;
        }


        listView = getListView();

        albumsList = new ArrayList<>();


        ApiService apiService = Api.getRetrofit().create(ApiService.class);

        Call<List<Album>> albumCall = apiService.getListOfAlbums();
        albumCall.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                albumsList = response.body();
                albumMainAdapter = new AlbumMainAdapter(getApplicationContext(),albumsList);
                listView.setAdapter(albumMainAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),EachAlbumActivity.class);
                String album_Id = ((TextView)view.findViewById(R.id.album_id)).getText().toString();
                intent.putExtra("ALBUM_ID",album_Id);
                startActivity(intent);
            }
        });

    }
}
