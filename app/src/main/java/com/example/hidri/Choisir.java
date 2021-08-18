package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Choisir extends AppCompatActivity {
    EditText nomclient;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir);
        nomclient=findViewById(R.id.nomclient);
        bt=findViewById(R.id.valider);
        bt.setOnClickListener(v -> {
            if(nomclient.getText().toString().isEmpty())
            {
                nomclient.setError("nom client obligatoire!");
                nomclient.requestFocus();
            }
            else
            {Intent intent=new Intent(getApplicationContext(),InformationClientProduit.class);
            intent.putExtra("nomclient",nomclient.getText().toString());
            startActivity(intent);}
        });
    }
}