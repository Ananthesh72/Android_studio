package com.example.entries;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the TextView
                TextView textView = findViewById(R.id.textView1);
                String text = textView.getText().toString();

                // Create a web intent with the Google URL
                Uri uri = Uri.parse("https://www.google.com/search?q=" + text);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                // Start the intent to open Google
                startActivity(intent);
            }
        });
    }
}
