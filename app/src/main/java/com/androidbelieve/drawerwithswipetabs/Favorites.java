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

/**
 * Created by Ratan on 7/29/2015.
 */
public class Favorites extends Fragment {

    private InformationAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView2;
    private List<EventInformation> list2= new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.initDataset2();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.social_layout, null);
        mRecyclerView2 = (RecyclerView) rootView.findViewById(R.id.RecyclerView2);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView2.setLayoutManager(mLayoutManager);
        adapter=new InformationAdapter(getContext(),list2);
        mRecyclerView2.setAdapter(adapter);
        return rootView;
    }

    private void initDataset2(){

        for(int i=0;i<10;i++){
            EventInformation eventInformation2 = new EventInformation();


            eventInformation2.venue="OAT";
            eventInformation2.InfTitle="Drama Night";
            eventInformation2.date="13/05/1995";
            eventInformation2.eventTime="08:00 AM";
            eventInformation2.organizer= "DTG";


            eventInformation2.agenda="Enjoy";
            eventInformation2.content="You know it very well";
            eventInformation2.URL="http://192.168.43.160/I_am_so_good";
            list2.add(eventInformation2);
        }
    }


}