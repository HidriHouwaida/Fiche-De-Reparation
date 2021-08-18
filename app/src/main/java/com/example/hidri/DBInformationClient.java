package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInformationClient extends SQLiteOpenHelper {
    public static final String name="client.db";
    public static final String TableName ="client_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="MotDePasse";
    public static final String colomn3="Adresse";
    public static final String colomn4="Societe";
    public static final String colomn5="Telephone";

    public DBInformationClient( Context context) {
        super(context, name, null, 1);
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(NomClient TEXT PRIMARY KEY,MotDePasse TEXT,Adresse TEXT,Societe TEXT,Telephone TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient, String MotDePasse, String Adresse,String Societe,String Telephone)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,MotDePasse);
        contentValues.put(colomn3,Adresse);
        contentValues.put(colomn4,Societe);
        contentValues.put(colomn5,Telephone);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName,null);

    }
    //supprimer les données
    public void delete(String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TableName, "NomClient=?", new String[]{nom});
    }
    //checkusername
    public boolean checkusername(String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select NomClient from "+TableName+" where NomClient=?",new String[]{nom});
        return cursor.getCount() > 0;
    }
    //checkusernamepassword
    public boolean checkusernamepassword(String nom,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select NomClient and MotDePasse from "+TableName+" where NomClient=? and MotDePasse=?",new String[]{nom,password});
        return cursor.getCount() > 0;
    }
    //getpassword
    public Cursor getMotDepasse(String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("Select MotDePasse from "+TableName+" where NomClient=?",new String[]{nom});
    }
    //getAdresse
    public Cursor getAdresse(String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("Select Adresse from "+TableName+" where NomClient=?",new String[]{nom});
    }
    //getNomSociete
    public Cursor getSociete(String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery(" Select Societe from "+TableName+" where NomClient=?",new String[]{nom});
    }

    //getTelephone
    public Cursor getTelephone(String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("Select Telephone from "+TableName+" where NomClient=?",new String[]{nom});
    }
    //la liste des clients
    public Cursor getNameClient() {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("Select NomClient from "+TableName,null);
    }
}
