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
                    Place p1 = new Place("Buddha Jayanti Park","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/parks%2Fbuddha_jayanti_park.jpg?alt=media&token=0593645a-e6bf-427b-ab97-f109ae4c5ca2");
                    Place p2 = new Place("The Lodi Garden","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/parks%2Fthe_lodhi_garden.jpg?alt=media&token=10d4e0b3-8b5b-43df-aba1-735697f941c5");
                    places.add(p1);
                    places.add(p2);
                }
                if (sunset.isChecked()) {
                    Place p1 = new Place("Hauz Khas Lake","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/sunset%2FSunset_at_Hauz_Khas_Lake.jpg?alt=media&token=bfc688d0-a2b5-4e80-9709-7c98f632757b");
                    Place p2 = new Place("Jama Masjid","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/sunset%2Fjama_masjid_sunset.jpg?alt=media&token=cb7f2699-05ab-4a70-9a86-99b07c3547b4");
                    places.add(p1);
                    places.add(p2);
                }
                if (food.isChecked()) {
                    Place p1 = new Place("Paranthe Wali Gali","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/food%2Fparanthe_vali_gali.jpg?alt=media&token=6f678c82-fdf5-4997-92ab-b2e2c02060ae");
                    Place p2 = new Place("Dilli Haat","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/food%2Fdili_haat-food.jpg?alt=media&token=72450428-0415-485c-8158-62a9bd66ba4e");
                    places.add(p1);
                    places.add(p2);
                }
                if (shopping.isChecked()) {
                    Place p1 = new Place("Janpath and Tibetan Market","https://www.indiatoday.in/india/delhi/story/janpath-market-demonetisation-rs-500-rs-1000-atms-shut-352168-2016-11-15");
                    Place p2 = new Place("Dilli Haat","http://www.101trips.in/2017/08/dilli-haat.html");
                    places.add(p1);
                    places.add(p2);
                }
                if (museum.isChecked()) {
                    Place p1 = new Place("National Gandhi Museum","https://www.tripadvisor.in/Attraction_Review-g304551-d311624-Reviews-National_Gandhi_Museum-New_Delhi_National_Capital_Territory_of_Delhi.html\n");
                    Place p2 = new Place("National Gallery of Modern Art","http://www.artculturefestival.in/national-gallery-modern-art-delhi/");
                    places.add(p1);
                    places.add(p2);
                }
                if (zoo.isChecked()) {
                    Place p1 = new Place("National Zoological Park","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/zoo%2Fnational_zoological_park.jpg?alt=media&token=d14ab3d6-3481-4411-b28d-76173977fea1");
                    places.add(p1);
                }
                if (amusement.isChecked()) {
                    Place p1 = new Place("Worlds of Wonder","https://www.youtube.com/watch?v=8ItHJAJr2bY");
                    Place p2 = new Place("Adventure Island","https://littleapp.in/deals/adventure-island-rohini-sec-10-delhi--mc-o0208990\n");
                    places.add(p1);
                    places.add(p2);
                }
                if (adventure.isChecked()){
                    Place p1 = new Place("Rock Climbing","https://www.thrillophilia.com/cities/new-delhi/tags/rock-climbing");
                    Place p2 = new Place("Flyboy Air Safari","https://www.thrillophilia.com/tours/flyboy-air-safari-delhi");
                    places.add(p1);
                    places.add(p2);
                }
                if (movies.isChecked()){
                    Place p1 = new Place("PVR Plaza Cinema","https://www.hindustantimes.com/business-news/pvr-eyes-100-million-visitors-annually-in-next-two-years/story-eNNlxcelOHxvQv1fu1EAyI.html");
                    Place p2 = new Place("PVR Saket"," https://www.livemint.com/Companies/UjW3j1eZExRlYE1FowerLO/PVR-earmarks-up-to-Rs-250-crore-capex-for-FY17.html");
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
