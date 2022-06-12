package com.example.recommentflowchartui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {

    private View view;
    private Button friendlist;
    private Button recomment;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag3,container,false);
        friendlist=view.findViewById(R.id.seefriend);
        recomment=view.findViewById(R.id.goupload);

        recomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),upload_page.class);
                startActivity(intent);
            }
        });
        friendlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Friendlist.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
