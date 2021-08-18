package com.example.hidri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Remarques extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    Button send;
    ImageView imageView;
    EditText to,subject,message;
    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remarques);
        //initialisation des variables
        //******************************************************************************************
        send=findViewById(R.id.bt_send);
        to=findViewById(R.id.edit_to);
        imageView=findViewById(R.id.open_menu);
        subject=findViewById(R.id.edit_subject);
        message=findViewById(R.id.edit_message);
        //******************************************************************************************


        //button pour envoyer un email
        //******************************************************************************************
        send.setOnClickListener(v -> {
            String receptionlist=to.getText().toString();
            String []receptions=receptionlist.split(",");
            Intent intent13 =new Intent(Intent.ACTION_SEND);
            intent13.putExtra(Intent.EXTRA_EMAIL,receptions);
            intent13.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
            intent13.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
            intent13.setType("message/rfc822");
            startActivity(Intent.createChooser(intent13,"choisir "));
        });
        //******************************************************************************************





        //imageview pour ouvrir le menu de l'application
        //******************************************************************************************
        imageView.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),MenuApplication.class);
            startActivity(intent1);});
        //******************************************************************************************

    }
}