package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class travail_termine_ou_non extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button bt_oui,bt_non;
    String nomclient,produit,marque,modele,travail;
    ImageView imageView;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travail_termine_ou_non);
        //initialisation des variables
        //******************************************************************************************
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        marque= intent.getStringExtra("marque");
        modele= intent.getStringExtra("modele");
        //******************************************************************************************

        //imageview pour ouvrir le menu de l'application
        //******************************************************************************************
        imageView=findViewById(R.id.open_menu);
        imageView.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent1);});
        //******************************************************************************************

        //button pour aller vers l'activité satisfaction client
        //******************************************************************************************
        bt_oui=findViewById(R.id.button_oui);
        bt_oui.setOnClickListener(v -> {
            travail="travail terminé";
            Intent intent1 = new Intent(getApplicationContext(),problemes.class);
            intent1.putExtra("nomclient",nomclient);
            intent1.putExtra("produit",produit);
            intent1.putExtra("modele",modele);
            intent1.putExtra("marque",marque);
            intent1.putExtra("travail",travail);
            startActivity(intent1);
        });
        //******************************************************************************************

        //button pour aller vers l'activité probléme
        //******************************************************************************************
        bt_non=findViewById(R.id.button_non);
        bt_non.setOnClickListener(v -> {
            travail="travail n'est pas terminé";
            Intent intent12 = new Intent(getApplicationContext(),problemes.class);
            intent12.putExtra("nomclient",nomclient);
            intent12.putExtra("produit",produit);
            intent12.putExtra("modele",modele);
            intent12.putExtra("marque",marque);
            intent12.putExtra("travail",travail);
            startActivity(intent12);
        });
        //******************************************************************************************

    }
}