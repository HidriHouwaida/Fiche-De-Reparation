package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ParametreMesure extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    TextInputEditText measuredvoltage,blowingtime,recoverytime,absorbedintensity,ampsteg,dischargepressure;
    ImageView imageView;
    String nomclient,modele,produit,marque;
    DBParametreMesure dbParametreMesure;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre_mesure);
        //initialisation des variables
        //******************************************************************************************
        measuredvoltage=findViewById(R.id.measuredVoltage);
        blowingtime=findViewById(R.id.blowingtime);
        recoverytime=findViewById(R.id.recoverytime);
        absorbedintensity=findViewById(R.id.absorbedintensity);
        ampsteg=findViewById(R.id.ampsteg);
        dischargepressure=findViewById(R.id.dischargepressure);
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        marque= intent.getStringExtra("marque");
        modele= intent.getStringExtra("modele");
        dbParametreMesure=new DBParametreMesure(this);
        //******************************************************************************************

        //button next pour aller vers l'activité Inforamtion6
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if(measuredvoltage.getText().toString().isEmpty())
            {
                measuredvoltage.setError("Tension mesuré obligatoire!");
                measuredvoltage.requestFocus();
            }
            else if(blowingtime.getText().toString().isEmpty())
            {
                blowingtime.setError("Temps de soufflage obligatoire!");
                blowingtime.requestFocus();
            }
            else if(recoverytime.getText().toString().isEmpty())
            {
                recoverytime.setError("Temps de reprise obligatoire!");
                recoverytime.requestFocus();
            }
            else if(absorbedintensity.getText().toString().isEmpty())
            {
                absorbedintensity.setError("Int absorbé obligatoire!");
                absorbedintensity.requestFocus();
            }

            else if(ampsteg.getText().toString().isEmpty())
            {
                ampsteg.setError("Amp steg obligatoire!");
                ampsteg.requestFocus();
            }
            else if(dischargepressure.getText().toString().isEmpty())
            {
                dischargepressure.setError("Pression de Refoulement obligatoire!");
                dischargepressure.requestFocus();
            }
            else
            {
                dbParametreMesure.insert(nomclient,modele,marque,produit,measuredvoltage.getText().toString(),
                        blowingtime.getText().toString(),recoverytime.getText().toString(),
                        absorbedintensity.getText().toString(),ampsteg.getText().toString(),
                        dischargepressure.getText().toString());
                Intent intent1 =new Intent(getApplicationContext(),Information6.class);
                intent1.putExtra("nomclient",nomclient);
                intent1.putExtra("produit",produit);
                intent1.putExtra("modele",modele);
                intent1.putExtra("marque",marque);
                startActivity(intent1);}
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