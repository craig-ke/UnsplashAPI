package com.craigke.picflicbackup.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MySplashArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public MySplashArrayAdapter (Context mContext, int resource, String[] mRestaurants, String[] mCuisines){
        super(mContext, resource);
        this.mContext = mContext;
        this.mCuisines = mCuisines;
        this.mRestaurants = mRestaurants;
    }

    @Override
    public Object getItem(int position){
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];
        return String.format("%s \n Serves great: %s", restaurant, cuisine);
    }

    @Override
    public int getCount(){
        return mRestaurants.length;
    }
}
