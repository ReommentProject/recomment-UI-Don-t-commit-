package com.example.recommentflowchartui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag1 extends Fragment {

    RecyclerView recyclerView;
    ArrayList images, name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag1, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        images = new ArrayList();
        name = new ArrayList();

        return getUsers(images, name, view);

//        Log.i("fuck", "image size : "+images.size());
//        Log.i("fuck", "name size : "+name.size());


    }

    private View getUsers(ArrayList images, ArrayList name, View view) {

        Call<List<Content>> call = RetrofitClient.getInstance().getMyApi().getMainContent();

        call.enqueue(new Callback<List<Content>>() {
            @Override
            public void onResponse(Call<List<Content>> call, Response<List<Content>> response) {

                List<Content> userList = response.body();

                Log.i("fuck", ""+response.body().size());

                if (userList != null) {
                    for (int i = 0; i < userList.size() ; i++) {
                        images.add(userList.get(i).getTitle());
                        name.add(userList.get(i).getContent());

                    }
                }
                HelperAdapter helperAdapter = new HelperAdapter(getContext(), images, name);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(helperAdapter);
            }

            @Override
            public void onFailure(Call<List<Content>> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured in get", Toast.LENGTH_LONG).show();
            }

        });

        return view;
    }
}
