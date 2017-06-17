package com.example.laptop.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mPolitics = (Button) findViewById(R.id.Politics);
        final String getPolitics = mPolitics.getText().toString();
        mPolitics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getPolitics);
                startActivity(intent);
            }
        });
        Button mSports = (Button) findViewById(R.id.Sports);
        final String getSports = mSports.getText().toString();
        mSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getSports);
                startActivity(intent);


            }
        });

        Button mEntertainment = (Button) findViewById(R.id.Entertainment);
        final String getEntertainment = mEntertainment.getText().toString();
        mEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getEntertainment);
                startActivity(intent);


            }
        });
        Button mWeather = (Button) findViewById(R.id.Weather);
        final String getWeather = mWeather.getText().toString();
        mWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getWeather);
                startActivity(intent);

            }
        });


        Button mgadget = (Button) findViewById(R.id.Gadget);
        final String getGadget = mgadget.getText().toString();
        mgadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getGadget);
                startActivity(intent);

            }
        });
        Button mFashion = (Button) findViewById(R.id.Fashion);
        final String getFashion = mFashion.getText().toString();
        mFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getFashion);
                startActivity(intent);

            }
        });
        Button mInternational = (Button) findViewById(R.id.International);
        final String getInternational = mInternational.getText().toString();
        mInternational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getInternational);
                startActivity(intent);

            }
        });
        Button mNational = (Button) findViewById(R.id.National);
        final String getNational = mNational.getText().toString();
        mNational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewsLayout.class);
                intent.putExtra("toSearch", getNational);
                startActivity(intent);

            }
        });


    }
}