package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Type_De_Personne extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button bt_user,bt_client;
    //***********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type__de__personne);

        //button pour accéder a l'activité de login de client
        //******************************************************************************************
        bt_client=findViewById(R.id.bt_client);
        bt_client.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Sign_In.class);
            startActivity(intent);
        });
        //******************************************************************************************


        //button pour accéder à la page de login de l'employer
        //******************************************************************************************
        bt_user=findViewById(R.id.bt_user);
        bt_user.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Code.class);
            startActivity(intent);
        });
        //******************************************************************************************
    }
}