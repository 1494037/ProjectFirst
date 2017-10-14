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

        data.add(new Myitems("a1", "a2", "a3"));
        data.add(new Myitems("b1", "b2", "b3"));
        data.add(new Myitems("c1", "c2", "c3"));

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