package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeLib extends AppCompatActivity {

    Button newlib,editlib, deletelib, out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lib);

        newlib = (Button) findViewById(R.id.btnnew);
        editlib = (Button) findViewById(R.id.btnedit);
        deletelib = (Button) findViewById(R.id.btndelete);
        out = (Button) findViewById(R.id.btnout);

        newlib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityNew.class);
                startActivity(intent);
            }
        });



        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                startActivity(intent);
            }
        });
    }
}