package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

public class HomePage extends AppCompatActivity {
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home_page );
        Toolbar toolbar=findViewById( R.id.toobar );
        profile=findViewById( R.id.profile );
        setSupportActionBar( toolbar );
        profile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,yourhealthprofile.class);
                startActivity( i );
                finish();
            }
        } );
    }
}