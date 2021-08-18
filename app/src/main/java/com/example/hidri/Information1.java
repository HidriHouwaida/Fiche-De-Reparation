package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Information1 extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    TextInputEditText identificationno,authorizedagent,serialno;
    ImageView imageView;
    DBInformation1 dbInformation1;
    String nomclient,produit,marque,modele;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information1);
        //initialisation des variables
        //******************************************************************************************
        identificationno=findViewById(R.id.identificationno);
        authorizedagent=findViewById(R.id.authorizedagent);
        serialno=findViewById(R.id.serialno);
        dbInformation1=new DBInformation1(this);
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        marque = intent.getStringExtra("marque");
        modele= intent.getStringExtra("modele");
        //******************************************************************************************



        //button next pour aller vers l'activité Information2
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
             if(identificationno.getText().toString().isEmpty())
            {
                identificationno.setError("Identification No obligatoire!");
                identificationno.requestFocus();
            }
            else  if(authorizedagent.getText().toString().isEmpty())
            {
                authorizedagent.setError("Agent agréé obligattoire!");
                authorizedagent.requestFocus();
            }
            else if(serialno.getText().toString().isEmpty())
            {
                serialno.setError("Serial no obligatoire!");
                serialno.requestFocus();
            }
            else
            {
                dbInformation1.insert(nomclient,modele,marque,produit,
                      identificationno.getText().toString(),
                        authorizedagent.getText().toString(),serialno.getText().toString());
                Intent intent1 =new Intent(getApplicationContext(),Information2.class);
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