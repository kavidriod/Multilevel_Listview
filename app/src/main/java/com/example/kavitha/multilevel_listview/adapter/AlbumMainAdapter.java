package com.example.kavitha.multilevel_listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kavitha.multilevel_listview.R;
import com.example.kavitha.multilevel_listview.model.Album;

import java.util.List;

/**
 * Created by Kavitha on 14-06-2017.
 */

public class AlbumMainAdapter extends BaseAdapter {

    Context activity;
    LayoutInflater layoutInflater;
    List<Album> albumsList;

    public AlbumMainAdapter(Context activity,List<Album> albumList){
        this.activity = activity;
        this.albumsList = albumList;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null){
            view = layoutInflater.inflate(R.layout.list_item_albums,null);
        }

        TextView songs_count = (TextView) view.findViewById(R.id.songs_count);
        TextView album_name = (TextView) view.findViewById(R.id.album_name);
        TextView album_id = (TextView) view.findViewById(R.id.album_id);


       Album eachAlbum = albumsList.get(position);

        songs_count.setText(String.valueOf(eachAlbum.getSongs_count()));
        album_name.setText(eachAlbum.getName());
        album_id.setText(String.valueOf(eachAlbum.getId()));


        return view;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return albumsList.size();
    }

    @Override
    public Object getItem(int position) {
        return albumsList.get(position);
    }
}
