package com.example.piyush.l4lists;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> courseList = new ArrayList<>(24);
        for(int i = 2014; i < 2020; i++) {
            courseList.add("LaunchPad" + i);
            courseList.add("Crux" + i);
            courseList.add("Pandora"+ i);
            courseList.add("Elixir" + i);
        }


        ListView listView = (ListView)findViewById(R.id.my_list);

        ArrayAdapter<String> courseAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,courseList);

        listView.setAdapter(courseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long id) {
                String courseName = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
                Toast.makeText(MainActivity.this, "Enrolled in " + courseName, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
