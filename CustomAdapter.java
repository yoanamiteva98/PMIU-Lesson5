package com.example.lesson5_adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataAnimals> {

    Context context;
    int LayoutResourceId;
    List <DataAnimals> data=null;

    public CustomAdapter(Context context, int resource, List<DataAnimals> objects) {
        super(context, resource, objects);
        this.LayoutResourceId = resource;
        this.context = context;
        this.data = objects;
    }

    static class DataHolder
    {
        ImageView ivAnimal;
        TextView tvAnimalName;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataHolder holder = null;
        if(convertView==null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(LayoutResourceId, parent);
            holder = new DataHolder();
            holder.ivAnimal = (ImageView)convertView.findViewById(R.id.ivAnimal);
            holder.tvAnimalName = (TextView)convertView.findViewById(R.id.tvAnimalName);
            convertView.setTag(holder);
        }
        else
        {
            holder = (DataHolder)convertView.getTag();
        }
        DataAnimals dataAnimals = data.get(position);
        holder.tvAnimalName.setText(dataAnimals.animalName);
        holder.ivAnimal.setImageResource(dataAnimals.resIdAnimal);
        return convertView;
    }

}
