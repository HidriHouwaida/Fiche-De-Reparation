package com.example.hidri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMagasinier extends SQLiteOpenHelper {
    public static final String name="Magasinier.db";
    public static final String TableName ="magasinier_table";
    public static final String colomn1="NomClient";
        public static final String colomn2="Modele";
        public static final String colomn3="Marque";
        public static final String colomn4="Produit";
        public static final String ID="ID";

    public DBMagasinier( Context context) {
            super(context, name, null, 1);
        }

        @Override
        // pour la creation de table
        public void onCreate( SQLiteDatabase db) {
            db.execSQL("create TABLE " +TableName+"(ID INTEGER PRIMARY KEY Autoincrement," +
                    "NomClient TEXT,Modele TEXT,Marque TEXT,Produit TEXT,image blob)");

        }

        @Override
        //pour la mise à jours
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE if EXISTS "+TableName);
            onCreate(db);

        }

        //insertion des données
        public boolean insert( String NomClient ,String Modele ,
                String Marque ,String Produit ,byte [] image)
        {   SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(colomn1,NomClient);
            contentValues.put(colomn2,Modele);
            contentValues.put(colomn3,Marque);
            contentValues.put(colomn4,Produit);
            contentValues.put("image",image);
            long l=db.insert(TableName,null,contentValues);
            return l != -1;
        }

        public byte[] getImage(String nomclient,String produit,String marque,String modele)
        {
            try
            {SQLiteDatabase db=this.getWritableDatabase();
                Cursor cursor=db.rawQuery("select image from "+TableName+" where NomClient=? and " +
                        "produit=? and modele=? and marque=?",new String[]
                        {nomclient,produit,modele,marque});
                if(cursor.moveToFirst())
                {
                    return cursor.getBlob(0);
                }
                return null;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
    }