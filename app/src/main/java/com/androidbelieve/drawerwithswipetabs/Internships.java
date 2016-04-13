package com.androidbelieve.drawerwithswipetabs;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Internships extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InternshipAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=(RecyclerView)findViewById(R.id.RecyclerView4);
        adapter=new InternshipAdapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static List<InternshipObject> getData(){
        List<InternshipObject> data=new ArrayList<>();

        for(int i=0;i<10;i++){
            InternshipObject InternInfo = new InternshipObject();

            InternInfo.InfTitle="Android Development";
            InternInfo.organizer= "Wipro";
            InternInfo.content="You know it very well";
            InternInfo.URL="http://192.168.43.160/I_am_so_good";
            data.add(InternInfo);
        }
        return data;
    }


}
