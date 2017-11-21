package com.example.user.projectfirst;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;



public class detailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }


        detailFragment details = new detailFragment();

        details.setSelection(getIntent().getIntExtra("index",-1));

        getSupportFragmentManager().beginTransaction().replace(R.id.details,details).commit();

    }
}