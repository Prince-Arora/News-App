package com.example.laptop.newsapp;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import java.util.ArrayList;


public class NewsLoader extends AsyncTaskLoader<ArrayList<Custom>> {
    private String mUrl = "";

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Custom> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        ArrayList<Custom> earthquakes = QueryUtils.fetchingData(mUrl);
        return earthquakes;
    }
}
