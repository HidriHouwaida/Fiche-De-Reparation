package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBTableau extends SQLiteOpenHelper {
    public static final String name = "informationTechnicien.db";
    public static final String TableName = "informationtechnicient_table";
    public static final String colomn1 = "NomClient";
    public static final String colomn2 = "Modele";
    public static final String colomn3 = "Marque";
    public static final String colomn4 = "Produit";
    public static final String colomn5 = "1";
    public static final String colomn6 = "2";
    public static final String colomn7 = "3";
    public static final String colomn8 = "4";
    public static final String colomn9 = "5";
    public static final String colomn10 = "6";
    public static final String colomn11 = "7";
    public static final String colomn12 = "8";
    public static final String colomn13 = "9";
    public static final String colomn14 = "10";
    public static final String colomn15 = "11";
    public static final String colomn16 = "12";
    public static final String colomn17 = "13";
    public static final String colomn18 = "14";
    public static final String colomn19 = "15";
    public static final String colomn20 = "16";
    public static final String colomn21 = "17";
    public static final String colomn22 = "18";
    public static final String colomn23 = "19";
    public static final String colomn24 = "20";
    public static final String ID = "ID";

    public DBTableau(Context context) {
        super(context, name, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    // pour la creation de table
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE " + TableName + "(ID INTEGER PRIMARY KEY Autoincrement," +
                "NomClient TEXT,Modele TEXT,Marque TEXT,e1 TEXT,AideTechnicien TEXT,e2 TEXT" +
                ",e3 TEXT,e4 TEXT,e5 TEXT,e6 TEXT,e7 TEXT,e8 TEXT,e9 TEXT,e10 TEXT,e11 TEXT" +
                ",e12 TEXT,e13 TEXT,e14 TEXT,e15 TEXT,e16 TEXT,e17 TEXT,e18 TEXT,e19 TEXT,e20 TEXT)");

    }

    @Override
    //pour la mise à jours
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS " + TableName);
        onCreate(db);

    }

    //insertion des données
    public boolean insert(String NomClient, String Modele,String produit,
                          String Marque, String e1, String e2, String e3,
                          String e4, String e5, String e6,String e7,String e8, String e9
    ,String e10,String e11,String e12,String e13,String e14,String e15
    ,String e16,String e17,String e18,String e19,String e20) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colomn1, NomClient);
        contentValues.put(colomn2, Modele);
        contentValues.put(colomn3, Marque);
        contentValues.put(colomn4, produit);
        contentValues.put(colomn5, e1);
        contentValues.put(colomn6, e2);
        contentValues.put(colomn7, e3);
        contentValues.put(colomn8, e4);
        contentValues.put(colomn9, e5);
        contentValues.put(colomn10, e6);
        contentValues.put(colomn11, e7);
        contentValues.put(colomn12, e8);
        contentValues.put(colomn13, e9);
        contentValues.put(colomn14, e10);
        contentValues.put(colomn15, e11);
        contentValues.put(colomn16, e12);
        contentValues.put(colomn17, e13);
        contentValues.put(colomn18, e14);
        contentValues.put(colomn19, e15);
        contentValues.put(colomn20, e16);
        contentValues.put(colomn21, e17);
        contentValues.put(colomn22, e18);
        contentValues.put(colomn23, e19);
        contentValues.put(colomn24, e20);
        long l = db.insert(TableName, null, contentValues);
        if (l == -1)
            return false;
        else
            return true;
    }
}
