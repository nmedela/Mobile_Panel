package com.example.mobilepanel.customComponents;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.view.LayoutInflater;

import androidx.fragment.app.Fragment;

import com.example.mobilepanel.R;

public class LoadingDialogFragment {
    Fragment activity;
    AlertDialog dialog;

    public LoadingDialogFragment(Fragment myActivity){
        activity= myActivity;

    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity.getContext());
        LayoutInflater inflater= activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_progress_bar,null));
        builder.setCancelable(true);

        dialog=builder.create();
        dialog.show();
    }

     public void dismissDialog(){
        dialog.dismiss();
    }
}
