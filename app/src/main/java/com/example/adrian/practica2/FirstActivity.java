package com.example.adrian.practica2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button addTxtBtn;
    private Button checkListBtn;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText = findViewById(R.id.editText);
        addTxtBtn = findViewById(R.id.addTxtBtn);
        checkListBtn = findViewById(R.id.checkListBtn);
    }

    @Override
    protected void onResume() {
        super.onResume();

        addTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                if (text.isEmpty())
                    Toast.makeText(getApplicationContext(), "Ingresa un texto", Toast.LENGTH_SHORT).show();
                else {
                    list.add(text);
                    editText.setText("");
                }
            }
        });

        checkListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putStringArrayListExtra("list", list);
                startActivity(intent);
            }
        });
    }
}
