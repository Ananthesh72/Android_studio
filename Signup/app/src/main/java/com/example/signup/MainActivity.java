package com.example.signup;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity
{
    EditText username,password;
    Button signUpBtn;
    String regularExpr="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d @$!]{8,}$";
    @SuppressLint("MissingInflatedId")
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.txtusername_su);
        password = findViewById(R.id.txtpassword);
        signUpBtn = findViewById(R.id.btnsignup);
        signUpBtn.setOnClickListener(new View.OnClickListener()
        {
            class signup {
            }

            @Override public void onClick(View v)
            {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                if(validatePassword(pwd))
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("username_B",uname);
                    bundle.putString("password_B",pwd);
                    Intent intent = new Intent(MainActivity.this,SIGNING.class);
                    intent.putExtras(bundle); startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean validatePassword(String pwd)
    {
        Pattern pattern = Pattern.compile(regularExpr);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }
}