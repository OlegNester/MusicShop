package com.nester.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    Spinner spinner;
    ArrayList arraySpinner;
    ArrayAdapter spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        arraySpinner = new ArrayList();

        arraySpinner.add("guitar");
        arraySpinner.add("drums");
        arraySpinner.add("keyboard");

            //Добавив адаптер, з випадаючим списком
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arraySpinner);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


    }

    //метод додавання кількості
    public void quantityPlus(View view) {
        TextView quantityNubmer = (TextView) findViewById(R.id.quantityNubmer);
        quantity += 1;
        quantityNubmer.setText("" + quantity);
    }
    //метод віднімання від кількості
    public void quantityMinus(View view) {
        TextView quantityNubmer = findViewById(R.id.quantityNubmer);
        quantity -= 1;

        //перевірка, щоб кількість не заходила в мінус
        if (quantity <= 0) {
            quantity = 0;
        }
        //вивід на екран кількості
        quantityNubmer.setText("" + quantity);
    }
}