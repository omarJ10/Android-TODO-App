package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsTache extends AppCompatActivity {
    TextView nameF;
    TextView jourF;
    TextView timeF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_tache);

        nameF = findViewById(R.id.Name);
        jourF = findViewById(R.id.Jour);
        timeF = findViewById(R.id.Time);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        nameF.setText(name);
        String jour = intent.getStringExtra("jour");
        jourF.setText(jour);
        String time = intent.getStringExtra("time");
        timeF.setText(time);
    }
}