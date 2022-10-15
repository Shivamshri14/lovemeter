package com.shivam.lovemeter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;

public class Home extends AppCompatActivity {

    TextView Results;
    Integer backpressed = 0;
    ProgressBar pb2;
    private Toolbar toolbar;
    private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getActionBar().hide();
        getSupportActionBar().hide();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = findViewById(R.id.Tryagain);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Home.class);
                startActivity(intent);
            }
        });


    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    public void Submitbt(View view) {

        backpressed = 0;
        EditText boyname = findViewById(R.id.boyname);
        EditText girlname = findViewById(R.id.girlname);
        String boy = "", girl = "";
        boy = boyname.getText().toString();
        girl = girlname.getText().toString();
        //boy = boy.trim();
        //girl = girl.trim();
        //boy = boy.toLowerCase();
        //girl = girl.toLowerCase();

        if (!(boy.isEmpty()) && !(girl.isEmpty())) {

            boy = boy.toLowerCase();

            char boyc, girlc;
            int boyint = 0, girlint = 0;

            for (int i = 0; i < boy.length(); i++) {
                boyc = boy.charAt(i);
                boyint = boyint + boyc;
            }

            for (int i = 0; i < girl.length(); i++) {
                girlc = girl.charAt(i);
                girlint = girlint + girlc;
            }

            Results(boyint, girlint, boy, girl);

        }

        else if (boy.matches("shivam") && (girl.matches("payal"))) {

            int results=100;
            Results.setText(results + "%");

        }


        else {
            Toast empty = Toast.makeText(getApplicationContext(), "Enter Both Names", Toast.LENGTH_SHORT);
            empty.setGravity(Gravity.BOTTOM, 0, 200);
            empty.show();
        }
    }


    public void Results(int boytotal, int girltotal, String boyname, String girlname) {

        try {
            RelativeLayout datalayout = findViewById(R.id.datalayout);
            RelativeLayout resultlayout = findViewById(R.id.resultlayout);
            TextView boynametext = findViewById(R.id.boynametext);
            TextView girlnametext = findViewById(R.id.girlnametext);

            Results = findViewById(R.id.results);
            datalayout.setVisibility(View.INVISIBLE);
            resultlayout.setVisibility(View.VISIBLE);

            boyname = boyname.toUpperCase();
            girlname = girlname.toUpperCase();
            boynametext.setText(boyname);
            girlnametext.setText(girlname);

            Integer sumtotal = boytotal + girltotal, temptotal = 0;
            String result1 = "", result2 = "", results = "";
            for (Integer i = 0; i <= 1; i++) {
                temptotal = sumtotal % 10;
                sumtotal = sumtotal / 10;
                if (i == 0) {
                    result1 = temptotal.toString();
                } else {
                    result2 = temptotal.toString();
                }
            }
            results = result1 + result2;
            Integer afterresults, temp;
            afterresults = Integer.parseInt(results);
            if (afterresults < 50)
                afterresults = afterresults + 40;

            results = afterresults.toString();
            Results.setText(results + "%");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    closeanim();
                }
            }, 2000);



        } catch (Exception ex) {
            Toast empty = Toast.makeText(getApplicationContext(), "Some Error Occured", Toast.LENGTH_SHORT);
            empty.setGravity(Gravity.BOTTOM, 0, 200);
            empty.show();
        }
    }
    private void closeanim() {

        TextView Results = findViewById(R.id.results);
        //yoyo.with(Techniques.RubberBand).duration(1000).repeat(1).playOn(Results);
        ProgressBar pb = findViewById(R.id.pb);

        pb.setVisibility(View.GONE);
        Results.setVisibility(View.VISIBLE);
    }


    public void Back(View view) {
    }
}
