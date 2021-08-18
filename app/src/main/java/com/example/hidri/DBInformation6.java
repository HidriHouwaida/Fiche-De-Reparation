package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInformation6 extends SQLiteOpenHelper {
    public static final String name="information6.db";
    public static final String TableName ="information6_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="ModHT";
    public static final String colomn6="Deplacement";
    public static final String colomn7="Transport";
    public static final String colomn8="PDRHT";
    public static final String colomn9="Supplement";
    public static final String colomn10="ReelTTC";
    public static final String ID="ID";

    public DBInformation6( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,ModHT TEXT,Deplacement TEXT,Transport TEXT" +
                ",PDRHT TEXT,Supplement TEXT,ReelTTC TEXT,Produit TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String ModHT , String Deplacement, String Transport,
                           String PDRHT,String Supplement,String ReelTTC,String Produit)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,ModHT);
        contentValues.put(colomn6,Deplacement);
        contentValues.put(colomn7,Transport);
        contentValues.put(colomn8,PDRHT);
        contentValues.put(colomn9,Supplement);
        contentValues.put(colomn10,ReelTTC);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);}
    //**********************************************************************************************

    public Cursor getModHt(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select ModHT from "+TableName+" where NomClient=?",new String[]{nomclient});}
    public Cursor getDeplacement(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Deplacement from "+TableName+" where NomClient=?",new String[]{nomclient});}
    public Cursor getTransport(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Transport from "+TableName+" where NomClient=?",new String[]{nomclient});}
    public Cursor getPDRHT(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select PDRHT from "+TableName+" where NomClient=?",new String[]{nomclient});}
    public Cursor getSupplement(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Supplement from "+TableName+" where NomClient=?",new String[]{nomclient});}
    public Cursor getReelTTC(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select ReelTTC from "+TableName+" where NomClient=?",new String[]{nomclient});}
}
