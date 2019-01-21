package com.example.lenovo.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MyRecyclerView   extends RecyclerView {
    private Context context;
    public MyRecyclerView(Context context) {
        super(context);
        this.context = context;

    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MyRecyclerView(Context context, AttributeSet attrs, int defStyle)     {
        super(context, attrs, defStyle);
        this.context = context;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View view = (View) getChildAt(getChildCount()-1);
        int diff = (view.getBottom()-(getHeight()+getScrollY()+view.getTop()));
        if( diff == 0 ){  // if diff is zero, then the bottom has been reached
            TextView tv = new TextView(context);
            tv.setHeight(dpToPx(50));
            addView(tv,getChildCount());//update --> add to last
            requestLayout();
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
}