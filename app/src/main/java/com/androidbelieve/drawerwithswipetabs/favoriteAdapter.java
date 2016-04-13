package com.androidbelieve.drawerwithswipetabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 3/29/2016.
 */
public class favoriteAdapter extends RecyclerView.Adapter<favoriteAdapter.viewHolder>{
    LayoutInflater inflater;
    List<favoriteObject> favList;
    public favoriteAdapter(Context context,List<favoriteObject> list){
        inflater= LayoutInflater.from(context);
        favList=list;
    }
    @Override
    public favoriteAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.favorite_rows,parent,false);
        viewHolder holder= new viewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(favoriteAdapter.viewHolder holder, int position) {

        favoriteObject current= favList.get(position);
        holder.fav_title.setText(current.getName());
        holder.checkBox.setClickable(current.getChecked());

    }

    @Override
    public int getItemCount() {
        if(!favList.isEmpty()){
            return favList.size();
        }else {
            return 0;
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView fav_title;
        CheckBox checkBox;
        public viewHolder(View itemView) {
            super(itemView);
            fav_title=(TextView)itemView.findViewById(R.id.fav_title);
            checkBox=(CheckBox)itemView.findViewById(R.id.fav_checkBox);
        }
    }
}
