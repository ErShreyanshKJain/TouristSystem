package com.example.tanya.touristsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Explore extends AppCompatActivity {

    ArrayList<String> placesList = new ArrayList<>();
    ArrayList<Place> dataPlace = new ArrayList<>();
    DatabaseReference databasePlaces;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        placesList = intent.getStringArrayListExtra("Places");

        databasePlaces = FirebaseDatabase.getInstance().getReference("Places");
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
        });
    }
}
