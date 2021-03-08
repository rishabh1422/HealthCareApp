package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

public class HomePage extends AppCompatActivity {
    ImageView profile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toobar);
        profile1 = findViewById(R.id.profile);
        setSupportActionBar(toolbar);

        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, yourhealthprofile.class);
                startActivity(i);
                finish();
            }
        });
    }

}