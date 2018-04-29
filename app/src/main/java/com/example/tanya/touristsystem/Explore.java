package com.example.tanya.touristsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Explore extends AppCompatActivity {

    List<Place> dataPlace = new ArrayList<>();
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataPlace = MainActivity.places;
        for(int i=0;i<dataPlace.size();i++)
        {
            Log.v("Places "+i,dataPlace.get(i).getName());
        }

        adapter = new CardAdapter(dataPlace,Explore.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        /*databasePlaces = FirebaseDatabase.getInstance().getReference("Places");
        databasePlaces.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataPlace.clear();
                for(DataSnapshot places : dataSnapshot.getChildren()){
                    Place place = places.getValue(Place.class);
                    dataPlace.add(place);
                }

                adapter = new CardAdapter(dataPlace,Explore.this);
                recyclerView.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }
}
