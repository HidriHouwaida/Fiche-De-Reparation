package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInformationProduit extends SQLiteOpenHelper {
    public static final String name="produit.db";
    public static final String TableName ="produit_table";
    public static final String id="id";
    public static final String colomn1="marque";
    public static final String colomn4="NomClient";
    public static final String colomn2="produit";
    public static final String colomn3="modele";

    public DBInformationProduit( Context context) {
        super(context, name, null, 1);
    }
    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY AUTOINCREMENT ,marque TEXT,produit TEXT,modele TEXT,NomClient TEXT)");
    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String marque, String modele, String produit,String NomClient)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,marque);
        contentValues.put(colomn2,produit);
        contentValues.put(colomn3,modele);
        contentValues.put(colomn4,NomClient);
        long l=db.insert(TableName,null,contentValues);
        return l != -1;
    }
    //pour afficher les données
    public Cursor getall(String nomclient)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+TableName+" where NomClient=?",new String []{nomclient});

    }
    //supprimer les données
    public void delete(String produit, String modele, String marque)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TableName, " produit=? and marque=? and modele=?", new String[]{produit, marque, modele});
    }

    public Cursor getMarque(String nomclient)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Marque from "+TableName+" where NomClient=?",new String []{nomclient});

    }

    public Cursor getProduit(String nomclient)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Produit from "+TableName+" where NomClient=?",new String []{nomclient});

    }

    public Cursor getModele(String nomclient)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select Modele from "+TableName+" where NomClient=?",new String []{nomclient});

    }
}
