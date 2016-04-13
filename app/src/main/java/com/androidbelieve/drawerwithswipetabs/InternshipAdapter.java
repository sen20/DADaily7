package com.androidbelieve.drawerwithswipetabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 3/29/2016.
 */
public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.viewHolder>{
    LayoutInflater inflater;
    List<InternshipObject> internshipList;
    public InternshipAdapter(Context context,List<InternshipObject> list){
        inflater= LayoutInflater.from(context);
        internshipList=list;
    }
    @Override
    public InternshipAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.internship_rows,parent,false);
        viewHolder holder= new viewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(InternshipAdapter.viewHolder holder, int position) {

        InternshipObject currrent= internshipList.get(position);
        holder.title.setText(currrent.getInfTitle());
        holder.organiser.setText(currrent.getOrganizer());
        holder.content.setText(currrent.getContent());
        holder.url.setText(currrent.getURL());





    }

    @Override
    public int getItemCount() {
        if(!internshipList.isEmpty()){
            return internshipList.size();
        }else {
            return 0;
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView title,organiser,content,url;
        public viewHolder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.Event_Title);
            organiser=(TextView) itemView.findViewById(R.id.Event_Org);
            content=(TextView) itemView.findViewById(R.id.Event_Content);
            url=(TextView)itemView.findViewById(R.id.Event_URL);


        }
    }
}
