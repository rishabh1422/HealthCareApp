package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class yourhealthprofile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_yourhealthprofile );
        PersonDatabase appData=PersonDatabase.getInstance( this );
        appData.personDao().getPersonalList();
        ProfileModel profileModel=new ProfileModel( "1234567","abc@co.in","19-05-1998","B+","UnMarried" );

        /* *
         *  Insert and get data using Database Async way
         */
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG","data saved");
                // Insert Data
                appData.personDao().updatePerson( profileModel );

                // Get Data
                // AppDatabase.getInstance(context).userDao().getAllUsers();
            }
        });
    }
}