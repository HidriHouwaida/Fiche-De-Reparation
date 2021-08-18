package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MontantApayer extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    TextInputEditText amountelectrostar,amountclient;
    ImageView imageView;
    String nomclient,produit,marque,modele;
    DBMontantApayer dbMontantApayer;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montant_apayer);
        //initialisation des variables
        //******************************************************************************************
        amountelectrostar=findViewById(R.id.amountelectrostar);
        amountclient=findViewById(R.id.amountclient);
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        marque= intent.getStringExtra("marque");
        modele= intent.getStringExtra("modele");
        dbMontantApayer=new DBMontantApayer(this);
        //******************************************************************************************

        //button next pour aller vers l'activité travail terminé ou non
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if(amountelectrostar.getText().toString().isEmpty())
            {
                amountelectrostar.setError("Montant à payer par Electrostar obligatoir!");
                amountelectrostar.requestFocus();
            }
            else if(amountclient.getText().toString().isEmpty())
            {
                amountclient.setError("Montant à payer par le client HT obligatoire!");
                amountclient.requestFocus();
            }
            else
            {
                dbMontantApayer.insert(nomclient,modele,marque,amountelectrostar.getText().toString(),
                        amountclient.getText().toString(),produit);
                Intent intent1 =new Intent(getApplicationContext(),travail_termine_ou_non.class);
                intent1.putExtra("nomclient",nomclient);
                intent1.putExtra("produit",produit);
                intent1.putExtra("modele",modele);
                intent1.putExtra("marque",marque);
                startActivity(intent1);
            }
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