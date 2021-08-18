package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBParametreMesure extends SQLiteOpenHelper {
    public static final String name="Parametremesure.db";
    public static final String TableName ="Parametremesure_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="Tension";
    public static final String colomn6="Soufflage";
    public static final String colomn7="Reprise";
    public static final String colomn8="Absorbe";
    public static final String colomn9="Steg";
    public static final String colomn10="Refoulement";
    public static final String ID="ID";

    public DBParametreMesure( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Produit TEXT,Tension TEXT,Soufflage TEXT" +
                ",Reprise TEXT,Absorbe TEXT,Steg TEXT,Refoulement TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Produit , String Tension, String Soufflage,
                           String Reprise,String Absorbe,String Steg,String Refoulement)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,Tension);
        contentValues.put(colomn6,Soufflage);
        contentValues.put(colomn7,Reprise);
        contentValues.put(colomn8,Absorbe);
        contentValues.put(colomn9,Steg);
        contentValues.put(colomn10,Refoulement);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);}
    //tension
    public Cursor gettension(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Tension from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //tension
    public Cursor getsoufflage(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Soufflage from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //Reprise
    public Cursor getReprise(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Reprise from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //STEG
    public Cursor getSTEG(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Steg from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //tension
    public Cursor getrefoulement(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Refoulement from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //absorbe
    public Cursor getabsorbe(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Absorbe from "+TableName+" where NomClient=?",new String[]{nomclient});}

}

