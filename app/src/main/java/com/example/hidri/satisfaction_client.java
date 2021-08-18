package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class satisfaction_client extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button remarque;
    ImageView imageView;
    RadioButton r1,r2,r3;
    String textview,nomclient,modele,marque,produit;
    DBDegresatisfaction dbDegresatisfaction;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satisfaction_client);

        dbDegresatisfaction=new DBDegresatisfaction(this);
        //initialisation des variables
        //******************************************************************************************
        r1=findViewById(R.id.satisfait);
        r2=findViewById(R.id.peu_satisfait);
        r3=findViewById(R.id.non_satisfait);
        //******************************************************************************************
        //******************************************************************************************

        r1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
            {textview="Satisfait";}
        });
        r2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
            { textview="peu satisfait";}
        });
        r3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
            {textview="non satisfait";}
        });
        //******************************************************************************************

        //button pour ajouter les remarques
        //******************************************************************************************
        remarque=findViewById(R.id.remarque);
        Intent intent=getIntent();
         nomclient=intent.getStringExtra("nomclient");
         produit=intent.getStringExtra("produit");
         modele=intent.getStringExtra("modele");
         marque=intent.getStringExtra("marque");
        remarque.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),Remarques.class);
            dbDegresatisfaction.insert(nomclient,modele,marque,produit,textview);
            startActivity(intent1);
        });
        //******************************************************************************************

        //imageview pour ouvrir le menu de l'application
        //******************************************************************************************
        imageView=findViewById(R.id.open_menu);
        imageView.setOnClickListener(v -> {
            Intent intent12 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent12);});
        //******************************************************************************************
    }
}