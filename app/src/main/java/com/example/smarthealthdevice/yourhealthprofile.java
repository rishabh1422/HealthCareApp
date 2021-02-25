package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class yourhealthprofile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_yourhealthprofile );
        PersonDatabase appData=PersonDatabase.getInstance( this );
        appData.personDao().getPersonalList();
        ProfileModel profileModel=new ProfileModel( "628039465","abc@co.in","19-05-1998","B+","UnMarried" );
        appData.personDao().insertPerson( profileModel );



    }
}