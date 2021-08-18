package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInformationTechnicien extends SQLiteOpenHelper {
    public static final String name="informationTechnicien.db";
    public static final String TableName ="informationtechnicient_table";
    public static final String colomn1="NomClient";
    public static final String colomn2="Modele";
    public static final String colomn3="Marque";
    public static final String colomn4="Produit";
    public static final String colomn5="Technicien";
    public static final String colomn6="AideTechnicien";
    public static final String colomn7="DebutReparation";
    public static final String colomn8="FinReparation";
    public static final String colomn9="DetailReparation";
    public static final String ID="ID";

    public DBInformationTechnicien( Context context) {
        super(context, name, null, 1);
        SQLiteDatabase db=this.getReadableDatabase();
    }

    @Override
    // pour la creation de table
    public void onCreate( SQLiteDatabase db) {
        db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,Technicien TEXT,AideTechnicien TEXT,DebutReparation TEXT" +
                ",FinReparation TEXT,DetailReparation TEXT,Produit TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS "+TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert( String NomClient ,String Modele ,
                           String Marque ,String Technicien , String AideTechnicient, String DebutReparation,
                           String FinReparation,String DetailReparation,String Produit)
    {   SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(colomn1,NomClient);
        contentValues.put(colomn2,Modele);
        contentValues.put(colomn3,Marque);
        contentValues.put(colomn4,Produit);
        contentValues.put(colomn5,Technicien);
        contentValues.put(colomn6,AideTechnicient);
        contentValues.put(colomn7,DebutReparation);
        contentValues.put(colomn8,FinReparation);
        contentValues.put(colomn9,DetailReparation);
        long l=db.insert(TableName,null,contentValues);
        if(l==-1)
            return false;
        else
            return true;
    }
    //pour afficher les données
    public Cursor getall()
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TableName,null);
        return res;}
    //pour la liste des téchnicien
    public Cursor getTechnicien(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select Technicien from "+TableName+" where NomClient=?",new String[]{nomclient});
        return res;}
        //pour la liste des aides téchnicien
    public Cursor getAideTechnicien(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select AideTechnicien from "+TableName+" where NomClient=?",new String[]{nomclient});
        return res;}
    //pour les dates de début réparatio
    public Cursor getdebutReparation(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select DebutReparation from "+TableName+" where NomClient=?",new String[]{nomclient});
        return res;}
    //pour les dates de fin réparation
    public Cursor getfinReparation(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select FinReparation from "+TableName+" where NomClient=?",new String[]{nomclient});
        return res;}
    //pour la liste des détails de réparation
    public Cursor getDetail(String nomclient)
    { SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select DetailReparation from "+TableName+" where NomClient=?",new String[]{nomclient});
        return res;}
}
