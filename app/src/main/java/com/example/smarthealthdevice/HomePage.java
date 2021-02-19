package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home_page );
        Toolbar toolbar=findViewById( R.id.toobar );
        setSupportActionBar( toolbar );
    }
}