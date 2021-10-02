package com.example.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tests.model.Car;
import com.example.tests.model.CarModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spin1;
    private Button btn1;
    private EditText out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        out = findViewById(R.id.out1);
        spin1 = findViewById(R.id.spin);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.buttonShow);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String type = spin1.getSelectedItem().toString();
                CarModel model = new CarModel();

                Car c = model.getCarByType(type);
                if(c!=null){
                    out.setText(c.getMake()+"year "+c.getModel());
                }else{
                    out.setText("car not found");
                }
            }
        });

    }
}