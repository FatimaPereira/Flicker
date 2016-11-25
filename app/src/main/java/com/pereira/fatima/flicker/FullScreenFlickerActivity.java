package com.pereira.fatima.flicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FullScreenFlickerActivity extends AppCompatActivity {

    List<ClassPhoto> classPhoto = new ArrayList<>();

    TextView titreFullscreen;
    TextView urlFullscreen;
    ImageView imageFullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_flicker);
        String title = getIntent().getStringExtra("Title");
        String url = getIntent().getStringExtra("Url");

        titreFullscreen = (TextView) findViewById(R.id.titre_fullscreen);
        titreFullscreen.setText(title);
        urlFullscreen = (TextView) findViewById(R.id.url_fullscreen);
        urlFullscreen.setText(url);
        imageFullscreen = (ImageView) findViewById(R.id.image_fullscreen);
        Picasso.with(this).load(url).into(imageFullscreen);


        Button btnResetFullScreen = (Button) findViewById(R.id.btn_reset_fullscreen);

        btnResetFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();

            }
        });

    }
}
