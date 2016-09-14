package com.example.zhenyang.cookbook;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView lv_category;
    private HashMap<String, List<String>> food_list;
    private List<String> food_type_list;
    private Food_Adapter food_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //------------------My Code
        lv_category=(ExpandableListView)findViewById(R.id.lv_category);
        food_list = new HashMap<>();
        food_type_list = new ArrayList<>();
        food_list = Data_category.get_list();

        food_type_list=new ArrayList<>(food_list.keySet());
        food_adapter= new Food_Adapter(this,food_list,food_type_list);
        lv_category.setAdapter(food_adapter);
        lv_category.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ImageView img = (ImageView)v.findViewById(R.id.img_food);
                String type = food_type_list.get(groupPosition);
                String name = food_list.get(food_type_list.get(groupPosition)).get(childPosition);
                String details= Data_category.get_detail(type,name);
                new AlertDialog.Builder(MainActivity.this).setTitle("Name: "+name).setMessage("Details: "+ details).setIcon(img.getDrawable()).create().show();


                return false;
            }
        });
        //-------------------My Code



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
