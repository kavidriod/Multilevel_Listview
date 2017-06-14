package com.example.kavitha.multilevel_listview.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.kavitha.multilevel_listview.R;

/**
 * Created by Kavitha on 08-06-2017.
 */

import android.content.DialogInterface;

import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager {

    public  void showDialog(Context context,String title,String message,Boolean status){

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        alertDialog.setTitle(title);

        alertDialog.setMessage(message);

         if (status != null){
       alertDialog.setIcon((status) ? R.drawable.success:R.drawable.fail);
         }

         alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {

             }
         });
        alertDialog.show();
    }
}
