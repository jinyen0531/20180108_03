package com.yenyu.a20180108_03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Map<String,Object>> mylist = new ArrayList<>();
    boolean chks[];
    Context context; //用來做(上下文、場景)交互使用的環境

    public MyAdapter(Context context,ArrayList<Map<String,Object>> mylist,boolean chks[])
            //建一個建構式，將MainActivtiy的mylist跟MainActivtity帶進MyAdapter的Class
    {
        this.context=context; //這邊的context用來銜接MainActivity的內容到這個新的Class
        this.mylist=mylist;
        this.chks=chks; //把這邊的chks指給MainActivity的chks
    }

    @Override //回傳Adapter 有幾格
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View v, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if( v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tv = v.findViewById(R.id.textView);
            viewHolder.tv2 = v.findViewById(R.id.textView2);
            viewHolder.img = v.findViewById(R.id.imageView);
            viewHolder.chk = v.findViewById(R.id.checkBox);
            v.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)v.getTag();
        }




        viewHolder.chk.setOnCheckedChangeListener(null);
        //加這行才會記憶打勾的項目!!!!!!!!!!
        //打勾過滑開後，便把記憶體回收給下一個出現的序號，
        //但在setChecked這行時，會觸動setOnCheckChangeListener，
        //序號回收後(5)，b沒改變，會將回收的(5)狀態傳給被回收(0)的序號
        //於是第0個序號原本是打勾的，卻被回收出來的第5個序號的動態轉成未打勾。
        //所以要加上這行，讓setOnCheckChangeListener不被啟動。
        viewHolder.chk.setChecked(chks[position]);
        //setChecked為boolean， 指向個別的布林chks[]項目
        //以記憶打勾的位置
        viewHolder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position]= b;
                if(b)
                {Toast.makeText(context,"您已選擇"+mylist.get(position).get("city"),Toast.LENGTH_SHORT).show();}
                else
                {Toast.makeText(context,"您已取消"+mylist.get(position).get("city"),Toast.LENGTH_SHORT).show();}}});
        viewHolder.tv.setText(mylist.get(position).get("city").toString());
        viewHolder.tv2.setText(mylist.get(position).get("code").toString());
        viewHolder.img.setImageResource(Integer.parseInt(mylist.get(position).get("img").toString()));

        return v; //回傳自訂的View 出來

    }

    static class ViewHolder
        //為了節省每離開記憶體後又重新findViewById
        //將會使用到的變數宣告在ViewHolder裡面
    {
        TextView tv;
        TextView tv2;
        ImageView img;
        CheckBox chk;

    }
}
