package com.example.recommentflowchartui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Loginpage extends AppCompatActivity {

    private Button Signup;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loginpage);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        Signup=findViewById(R.id.Signup);
        Login=findViewById(R.id.login);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Loginpage.this,Signup_page1.class);
                startActivity(intent);
            }
        });
       /* Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Loginpage.this,post_page.class);
                startActivity(intent);
            }
        });*/
    }
}