package com.androidbelieve.drawerwithswipetabs;

       import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;


/**
 * Created by Tirth Gajjar on 3/29/2016.
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.viewHolder> {

    LayoutInflater inflater;
    List<EventInformation>  eventList;
    public InformationAdapter(Context context,List<EventInformation> list){
        inflater= LayoutInflater.from(context);
        eventList=list;
    }
    @Override
    public InformationAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_details_row,parent,false);
        viewHolder holder= new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(InformationAdapter.viewHolder holder, int position) {

        EventInformation currrent= eventList.get(position);
        holder.title.setText(currrent.getInfTitle());
        holder.organiser.setText(currrent.getOrganizer());
        holder.agenda.setText(currrent.getAgenda());
        holder.venue.setText(currrent.getVenue());
        holder.date.setText(currrent.getDate());
        holder.time.setText(currrent.getEventTime());
        holder.content.setText(currrent.getContent());
        holder.url.setText(currrent.getURL());





    }

    @Override
    public int getItemCount() {
        if(!eventList.isEmpty()){
            return eventList.size();
        }else {
            return 0;
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView title,organiser,agenda,date,time,venue,content,url;
        public viewHolder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.Event_Title);
            organiser=(TextView) itemView.findViewById(R.id.Event_Org);
            agenda=(TextView) itemView.findViewById(R.id.Event_Agenda);
            date=(TextView) itemView.findViewById(R.id.Event_Date);
            time=(TextView) itemView.findViewById(R.id.Event_Time);
            venue=(TextView) itemView.findViewById(R.id.Event_Venue);
            content=(TextView) itemView.findViewById(R.id.Event_Content);
            url=(TextView)itemView.findViewById(R.id.Event_URL);


        }
    }


}
