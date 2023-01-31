package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_no);

        TextView text = findViewById(R.id.Lucky_no_text);
        Button btn = findViewById(R.id.share);

        Intent i = getIntent();

        // UserName
        String username = i.getStringExtra("name");
        Toast.makeText(this, "username "+username, Toast.LENGTH_SHORT).show();

        // Random no Generated

        int random_Num = generateRandomNumber();

        text.setText(""+random_Num);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedata(username,random_Num);
            }
        });

    }

    public void sharedata(String username, int random_Num){
        // implicit intent

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // convert no to string
        String number = String.valueOf(random_Num);

        i.putExtra(Intent.EXTRA_TEXT,username +" got a lucky no "+ number);  // body

        startActivity(Intent.createChooser(i,"Choose a platform"));

    }

    public int generateRandomNumber (){
        Random random = new Random();

        int upper_limit = 1000;

        return random.nextInt(upper_limit);
    }


}