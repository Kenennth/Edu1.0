package com.kenneth1993.education;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by stupidsungjin on 2017-07-01.
 */

public class Loading_Adapter extends PagerAdapter {

    LayoutInflater inflater;

    public Loading_Adapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View page=inflater.inflate(R.layout.pages,container,false);
        ImageView img=(ImageView)page.findViewById(R.id.img);
        img.setImageResource(R.drawable.a0 +position);
        container.addView(page);


        return page;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
