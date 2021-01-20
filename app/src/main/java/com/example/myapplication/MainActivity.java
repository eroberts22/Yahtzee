package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();

    // array list holding all possible dice face ids
    static ArrayList<Integer> dice_faces = new ArrayList<>();

    // array list holding the ids of image views
    static ArrayList<Integer> img_views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillArrays(); // fill array lists

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Integer i : img_views) {
                    int n = rand.nextInt(dice_faces.size());
                    ((ImageView)findViewById(i)).setImageResource(dice_faces.get(n));
                }
            }
        });
    }

    protected void fillArrays() {
        // fill the image view array with ids representing
        // the five dice that are visible to the user
        ImageView d1 = findViewById(R.id.dice1);
        ImageView d2 = findViewById(R.id.dice2);
        ImageView d3 = findViewById(R.id.dice3);
        ImageView d4 = findViewById(R.id.dice4);
        ImageView d5 = findViewById(R.id.dice5);
        int i1 = d1.getId();
        int i2 = d2.getId();
        int i3 = d3.getId();
        int i4 = d4.getId();
        int i5 = d5.getId();
        img_views.add(i1);
        img_views.add(i2);
        img_views.add(i3);
        img_views.add(i4);
        img_views.add(i5);

        // fill the dice face array with all possible dice face ids
        int num_faces = 6;
        for (int i = 0; i < num_faces; i++) {
            String str = "dice" + (i+1);
            int dr = getResources().getIdentifier (str, "drawable", "com.example.myapplication");
            dice_faces.add(dr);
        }
    }
}
