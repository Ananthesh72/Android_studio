package com.example.callandsave;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpCookie;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button btnCall,btnSave,btnRemove;
    Button btnstar,btnhash;
    EditText tres;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=findViewById(R.id.btn0);
        b0.setOnClickListener(this);
        b1=findViewById(R.id.btn1);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.btn2);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.btn3);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.btn4);
        b4.setOnClickListener(this);
        b5=findViewById(R.id.btn5);
        b5.setOnClickListener(this);
        b6=findViewById(R.id.btn6);
        b6.setOnClickListener(this);
        b7=findViewById(R.id.btn7);
        b7.setOnClickListener(this);
        b8=findViewById(R.id.btn8);
        b8.setOnClickListener(this);
        b9=findViewById(R.id.btn9);
        b9.setOnClickListener(this);
        btnstar=findViewById(R.id.btnstar);
        btnstar.setOnClickListener(this);
        btnhash =findViewById(R.id.btnhash);
        btnhash.setOnClickListener(this);
        btnCall =findViewById(R.id.btncall);
        btnCall.setOnClickListener(this);
        btnSave =findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnRemove=findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(this);
        tres=findViewById(R.id.result);
        tres.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    String data=tres.getText().toString();
        if(v.equals(b0))
            tres.append("0");
        if(v.equals(b1))
            tres.append("1");
        if(v.equals(b2))
            tres.append("2");
        if(v.equals(b3))
            tres.append("3");
        if(v.equals(b4))
            tres.append("4");
        if(v.equals(b5))
            tres.append("5");
        if(v.equals(b6))
            tres.append("6");
        if(v.equals(b7))
            tres.append("7");
        if(v.equals(b8))
            tres.append("8");
        if(v.equals(b9))
            tres.append("9");
        if(v.equals(btnhash))
            tres.append("#");
        if(v.equals(btnstar))
            tres.append("*");
        if(v.equals(btnCall)){call(data);}
        if(v.equals(btnRemove)){Remove(data);}
        if(v.equals(btnSave)){Save(data);}
    }

    private void Save(String data) {
       Intent intent =new Intent(ContactsContract.Intents.Insert.ACTION);
       intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
       intent.putExtra(ContactsContract.Intents.Insert.NAME,"UNKNOWN");
       intent.putExtra(ContactsContract.Intents.Insert.PHONE,data);
       startActivity(intent);
    }

    private void Remove(String data) {
     if(data.length()>0)
     {
         String val=data.substring(0,data.length()-1);
         tres.setText(val);
     }
     else {
         tres.setText(data);
     }
    }

    private void call(String data) {
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel"+data));
        startActivity(intent);
    }
}