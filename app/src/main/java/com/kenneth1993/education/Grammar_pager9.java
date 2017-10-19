package com.kenneth1993.education;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alfo06-24 on 2017-07-25.
 */

public class Grammar_pager9 extends PagerAdapter {

    LayoutInflater inflater1;

    public Grammar_pager9(LayoutInflater inflater) {
        this.inflater1 = inflater;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View page1=inflater1.inflate(R.layout.page,container,false); // page의 infalter
        TextView img=(TextView) page1.findViewById(R.id.image1);//xml에 있는 이미지뷰의 id

        img.setBackgroundResource(R.drawable.paper_00+position);

        if(position==0){img.setText(R.string.btn9_1);}
        if(position==1){img.setText(R.string.btn9_2);}


        container.addView(page1);

        return page1;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View)object);
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
