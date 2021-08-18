package com.example.hidri;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformationClientProduit extends AppCompatActivity {
    //déclaration des variables
    //**********************************************************************************************
    String nomclient;
    TextView nom,adresse,societe,telephone,marque,modele,produit;
    DBInformationClient dbInformationClient;
    DBInformationProduit dbInformationProduit;
    TextView datedachat,revendeur,panne,diag,livraison;
    DBInformation dbInformation;
    TextView identification,agent,serial,intervention,refclient;
    DBInformation1 dbInformation1;
    DBInformation2 dbInformation2;
    TextView demande,reception,tension,soufflage,reprise;
    DBDate dbDate;DBParametreMesure dbParametreMesure;
    TextView absorbe,steg,pression,modht,deplacement,transport,pdrrht,supplement,reelttc,electrostar,client;
    DBInformation6 dbInformation6;
    DBMontantApayer dbMontantApayer;
    DBDegresatisfaction dbDegresatisfaction;
    //**********************************************************************************************
    //**********************************************************************************************
    //**********************************************************************************************
    TextView travail,degresatisfaction,probleme;
    DBProblemes dbProbleme;
    DBInformationTechnicien dbInformationTechnicien;
    TextView technicien,aidetechnicien,debut,fin,detail;
    //**********************************************************************************************





    //**********************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_client_produit);
        //initialisation des variables
        //******************************************************************************************

        //1******************************************************************************************
        Intent intent=getIntent();
        nomclient=intent.getStringExtra("nomclient");
        nom=findViewById(R.id.nom);nom.setText("  "+nomclient+"\n"+"\n"+"\n"+"\n"+"\n");
        adresse=findViewById(R.id.adresse);
        societe=findViewById(R.id.societe);
        telephone=findViewById(R.id.telephone);
        marque=findViewById(R.id.marque);
        modele=findViewById(R.id.modele);
        produit=findViewById(R.id.produit);
        dbInformationClient=new DBInformationClient(this);
        dbInformationProduit=new DBInformationProduit(this);
        //******************************************************************************************
        //2*****************************************************************************************
        datedachat=findViewById(R.id.datedachat);
        revendeur=findViewById(R.id.revendeu);
        panne=findViewById(R.id.panne);
        diag=findViewById(R.id.diag);
        livraison=findViewById(R.id.livraison);
        dbInformation=new DBInformation(this);
        //******************************************************************************************
        //3******************************************************************************************
        identification=findViewById(R.id.identification);
        agent=findViewById(R.id.agent);
        serial=findViewById(R.id.serialno);
        intervention=findViewById(R.id.intervention);
        refclient=findViewById(R.id.refclient);
        dbInformation1=new DBInformation1(this);
        dbInformation2=new DBInformation2(this);
        //******************************************************************************************
        //4*****************************************************************************************
        dbDate=new DBDate(this);
        demande=findViewById(R.id.demandepdr);
        reception=findViewById(R.id.receptionpdr);
        //******************************************************************************************
        //5*****************************************************************************************
        tension=findViewById(R.id.tension_mesure);
        soufflage=findViewById(R.id.soufflage);
        reprise=findViewById(R.id.reprise);
        dbParametreMesure=new DBParametreMesure(this);
        //******************************************************************************************
        //6*****************************************************************************************
        absorbe=findViewById(R.id.absorbe);
        steg=findViewById(R.id.steg);
        pression=findViewById(R.id.pression);
        modht=findViewById(R.id.modht);
        deplacement=findViewById(R.id.deplacement);
        transport=findViewById(R.id.transport);
        pdrrht=findViewById(R.id.pdrht);
        supplement=findViewById(R.id.supplement);
        reelttc=findViewById(R.id.reelttc);
        electrostar=findViewById(R.id.electrostar);
        client=findViewById(R.id.client);
        dbInformation6=new DBInformation6(this);
        dbMontantApayer=new DBMontantApayer(this);
        //******************************************************************************************
        //******************************************************************************************
        degresatisfaction=findViewById(R.id.degresatisfaction);
        dbDegresatisfaction=new DBDegresatisfaction(this);
        travail=findViewById(R.id.travail);
        probleme=findViewById(R.id.probleme);
        dbProbleme=new DBProblemes(this);
        //******************************************************************************************
         dbInformationTechnicien=new DBInformationTechnicien(this);
         technicien=findViewById(R.id.technicien);
         aidetechnicien=findViewById(R.id.aidetechnicien);
         debut=findViewById(R.id.debut);
         fin=findViewById(R.id.fin);
         detail=findViewById(R.id.detail);



        //******************************************************************************************

        //trouver la valeur d'adresse
        //******************************************************************************************
        Cursor cursor = dbInformationClient.getAdresse(nomclient);
        if(cursor.getCount()==0)
        {
           return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor.moveToNext())
            {
                buffer.append(cursor.getString(0)+"\n");
            }
           adresse.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver la valeur de nom de société
        //******************************************************************************************
        Cursor cursor1 = dbInformationClient.getSociete(nomclient);
        if(cursor1.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor1.moveToNext())
            {
                buffer.append(cursor1.getString(0)+"\n");
            }
            societe.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //trouver la valeur de numéro de téléphone
        //******************************************************************************************
        Cursor cursor2 = dbInformationClient.getTelephone(nomclient);
        if(cursor2.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor2.moveToNext())
            {
                buffer.append(cursor2.getString(0)+"\n");
            }
            telephone.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver tous les marques
        //******************************************************************************************
        Cursor cursor3 = dbInformationProduit.getMarque(nomclient);
        if(cursor3.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor3.moveToNext())
            {
                buffer.append(cursor3.getString(0)+"\n"+"  ");
            }
            marque.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //trouver tous les mmodeles
        //******************************************************************************************
        Cursor cursor4 = dbInformationProduit.getModele(nomclient);
        if(cursor4.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor4.moveToNext())
            {
                buffer.append(cursor4.getString(0)+"\n"+"  ");
            }
            modele.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //trouver tous les produits
        //******************************************************************************************
        Cursor cursor5 = dbInformationProduit.getProduit(nomclient);
        if(cursor5.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor5.moveToNext())
            {
                buffer.append(cursor5.getString(0)+"\n"+"  ");
            }
            produit.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************









        //trouver les dates d'achat
        //******************************************************************************************
        Cursor cursor6 = dbInformation.getdatedachat(nomclient);
        if(cursor6.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor6.moveToNext())
            {
                buffer.append(cursor6.getString(0)+"\n"+" ");
            }
            datedachat.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver tous les revendeur
        //******************************************************************************************
        Cursor cursor7 = dbInformation.getrevendeur(nomclient);
        if(cursor7.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor7.moveToNext())
            {
                buffer.append(cursor7.getString(0)+"\n"+" ");
            }
            revendeur.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //trouver tous les pannes clients
        //******************************************************************************************
        Cursor cursor8 = dbInformation.getpanne(nomclient);
        if(cursor8.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor8.moveToNext())
            {
                buffer.append(cursor8.getString(0)+"\n"+" ");
            }
            panne.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver tous les diag 1ere niveau
        //******************************************************************************************
        Cursor cursor9 = dbInformation.getdiag(nomclient);
        if(cursor9.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor9.moveToNext())
            {
                buffer.append(cursor9.getString(0)+"\n"+" ");
            }
            diag.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver tous les dates prévue de livraison
        //******************************************************************************************
        Cursor cursor10 = dbInformation.getDateLivraison(nomclient);
        if(cursor10.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor10.moveToNext())
            {
                buffer.append(cursor10.getString(0)+"\n"+" ");
            }
            livraison.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

       //trouver tous les identification no
        //******************************************************************************************
        Cursor cursor11 = dbInformation1.getidentificationno(nomclient);
        if(cursor11.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor11.moveToNext())
            {
                buffer.append(cursor11.getString(0)+"\n"+" ");
            }
            identification.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver tous les Agents agrée
        //******************************************************************************************
        Cursor cursor12 = dbInformation1.getagent(nomclient);
        if(cursor12.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor12.moveToNext())
            {
                buffer.append(cursor12.getString(0)+"\n"+" ");
            }
            agent.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //trouver tous les SerialNo
        //******************************************************************************************
        Cursor cursor13 = dbInformation1.getserialno(nomclient);
        if(cursor13.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor13.moveToNext())
            {
                buffer.append(cursor13.getString(0)+"\n"+" ");
            }
            serial.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //trouver tous les interventions
        //******************************************************************************************
        Cursor cursor14 = dbInformation2.getintervention(nomclient);
        if(cursor14.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor14.moveToNext())
            {
                buffer.append(cursor14.getString(0)+"\n"+" ");
            }
            intervention.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //ref client
        //******************************************************************************************
        Cursor cursor15 = dbInformation2.getrefclient(nomclient);
        if(cursor15.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor15.moveToNext())
            {
                buffer.append(cursor15.getString(0)+"\n"+" ");
            }
            refclient.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //date demande pdr
        //******************************************************************************************
        Cursor cursor21 = dbDate.getDemande(nomclient);
        if(cursor21.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor21.moveToNext())
            {
                buffer.append(cursor21.getString(0)+"\n"+" ");
            }
            demande.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //date reception pdr
        Cursor cursor40 = dbDate.getReception(nomclient);
        if(cursor40.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor40.moveToNext())
            {
                buffer.append(cursor40.getString(0)+"\n"+" ");
            }
            reception.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //******************************************************************************************
        //tension
       //******************************************************************************************
        Cursor cursor22 = dbParametreMesure.gettension(nomclient);
        if(cursor22.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor22.moveToNext())
            {
                buffer.append(cursor22.getString(0)+"\n"+" ");
            }
            tension.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //soufflage
        //******************************************************************************************
        Cursor cursor23 = dbParametreMesure.getsoufflage(nomclient);
        if(cursor23.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor23.moveToNext())
            {
                buffer.append(cursor23.getString(0)+"\n"+" ");
            }
            soufflage.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //reprise
        //******************************************************************************************
        Cursor cursor24 = dbParametreMesure.getReprise(nomclient);
        if(cursor24.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor24.moveToNext())
            {
                buffer.append(cursor24.getString(0)+"\n"+" ");
            }
            reprise.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
       //*******************************************************************************************
        // int absorbé
        //******************************************************************************************
        Cursor cursor25= dbParametreMesure.getabsorbe(nomclient);
        if(cursor25.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor25.moveToNext())
            {
                buffer.append(cursor25.getString(0)+"\n"+" ");
            }
            absorbe.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //steg
        //******************************************************************************************
        Cursor cursor26 = dbParametreMesure.getSTEG(nomclient);
        if(cursor26.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor26.moveToNext())
            {
                buffer.append(cursor26.getString(0)+"\n"+"  ");
            }
            steg.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //pression
        //******************************************************************************************
        Cursor cursor27 = dbParametreMesure.getrefoulement(nomclient);
        if(cursor27.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor27.moveToNext())
            {
                buffer.append(cursor27.getString(0)+"\n"+"  ");
            }
            pression.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

































        //modht
        //******************************************************************************************
        Cursor cursor28 = dbInformation6.getModHt(nomclient);
        if(cursor28.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor28.moveToNext())
            {
                buffer.append(cursor28.getString(0)+"\n"+" ");
            }
            modht.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //deplacement
        //******************************************************************************************
        Cursor cursor29 = dbInformation6.getDeplacement(nomclient);
        if(cursor29.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor29.moveToNext())
            {
                buffer.append(cursor29.getString(0)+"\n"+" ");
            }
            deplacement.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //transport
        //******************************************************************************************
        Cursor cursor30 = dbInformation6.getTransport(nomclient);
        if(cursor30.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor30.moveToNext())
            {
                buffer.append(cursor30.getString(0)+"\n"+" ");
            }
            transport.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //Montant PDR HT
        //******************************************************************************************
        Cursor cursor31 = dbInformation6.getPDRHT(nomclient);
        if(cursor31.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor31.moveToNext())
            {
                buffer.append(cursor31.getString(0)+"\n"+" ");
            }
            pdrrht.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //Montant autre Supplement
        //******************************************************************************************
        Cursor cursor32 = dbInformation6.getSupplement(nomclient);
        if(cursor32.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor32.moveToNext())
            {
                buffer.append(cursor32.getString(0)+"\n"+"  ");
            }
            supplement.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //Montant réel ttc
        //******************************************************************************************
        Cursor cursor33 = dbInformation6.getReelTTC(nomclient);
        if(cursor33.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor33.moveToNext())
            {
                buffer.append(cursor33.getString(0)+"\n"+" ");
            }
            reelttc.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //client
        //******************************************************************************************
        Cursor cursor34 = dbMontantApayer.getclient(nomclient);
        if(cursor34.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor34.moveToNext())
            {
                buffer.append(cursor34.getString(0)+"\n"+"  ");
            }
            client.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //electrostar
        //******************************************************************************************
        Cursor cursor35 = dbMontantApayer.getElectrostar(nomclient);
        if(cursor35.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor35.moveToNext())
            {
                buffer.append(cursor35.getString(0)+"\n"+" ");
            }
            electrostar.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //degre satisfaction
        //******************************************************************************************
        Cursor cursor36 = dbDegresatisfaction.getdegresatisfaction(nomclient);
        if(cursor36.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor36.moveToNext())
            {
                buffer.append(cursor36.getString(0)+"\n"+"  ");
            }
            degresatisfaction.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************

        //probleme
        //******************************************************************************************
        Cursor cursor37 = dbProbleme.getprobleme(nomclient);
        if(cursor37.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor37.moveToNext())
            {
                buffer.append(cursor37.getString(0)+"\n"+"  ");
            }
            probleme.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        //travail terminé ou non
        //******************************************************************************************
        Cursor cursor38 = dbProbleme.gettravail(nomclient);
        if(cursor38.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor38.moveToNext())
            {
                buffer.append(cursor38.getString(0)+"\n"+"  ");
            }
            travail.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        Cursor cursor39 = dbInformationTechnicien.getTechnicien(nomclient);
        if(cursor39.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor39.moveToNext())
            {
                buffer.append(cursor39.getString(0)+"\n"+"  ");
            }
            technicien.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        //******************************************************************************************
        Cursor cursor41 = dbInformationTechnicien.getAideTechnicien(nomclient);
        if(cursor41.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor41.moveToNext())
            {
                buffer.append(cursor41.getString(0)+"\n"+"  ");
            }
            aidetechnicien.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        Cursor cursor42 = dbInformationTechnicien.getdebutReparation(nomclient);
        if(cursor42.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor42.moveToNext())
            {
                buffer.append(cursor42.getString(0)+"\n"+"  ");
            }
            debut.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        Cursor cursor43 = dbInformationTechnicien.getfinReparation(nomclient);
        if(cursor43.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor43.moveToNext())
            {
                buffer.append(cursor43.getString(0)+"\n"+"  ");
            }
            fin.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
        Cursor cursor44 = dbInformationTechnicien.getDetail(nomclient);
        if(cursor44.getCount()==0)
        {
            return;
        }
        else
        {StringBuffer buffer=new StringBuffer();
            while(cursor44.moveToNext())
            {
                buffer.append(cursor44.getString(0)+"\n"+"  ");
            }
            detail.setText("  "+buffer.toString()+"\n"+"\n"+"\n"+"\n");
        }
    }
}