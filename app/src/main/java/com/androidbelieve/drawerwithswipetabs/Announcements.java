package com.androidbelieve.drawerwithswipetabs;


import android.os.Bundle;
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
public class Announcements extends Fragment {

    private InformationAdapter adapter3;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView3;
    private List<EventInformation> list3= new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.initDataset3();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_announcements, null);
        mRecyclerView3 = (RecyclerView) rootView.findViewById(R.id.RecyclerView3);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView3.setLayoutManager(mLayoutManager);
        adapter3 =new InformationAdapter(getContext(),list3);
        mRecyclerView3.setAdapter(adapter3);
        return rootView;
    }

    private void initDataset3(){

        for(int i=0;i<10;i++){
            EventInformation eventInformation3 = new EventInformation();


            eventInformation3.venue="CEP";
            eventInformation3.InfTitle="Exam";
            eventInformation3.date="13/05/1995";
            eventInformation3.eventTime="08:00 AM";
            eventInformation3.organizer= "Admin";


            eventInformation3.agenda="Grades";
            eventInformation3.content="You know it very well";
            eventInformation3.URL="http://192.168.43.160/I_am_so_good";
            list3.add(eventInformation3);
        }
    }


}