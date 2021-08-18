package com.example.hidri;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChoisirNomProduit extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button liste,valider,supprimer;
    EditText nomproduit,nommodele,nommarque;
    DBInformationProduit dbInformationProduit;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_nom_produit);

        //initialisation des variables
        //******************************************************************************************
        liste=findViewById(R.id.ListeDesProduit);
        Intent intent=getIntent();
       String nomclient=intent.getStringExtra("nomclient");
        dbInformationProduit=new DBInformationProduit(this);
        nomproduit=findViewById(R.id.nomproduit);
        nommodele=findViewById(R.id.nommodele);
        nommarque=findViewById(R.id.nommarque);
        supprimer=findViewById(R.id.SupprimerProduit);
        valider=findViewById(R.id.bt_valider);
        //******************************************************************************************

        //button pour avoir la liste des produits
        //******************************************************************************************
        liste.setOnClickListener(v -> {
            Cursor cursor = dbInformationProduit.getall(nomclient);
            if(cursor.getCount()==0)
            {
                showmessage("Erreur","Nothing found");
            }
            else
            {StringBuffer buffer=new StringBuffer();
                while(cursor.moveToNext())
                {
                    buffer.append("Produit: "+cursor.getString(2)+"\n");
                    buffer.append("Modéle:  "+cursor.getString(3)+"\n");
                    buffer.append("Marque:  "+cursor.getString(1)+"\n");
                    buffer.append("\n");
                }
                showmessage("Liste Des Noms Des Produit Des Marque et Des Modéle ",buffer.toString());
            }
        });
        //******************************************************************************************



        //button pour supprimer un produit
        //******************************************************************************************
        supprimer.setOnClickListener(v -> dbInformationProduit.delete(nomproduit.getText().toString(),nommodele.getText().toString()
                ,nommarque.getText().toString()));
        //******************************************************************************************

        //button valider pour aller vers l'activité suivante
        //******************************************************************************************
        valider.setOnClickListener(v -> {
            if(nomproduit.getText().toString().isEmpty())
            {
                nomproduit.setError("produit obligatoire!");
                nomproduit.requestFocus();
            }
            else if(nommarque.getText().toString().isEmpty())
            {
                nommarque.setError("marque obligatoire!");
                nommarque.requestFocus();
            }
            else if(nommodele.getText().toString().isEmpty())
            {
                nommodele.setError("modele obligatoire!");
                nommodele.requestFocus();
            }
            else
            {Intent intent1=new Intent(getApplicationContext(),Information.class);
            intent1.putExtra("client",nomclient);
            intent1.putExtra("produit",nomproduit.getText().toString());
            intent1.putExtra("modele",nommodele.getText().toString());
            intent1.putExtra("marque",nommarque.getText().toString());
            startActivity(intent1);}
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
