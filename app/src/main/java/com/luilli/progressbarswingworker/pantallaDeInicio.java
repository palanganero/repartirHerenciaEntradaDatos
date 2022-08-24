package com.luilli.progressbarswingworker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class pantallaDeInicio extends AppCompatActivity {
    //public ArrayList<Bien> inputs = new ArrayList();
    //public static ArrayList<Bien> A = new ArrayList();
    public RecyclerView recycler;
    public Button siguiente;
    public ArrayList<Bien> input = new ArrayList<>();
    public ArrayList<Bien> ia = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_inicio);
        siguiente= findViewById(R.id.siguiente);
        recycler= findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MainActivity.Input_Array = new Bien[Integer.parseInt(introducirPrimerosDatos.numeroBienes.getText().toString())];

        for(int i=0; i<Integer.parseInt(introducirPrimerosDatos.numeroBienes.getText().toString());i++)
        {
            Bien b= new Bien();
            b.setNombre("");
            b.setValor((double)i);
            MainActivity.Input_Array[i]=b;

        }
        for(int i=0;i<MainActivity.Input_Array.length;i++)
        {
            ia.add(MainActivity.Input_Array[i]);
        }
        adapter a= new adapter(ia);
        recycler.setAdapter(a);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.Input_Array=a.getInput();
                for(int i=0;i<a.getInput().size();i++)
                {
                    MainActivity.Input_Array[i]=a.getInput().get(i);
                }

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}