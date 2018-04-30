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
                    Place p1 = new Place("Janpath and Tibetan Market","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/shopping%2Fjanpath%26tibetian_market.jpg?alt=media&token=e99977ec-5f7f-48b1-83b4-327375d2e179");
                    Place p2 = new Place("Dilli Haat","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/shopping%2Fdili_haat_shopping.jpg?alt=media&token=deece949-6229-4586-981f-68c885974924");
                    places.add(p1);
                    places.add(p2);
                }
                if (museum.isChecked()) {
                    Place p1 = new Place("National Gandhi Museum","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/museum%2Fnational_gandhi_museum.jpg?alt=media&token=5649a31c-b2ee-4f60-91c4-186bc2c143f8");
                    Place p2 = new Place("National Gallery of Modern Art","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/museum%2FNational_gallery_of_modern_art.jpg?alt=media&token=9b6725a0-8109-4c4a-a810-3bbb619eba6f");
                    places.add(p1);
                    places.add(p2);
                }
                if (zoo.isChecked()) {
                    Place p1 = new Place("National Zoological Park","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/zoo%2Fnational_zoological_park.jpg?alt=media&token=d14ab3d6-3481-4411-b28d-76173977fea1");
                    places.add(p1);
                }
                if (amusement.isChecked()) {
                    Place p1 = new Place("Worlds of Wonder","https://www.youtube.com/watch?v=8ItHJAJr2bY");
                    Place p2 = new Place("Adventure Island","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/amusement%20parks%2Fworlds_of_wonder.jpg?alt=media&token=ca60cb49-c40e-4fc0-9d9a-d10f4070ae78");
                    places.add(p1);
                    places.add(p2);
                }
                if (adventure.isChecked()){
                    Place p1 = new Place("Rock Climbing","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/adventure%20sports%2Frock_climbing.jpg?alt=media&token=cc987d9f-c850-4c87-9edf-a081ecdc0fad");
                    Place p2 = new Place("Flyboy Air Safari","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/adventure%20sports%2Fflyboy_air_safari.jpg?alt=media&token=bf585555-6a93-4136-9bcd-ef590b85933a");
                    places.add(p1);
                    places.add(p2);
                }
                if (movies.isChecked()){
                    Place p1 = new Place("PVR Plaza Cinema","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/cinemas%2Fpvr_plaza.jpg?alt=media&token=065537ea-e095-42f6-a76c-fbbcb022abdf");
                    Place p2 = new Place("PVR Saket","https://firebasestorage.googleapis.com/v0/b/touristsystem-57bed.appspot.com/o/cinemas%2Fpvr_saket.jpg?alt=media&token=96d4eb78-beba-4a6e-bd7a-5555376b764b");
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
