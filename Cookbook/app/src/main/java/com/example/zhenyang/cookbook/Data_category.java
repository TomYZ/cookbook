package com.example.zhenyang.cookbook;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhenyang on 9/12/16.
 */
public class Data_category {
    public static List<String> get_food() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());

        List<String> food_list = new ArrayList<String>();
        try {

            String urlPath="http://www.edward-hu.com/cookbook";
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int len = 0;
            URL url = null;

                url = new URL(urlPath);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inStream = conn.getInputStream();
            while ((len = inStream.read(data)) != -1) {
                outStream.write(data, 0, len);
            }
            inStream.close();
            String s=new String(outStream.toByteArray());
            JSONObject jsonObject=new JSONObject(s);
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = jsonObject.getString(key);
                //Log.e("food category",key);
                food_list.add(key);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
        return food_list;

    }
    public static  String get_detail(String selected_type,String selected_name){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        String d="";


        try {

            String urlPath="http://www.edward-hu.com/cookbook";
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int len = 0;
            URL url = null;

            url = new URL(urlPath);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inStream = conn.getInputStream();
            while ((len = inStream.read(data)) != -1) {
                outStream.write(data, 0, len);
            }
            inStream.close();
            String s=new String(outStream.toByteArray());
            JSONObject jsonObject=new JSONObject(s);
            Iterator it = jsonObject.keys();

            while (it.hasNext()) {
                String key = (String) it.next();
                String value = jsonObject.getString(key);
                if(key.equals(selected_type) ) {
                    JSONArray jsonArray = new JSONArray(value);

                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONObject item = jsonArray.getJSONObject(j);
                        String name = item.getString("name");
                        String detail = item.getString("details");
                        if(name.equals(selected_name)){
                            return detail;
                        }


                    }


                }




            }





        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;

    }

    public static HashMap<String,List<String>> get_list() {

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());

        HashMap<String,List<String>> food_list = new HashMap<>();

        try {

            String urlPath="http://www.edward-hu.com/cookbook";
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int len = 0;
            URL url = null;

            url = new URL(urlPath);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inStream = conn.getInputStream();
            while ((len = inStream.read(data)) != -1) {
                outStream.write(data, 0, len);
            }
            inStream.close();
            String s=new String(outStream.toByteArray());
            JSONObject jsonObject=new JSONObject(s);
            Iterator it = jsonObject.keys();

            while (it.hasNext()) {
                String key = (String) it.next();
                String value = jsonObject.getString(key);

                    JSONArray jsonArray = new JSONArray(value);
                    List<String> food_type_list = new ArrayList<>();
                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONObject item = jsonArray.getJSONObject(j);
                        String name = item.getString("name");
                        String detail = item.getString("details");

                        food_type_list.add(name);


                    }

                    food_list.put(key, food_type_list);
                    Log.e("food list", food_list.toString());




            }





        } catch (Exception e) {
            e.printStackTrace();
        }
        return food_list;

    }


}
