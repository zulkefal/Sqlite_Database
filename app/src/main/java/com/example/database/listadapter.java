package com.example.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class listadapter extends ArrayAdapter {
    List list=new ArrayList();

    public listadapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView id, name, father,semes,sec,marks,phone;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    public int count()
    {
        return list.size();
    }
    @Nullable
    public Object getitem(int position)
    {
        return list.get(position);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;

        LayoutHandler layoutHandler;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row,parent,false);
            layoutHandler= new LayoutHandler();
            layoutHandler.id=(TextView) row.findViewById(R.id.id1);
            layoutHandler.name=(TextView) row.findViewById(R.id.name1);
            layoutHandler.father=(TextView) row.findViewById(R.id.father1);
            layoutHandler.semes=(TextView) row.findViewById(R.id.semes1);
            layoutHandler.sec=(TextView) row.findViewById(R.id.sec1);
            layoutHandler.marks=(TextView) row.findViewById(R.id.mark1);
            layoutHandler.phone=(TextView) row.findViewById(R.id.ph1);
            row.setTag(layoutHandler);


        }
        else
        {
            layoutHandler=(LayoutHandler) row.getTag();

        }

        dataprovider dd=(dataprovider) this.getitem(position);
        layoutHandler.id.setText(dd.getRoll());
        layoutHandler.name.setText(dd.getName());
        layoutHandler.father.setText(dd.getFat());
        layoutHandler.semes.setText(dd.getSem());
        layoutHandler.sec.setText(dd.getSec());
        layoutHandler.marks.setText(dd.getMk());
        layoutHandler.phone.setText(dd.getPone());

        return row;
        //return super.getView(position, convertView, parent);
    }
}
