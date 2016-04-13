package com.androidbelieve.drawerwithswipetabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class All extends Fragment {


    private InformationAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private List<EventInformation> list1= new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         this.initDataset1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.primary_layout, null);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.RecyclerView1);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter=new InformationAdapter(getContext(),list1);
        mRecyclerView.setAdapter(adapter);
        return rootView;
    }

    private void initDataset1(){

        for(int i=0;i<10;i++){
            EventInformation eventInformation = new EventInformation();


            eventInformation.venue="DAIICT";
            eventInformation.InfTitle="HACHATHON";
            eventInformation.date="13/05/1995";
            eventInformation.eventTime="08:00 AM";
            eventInformation.organizer= "DAIICT";


            eventInformation.agenda="WTF";
            eventInformation.content="You know it very well";
            eventInformation.URL="http://192.168.43.160/I_am_so_good";
            list1.add(eventInformation);
        }
    }}
