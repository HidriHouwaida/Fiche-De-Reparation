package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Information5 extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    ImageView imageView;
    String nomclient,produit,modele,marque;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20;
    String ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10,ed11,ed12,ed13,ed14,ed15,ed16,ed17,ed18,ed19,ed20;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information5);
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        modele= intent.getStringExtra("modele");
        marque=intent.getStringExtra("marque");
        DBTableau dbTableau=new DBTableau(this);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        e3=findViewById(R.id.ed3);
        e4=findViewById(R.id.ed4);
        e5=findViewById(R.id.ed5);
        e6=findViewById(R.id.ed6);
        e7=findViewById(R.id.ed7);
        e8=findViewById(R.id.ed8);
        e9=findViewById(R.id.ed9);
        e10=findViewById(R.id.ed10);
        e11=findViewById(R.id.ed11);
        e12=findViewById(R.id.ed12);
        e13=findViewById(R.id.ed13);
        e14=findViewById(R.id.ed14);
        e15=findViewById(R.id.ed15);
        e16=findViewById(R.id.ed16);
        e17=findViewById(R.id.ed17);
        e18=findViewById(R.id.ed18);
        e19=findViewById(R.id.ed19);
        e20=findViewById(R.id.ed20);
        ed1=e1.getText().toString();
        ed2=e2.getText().toString();
        ed3=e3.getText().toString();
        ed4=e4.getText().toString();
        ed5=e5.getText().toString();
        ed6=e6.getText().toString();
        ed7=e7.getText().toString();
        ed8=e8.getText().toString();
        ed9=e9.getText().toString();
        ed10=e10.getText().toString();
        ed11=e11.getText().toString();
        ed12=e12.getText().toString();
        ed13=e13.getText().toString();
        ed14=e14.getText().toString();
        ed15=e15.getText().toString();
        ed16=e16.getText().toString();
        ed17=e17.getText().toString();
        ed18=e18.getText().toString();
        ed20=e20.getText().toString();
        ed19=e19.getText().toString();
        //button next pour aller vers l'activité ParametreMesuré
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),ParametreMesure.class);
            intent1.putExtra("nomclient",nomclient);
            intent1.putExtra("marque",marque);
            intent1.putExtra("modele",modele);
            intent1.putExtra("produit",produit);
            dbTableau.insert(nomclient,modele,produit,marque,ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9
                    ,ed10,ed11,ed12,ed13,ed14,ed15,ed16,ed17,ed18,ed19,ed20);
            startActivity(intent1);
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