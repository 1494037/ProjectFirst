package com.example.user.projectfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int img = intent.getIntExtra("img", 0);
        String name = intent.getStringExtra("name");
        String cost = intent.getStringExtra("cost");
        String star = intent.getStringExtra("star");

        setContentView(R.layout.activity_second);

        ImageView ya0 = (ImageView) findViewById(R.id.text34);
        TextView ya1 = (TextView) findViewById(R.id.text4);
        TextView ya2 = (TextView) findViewById(R.id.text5);
        TextView ya3 = (TextView) findViewById(R.id.text6);
        ya0.setImageResource(img);
        ya1.setText(name);
        ya2.setText(cost + " 원");
        ya3.setText("평점 : " + star);
    }
}
