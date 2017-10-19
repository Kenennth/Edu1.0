package com.kenneth1993.education;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-24 on 2017-07-20.
 */

public class Application_Items_For_Adapter extends BaseAdapter {

    ArrayList<Application_Items_For_ListView> item;
    LayoutInflater inflater;

    public Application_Items_For_Adapter(ArrayList<Application_Items_For_ListView> item, LayoutInflater inflater) {
        this.item = item;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=inflater.inflate(R.layout.application_items,null);
        }
        Application_Items_For_ListView items= item.get(position);

        int img=items.img;
        String header =items.header;
        String contents= items.contents;


        ImageView img1=(ImageView)convertView.findViewById(R.id.img1);
        TextView header1=(TextView)convertView.findViewById(R.id.text);
        TextView contents1=(TextView)convertView.findViewById(R.id.text2);

        img1.setImageResource(img);
        header1.setText(header);
        contents1.setText(contents);

        return convertView;
    }
}
