package com.example.user.projectfirst;


import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.view.Menu;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainFragment.OnTitleSelectedListener{
    public DBHelper mDbHelper1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper1 = new DBHelper(this);

        ImageButton pbtn = (ImageButton)findViewById(R.id.Phonebutton);

        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phoneaction(v);
            }
        });


    }

    public void Phoneaction(View v) {
        Cursor cursors = mDbHelper1.getAllUsersBySQL();
        cursors.moveToLast();
        String tel = "tel: " + cursors.getString(3);
        Log.v("tel", tel);
        Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(tel));
        startActivity(intents);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //item선택됬을때 --> 상단 메뉴
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_menu:
                Intent intent = new Intent(getApplicationContext(), addMenu.class);
                startActivity(intent);
            case R.id.add_store:
                Intent intent2 = new Intent(getApplicationContext(), addActivity.class);
                startActivity(intent2);
                return true;
        }
        return false;
    }


    @Override
    public void onTitleSelected(int i) {
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            //DetailsFragment detailsFragment = new DetailsFragment();
            detailFragment detailfragment = new detailFragment();
            detailfragment.setSelection(i);
            getSupportFragmentManager().beginTransaction().replace(R.id.details, detailfragment).commit();
        } else {
            Intent intent = new Intent(this, detailActivity.class);
            intent.putExtra("index", i);
            startActivity(intent);

        }
    }


}