package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMontantApayer extends SQLiteOpenHelper {
    public static final String name="MontantApayer.db";
    public static final String TableName ="MontantApayer_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="Electrostar";
    public static final String colomn6="Client";
    public static final String ID="ID";

    public DBMontantApayer( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Electrostar TEXT,Client TEXT,Produit TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Electrostar , String Client,String Produit)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,Electrostar);
        contentValues.put(colomn6,Client);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);}
    //pour afficher les données
    public Cursor getclient(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Client from "+TableName+" where NomClient=?",new String[]{nomclient});}

    //pour afficher les données
    public Cursor getElectrostar(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Electrostar from "+TableName+" where NomClient=?",new String[]{nomclient});}



}
