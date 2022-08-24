package com.luilli.progressbarswingworker;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class TableDynamic {
    private TableLayout tableLayout;
    private Context context;
    private String[] header;
    private List<List<Bien>>data;
    private TableRow tableRow;
    private TextView txtCell;
    private int indexC;
    private int indexR;
    private boolean multiColor=false;


    public TableDynamic(TableLayout tableLayout, Context context) {
        this.tableLayout=tableLayout;
        this.context=context;
    }

    public void addHeader(int combinacion)
    {
        String [] header= {String.valueOf(combinacion)};
        this.header=header;
        createHeader();
    }
    public void addData(List<List<Bien>> data)
    {
        this.data=data;
        createDataTable();
    }
    private void newRow()
    {
        tableRow= new TableRow(context);
        tableRow.setBackgroundColor(Color.BLACK);
    }
    private void newCell()
    {
        txtCell= new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(25);
    }

    private void createHeader()
    {
        indexC=0;
        newRow();
        while(indexC<header.length)
        {
            newCell();
            txtCell.setText("Combinacion "+header[indexC++]);
            txtCell.setTextColor(Color.WHITE);
            tableRow.addView(txtCell,newTableRowParams());
            tableRow.setBackgroundColor(Color.DKGRAY);
        }
        tableLayout.addView(tableRow);
    }

    private void createDataTable()
    {
        Bien info;
            for(indexR=0;indexR< data.size();indexR++)
            {
                    //multiColor=!multiColor;
                    newRow();
                    newCell();
                    txtCell.setText("Heredero"+String.valueOf(indexR));
                    txtCell.setBackgroundColor(Color.GRAY);
                    tableRow.addView(txtCell, newTableRowParams());
                    for (indexC = 0; indexC < data.get(indexR).size(); indexC++) {
                        newCell();
                        txtCell.setText(String.valueOf(data.get(indexR).get(indexC).getNombre()));
                        txtCell.setBackgroundColor((multiColor)? Color.GRAY:Color.CYAN);
                        tableRow.addView(txtCell, newTableRowParams());

                        newCell();
                        txtCell.setText(String.valueOf(data.get(indexR).get(indexC).getValor()));
                        txtCell.setBackgroundColor((multiColor)? Color.GRAY:Color.CYAN);
                        tableRow.addView(txtCell, newTableRowParams());
                    }
                    tableLayout.addView(tableRow);
            }
    }

    public void backgroundHeader(int color)
    {
        indexC=0;
        while(indexC<header.length)
        {
            txtCell=getCell(0,indexC++);
            txtCell.setBackgroundColor(color);
        }
    }

    public void lineColor(int color)
    {
        indexR=0;
        while(indexR<=data.size())
        {
            //Log.i("hola",String.valueOf(indexR));
            getRow(indexR++).setBackgroundColor(color);
        }
    }

    private TableRow getRow(int index)
    {
        return (TableRow) tableLayout.getChildAt(index);
    }

    private TextView getCell(int rowIndex,int columnIndex)
    {
        tableRow=getRow(rowIndex);
        return (TextView) tableRow.getChildAt(columnIndex);
    }

    private TableRow.LayoutParams newTableRowParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1, 1, 1, 1);
        params.weight = 1;
        return params;
    }


}
