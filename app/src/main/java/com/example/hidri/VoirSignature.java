package com.example.hidri;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class VoirSignature extends AppCompatActivity {
    ImageView receptionnaire,magasinier,resequipe,visaclient;
    DBReceptionnaire dbReceptionnaire;
    DBVisaClient dbVisaClient;
    DBRespEquipe dbRespEquipe;
    DBMagasinier dbMagasinier;
    EditText nomclient,produit,marque,modele;
    Button valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_signature);
        receptionnaire=findViewById(R.id.receptionnaire);
        magasinier=findViewById(R.id.magasinier);
        resequipe=findViewById(R.id.respequipe);
        visaclient=findViewById(R.id.visaclient);
        nomclient=findViewById(R.id.nomclient);
        produit=findViewById(R.id.nomproduit);
        marque=findViewById(R.id.nommarque);
        modele=findViewById(R.id.nommodele);
        valider=findViewById(R.id.valider);
        dbReceptionnaire=new DBReceptionnaire(this);
        dbMagasinier=new DBMagasinier(this);
        dbRespEquipe=new DBRespEquipe(this);
        dbVisaClient=new DBVisaClient(this);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte [] bytes=dbReceptionnaire.getImage(nomclient.getText().toString(),produit.getText().toString()
                        ,marque.getText().toString(),modele.getText().toString());
                if(bytes!=null)
                {
                    Bitmap bitmap=convertByteArraytoBitmap(bytes);
                    receptionnaire.setImageBitmap(bitmap);
                }
                byte [] bytes1=dbMagasinier.getImage(nomclient.getText().toString(),produit.getText().toString()
                        ,marque.getText().toString(),modele.getText().toString());
                if(bytes1!=null)
                {
                    Bitmap bitmap=convertByteArraytoBitmap(bytes1);
                    magasinier.setImageBitmap(bitmap);
                }
                byte [] bytes2=dbRespEquipe.getImage(nomclient.getText().toString(),produit.getText().toString()
                        ,marque.getText().toString(),modele.getText().toString());
                if(bytes2!=null)
                {
                    Bitmap bitmap=convertByteArraytoBitmap(bytes2);
                    resequipe.setImageBitmap(bitmap);
                }
                byte [] bytes3=dbVisaClient.getImage(nomclient.getText().toString(),produit.getText().toString()
                        ,marque.getText().toString(),modele.getText().toString());
                if(bytes3!=null)
                {
                    Bitmap bitmap=convertByteArraytoBitmap(bytes3);
                    visaclient.setImageBitmap(bitmap);
                }
            }
        });


    }
    private Bitmap convertByteArraytoBitmap(byte []image)
    {
        return BitmapFactory.decodeByteArray(image,0,image.length);

    }
}