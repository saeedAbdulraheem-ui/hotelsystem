package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupReturnButton();
        calculateBmi();
    }

    public void setupReturnButton(){
        Button returntolobby = (Button)findViewById(R.id.returnfrombmi);

        returntolobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void calculateBmi(){
        Button getbmi = (Button)findViewById(R.id.calcbmi);
        getbmi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView bmires = (TextView)findViewById(R.id.resultofbmi);
                EditText weightedit = (EditText)findViewById(R.id.editweight);
                EditText heightedit = (EditText)findViewById(R.id.editheight);
                float weight,height,bmi;
                if(weightedit.getText().toString().length() > 1 && heightedit.getText().toString().length()>1) {
                    weight = Float.parseFloat(weightedit.getText().toString());
                    height = Float.parseFloat(heightedit.getText().toString()); //bmi = KG/M^2
                    bmi = 10000*weight/(height*height);
                    if(bmi > 25){
                        //fat
                        bmires.setText(bmi +" overweight");
                    }else{
                        //normal
                        bmires.setText(bmi +" normal BMI");
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"please enter proper values",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}