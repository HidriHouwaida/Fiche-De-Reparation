package com.example.hidri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Code extends AppCompatActivity {
    //déclaration des variales
    //**********************************************************************************************
    EditText code;
    Button bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_0;
    ImageView valider,delete;
    //**********************************************************************************************
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        //initialisation des variables
        //******************************************************************************************
        code=findViewById(R.id.code);
        valider=findViewById(R.id.valider);
        delete=findViewById(R.id.delete);

        //******************************************************************************************


        //button_1
        //******************************************************************************************
        bt_1=findViewById(R.id.bt_1);
        bt_1.setOnClickListener(v -> code.setText(code.getText().toString()+"1"));
        //******************************************************************************************

        //button_2
        //******************************************************************************************
        bt_2=findViewById(R.id.bt_2);
        bt_2.setOnClickListener(v -> code.setText(code.getText().toString()+"2"));
        //******************************************************************************************

        //button_3
        //******************************************************************************************
        bt_3=findViewById(R.id.bt_3);
        bt_3.setOnClickListener(v -> code.setText(code.getText().toString()+"3"));
        //******************************************************************************************

        //button_4
        //******************************************************************************************
        bt_4=findViewById(R.id.bt_4);
        bt_4.setOnClickListener(v -> code.setText(code.getText().toString()+"4"));
        //******************************************************************************************

        //button_5
        //******************************************************************************************
        bt_5=findViewById(R.id.bt_5);
        bt_5.setOnClickListener(v -> code.setText(code.getText().toString()+"5"));
        //******************************************************************************************
        //button_6
        //******************************************************************************************
        bt_6=findViewById(R.id.bt_6);
        bt_6.setOnClickListener(v -> code.setText(code.getText().toString()+"6"));
        //******************************************************************************************
        //button_7
        //******************************************************************************************
        bt_7=findViewById(R.id.bt_7);
        bt_7.setOnClickListener(v -> code.setText(code.getText().toString()+"7"));
        //******************************************************************************************
        //button_8
        //******************************************************************************************
        bt_8=findViewById(R.id.bt_8);
        bt_8.setOnClickListener(v -> code.setText(code.getText().toString()+"8"));
        //******************************************************************************************
        //button_9
        //******************************************************************************************
        bt_9=findViewById(R.id.bt_9);
        bt_9.setOnClickListener(v -> code.setText(code.getText().toString()+"9"));
        //******************************************************************************************

        //button_0
        //******************************************************************************************
        bt_0=findViewById(R.id.bt_0);
        bt_0.setOnClickListener(v -> code.setText(code.getText().toString()+"0"));
        //******************************************************************************************

        //imageview pour supprimer
        //******************************************************************************************
        delete.setOnClickListener(v -> code.setText(""));
        //******************************************************************************************

        //imageview pour valider le code
        //******************************************************************************************
        valider.setOnClickListener(v -> {
            if(code.getText().toString().isEmpty())
            {
                code.setError("Code obligatoire!");
                code.requestFocus();
            }
            else if(!code.getText().toString().equals("0000"))
            {
                code.setError("Code inccorcet!");
                code.requestFocus();
            }
            else if(code.getText().toString().equals("0000"))
            {
                Intent intent=new Intent(getApplicationContext(),ChoisirNomClient.class);
                startActivity(intent);
            }
        });



        //*******************************************************************************************
    }
}