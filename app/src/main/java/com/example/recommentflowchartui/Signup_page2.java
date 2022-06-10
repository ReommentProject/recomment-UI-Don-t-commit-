package com.example.recommentflowchartui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Signup_page2 extends AppCompatActivity {
    private Button next2;
    ListView listViewData;
    ArrayAdapter<String>adapter;
    String[]arrayPeliculas={"Science" , "History" ,"Sports" ,"Music" ,"Entertainment" ,"Game" , "Animal" ,"Cooking" ,"Movie" ,"Drama"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_page2);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        listViewData=findViewById(R.id.listView_data);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,arrayPeliculas);
        listViewData.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId();
        if(id==R.id.item_done)
        {
            String itemSelected="Selected items:\n";
            for(int i=0;i<listViewData.getCount();i++)
            {
                if(listViewData.isItemChecked(i)){
                    itemSelected+=listViewData.getItemAtPosition(i)+"\n";


                }
            }
            customToastView("성공했습니다");
        }
        return super.onOptionsItemSelected(item);
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