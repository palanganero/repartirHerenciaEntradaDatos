package com.luilli.progressbarswingworker;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>{

    public static ArrayList<Bien> listDatos;
    public static ArrayList<Bien> input = new ArrayList<>();
    public static String name;
    public static double value;
    public adapter(ArrayList<Bien> listDatos) {
        this.listDatos = listDatos;
        this.input.addAll(listDatos);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(listDatos.get(position).getNombre());
    }
    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    /*
    public Bien[] getInput()
    {
        Bien[]aux=new Bien[input.size()];
        for(int i=0;i<input.size();i++)
        {
            aux[i]=input.get(i);
        }
        return aux;

    }*/
    public ArrayList<Bien> getInput()
    {
        return input;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        EditText nombre,valor;
        Button siguiente;
        public ViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            valor= itemView.findViewById(R.id.valor);
            siguiente= itemView.findViewById(R.id.siguiente);

            nombre.addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) {}
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!s.toString().matches(""))
                    {
                        name=s.toString();
                        Bien b= new Bien();
                        b.setNombre(s.toString());
                        b.setValor(value);
                        input.set(getAdapterPosition(), b);
                    }
                }
            });
            valor.addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) {}
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!s.toString().matches(""))
                    {
                        value=Double.parseDouble(s.toString());
                        Bien b= new Bien();
                        b.setValor(Double.parseDouble(s.toString()));
                        b.setNombre(name);
                        input.set(getAdapterPosition(), b);
                    }
                }
            });

        }
    }

}
