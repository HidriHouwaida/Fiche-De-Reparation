package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuApplication extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    ImageView accueil;
    ImageView se_deconnecter;
    ImageView recherche;
    ImageView partager;
    ImageView signature;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_application);
        //accueil
        //******************************************************************************************
        accueil=findViewById(R.id.image_accueil);
        accueil.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
        //******************************************************************************************

        //se deconnecter
        //******************************************************************************************
        se_deconnecter=findViewById(R.id.image_se_deconnecter);
        se_deconnecter.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Sign_In.class);
            startActivity(intent);
        });
        //******************************************************************************************



        //recherche
        //******************************************************************************************
        recherche=findViewById(R.id.image_recherche);
        recherche.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Recherche.class);
            startActivity(intent);
        });
        //******************************************************************************************






        //partager
        //******************************************************************************************
        partager=findViewById(R.id.image_partager);
        partager.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String body="Download this App";
            String sub="http://play.google.com";
            intent.putExtra(Intent.EXTRA_TEXT,body);
            intent.putExtra(Intent.EXTRA_TEXT,sub);
            startActivity(Intent.createChooser(intent,"ShareVia"));
        });
        //******************************************************************************************

        //signature
        //******************************************************************************************
        signature=findViewById(R.id.image_signature);
          signature.setOnClickListener(v -> {
              Intent intent=new Intent(getApplicationContext(),Choix.class);
              startActivity(intent);
          });

        //******************************************************************************************
    }

    }
