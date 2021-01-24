package com.nester.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

    //OnItemSelectedListener - потрібний для слухання натискань користувачем

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;
    Spinner spinner;
    ArrayList arraySpinner;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
        createMap();
    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this); //прослуховує спінер, що в ньому вибрано

        arraySpinner = new ArrayList();
        arraySpinner.add("guitar");
        arraySpinner.add("drums");
        arraySpinner.add("keyboard");

        //Добавив адаптер, з випадаючим списком
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arraySpinner);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap() {
        //Добавлення ціни при виборі товару у спінері
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 2000.0);
    }

    //метод додавання кількості
    public void quantityPlus(View view) {
        TextView quantityNubmer = (TextView) findViewById(R.id.quantityNubmer);
        quantity += 1;
        quantityNubmer.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
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
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

        //onItemSelected в даному методі пишеться код який виконуєть тоді коли якийсь елемент вибраний
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString(); // виводить назву елементу який вибраний у спінері
        price = (double) goodsMap.get(goodsName); //отримую ціну товару з map
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

            //Перевіряю імя в спінері, та виводжу до ньго правильну картинку. equals - використовується так як це строки - об'єкт.
            //Метод через if
        ImageView goodsImageView = findViewById(R.id.goodsImageView);
       /*if (goodsName.equals("guitar")) {
            goodsImageView.setImageResource(R.drawable.guitar);
        } else if (goodsName.equals("drums")) {
            goodsImageView.setImageResource(R.drawable.drums);
        } else if (goodsName.equals("keyboard")) {
            goodsImageView.setImageResource(R.drawable.keyboard);
        }*/

            //Метод череч Switch
        switch (goodsName) {
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                goodsImageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}