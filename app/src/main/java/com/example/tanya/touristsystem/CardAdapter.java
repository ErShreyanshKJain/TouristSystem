package com.example.tanya.touristsystem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private ArrayList<Place> placeList;
    private Context context;

    public CardAdapter(ArrayList<Place> placeList, Context context) {
        this.placeList = placeList;
        this.context = context;
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CardAdapter.ViewHolder holder, int position) {
        final Place place = placeList.get(position);

        holder.head.setText(place.getName());


    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView head;
        public ImageView image;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            head = (TextView)itemView.findViewById(R.id.heading);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }
}
