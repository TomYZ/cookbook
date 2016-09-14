package com.example.zhenyang.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhenyang on 9/12/16.
 */
public class Category_Adapter extends BaseAdapter{

    private Context context;
    private List<String> food_list;

    public Category_Adapter(Context context, List<String> food_list){
        this.context = context;
        this.food_list = food_list;

    }


    @Override
    public int getCount() {
        return food_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String food_name = food_list.get(position);
        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.category_child,parent,false);

        }
        TextView tv = (TextView)convertView.findViewById(R.id.tv_category);
        tv.setText(food_name);
        HashMap<String,List<String>> food_list = new HashMap<>();
        List<String> food_type_list = new ArrayList<>();
        ExpandableListView exp_lv = (ExpandableListView)convertView.findViewById(R.id.exp_lv);
        food_list = Data_category.get_list();
        food_type_list = new ArrayList<>(food_list.keySet());
        Food_Adapter food_adapter = new Food_Adapter(context,food_list,food_type_list);
        exp_lv.setAdapter(food_adapter);



        return convertView;
    }
}
