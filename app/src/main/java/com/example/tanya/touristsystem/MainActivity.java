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

                ArrayList places = new ArrayList<String>();
                /*String s1,s2,s3,s4,s5,s6,s7,s8,s9;
                s1 = s2 = s3 = s4 = s5 = s6 = s7 = s8 = s9 = "";
                */if (parks.isChecked())
                    places.add("parks");
                if (sunset.isChecked())
                    places.add("sunset");
                if (food.isChecked())
                    places.add("food");
                if (shopping.isChecked())
                    places.add("shopping");
                if (museum.isChecked())
                    places.add("museum");
                if (zoo.isChecked())
                    places.add("zoo");
                if (adventure.isChecked())
                    places.add("adventure");
                if (amusement.isChecked())
                    places.add("amusement");
                if (movies.isChecked())
                    places.add("movies");

                Intent intent = new Intent(MainActivity.this,Explore.class);
                intent.putExtra("Places",places);
                Toast.makeText(MainActivity.this,"Your selection is processed",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
