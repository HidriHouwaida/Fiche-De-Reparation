package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInformation  extends SQLiteOpenHelper {
    public static final String name="information.db";
    public static final String TableName ="information_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="DateAchat";
    public static final String colomn6="Revendeur";
    public static final String colomn7="Panne";
    public static final String colomn8="Diag";
    public static final String colomn9="DateLivraison";
    public static final String ID="ID";

    public DBInformation( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Produit TEXT,DateAchat TEXT,Revendeur TEXT" +
                ",Panne TEXT,Diag TEXT,DateLivraison TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Produit , String DateAchat, String Revendeur,
                           String Panne,String Diag ,String DateLivraison)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,DateAchat);
        contentValues.put(colomn6,Revendeur);
        contentValues.put(colomn7,Panne);
        contentValues.put(colomn8,Diag);
        contentValues.put(colomn9,DateLivraison);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);}
        //datedachat
        public Cursor getdatedachat(String nomclient)
        { SQLiteDatabase db=this.getWritableDatabase();
            return db.rawQuery("select DateAchat from "+TableName+" where NomClient=?",new String[]{nomclient});}

    //revendeur
    public Cursor getrevendeur(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Revendeur from "+TableName+" where NomClient=?",new String[]{nomclient});}


    //panne
    public Cursor getpanne(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Panne from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //diag
    public Cursor getdiag(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Diag from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //datedachat
    public Cursor getDateLivraison(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select DateLivraison from "+TableName+" where NomClient=?",new String[]{nomclient});}
}
