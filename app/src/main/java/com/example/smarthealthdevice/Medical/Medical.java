package com.example.smarthealthdevice.Medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smarthealthdevice.R;

public class Medical extends AppCompatActivity {
    CardView card1,card2,card3,card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Medical.this,MedicalIndex.class);
                startActivity(i);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Medical.this,SugarLeval.class);
                startActivity(i);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Medical.this,BodyTemptrature.class);
                startActivity(i);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(Medical.this,Oxygen.class);
                startActivity(i);
            }
        });
    }
}