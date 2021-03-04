package com.example.smarthealthdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText email,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        email=findViewById( R.id.emaial );
        pass=findViewById( R.id.password );
        login=findViewById( R.id.login );

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString().trim();
                String pass1=pass.getText().toString().trim();
                if(email1.equals(getString(R.string.userName))&& pass1.equals( getString(R.string.password) ))
                {
                    Intent i=new Intent(MainActivity.this, HomePage.class);
                    startActivity( i );
                    Toast.makeText( MainActivity.this, getString(R.string.sucess_msg), Toast.LENGTH_SHORT ).show();
                } else if(TextUtils.isEmpty( email1 ))
                {
                    Toast.makeText( MainActivity.this, getString(R.string.email_placeholder), Toast.LENGTH_SHORT ).show();
                }
                else if(TextUtils.isEmpty( pass1 ))
                {
                    Toast.makeText( MainActivity.this, getString(R.string.password_placeholder), Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}