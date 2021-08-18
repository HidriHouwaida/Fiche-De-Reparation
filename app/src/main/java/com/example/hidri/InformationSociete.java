package com.example.hidri;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class InformationSociete extends AppCompatActivity {
    Button bt,bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_societe);
        bt=findViewById(R.id.telephone);
        bt1=findViewById(R.id.telephon);
        bt.setOnClickListener(v -> {
            String buffer = "Tunis  -" + "Tél:" + "71396222" + "  " + "Fax:71844402" + "\n" + "\n" +
                    "Sfax   -" + "Tél:" + "74468788" + "  " + "Fax:74468495" + "\n" + "\n" +
                    "Sousse -" + "Tél:" + "73233700" + "  " + "Fax:73233792" + "\n" + "\n" +
                    "N°GSM  -" + "28530971" + "\n" + "\n";
            showmessage("Sté HHW TRADING", buffer);
        });
        bt1.setOnClickListener(v -> {
            String buffer = "Branche        " + "Djebel Djeloud" + "\n" + "\n" +
                    "Type Service   " + "Fixe" + "\n" + "\n" +
                    "Cité           " + "Ksar Said" + "\n" + "\n";
            showmessage("RLSF1310100015", buffer);
        });
    }
    public  void showmessage(String title,String message)
    {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setCancelable(true);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.show();
    }
}