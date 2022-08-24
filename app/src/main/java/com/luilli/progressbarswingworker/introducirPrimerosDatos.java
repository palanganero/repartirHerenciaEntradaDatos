package com.luilli.progressbarswingworker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class introducirPrimerosDatos extends AppCompatActivity {

    public Button siguiente;
    public static EditText numeroHerederos,numeroBienes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_primeros_datos);
        numeroHerederos=findViewById(R.id.numeroHerederos);
        numeroBienes=findViewById(R.id.numeroDeBienes);
        siguiente=findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),pantallaDeInicio.class);
                startActivity(intent);
            }
        });
    }
}