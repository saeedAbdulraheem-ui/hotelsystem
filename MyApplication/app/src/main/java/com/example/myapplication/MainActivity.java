package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private static Context context;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        addItemsOnSpinner1();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    public void addItemsOnSpinner1() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("BMI calculator");
        list.add("Exercise");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public static Context getAppContext(){
        return MainActivity.context;
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnSubmit = (Button) findViewById(R.id.enterAppButton);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            String selection = spinner1.getSelectedItem().toString();//check this item if BMI go to BMI entry otherwise go to other one
                if(selection.equalsIgnoreCase("BMI calculator")){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }else if(selection.equalsIgnoreCase("Exercise")){
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,
                            "Please select an Activity from the list",
                            Toast.LENGTH_SHORT).show();
                }

            Toast.makeText(MainActivity.this,
                    "OnClickListener : " +
                            "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()),
                    Toast.LENGTH_SHORT).show();

        }

    });

}}