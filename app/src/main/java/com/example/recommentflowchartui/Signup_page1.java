package com.example.recommentflowchartui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Signup_page1 extends AppCompatActivity {
    private Button next;
    private EditText id,password,nickname;
    ImageView imageView;
    Uri uri;

    public User createdUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_page1);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        next=findViewById(R.id.next);
        id=findViewById(R.id.id);
        password=findViewById(R.id.password);
        nickname=findViewById(R.id.nickname);
        Button selectImage=findViewById(R.id.selectImage);
        imageView=findViewById(R.id.imageview);

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityResult.launch(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1,str2,str3;
                str1=id.getText().toString();
                str2=password.getText().toString();
                str3=nickname.getText().toString();

                if((str1.length()!=0)&&(str2.length()!=0)&&(str3.length()!=0))
                {
                    createdUser = new User(str1, str2, str3);

                    Intent intent=new Intent(Signup_page1.this,Signup_page2.class);
                    intent.putExtra("createdUser", createdUser);
                    startActivity(intent);
                }
                else
                {
                    customToastView("작성하지 않은 정보가 있습니다");
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
    ActivityResultLauncher<Intent>startActivityResult=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK&&result.getData()!=null)
                    {
                        uri=result.getData().getData();
                        Glide.with(getApplicationContext()).load(uri).apply(new RequestOptions().circleCrop()).into(imageView);


                    }
                }
            }
    );

}