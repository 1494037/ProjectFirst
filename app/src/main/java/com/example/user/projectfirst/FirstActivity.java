package com.example.user.projectfirst;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.user.projectfirst.R.layout.activity_first;

public class FirstActivity extends AppCompatActivity {
    static MyAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_first);

        ArrayList<Myitems> data = new ArrayList();

        data.add(new Myitems(R.drawable.new1, "김치나베 돈카츠", "6500"));
        data.add(new Myitems(R.drawable.new2, "가츠동", "6500"));
        data.add(new Myitems(R.drawable.new3, "돈니꾸동", "6500"));
        data.add(new Myitems(R.drawable.new4, "수제 돈카츠", "6500"));
        data.add(new Myitems(R.drawable.new5, "오뎅우동", "6500"));


        myadapter = new MyAdapter(data, this, R.layout.yep);

        ListView listView = (ListView)findViewById(R.id.nope);
        listView.setAdapter(myadapter);

        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(5);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}