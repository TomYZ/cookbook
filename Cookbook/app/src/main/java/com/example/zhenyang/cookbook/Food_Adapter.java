package com.example.zhenyang.cookbook;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhenyang on 9/13/16.
 */
public class Food_Adapter extends BaseExpandableListAdapter {

    private Context context;
    private HashMap<String, List<String>> food_list;
    private List<String> food_type_list;

    public Food_Adapter( Context context,HashMap<String, List<String>> food_list,List<String> food_type_list){
        this.context = context;
        this.food_list = food_list;
        this.food_type_list = food_type_list;

    }

    @Override
    public int getGroupCount() {
        return food_type_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //Log.e("details",food_list.get(food_type_list.get(groupPosition)).get(0));
        return food_list.get(food_type_list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return food_type_list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return food_list.get(food_type_list.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String p= (String)getGroup(groupPosition);
        //Log.e("group",p);
        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.food_parent,parent,false);
        }
        TextView name =(TextView)convertView.findViewById(R.id.tv_type);
        name.setText(p);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child= (String)getChild(groupPosition, childPosition);
        //Log.e("child",child);
        if(convertView == null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.food_child,parent,false);
        }
        ImageView img= (ImageView)convertView.findViewById(R.id.img_food);
        TextView detail = (TextView)convertView.findViewById(R.id.tv_name);
        if("Fried Rice".equals(child)){
            img.setImageResource(R.drawable.fried_rice);
        }
        if("Wonton".equals(child)){
            img.setImageResource(R.drawable.wonton);
        }
        if("Samosa".equals(child)){
            img.setImageResource(R.drawable.samosa);

        }
        if("Burger".equals(child)){
            img.setImageResource(R.drawable.burger);
        }

        detail.setText(child);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
