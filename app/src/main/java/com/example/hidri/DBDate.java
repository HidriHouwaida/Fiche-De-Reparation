package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDate extends SQLiteOpenHelper {
    public static final String name="date.db";
    public static final String TableName ="date_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="DateDemandePDR";
    public static final String colomn6="DateReceptionPDR";
    public static final String ID="ID";

    public DBDate( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Produit TEXT,DateDemandePDR TEXT,DateReceptionPDR TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Produit , String DateDemandePDR, String DateReceptionPDR)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,DateDemandePDR);
        contentValues.put(colomn6,DateReceptionPDR);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);}
    //pour afficher la date de demande réparation
    public Cursor getDemande(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select DateDemandePDR from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //pour afficher la date de reception réparation
    public Cursor getReception(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select DateReceptionPDR from "+TableName+" where NomClient=?",new String[]{nomclient});}
}