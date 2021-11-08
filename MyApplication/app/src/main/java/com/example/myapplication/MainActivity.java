package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private static Context context;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        loadprevemail();
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
        EditText emailfield = (EditText) findViewById(R.id.editTextTextEmailAddress);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnSubmit = (Button) findViewById(R.id.enterAppButton);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            String selection = spinner1.getSelectedItem().toString();//check this item if BMI go to BMI entry otherwise go to other one
            String email = emailfield.getText().toString();
            if(checkemail(email)){ // if the email is real save it locally in json format
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = prefs.edit();
                Gson gson = new Gson();
                String emailjson = gson.toJson(email);
                editor.putString("123", emailjson);
                editor.commit();
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
            }else{
                Toast.makeText(MainActivity.this, "Invalid Email, check again", Toast.LENGTH_SHORT).show();
            }
        }

    });

    }

    public void loadprevemail() {
        EditText emailfield = (EditText) findViewById(R.id.editTextTextEmailAddress);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("123", "");
        String email = gson.fromJson(str, String.class);
        if(email!= null) {
            emailfield.setText(email);
        }
    }
    public static boolean checkemail(String email){   //checks if a string is an email
        Toast.makeText(getAppContext(), email,
                Toast.LENGTH_SHORT).show();
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);

        if(mat.matches()){
            return true;
        }else{
            return false;
        }
    }
}