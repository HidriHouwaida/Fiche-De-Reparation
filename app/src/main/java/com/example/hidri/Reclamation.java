package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Reclamation extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    TextInputEditText mark,product,model;
    ImageView imageView;
    DBInformationProduit dbInformationProduit;
    String nomclient;
    //**********************************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);
        //initialisation des variables
        //******************************************************************************************
        mark=findViewById(R.id.mark);
        product=findViewById(R.id.product);
        model=findViewById(R.id.model);
        Intent intent=getIntent();
        dbInformationProduit=new DBInformationProduit(this);
        nomclient=intent.getStringExtra("NomClient");
        //******************************************************************************************



        //button next pour aller ver l'activité satisfaction client
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if (mark.getText().toString().isEmpty()) {
                mark.setError("Marque obligatoire!");
                mark.requestFocus();
            } else if (product.getText().toString().isEmpty()) {
                product.setError("Produit obligatoire!");
                product.requestFocus();

            } else if (model.getText().toString().isEmpty()) {
                model.setError("Modéle obligatoire!");
                model.requestFocus();
            } else {
                dbInformationProduit.insert(mark.getText().toString(), model.getText().toString()
                        , product.getText().toString(), nomclient);
                Intent intent1 = new Intent(getApplicationContext(), satisfaction_client.class);
                intent1.putExtra("nomclient", nomclient);
                intent1.putExtra("produit", product.getText().toString());
                intent1.putExtra("marque", mark.getText().toString());
                intent1.putExtra("modele", model.getText().toString());
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