package com.example.tanya.touristsystem;

import android.content.Intent;
import android.support.transition.Transition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Place> places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search = (Button)findViewById(R.id.search);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox parks = (CheckBox)findViewById(R.id.parks);
                CheckBox sunset = (CheckBox)findViewById(R.id.sunset);
                CheckBox food = (CheckBox)findViewById(R.id.food);
                CheckBox shopping = (CheckBox)findViewById(R.id.shopping);
                CheckBox museum = (CheckBox)findViewById(R.id.museum);
                CheckBox zoo = (CheckBox)findViewById(R.id.zoo);
                CheckBox adventure = (CheckBox)findViewById(R.id.adventure);
                CheckBox amusement = (CheckBox)findViewById(R.id.amusement);
                CheckBox movies = (CheckBox)findViewById(R.id.movies);

                places = new ArrayList();
                if (parks.isChecked()) {
                    Place p1 = new Place("Buddha Jayanti Park","");
                    Place p2 = new Place("The Lodi Garden","");
                    places.add(p1);
                    places.add(p2);
                }
                if (sunset.isChecked()) {
                    Place p1 = new Place("Hauz Khas Lake","");
                    Place p2 = new Place("Jama Masjid","");
                    places.add(p1);
                    places.add(p2);
                }
                if (food.isChecked()) {
                    Place p1 = new Place("Paranthe Wali Gali","");
                    Place p2 = new Place("Dilli Haat","");
                    places.add(p1);
                    places.add(p2);
                }
                if (shopping.isChecked()) {
                    Place p1 = new Place("Janpath and Tibetan Market","");
                    Place p2 = new Place("Dilli Haat","");
                    places.add(p1);
                    places.add(p2);
                }
                if (museum.isChecked()) {
                    Place p1 = new Place("National Gandhi Museum","");
                    Place p2 = new Place("National Gallery of Modern Art","");
                    places.add(p1);
                    places.add(p2);
                }
                if (zoo.isChecked()) {
                    Place p1 = new Place("National Zoological Park","");
                    places.add(p1);
                }
                if (amusement.isChecked()) {
                    Place p1 = new Place("Worlds of Wonder","");
                    Place p2 = new Place("Adventure Island","");
                    places.add(p1);
                    places.add(p2);
                }
                if (adventure.isChecked()){
                    Place p1 = new Place("Rock Climbing","");
                    Place p2 = new Place("Flyboy Air Safari","");
                    places.add(p1);
                    places.add(p2);
                }
                if (movies.isChecked()){
                    Place p1 = new Place("PVR Plaza Cinema","");
                    Place p2 = new Place("PVR Saket","");
                    places.add(p1);
                    places.add(p2);
                }

                Intent intent = new Intent(MainActivity.this,Explore.class);
                intent.putExtra("Places",places.toString());
                Toast.makeText(MainActivity.this,"Your selection is processed",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
