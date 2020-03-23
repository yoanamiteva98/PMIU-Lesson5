package com.example.lesson5_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<DataAnimals> lstData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstData = new ArrayList<>();
        lstData.add(new DataAnimals(R.drawable.lion,"Lion"));
        lstData.add(new DataAnimals(R.drawable.leopard,"Leopard"));
        lstData.add(new DataAnimals(R.drawable.tiger,"Tiger"));

        ListView listView = (ListView)findViewById(R.id.ListView);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.animalrow,lstData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            intent.putExtra("Animal",lstData.get(position).animalName);
                intent.putExtra("Photo",lstData.get(position).resIdAnimal);
                intent.setClass(MainActivity.this,Lion.class);
                startActivity(intent);


            }
        });

    }
}
