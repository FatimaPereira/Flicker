package com.pereira.fatima.flicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FlickerAdapter flickerAdapter = new FlickerAdapter();
    ArrayList<ClassPhoto> classPhoto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    flickerAdapter.classPhoto.add(new ClassPhoto("Chat","http://media.koreus.com/201409/109-insolite-34.jpg"));
    flickerAdapter.classPhoto.add(new ClassPhoto("Titre","http://media.koreus.com/201409/109-insolite-34.jpg"));
    flickerAdapter.classPhoto.add(new ClassPhoto("Titre","http://media.koreus.com/201409/109-insolite-34.jpg"));


        listView = (ListView) findViewById(R.id.list_flick);
        listView.setAdapter(flickerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ClassPhoto image = (ClassPhoto) flickerAdapter.getItem(i);
                String title = image.getTitle();
                String url = image.getUrl();
                Intent intent = new Intent(MainActivity.this, FullScreenFlicker.class);
                intent.putExtra("Title",title);
                intent.putExtra("Url",url);
                startActivity(intent);
            }
        });
    }
}
