package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Information2 extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    TextInputEditText intervention,customerref;
    ImageView imageView;
    String nomclient,produit,modele,marque;
    DBInformation2 dbInformation2;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information2);
        //initialisation des variables
        //******************************************************************************************
        next=findViewById(R.id.next);
        intervention=findViewById(R.id.intervention);
        customerref=findViewById(R.id.customer_ref);
        Intent intent=getIntent();
        nomclient=  intent.getStringExtra("nomclient");
        dbInformation2=new DBInformation2(this);
        produit=intent.getStringExtra("produit");
        modele=intent.getStringExtra("modele");
        marque=intent.getStringExtra("marque");
        //******************************************************************************************



        //button next pour aller vers l'activité Information technicien
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if(intervention.getText().toString().isEmpty())
            {
                intervention.setError("Intervention obligatoire!");
                intervention.requestFocus();
            }
            else if(customerref.getText().toString().isEmpty())
            {
                customerref.setError("Réf.client obligatoire!");
                customerref.requestFocus();
            }
            else
            {
                dbInformation2.insert(nomclient,modele,marque,produit,intervention.getText().toString(),
                        customerref.getText().toString());
                Intent intent1 =new Intent(getApplicationContext(),InformationTechnicien.class);
                intent1.putExtra("nomclient",nomclient);
                intent1.putExtra("produit",produit);
                intent1.putExtra("modele",modele);
                intent1.putExtra("marque",marque);
                startActivity(intent1);}
        });
        //******************************************************************************************


        //imageview pour aller vers le menu
        //******************************************************************************************
        imageView=findViewById(R.id.open_menu);
        imageView.setOnClickListener(v -> {
            Intent intent12 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent12);});
        //******************************************************************************************
    }
}