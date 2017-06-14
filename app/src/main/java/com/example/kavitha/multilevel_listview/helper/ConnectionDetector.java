package com.example.kavitha.multilevel_listview.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Kavitha on 08-06-2017.
 */

public class ConnectionDetector {

    Context context;
    boolean statusNet = false;
    String TAG = "ConnectionDetector";

    public  ConnectionDetector(Context context){
    this.context = context;
    }

public  boolean isConnected(){
            ConnectivityManager connectivityManager =  (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

    statusNet = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();

    Log.i(TAG,"statusNet ?"+statusNet);

    return statusNet;
}
}
