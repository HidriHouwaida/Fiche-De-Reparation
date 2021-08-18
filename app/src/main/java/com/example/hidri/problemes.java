package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class problemes extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    ImageView imageView;
    String nomclient,produit,marque,modele,travail,probleme;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
    DBProblemes dbProblemes;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problemes);
        //initialisation des variables
        //******************************************************************************************
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        marque= intent.getStringExtra("marque");
        modele= intent.getStringExtra("modele");
        travail= intent.getStringExtra("travail");
        probleme=" ";
        checkBox1=findViewById(R.id.technique);
        checkBox2=findViewById(R.id.reparationdifficle);
        checkBox3=findViewById(R.id.tempsinsuffisant);
        checkBox4=findViewById(R.id.clientnondisponible);
        checkBox5=findViewById(R.id.aucun);
        dbProblemes=new DBProblemes(this);
        //******************************************************************************************
        //button next pour aller vers l'activité remarque
        //******************************************************************************************
            checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked)
                {probleme=probleme+" Technique"+"\n";}
            });
            checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked)
                {probleme=probleme+" Réparation Difficile"+"\n";}
            });
            checkBox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked)
                {probleme=probleme+" Temps Insuffisant"+"\n";}
            });
            checkBox4.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked)
                { probleme=probleme+" Client Non Disponible"+"\n";}
            });
            checkBox5.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked)
                {  probleme=probleme+" Aucun"+"\n";}
            });
            next=findViewById(R.id.next);
            next.setOnClickListener(v -> dbProblemes.insert(nomclient,modele,marque,produit,probleme,travail));
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