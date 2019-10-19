package com.example.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText id,Pass;
    Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    id=(EditText)findViewById(R.id.Id);
    Pass=(EditText)findViewById(R.id.Password);
    Login=(Button)findViewById(R.id.SignIn);
    Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Validate(id.getText().toString(),Pass.getText().toString());
        }
    });
    }

public void Validate(String name,String Password){
        if (name.equals("com")&&Password.equals("Hell")){
            Intent i =new Intent(Login.this,DataInsertion.class);
            startActivity(i);
            this.finish();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "Id or password incorrect", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();
        }
}
    }

