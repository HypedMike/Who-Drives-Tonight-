package com.example.whodrivestonight;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Button add_butt;
    EditText input_name;
    TextView list_of_names;
    Button generator;

    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_butt = findViewById(R.id.add_button);
        input_name = findViewById(R.id.add_name_input);
        list_of_names= findViewById(R.id.list_of_names);
        generator = findViewById(R.id.random_generator_butt);

        names = new LinkedList<String>();

        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = (int) Math.floor(Math.random()*((names.size() - 1)+1));
                Snackbar mySnackbar = Snackbar.make(view, names.get(index), BaseTransientBottomBar.LENGTH_LONG);
                mySnackbar.show();
            }
        });

        add_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = input_name.getText().toString();
                System.out.println(temp);
                if(temp != null){
                    names.add(temp);
                    input_name.setText("");
                }
                update_textview();
            }
        });
    }
    public void update_textview(){
        list_of_names.setText(String.join(", ", names));
    }

}