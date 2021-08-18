package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InformationTechnicien extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button next,bt_choisirdate;
    ImageView imageView;
    TextInputEditText technicien,assistanttechnicien,startrepair,endofrepair,repairdetail;
    String nomclient,produit,marque,modele;
    DBInformationTechnicien dbInformationTechnicien;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_technicien);
        //initialisation des variables
        //******************************************************************************************
        technicien=findViewById(R.id.technician);
        assistanttechnicien=findViewById(R.id.assistanttechnicien);
        startrepair=findViewById(R.id.debutreparition);
        endofrepair=findViewById(R.id.finreparition);
        repairdetail=findViewById(R.id.detailrep);
        dbInformationTechnicien=new DBInformationTechnicien(this);
        Intent intent=getIntent();
        nomclient= intent.getStringExtra("nomclient");
        produit= intent.getStringExtra("produit");
        modele= intent.getStringExtra("modele");
        marque= intent.getStringExtra("marque");
        //******************************************************************************************
        //button next
        //******************************************************************************************
        next=findViewById(R.id.nex);
        next.setOnClickListener(v -> {
            if(technicien.getText().toString().isEmpty())
            {
                technicien.setError("Nom de technicien obligatoire!");
                technicien.requestFocus();
            }
            else if(assistanttechnicien.getText().toString().isEmpty())
            {
                assistanttechnicien.setError("Nom d'aide technicien obligatoire!");
                assistanttechnicien.requestFocus();
            }
            else if(startrepair.getText().toString().isEmpty())
            {
                startrepair.setError("Début de réperation obligatoire!");
                startrepair.requestFocus();
            }
            else if(endofrepair.getText().toString().isEmpty())
            {
                endofrepair.setError("Fin de réparation obligatoire!");
                endofrepair.requestFocus();
            }
            else if(repairdetail.getText().toString().isEmpty())
            {
                repairdetail.setError("Détail de réparation obligatoire!");
                repairdetail.requestFocus();
            }
            else
            {
                dbInformationTechnicien.insert(nomclient,modele,marque,technicien.getText().toString(),
                        assistanttechnicien.getText().toString(),startrepair.getText().toString(),
                        endofrepair.getText().toString(),repairdetail.getText().toString(),produit);
                Intent intent12 =new Intent(getApplicationContext(),date.class);
                intent12.putExtra("nomclient",nomclient);
                intent12.putExtra("produit",produit);
                intent12.putExtra("marque",marque);
                intent12.putExtra("modele",modele);
                startActivity(intent12); }
        });
        //******************************************************************************************
        //imageview pour aller vers le menu
        //******************************************************************************************
        imageView=findViewById(R.id.open_menu);
        imageView.setOnClickListener(v -> {
            Intent intent13 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent13);});
        //******************************************************************************************

        //button pour ouvrir le calendrier
        //******************************************************************************************
        bt_choisirdate=findViewById(R.id.choisirdate);
        bt_choisirdate.setOnClickListener(v -> {
            Intent intent14 =new Intent(getApplicationContext(),Calendrier.class);
            intent14.putExtra("nomclient",nomclient);
            intent14.putExtra("produit",produit);
            intent14.putExtra("marque",marque);
            intent14.putExtra("modele",modele);
            startActivity(intent14);
        });


        //******************************************************************************************

        //recupérer les valeurs des dates
        //******************************************************************************************
        Intent intent1=getIntent();
        startrepair.setText(intent1.getStringExtra("debut"));
        endofrepair.setText(intent1.getStringExtra("fin"));


        //******************************************************************************************
    }
}