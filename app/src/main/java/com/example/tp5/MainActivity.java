package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.tp5.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityMainBinding binding;
    Button add;
    TextView taches;
    EditText tacheEditText;
    TimePicker timePicker ;
    ArrayList<Tache> tachesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /*----------------Spinner-----------------*/
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        /*---------------------------------------*/


        add = findViewById(R.id.button);
        taches = findViewById(R.id.textView2);
        tacheEditText = findViewById(R.id.textView);
        timePicker = findViewById(R.id.timePicker);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int heure = timePicker.getHour();
                int minutes = timePicker.getMinute();
                String tacheTime = String.format("%02d:%02d", heure, minutes); // Format "heures:minutes"
                String tacheName = tacheEditText.getText().toString();
                String tacheJour = spinner.getSelectedItem().toString();
                Tache t = new Tache(tacheName,tacheJour,tacheTime);
                tachesList.add(t);

                String textTaches = "";
                for (Tache tache : tachesList) {
                    textTaches += tache.getTachename() + " le " + tache.getTachejour() + " à " + tache.getTachetime() + "\n";
                }
                taches.setText(textTaches);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(parent.getContext(),"Veuillez entrer un jour " , Toast.LENGTH_SHORT).show();
    }
}