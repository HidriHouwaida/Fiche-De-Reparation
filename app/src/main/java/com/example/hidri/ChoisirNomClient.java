package com.example.hidri;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChoisirNomClient extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button valider,liste,supprimer;
    EditText nom;
    DBInformationClient dbHelpeur;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_nom_client);

        //initialisation des variables
        //******************************************************************************************
        liste=findViewById(R.id.ListeDesClient);
        supprimer=findViewById(R.id.SupprimerClient);
        valider=findViewById(R.id.valider);
        dbHelpeur=new DBInformationClient(this);
        nom=findViewById(R.id.nomclient);
        //******************************************************************************************


        //button pour avoir la liste des Clients
        //******************************************************************************************
        liste.setOnClickListener(v -> {
            Cursor cursor =dbHelpeur.getNameClient() ;
            if(cursor.getCount()==0)
            {
                showmessage("Erreur","Nothing found");
            }
            else
            {StringBuffer buffer=new StringBuffer();
                while(cursor.moveToNext())
                {
                    buffer.append("Nom: "+cursor.getString(0)+"\n");
                }
                showmessage("Liste Des Noms Des Clients ",buffer.toString());
            }
        });
        //******************************************************************************************

        //button pour supprimer un client
        //******************************************************************************************
        supprimer.setOnClickListener(v -> dbHelpeur.delete(nom.getText().toString()));
        //******************************************************************************************



        //button valider pour aller vers l'activité choisir produit
        //******************************************************************************************
        valider.setOnClickListener(v -> {
            if(nom.getText().toString().isEmpty())
            {
                nom.setError("nom de client obligatoire!");
                nom.requestFocus();
            }
            else
            {Intent intent=new Intent(getApplicationContext(),ChoisirNomProduit.class);
            intent.putExtra("nomclient",nom.getText().toString());
            startActivity(intent);}
        });

        //******************************************************************************************
    }
    public  void showmessage(String title,String message)
    {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setCancelable(true);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.show();
    }
}