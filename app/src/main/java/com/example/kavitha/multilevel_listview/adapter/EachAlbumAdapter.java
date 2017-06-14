package com.example.kavitha.multilevel_listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kavitha.multilevel_listview.R;
import com.example.kavitha.multilevel_listview.model.Songs;
import com.example.kavitha.multilevel_listview.model.SongsByAlbumId;

import java.util.List;

/**
 * Created by Kavitha on 14-06-2017.
 */

public class EachAlbumAdapter extends BaseAdapter {

    Context context;
    List<Songs> songs;
    int album_Id;
    LayoutInflater layoutInflater;

    public EachAlbumAdapter(Context context, List<Songs> songs,int album_Id){
        this.context = context;
        this.songs = songs;
        this.album_Id = album_Id;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null){
            view = layoutInflater.inflate(R.layout.list_item_each_album,null);
        }

        TextView album_id = (TextView) view.findViewById(R.id.album_id);
        TextView song_id = (TextView) view.findViewById(R.id.song_id);

        album_id.setText(String.valueOf(album_Id));


        TextView track_no = (TextView) view.findViewById(R.id.track_no);
        TextView album_name = (TextView) view.findViewById(R.id.album_name);
        TextView song_duration = (TextView) view.findViewById(R.id.song_duration);

        Songs eachSongs = songs.get(position);

        song_id.setText(String.valueOf(eachSongs.getId()));
        track_no.setText(String.valueOf(eachSongs.getId()));
        album_name.setText(eachSongs.getName());
        song_duration.setText(String.valueOf(eachSongs.getDuration()));

        return view;
    }
}
