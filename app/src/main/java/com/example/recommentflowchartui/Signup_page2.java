package com.example.recommentflowchartui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Signup_page2 extends AppCompatActivity {
    private Button next2;
    private CheckBox science,history,sports,music,funny,game,animal,cook,movie,drama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_page2);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        next2=findViewById(R.id.next2);
        science=findViewById(R.id.science);
        history=findViewById(R.id.history);
        sports=findViewById(R.id.sports);
        music=findViewById(R.id.music);
        funny=findViewById(R.id.funny);
        game=findViewById(R.id.game);
        animal=findViewById(R.id.animal);
        cook=findViewById(R.id.cook);
        movie=findViewById(R.id.movie);
        drama=findViewById(R.id.drama);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checknum=0;
                if(science.isChecked())
                {
                    //값을 데이터베이스에 저장하는 코드가 필요하다.
                    checknum+=1;
                }
                if(history.isChecked())
                {
                    checknum+=1;
                }
                if(music.isChecked())
                {
                    checknum+=1;
                }
                if(funny.isChecked())
                {
                    checknum+=1;
                }
                if(game.isChecked())
                {
                    checknum+=1;
                }
                if(animal.isChecked())
                {
                    checknum+=1;
                }
                if(cook.isChecked())
                {
                    checknum+=1;
                }
                if(movie.isChecked())
                {
                    checknum+=1;
                }
                if(drama.isChecked())
                {
                    checknum+=1;
                }
                if((0<checknum)&&(checknum<=5))
                {
                    Intent intent=new Intent(Signup_page2.this,Signup_finish.class);
                    startActivity(intent);
                }
                else if(5<checknum)
                {
                   customToastView("5개 이하로 선택해주세요!!");
                }
                else
                {
                    customToastView("1개 이상 선택해주세요!!");
                }

            }
        });
    }
    public void customToastView(String text)
    {
        LayoutInflater inflater=getLayoutInflater();
        View layout =inflater.inflate(R.layout.toast_board,(ViewGroup) findViewById((R.id.toast_layout_root)));
        TextView textView=layout.findViewById(R.id.textboard);
        textView.setText(text);
        Toast toastView = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
        toastView.setView(layout);
        toastView.show();

    }
}