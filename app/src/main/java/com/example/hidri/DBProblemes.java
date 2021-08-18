package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBProblemes extends SQLiteOpenHelper {
    public static final String name="problemes.db";
    public static final String TableName ="Problemes_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="Probleme";
    public static final String colomn6="travail";
    public static final String ID="ID";

    public DBProblemes( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Produit TEXT,Probleme TEXT,travail TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Produit , String probleme, String travail)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,probleme);
        contentValues.put(colomn6,travail);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }

    public Cursor getprobleme(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Probleme from "+TableName+" where NomClient=?",new String[]{nomclient});}
    public Cursor gettravail(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select travail from "+TableName+" where NomClient=?",new String[]{nomclient});}
}

