package com.androidbelieve.drawerwithswipetabs;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

import static com.androidbelieve.drawerwithswipetabs.R.layout.activity_myprofile;


public class MyProfile extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private favoriteAdapter adapter1;
    private favoriteAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView1=(RecyclerView)findViewById(R.id.RecyclerView5);
        recyclerView2=(RecyclerView)findViewById(R.id.RecyclerView6);
        adapter1=new favoriteAdapter(this,getData1());
        adapter2=new favoriteAdapter(this,getData2());
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }

    public static List<favoriteObject> getData1(){
        List<favoriteObject> data1=new ArrayList<>();

        for(int i=0;i<10;i++){
            favoriteObject favorites = new favoriteObject();

            favorites.name="DTG";

            data1.add(favorites);
        }
        return data1;
    }
    public static List<favoriteObject> getData2(){
        List<favoriteObject> data2=new ArrayList<>();

        for(int i=0;i<10;i++){
            favoriteObject favorites = new favoriteObject();

            favorites.name="SPC";
            favorites.checkBox=true;
            data2.add(favorites);
        }
        return data2;
    }

}
