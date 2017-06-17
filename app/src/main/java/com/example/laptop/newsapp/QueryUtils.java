package com.example.laptop.newsapp;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
public final class QueryUtils {
    private QueryUtils() {
    }

    public static ArrayList<Custom> fetchingData(String URL) {
        URL url = createUrl(URL);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
        }

        ArrayList<Custom> NEWS = extractJSON(jsonResponse);
        return NEWS;
    }

    private static URL createUrl(String URL) {
        URL url = null;
        try {
            url = new URL(URL);
        } catch (MalformedURLException e) {
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
            }
        } catch (IOException e) {
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static ArrayList<Custom> extractJSON(String newsJSON) {

        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        ArrayList<Custom> JsonRESULT = new ArrayList<>();

        try {
            JSONObject base = new JSONObject(newsJSON);
            JSONObject mresponse = base.getJSONObject("response");
            JSONArray mresults = mresponse.getJSONArray("results");
            for (int i = 0; i < mresults.length(); i++) {
                JSONObject newObject = mresults.getJSONObject(i);
                String WebTitle = newObject.getString("webTitle");
                String webUrl = newObject.getString("webUrl");
                String WebPublicationDate = newObject.getString("webPublicationDate");
                String Sectionname = newObject.getString("sectionName");
                JsonRESULT.add(new Custom(Sectionname, WebTitle, WebPublicationDate, webUrl));
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }
        return JsonRESULT;
    }
}
