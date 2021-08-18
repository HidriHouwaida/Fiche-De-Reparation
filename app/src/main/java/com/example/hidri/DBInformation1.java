package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInformation1 extends SQLiteOpenHelper {
    public static final String name="information1.db";
    public static final String TableName ="information1_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="IdentificationNo";
    public static final String colomn6="Agentagre";
    public static final String colomn7="SerialNo";
    public static final String ID="ID";

    public DBInformation1( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Produit TEXT" +
                ",IdentificationNo TEXT,Agentagre TEXT,SerialNo TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Produit ,
                           String IdentifactionNo,String Agentagree ,String SerialNo)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,IdentifactionNo);
        contentValues.put(colomn6,Agentagree);
        contentValues.put(colomn7,SerialNo);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);}
        //identification no
        public Cursor getidentificationno(String nomclient)
        { SQLiteDatabase db=this.getWritableDatabase();
            return db.rawQuery("select IdentificationNo from "+TableName+" where NomClient=?",new String[]{nomclient});}

    //agent agrée
    public Cursor getagent(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Agentagre from "+TableName+" where NomClient=?",new String[]{nomclient});}
    //serial no
    public Cursor getserialno(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select SerialNo from "+TableName+" where NomClient=?",new String[]{nomclient});}
}

