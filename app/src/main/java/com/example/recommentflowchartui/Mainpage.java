package com.example.recommentflowchartui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mainpage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainpage);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Frag1()).commit();

        bottomNavigationView=findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.action_friends:
                        //fragment= new Fragment1();
                        fragment = new Frag1();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.main_frame, fragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.action_usergroup:
                        fragment = new Frag2();
                        break;
                    case R.id.action_Mypage:
                        fragment = new Frag3();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
                return true;
            }
        });
        /*frag1=new Frag1();
        frag2=new Frag2();
        frag3=new Frag3();
        setFrag(0);//??? ??????????????? ??????*/
    }

    //??????????????? ????????? ???????????? ?????????
   /* private void setFrag(int n){
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        switch (n)
        {
            case 0:
                ft.replace(R.id.main_frame,frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
        }
    }*/
}