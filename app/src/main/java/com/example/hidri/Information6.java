package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Information6 extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next;
    TextInputEditText amountmodeht,dispalcement,transport,htpdramount,othersupplement,amountincludingvt;
    ImageView imageView;
    String nomclient,produit,marque,modele;
    DBInformation6 dbInformation6;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information6);
        //initialisation des variables
        //******************************************************************************************
        amountmodeht=findViewById(R.id.amountmodeht);
        dispalcement=findViewById(R.id.displacement);
        transport=findViewById(R.id.transport);
        Intent intent=getIntent();
        htpdramount=findViewById(R.id.htamountpdr);
        othersupplement=findViewById(R.id.othersupplements);
        amountincludingvt=findViewById(R.id.amountincludingvat);
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        marque= intent.getStringExtra("marque");
        modele= intent.getStringExtra("modele");
        dbInformation6=new DBInformation6(this);
        //******************************************************************************************

        //button pour aller vers l'activité montant à payer
        //******************************************************************************************
        next=findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if(amountmodeht.getText().toString().isEmpty())
            {
                amountmodeht.setError("Montant MOD HT obligatoir!");
                amountmodeht.requestFocus();
            }
            else if(dispalcement.getText().toString().isEmpty())
            {  dispalcement.setError("Montant déplacement HT obligatoire!");
                dispalcement.requestFocus();

            }
            else if(transport.getText().toString().isEmpty())
            {
                transport.setError("Montant de transport PDR obligatoire!");
                transport.requestFocus();
            }
            else if(htpdramount.getText().toString().isEmpty())
            {
                htpdramount.setError("Montant PDR HT obligatoire!");
                htpdramount.requestFocus();
            }
            else if(othersupplement.getText().toString().isEmpty())
            {
                othersupplement.setError("Montant Autres Supplément HT obligatoire!");
                othersupplement.requestFocus();
            }
            else if(amountincludingvt.getText().toString().isEmpty())
            {
                amountincludingvt.setError("Montant réel TTC obligatoire!");
                amountincludingvt.requestFocus();
            }
            else
            {
                dbInformation6.insert(nomclient,modele,marque,amountmodeht.getText().toString(),
                        dispalcement.getText().toString(),transport.getText().toString(),htpdramount.getText().toString(),
                        othersupplement.getText().toString(),amountincludingvt.getText().toString(),produit);
                Intent intent1 =new Intent(getApplicationContext(),MontantApayer.class);
                intent1.putExtra("nomclient",nomclient);
                intent1.putExtra("produit",produit);
                intent1.putExtra("modele",modele);
                intent1.putExtra("marque",marque);
                startActivity(intent1);
            }
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