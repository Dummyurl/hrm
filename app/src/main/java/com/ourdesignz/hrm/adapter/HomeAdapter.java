package com.ourdesignz.hrm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.model.HomePOJO;
import com.ourdesignz.hrm.utilities.Utilitity;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

import java.util.List;

/**
 * Created by ourdesignz on 26/9/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    List<HomePOJO.Result> announcements;
    private LayoutInflater inflater;
    private Context context;

    public HomeAdapter(Context context, List<HomePOJO.Result> announcements) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.announcements = announcements;
    }

    public void delete(int position) {
        announcements.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_index_items, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(announcements.get(position).getAnnouncement().getTitle());
        Utilitity.setTypeFace2(context, holder.title);
        holder.description.setText(announcements.get(position).getAnnouncement().getDesc());
        Utilitity.setTypeFace(context, holder.description);
        holder.date_time.setText(Utilitity.formatDateFromString(announcements.get(position)
                .getAnnouncement().getCreated()));
        Utilitity.setTypeFace(context, holder.date_time);
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        JustifiedTextView title;
        JustifiedTextView description;
        TextView date_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (JustifiedTextView) itemView.findViewById(R.id.title);
            description = (JustifiedTextView) itemView.findViewById(R.id.descriptions);
            date_time = (TextView) itemView.findViewById(R.id.date_time);

        }
    }

}