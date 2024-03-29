package com.example.signup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class SIGNING extends AppCompatActivity
{
    EditText username,password;
    Button signInBtn;
    int count=0;
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username = findViewById(R.id.UsernameView);
        password = findViewById(R.id.PasswordView);
        signInBtn = findViewById(R.id.buttonsignin);
        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("username_B");
        String pwd = bundle.getString("password_B");
        signInBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals(uname) && pass.equals(pwd))
                {
                    Toast.makeText(SIGNING.this, "SuccessFull", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    count++;
                    if (count >= 3)
                    {
                        signInBtn.setEnabled(false);
                    }
                    else
                    {
                        Toast.makeText(SIGNING.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
    }
}