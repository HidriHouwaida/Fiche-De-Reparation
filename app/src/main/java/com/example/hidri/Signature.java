package com.example.hidri;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.ByteArrayOutputStream;

public class Signature extends AppCompatActivity {
    //signature de receptionnaire
    Button clear_receptionaire,save_receptionnaire;
    SignaturePad signature_receptionnaire;
    RelativeLayout relativeLayout_receptionnaire;
    ImageView imageView_receptionnaire;
    DBReceptionnaire dbReceptionnaire;
    //**********************************************************************************************
    //signature de magasinier
    Button clear_magasinier,save_magasinier;
    SignaturePad signature_magasinier;
    RelativeLayout relativeLayout_magasinier;
    ImageView imageView_magasinier;
    DBMagasinier dbMagasinier;
    //**********************************************************************************************
    //signature de resp equipe
    Button clear_resp_equipe,save_resp_equipe;
    SignaturePad signature_resp_equipe ;
    RelativeLayout relativeLayout_resp_equipe;
    ImageView imageView_resp_equipe;
    DBRespEquipe dbRespEquipe;
    //**********************************************************************************************
    //signature de visa client
    Button clear_visa_client,save_visa_client;
    SignaturePad signature_visa_client ;
    RelativeLayout relativeLayout_visa_client;
    ImageView imageView_visa_client;
    DBVisaClient dbVisaClient;
    //**********************************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        //récupération de nomclient produit marque modele
        Intent intent=getIntent();
        String nomclient=intent.getStringExtra("nomclient");
        String produit= intent.getStringExtra("produit");
        String marque= intent.getStringExtra("marque");
        String modele= intent.getStringExtra("modele");

        //signature receptionnaire
        clear_receptionaire=findViewById(R.id.bt_claer_receptionnaire);
        save_receptionnaire=findViewById(R.id.bt_save_receptionnaire);
        relativeLayout_receptionnaire=findViewById(R.id.receptionnaire);
        imageView_receptionnaire=findViewById(R.id.image_receptionnaire);
        signature_receptionnaire=findViewById(R.id.signature_pad_receptionnaire);
        dbReceptionnaire=new DBReceptionnaire(this);
        clear_receptionaire.setOnClickListener(v -> signature_receptionnaire.clear());
        save_receptionnaire.setOnClickListener(v -> {
            Bitmap bitmap=Bitmap.createBitmap(relativeLayout_receptionnaire.getWidth(),relativeLayout_receptionnaire.getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas=new Canvas(bitmap);
            relativeLayout_receptionnaire.draw(canvas);
            imageView_receptionnaire.setImageBitmap(bitmap);
            byte [] pp=convertImageViewToByteArray(imageView_receptionnaire);
            Boolean insert=dbReceptionnaire.insert(nomclient,modele,marque,produit,pp);
            if(insert==true)
            {
                Toast.makeText(getApplicationContext(),"save successful",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"save failed",Toast.LENGTH_LONG).show();
            }
        });
        //*******************************************************************************************
        //signature magasinier
        clear_magasinier=findViewById(R.id.bt_claer_magasinier);
        save_magasinier=findViewById(R.id.bt_save_magasinier);
        relativeLayout_magasinier=findViewById(R.id.magasinier);
        imageView_magasinier=findViewById(R.id.image_magasinier);
        dbMagasinier=new DBMagasinier(this);
        signature_magasinier=findViewById(R.id.signature_pad_magasinier);
        clear_magasinier.setOnClickListener(v -> signature_magasinier.clear());
        save_magasinier.setOnClickListener(v -> {
            Bitmap bitmap=Bitmap.createBitmap(relativeLayout_magasinier.getWidth(),relativeLayout_magasinier.getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas=new Canvas(bitmap);
            relativeLayout_magasinier.draw(canvas);
            imageView_magasinier.setImageBitmap(bitmap);
            byte [] pp=convertImageViewToByteArray(imageView_magasinier);
            Boolean insert=dbMagasinier.insert(nomclient,modele,marque,produit,pp);
            if(insert==true)
            {
                Toast.makeText(getApplicationContext(),"save successful",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"save failed",Toast.LENGTH_LONG).show();
            }

        });
        //******************************************************************************************
        //signature de resp equipe
        clear_resp_equipe=findViewById(R.id.bt_claer_res_equipe);
        save_resp_equipe=findViewById(R.id.bt_save_res_equipe);
        relativeLayout_resp_equipe=findViewById(R.id.resp_equipe);
        imageView_resp_equipe=findViewById(R.id.image_res_equipe);
        dbRespEquipe=new DBRespEquipe(this);
        signature_resp_equipe=findViewById(R.id.signature_pad_resp_equipe);
        clear_resp_equipe.setOnClickListener(v -> signature_resp_equipe.clear());
        save_resp_equipe.setOnClickListener(v -> {
            Bitmap bitmap=Bitmap.createBitmap(relativeLayout_resp_equipe.getWidth(),relativeLayout_resp_equipe.getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas=new Canvas(bitmap);
            relativeLayout_resp_equipe.draw(canvas);
            imageView_resp_equipe.setImageBitmap(bitmap);
            byte [] pp=convertImageViewToByteArray(imageView_resp_equipe);
            Boolean insert=dbRespEquipe.insert(nomclient,modele,marque,produit,pp);
            if(insert==true)
            {
                Toast.makeText(getApplicationContext(),"save successful",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"save failed",Toast.LENGTH_LONG).show();
            }
        });
        //******************************************************************************************
        //signature visa client
        clear_visa_client=findViewById(R.id.bt_claer_visa_client);
        save_visa_client=findViewById(R.id.bt_save_visa_client);
        relativeLayout_visa_client=findViewById(R.id.visa_client);
        imageView_visa_client=findViewById(R.id.image_visa_client);
        dbVisaClient=new DBVisaClient(this);
        signature_visa_client=findViewById(R.id.signature_pad_visa_client);
        clear_visa_client.setOnClickListener(v -> signature_visa_client.clear());
        save_visa_client.setOnClickListener(v -> {
            Bitmap bitmap=Bitmap.createBitmap(relativeLayout_visa_client.getWidth(),relativeLayout_visa_client.getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas=new Canvas(bitmap);
            relativeLayout_visa_client.draw(canvas);
            imageView_visa_client.setImageBitmap(bitmap);
            byte [] pp=convertImageViewToByteArray(imageView_visa_client);
            Boolean insert=dbVisaClient.insert(nomclient,modele,marque,produit,pp);
            if(insert==true)
            {
                Toast.makeText(getApplicationContext(),"save successful",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"save failed",Toast.LENGTH_LONG).show();
            }
        });
    }
    private byte [] convertImageViewToByteArray(ImageView imageView)
    {
        Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}