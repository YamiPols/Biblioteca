package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeAdmin extends AppCompatActivity {
    EditText usernameregis, passwordregis;
    Button enter;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        usernameregis = (EditText) findViewById(R.id.usernameregis);
        passwordregis = (EditText) findViewById(R.id.passwordregis);
        enter = (Button) findViewById(R.id.btnenter);
        DB = new DBHelper(this);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userres = usernameregis.getText().toString();
                String passres = passwordregis.getText().toString();
                if(userres.equals("Admin")&& passres.equals("1234")){
                Intent intent= new Intent(getApplicationContext(), HomeLib.class);
                startActivity(intent);
                }
                if (userres.equals("") || passres.equals(""))
                    Toast.makeText(HomeAdmin.this, "Porfavor llena todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkusernamepasswordre = DB.checkusernamepasswordre(userres, passres);
                    if (checkusernamepasswordre == false) {
                        Toast.makeText(HomeAdmin.this, "Los datos son incorrectos", Toast.LENGTH_SHORT).show();
                    } else {
                        if (checkusernamepasswordre == true) {
                            Toast.makeText(HomeAdmin.this, "Bienvenid@", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}