package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.signin);
        EditText editText = findViewById(R.id.username);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = editText.getText().toString();

                //Explicit Intent
                // Toast.makeText(MainActivity.this, "username" +user_name, Toast.LENGTH_SHORT).show();


                Intent i = new Intent(getApplicationContext(),LuckyNoActivity.class);

                // passing the name to second activity

                i.putExtra("name",user_name);

                startActivity(i);
            }
        });

    }
}