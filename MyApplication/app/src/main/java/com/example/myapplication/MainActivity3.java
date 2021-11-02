package com.example.myapplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

        // Array of strings storing country names
        String[] countries = new String[] {
                "India",
                "Pakistan",
                "Sri Lanka",
                "China",
                "Bangladesh",
                "Nepal",
                "Afghanistan",
                "North Korea",
                "South Korea",
                "Japan"
        };

        // Array of integers points to images stored in /res/drawable-hdpi/

        //here you have to give image name which you already pasted it in /res/drawable-hdpi/

        int[] flags = new int[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
        };

        // Array of strings to store currencies
        String[] currency = new String[]{
                "Indian Rupee",
                "Pakistani Rupee",
                "Sri Lankan Rupee",
                "Renminbi",
                "Bangladeshi Taka",
                "Nepalese Rupee",
                "Afghani",
                "North Korean Won",
                "South Korean Won",
                "Japanese Yen"
        };

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            // Each row in the list stores country name, currency and flag
            List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

            for(int i=0;i<10;i++){
                HashMap<String, String> hm = new HashMap<String,String>();
                hm.put("txt", "Country : " + countries[i]);
                hm.put("cur","Currency : " + currency[i]);
                hm.put("flag", Integer.toString(flags[i]) );
                aList.add(hm);
            }

            // Keys used in Hashmap
            String[] from = { "flag","txt","cur" };

            // Ids of views in listview_layout
            int[] to = { R.id.flag,R.id.txt,R.id.cur};

            // Instantiating an adapter to store each items
            // R.layout.listview_layout defines the layout of each item
            SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);

            // Getting a reference to listview of main.xml layout file
            ListView listView = ( ListView ) findViewById(R.id.listview);

            // Setting the adapter to the listView
            listView.setAdapter(adapter);
        }
    }