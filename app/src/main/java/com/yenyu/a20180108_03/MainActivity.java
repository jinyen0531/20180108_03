package com.yenyu.a20180108_03;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Map<String,Object>> mylist = new ArrayList<>();
    boolean chks[]= new boolean[7];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        MyAdapter  adapter =new MyAdapter(MainActivity.this,mylist,chks);
        lv.setAdapter(adapter);

        HashMap<String,Object> m1 =new HashMap<>();
        HashMap<String,Object> m2 =new HashMap<>();
        HashMap<String,Object> m3 =new HashMap<>();
        HashMap<String,Object> m4 =new HashMap<>();
        HashMap<String,Object> m5 =new HashMap<>();
        HashMap<String,Object> m6 =new HashMap<>();
        HashMap<String,Object> m7 =new HashMap<>();

        m1.put("city","台北");
        m2.put("city","台中");
        m3.put("city","台南");
        m4.put("city","高雄");
        m5.put("city","台東");
        m6.put("city","宜蘭");
        m7.put("city","彰化");

        m1.put("code","02");
        m2.put("code","04");
        m3.put("code","06");
        m4.put("code","07");
        m5.put("code","08");
        m6.put("code","09");
        m7.put("code","03");

        m1.put("img",R.drawable.tp);
        m2.put("img",R.drawable.tc);
        m3.put("img",R.drawable.tn);
        m4.put("img",R.drawable.kh);
        m5.put("img",R.drawable.kh);
        m6.put("img",R.drawable.kh);
        m7.put("img",R.drawable.kh);

        mylist.add(m1);
        mylist.add(m2);
        mylist.add(m3);
        mylist.add(m4);
        mylist.add(m5);
        mylist.add(m6);
        mylist.add(m7);

    }

    public void click1(View v) //點擊顯示選擇的CheckBox
    {
        StringBuilder sb = new StringBuilder(); //StringBuilder 可不斷新增的字串空間
        for(int i=0 ; i<chks.length;i++) //跑chks陣列的迴圈
        {
            if(chks[i]) //如果chks[i] = true
            {
                sb.append(mylist.get(i).get("city")+",");
                //新增i 的 city(KEY)的VALUE進去字串空間
            }
        }
        Toast.makeText(MainActivity.this,"您選擇了"+sb.toString(),Toast.LENGTH_SHORT).show();

    }


}

