package com.simrnpuri.simran_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener{

    private ArrayList<String> listStrings;
    private ListView list;
    private ArrayAdapter<String> arrayAdapter;
    private EditText textEdit;
    private int i;
    private Editable newText;
    private Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listStrings = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,listStrings);
        list = findViewById(R.id.toDoList);
        list.setAdapter(arrayAdapter);
        textEdit = findViewById(R.id.textView);
        buttonAdd = findViewById(R.id.button);

        textEdit.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckedTextView task = (CheckedTextView) view;
        task.setChecked(!task.isChecked());
    }


    @Override
    public void onClick(View view) {
        newText = textEdit.getText();

        switch (view.getId()) {
            case R.id.button:
                Add();
                break;
        }
    }

    private void Add(){
        if (newText.toString() != "") {

            //add the text from the edit box to the list on button click
            listStrings.add(i, newText.toString());

            //clears the text in the edit box
            textEdit.getText().clear();

            //list is updated/refreshed
            arrayAdapter.notifyDataSetChanged();
        }
    }
}