package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class date extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next,bt_choisir;
    TextInputEditText dateofpdrrequest,dateofreceptionpdr;
    ImageView imageView;
    String nomclient,produit,modele,marque;
    DBDate dbDate;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        //initialisation des variables
        //******************************************************************************************
        dateofpdrrequest=findViewById(R.id.Dateofrequest);
        dateofreceptionpdr=findViewById(R.id.dateofreceptionpdr);
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        modele= intent.getStringExtra("modele");
        marque=intent.getStringExtra("marque");
        dbDate=new DBDate(this);
        //******************************************************************************************

        //button next
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if(dateofpdrrequest.getText().toString().isEmpty())
            {
                dateofpdrrequest.setError("Date Demande PDR Obligatoire!");
                dateofpdrrequest.requestFocus();
            }
            else if (dateofreceptionpdr.getText().toString().isEmpty())
            {
                dateofreceptionpdr.setError("Date Réception PDR Obligatoire!");
                dateofreceptionpdr.requestFocus();
            }
            else
            {
                dbDate.insert(nomclient,modele,marque,produit,dateofpdrrequest.getText().toString(),
                        dateofreceptionpdr.getText().toString());
                Intent intent1 =new Intent(getApplicationContext(),Information4.class);
                intent1.putExtra("nomclient",nomclient);
                intent1.putExtra("marque",marque);
                intent1.putExtra("modele",modele);
                intent1.putExtra("produit",produit);
                startActivity(intent1);
            }
        });
        //******************************************************************************************





        //button pour ouvrir le calendrier
        //******************************************************************************************
        bt_choisir=findViewById(R.id.choisir);
        bt_choisir.setOnClickListener(v -> {
            Intent intent12 =new Intent(getApplicationContext(),Calendrier.class);
            intent12.putExtra("nomclient",nomclient);
            intent12.putExtra("marque",marque);
            intent12.putExtra("modele",modele);
            intent12.putExtra("produit",produit);
            startActivity(intent12);
        });
        //******************************************************************************************

        //récuparation des dates
        //******************************************************************************************
        Intent i=getIntent();
        dateofpdrrequest.setText(i.getStringExtra("demandepdr"));
        dateofreceptionpdr.setText(i.getStringExtra("receptionpdr"));

        //******************************************************************************************




        //imageview pour aller vers le menu
        //******************************************************************************************
        imageView=findViewById(R.id.open_menu);
        imageView.setOnClickListener(v -> {
            Intent intent13 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent13);});
        //******************************************************************************************
    }
}