package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Information extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next,choisir;
    ImageView imageView;
    TextInputEditText dateofpurchase,dealer,customerfailure,leveldialog,expecteddemiverydate;
    String nomclient,nomproduit,modele,marque;
    DBInformation dbInformation;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        //initialisation des variables
        //*******************************************************************************************
        dateofpurchase=findViewById(R.id.date_dachat);
        dealer=findViewById(R.id.revendeur);
        customerfailure=findViewById(R.id.panneclient);
        leveldialog=findViewById(R.id.diag1ereniveau);
        expecteddemiverydate=findViewById(R.id.dateprevuedelivraison);
        dbInformation=new DBInformation(this);


        Intent intent=getIntent();
        nomproduit= intent.getStringExtra("produit");
        modele= intent.getStringExtra("modele");
        marque= intent.getStringExtra("marque");
        nomclient=intent.getStringExtra("client");
        //******************************************************************************************


        //button next pour aller vers l'activité Information1
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if(dateofpurchase.getText().toString().isEmpty())
            {
                dateofpurchase.setError("Date d'achat obligatoire!");
                dateofpurchase.requestFocus();
            }
            else if(dealer.getText().toString().isEmpty())
            {   dealer.setError("Revendeur obligatoire!");
                dealer.requestFocus();}
            else if(customerfailure.getText().toString().isEmpty())
            {   customerfailure.setError("Panne client obligatoire!");
                customerfailure.requestFocus();}
            else if(leveldialog.getText().toString().isEmpty())
            {   leveldialog.setError("Diag 1ere Niveau obligatoire!");
                leveldialog.requestFocus();}
            else if(expecteddemiverydate.getText().toString().isEmpty())
            {   expecteddemiverydate.setError("Date prévue de livraison /intervention obligatoire!");
                expecteddemiverydate.requestFocus();}
            else
            {
                Intent intent12 =new Intent(getApplicationContext(),Information1.class);
                dbInformation.insert(nomclient,modele,marque,nomproduit,
                        dateofpurchase.getText().toString(),dealer.getText().toString(),
                        customerfailure.getText().toString(),leveldialog.getText().toString(),
                        expecteddemiverydate.getText().toString());
                intent12.putExtra("nomclient",nomclient);
                intent12.putExtra("produit",nomproduit);
                intent12.putExtra("modele",modele);
                intent12.putExtra("marque",marque);
                startActivity(intent12);}
        });
        //******************************************************************************************



        //imageview pour aller vers le menu
        //******************************************************************************************
        imageView=findViewById(R.id.open_menu);
        imageView.setOnClickListener(v -> {
            Intent intent13 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent13);});
        //******************************************************************************************
        //récupurer les valeurs des dates
        //******************************************************************************************
        Intent intent2=getIntent();
        dateofpurchase.setText(intent2.getStringExtra("date_dachat"));
        expecteddemiverydate.setText(intent2.getStringExtra("date_livraison"));

        //******************************************************************************************

        //button choisir pour ouvrir le calendrier
        //******************************************************************************************
        choisir=findViewById(R.id.choisir_les_dates);
        choisir.setOnClickListener(v -> {
            Intent intent1=new Intent(getApplicationContext(),Calendrier.class);
            intent1.putExtra("nomclient",nomclient);
            intent1.putExtra("produit",nomproduit);
            intent1.putExtra("modele",modele);
            intent1.putExtra("marque",marque);
            startActivity(intent1);
        });
        //******************************************************************************************
    }
}