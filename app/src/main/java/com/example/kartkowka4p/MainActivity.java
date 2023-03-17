package com.example.kartkowka4p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> cosie = new ArrayList<>();
    Button buttonDodaj;
    EditText editText;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDodaj = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);
        cosie.add ("zagrać");
        cosie.add ("zagrać");
        cosie.add ("zagrać");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cosie);
        ListView listView = findViewById(R.id.listViewCos);
        listView.setAdapter(adapter);
       buttonDodaj.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       cosie.add(editText.getText().toString());
                   adapter.notifyDataSetChanged();
                   }
               }
       );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        cosie.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }
}