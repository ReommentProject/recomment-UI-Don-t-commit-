package com.example.recommentflowchartui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OtherPage extends AppCompatActivity {
    private Button friendlist;
    private Button befriend;
    private ArrayList<CategoryData> arrayList;
    private CategoryAdapter categoryAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_other_page);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        friendlist=(Button) findViewById(R.id.seefriend);
        befriend=(Button) findViewById(R.id.befriend);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView5);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList=new ArrayList<>();
        categoryAdapter=new CategoryAdapter(arrayList);
        recyclerView.setAdapter(categoryAdapter);
        for(int i=0 ; i<10 ; i++)
        {
            CategoryData categoryData=new CategoryData(R.drawable.star,"카테고리");
            arrayList.add(categoryData);
        }
        befriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //나의 계정 친구데이터베이스에 친구 추가
            }
        });
        friendlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OtherPage.this,Friendlist.class);
                startActivity(intent);
            }
        });

    }
}