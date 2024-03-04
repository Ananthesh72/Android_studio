package com.example.callnsaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.Contract;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText tres;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button btnCall,btnSave,btnStar,btnHash,btnRemove;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=findViewById(R.id.btnZero);
        b0.setOnClickListener(this);

        b1=findViewById(R.id.btnOne);
        b1.setOnClickListener(this);

        b2=findViewById(R.id.btnTwo);
        b2.setOnClickListener(this);

        b3=findViewById(R.id.btnThree);
        b3.setOnClickListener(this);

        b4=findViewById(R.id.btnFour);
        b4.setOnClickListener(this);

        b5=findViewById(R.id.btnFive);
        b5.setOnClickListener(this);

        b6=findViewById(R.id.btnSix);
        b6.setOnClickListener(this);

        b7=findViewById(R.id.btnSeven);
        b7.setOnClickListener(this);

        b8=findViewById(R.id.btnEight);
        b8.setOnClickListener(this);

        b9=findViewById(R.id.btnNine);
        b9.setOnClickListener(this);

        btnCall=findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);

        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnRemove=findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(this);

        btnStar=findViewById(R.id.btnStar);
        btnStar.setOnClickListener(this);

        btnHash=findViewById(R.id.btnHash);
        btnHash.setOnClickListener(this);

        tres=findViewById(R.id.txtResult);
        tres.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data=tres.getText().toString();
        if(v.equals(b0)) tres.append("0");
        if(v.equals(b1)) tres.append("1");
        if(v.equals(b2)) tres.append("2");
        if(v.equals(b3)) tres.append("3");
        if(v.equals(b4)) tres.append("4");
        if(v.equals(b5)) tres.append("5");
        if(v.equals(b6)) tres.append("6");
        if(v.equals(b7)) tres.append("7");
        if(v.equals(b8)) tres.append("8");
        if(v.equals(b9)) tres.append("9");
        if(v.equals(btnStar)) tres.append("*");
        if(v.equals(btnHash)) tres.append("#");
        if(v.equals(btnSave)) {save(data);}
        if(v.equals(btnRemove)) {remove(data);}
        if(v.equals(btnCall)) {call(data);}

    }


    private void save(String data) {
        Intent intent=new Intent((ContactsContract.Intents.Insert.ACTION));
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,"data");
        startActivity(intent);
    }
    private void remove(String data)
    {
        if(data.length()>0){
            String val = data.substring(0,data.length()-1); tres.setText(val);
        }
        else{
            tres.setText("");
        }
    }

    private void call(String data)
    {
        if(data.length()==10)
        {
            Intent intent = new Intent(Intent.ACTION_DIAL); intent.setData(Uri.parse("tel:"+data)); startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "Enter proper 10 digits", Toast.LENGTH_SHORT).show();
        }
    }

}

