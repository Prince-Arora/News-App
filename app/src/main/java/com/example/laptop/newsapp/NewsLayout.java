package com.example.laptop.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsLayout extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Custom>> {
    public String query = "";
    private NewsAdapter mNewsAdapters;
    private String USGS_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_layout);
        query = getIntent().getExtras().get("toSearch").toString();
        USGS_URL = "http://content.guardianapis.com/search?q=" + query + "&api-key=test";
        ListView NewsListView = (ListView) findViewById(R.id.list);
        mNewsAdapters = new NewsAdapter(this, new ArrayList<Custom>());
        NewsListView.setAdapter(mNewsAdapters);
        NewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Custom currentNews = mNewsAdapters.getItem(position);
                Uri URI = Uri.parse(currentNews.getWebUrl());
                Intent webBrowser = new Intent(Intent.ACTION_VIEW, URI);
                startActivity(webBrowser);
            }
        });
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(0, null, this);
        }
        else
        {
            TextView tview=(TextView)findViewById(R.id.empty_view);
            tview.setText("No Internet Access");
        }
    }

    public Loader<ArrayList<Custom>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(NewsLayout.this, USGS_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Custom>> loader, ArrayList<Custom> data) {
        mNewsAdapters.clear();
        if (data != null && !data.isEmpty()) {
            mNewsAdapters.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Custom>> loader) {
        mNewsAdapters.clear();
    }

}





