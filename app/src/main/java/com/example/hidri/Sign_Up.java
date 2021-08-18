package com.example.hidri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Sign_Up extends AppCompatActivity {


    //déclaration des variables
    //**********************************************************************************************
    TextInputEditText username,password,adress,name_of_the_socity,telephone;
    Button signup,aleardyhadaccount;
    DBInformationClient dbInformationClient;
    //**********************************************************************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        //initialisation des variables
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        adress=findViewById(R.id.adress);
        name_of_the_socity=findViewById(R.id.nomsociete);
        telephone=findViewById(R.id.telephone_domicile);
        signup=findViewById(R.id.sign_up_button);
        aleardyhadaccount=findViewById(R.id.button_aleardyhadaccount);
        dbInformationClient=new DBInformationClient(this);
        //setOnClickListener pour le button vous avez déja un compte
        //******************************************************************************************
        aleardyhadaccount.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),Sign_In.class);
            startActivity(intent);
        });
        //******************************************************************************************

        //setOnClickListener pour le button Création de compte
        //******************************************************************************************
        signup.setOnClickListener(v -> {
            //test pour vérifier que tous les champs sont remplis
            if(username.getText().toString().isEmpty())
            {
                username.setError("Nom client obligatoire !");
                username.requestFocus();
            }
            else if(password.getText().toString().isEmpty())
            {
                password.setError("Mot de passe obligatoire!");
                password.requestFocus();
            }
            //longueur de password doit étre >6
            else if(password.getText().toString().length()<6)
            {
                password.setError("Longueur minimal de mot de passe 6!");
                password.requestFocus();
            }
            else if(adress.getText().toString().isEmpty())
            {
                adress.setError("Adresse email obligatoire!");
                adress.requestFocus();
            }
            else if(name_of_the_socity.getText().toString().isEmpty())
            {  name_of_the_socity.setError("Nom de société obligatoire!");
                name_of_the_socity.requestFocus();
            }
            else if(telephone.getText().toString().isEmpty())
            {
                telephone.setError("Téléphone de socité obligatoire!");
                telephone.requestFocus();
            }
            else if(telephone.getText().toString().length()<8)
            {
                telephone.setError("Téléphone de sociéte non valide!");
                telephone.requestFocus();
            }
            else
            {
                boolean checkuser=dbInformationClient.checkusername(username.getText().toString());
                if(!checkuser)
                {
                    boolean insert=dbInformationClient.insert(username.getText().toString(),password.getText().toString(),
                            adress.getText().toString(),name_of_the_socity.getText().toString(),
                            telephone.getText().toString());
                    if(insert)
                    {
                        Toast.makeText(getApplicationContext(),"inscription réussie",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),Sign_In.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"échec de l'enregistrement",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"utilisateur existe déja! ",Toast.LENGTH_LONG).show();
                }
            }

        });
        //******************************************************************************************
    }
}