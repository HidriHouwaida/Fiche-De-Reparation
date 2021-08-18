package com.example.hidri;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Calendrier extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    DatePicker datePicker;
    Button bt_achat,bt_livraison,bt_enregistrer;



    Button bt_debut,bt_fin,bt_enregistrer1;
    TextView textView_achat,textView_livraison;
    TextView textView_debut_reparation,textView_fin_reparation;


    Button bt_demande,bt_reception,bt_enregistrer2;
    TextView textView_demande,textView_reception;
    //**********************************************************************************************
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);
        //initialisation des variables
        //******************************************************************************************
        datePicker=findViewById(R.id.calendrier);
        textView_achat=findViewById(R.id.textview_date_dachat);
        textView_livraison=findViewById(R.id.textview_date_livraison);
        textView_debut_reparation=findViewById(R.id.textView_debut_reparation);
        textView_fin_reparation=findViewById(R.id.textview_fin_reparation);
        textView_demande=findViewById(R.id.textview_demandePDR);
        textView_reception=findViewById(R.id.textview_receptionPDR);

        Intent intent=getIntent();
        String  nomproduit1= intent.getStringExtra("produit");
        String  modele1= intent.getStringExtra("modele");
        String marque1= intent.getStringExtra("marque");
        String nomclient1=intent.getStringExtra("nomclient");
        //******************************************************************************************

        //button pour lire la date de d'achat
        //******************************************************************************************
        bt_achat=findViewById(R.id.bt_date_dachat);
        bt_achat.setOnClickListener(v -> datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
            String date=dayOfMonth+"/"+monthOfYear+"/"+year;
            textView_achat.setText(date);
        }));
        //******************************************************************************************



        //button pour lire la date de livraison
        //******************************************************************************************
        bt_livraison=findViewById(R.id.bt_date_livraison);
        bt_livraison.setOnClickListener(v -> datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
            String date=dayOfMonth+"/"+monthOfYear+"/"+year;
            textView_livraison.setText(date);}));
        //******************************************************************************************

        //button bt_enregistrer pour enregistrer les dates de livraison et d'achat
        //******************************************************************************************
        bt_enregistrer=findViewById(R.id.enregistrer);
        bt_enregistrer.setOnClickListener(v -> {
            Intent intent12 =new Intent(getApplicationContext(),Information.class);
            intent12.putExtra("date_dachat",textView_achat.getText().toString());
            intent12.putExtra("date_livraison",textView_livraison.getText().toString());
            intent12.putExtra("client",nomclient1);
            intent12.putExtra("produit",nomproduit1);
            intent12.putExtra("modele",modele1);
            intent12.putExtra("marque",marque1);
            startActivity(intent12);
        });
        //******************************************************************************************










        //button pour lire la date de début réparation
        //******************************************************************************************
        bt_debut=findViewById(R.id.bt_debut_reparation);
        bt_debut.setOnClickListener(v -> datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> textView_debut_reparation.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year)));
        //******************************************************************************************
        //button pour lire la date de fin de réparation
        //******************************************************************************************
        bt_fin=findViewById(R.id.bt_fin_reparation);
        bt_fin.setOnClickListener(v -> datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> textView_fin_reparation.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year)));
        //******************************************************************************************

        //button enregistrer pour enregistrer les date de debut et de fin de réparation
        //******************************************************************************************
        bt_enregistrer1=findViewById(R.id.enregistrer1);
        bt_enregistrer1.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),InformationTechnicien.class);
            intent1.putExtra("debut",textView_debut_reparation.getText().toString());
            intent1.putExtra("fin",textView_fin_reparation.getText().toString());
            intent1.putExtra("nomclient",nomclient1);
            intent1.putExtra("produit",nomproduit1);
            intent1.putExtra("modele",modele1);
            intent1.putExtra("marque",marque1);
            startActivity(intent1);
        });




        //******************************************************************************************



        //button pour lire la date de demande PDR
        //******************************************************************************************
        bt_demande=findViewById(R.id.bt_demandePDR);
        bt_demande.setOnClickListener(v -> datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> textView_demande.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year)));
        //******************************************************************************************

        //button pour lire la date de reception PDR
        //******************************************************************************************
        bt_reception=findViewById(R.id.bt_receptionPDR);
        bt_reception.setOnClickListener(v -> datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> textView_reception.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year)));
        //******************************************************************************************


        //button pour enregistrer les dates de demande et reception pdr
        bt_enregistrer2=findViewById(R.id.enregistrer2);
        bt_enregistrer2.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),date.class);
            i.putExtra("demandepdr",textView_demande.getText().toString());
            i.putExtra("receptionpdr",textView_reception.getText().toString());
            i.putExtra("nomclient",nomclient1);
            i.putExtra("produit",nomproduit1);
            i.putExtra("modele",modele1);
            i.putExtra("marque",marque1);
            startActivity(i);
        });

    }
}