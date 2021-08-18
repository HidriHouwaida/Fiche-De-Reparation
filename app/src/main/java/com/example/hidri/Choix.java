package com.example.hidri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Choix extends AppCompatActivity {
    Button valider;
    EditText nomclient,nomproduit,marque,modele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        valider=findViewById(R.id.bt_valider);
        nomclient=findViewById(R.id.nomclient);
        nomproduit=findViewById(R.id.nomproduit);
        marque=findViewById(R.id.nommarque);
        modele=findViewById(R.id.nommodele);
        valider.setOnClickListener(v -> {
            if(nomclient.getText().toString().isEmpty())
            {
                nomclient.setError("nom client  obligatoire!");
                nomclient.requestFocus();
             }
           else if(nomproduit.getText().toString().isEmpty())
            {
                nomproduit.setError("produit obligatoire!");
                nomproduit.requestFocus();
            }
            else if(marque.getText().toString().isEmpty())
            {
                marque.setError("marque obligatoire!");
                marque.requestFocus();
            }
            else if(modele.getText().toString().isEmpty())
            {
                modele.setError("modele obligatoire!");
                modele.requestFocus();
            }
            else
            {Intent intent=new Intent(getApplicationContext(),Signature.class);
            intent.putExtra("nomclient",nomclient.getText().toString());
            intent.putExtra("modele",modele.getText().toString());
            intent.putExtra("marque",marque.getText().toString());
            intent.putExtra("produit",nomproduit.getText().toString());
            startActivity(intent);}
        });
    }
}