package com.example.recommentflowchartui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;

public class Friendlist extends AppCompatActivity {

    private ArrayList<friendData> arrayList;
    private FriendAdapter friendAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_friendlist);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        recyclerView=(RecyclerView) findViewById(R.id.friendlist);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList=new ArrayList<>();
        friendAdapter=new FriendAdapter(arrayList);
        recyclerView.setAdapter(friendAdapter);
        for(int i=0 ; i<50 ; i++)
        {
            friendData friendData=new friendData(R.mipmap.ic_launcher,"친구 닉네임","관심있는 카테고리");
            arrayList.add(friendData);
        }


    }
}