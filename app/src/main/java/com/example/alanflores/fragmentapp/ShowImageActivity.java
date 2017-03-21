package com.example.alanflores.fragmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.content.res.Configuration;

public class ShowImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        if(savedInstanceState == null){
            ShowImageFragment showImageFragment = new ShowImageFragment();
            showImageFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content,showImageFragment).commit();
        }

    }
}
