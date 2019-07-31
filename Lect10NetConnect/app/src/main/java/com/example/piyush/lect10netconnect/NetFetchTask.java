package com.example.piyush.lect10netconnect;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Piyush on 05-07-2016.
 */
public class NetFetchTask extends AsyncTask<String, Void, Event> {

    public static final String TAG = "NetFetchTask";

    public interface PostExecuteListener {
        public void postExecuteDone(Event event);
    }

    private PostExecuteListener myListener;

    public NetFetchTask(PostExecuteListener postExecuteListener) {
        myListener = postExecuteListener;
    }


    @Override
    protected Event doInBackground(String... params) {

        Event myEvent = null;

        String returnString = "";
        Log.d(TAG, "doInBackground: ");
        int responseCode = 0;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(10000);
            urlConn.setReadTimeout(20000);

            urlConn.connect();

            responseCode = urlConn.getResponseCode();
            Log.d(TAG,"response "+responseCode);
            if(responseCode == 200){
                returnString = isToString(urlConn.getInputStream());
                Log.d("myJsonString",returnString);
                myEvent = getEventFromResponse(returnString);
                Log.d("!Event",myEvent.eventName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return myEvent;
    }

    @Override
    protected void onPostExecute(Event event) {
        Log.d(TAG, "onPostExecute: "+event.eventType);
        super.onPostExecute(event);
        myListener.postExecuteDone(event);
    }

    public String isToString (InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));
//        char[] buffer = new char[10];
//        r.read(buffer);

        StringBuilder sb = new StringBuilder();
        String line = r.readLine();
        while (line != null && !line.isEmpty()){
            sb.append(line);
            line = r.readLine();
        }

        return sb.toString();
    }

    public Event getEventFromResponse(String resp) throws JSONException {
        Log.d(TAG, "getEventFromResponse: ");
        JSONObject jsonObject = new JSONObject(resp);
        Event event = new Event(
                jsonObject.getString("name"),
                jsonObject.getString("location_name"),
                jsonObject.getString("topic"),
                jsonObject.getString("type")
        );
        Log.d(TAG,event.eventName);
        //=====================

//        JSONArray jsonArray = new JSONArray(resp);
//        int len = jsonArray.length();
//        for (int i = 0; i < len; i++){
//            JSONObject singleObject = jsonArray.getJSONObject(i);
//        }

        //=====================

        return event;
    }

}
