package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityNew extends AppCompatActivity {
EditText id, nombre, editorial, paginas, descripcion;
Button agregar;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        id = (EditText) findViewById(R.id.idlib);
        nombre = (EditText) findViewById(R.id.namellib);
        editorial = (EditText) findViewById(R.id.editoriallib);
        paginas = (EditText) findViewById(R.id.pagelib);
        descripcion = (EditText) findViewById(R.id.descriptionlib);
        agregar = (Button) findViewById(R.id.btnadd);
        DB = new DBHelper(this);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idlib = id.getText().toString();
                String nombrelib = nombre.getText().toString();
                String edilib = editorial.getText().toString();
                String paginaslib = paginas.getText().toString();
                String descriplib = descripcion.getText().toString();
                if (idlib.equals("")||nombrelib.equals("")||edilib.equals("")||paginaslib.equals("")||descriplib.equals(""))
                    Toast.makeText(ActivityNew.this, "Porfavor llena todos los campos", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(idlib,nombrelib,edilib,paginaslib,descriplib);
                    if (insert==true){
                        Toast.makeText(ActivityNew.this, "Agregado exitosamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}