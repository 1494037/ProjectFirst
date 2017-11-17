package com.example.user.projectfirst;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.user.projectfirst.R.layout.activity_first;

public class FirstActivity extends AppCompatActivity {
    static MyAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_first);

        ArrayList<Myitems> data = new ArrayList();

        data.add(new Myitems(R.drawable.new1, "김치나베 돈카츠", "6500", "4.0"));
        data.add(new Myitems(R.drawable.new2, "가츠동", "6500", "4.5"));
        data.add(new Myitems(R.drawable.new3, "돈니꾸동", "6500", "4.0"));
        data.add(new Myitems(R.drawable.new4, "수제 돈카츠", "6500", "3.5"));
        data.add(new Myitems(R.drawable.new5, "오뎅우동", "6500", "3.5"));


        myadapter = new MyAdapter(data, this, R.layout.yep);

        ListView listView = (ListView)findViewById(R.id.nope);
        listView.setAdapter(myadapter);

        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(5);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("img", ((Myitems)myadapter.getItem(position)).getImg());
                intent.putExtra("name", ((Myitems)myadapter.getItem(position)).getName());
                intent.putExtra("cost", ((Myitems)myadapter.getItem(position)).getCost());
                intent.putExtra("star", ((Myitems)myadapter.getItem(position)).getStar());
                startActivity(intent);
            }
        });

        ImageButton btn = (ImageButton)findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicit_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:07077660144"));
                startActivity(implicit_intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_store:
                startActivity(new Intent(this, addActivity.class));
                return true;
            default:

        return super.onOptionsItemSelected(item);
    }
}