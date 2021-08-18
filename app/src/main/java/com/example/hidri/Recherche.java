package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Recherche extends AppCompatActivity {
    TextView informationSocite,informationclientetproduit,signature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        informationSocite=findViewById(R.id.societe);
        informationclientetproduit=findViewById(R.id.client);
        signature=findViewById(R.id.signature);
        informationSocite.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),InformationSociete.class);
            startActivity(intent);
        });
        informationclientetproduit.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Choisir.class);
            startActivity(intent);
        });
        signature.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),VoirSignature.class);
            startActivity(intent);
        });
    }
}