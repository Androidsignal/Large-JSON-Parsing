package com.example.akshar.largejson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String TAG="MainActivity";
    ListView listView;
    ArrayList<Bean> arrayList;
    public static String Lat="";
    public static String Longitude="";
    public static String Locality="";
    public static String Seris="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mylistView);
        arrayList = new ArrayList<>();


        AsynkLoader asyncLoader = new AsynkLoader(MainActivity.this, "http://ergast.com/api/f1/2004/1/results.json", new OnAsynkLoader() {
            @Override
            public void OnResult(String result) {

                try {
                    JSONObject mainJsonObject = new JSONObject(result);

                    //MRData
                    JSONObject jsonObject2 = mainJsonObject.getJSONObject("MRData");

                    //serise value
                    Seris=jsonObject2.getString("series");

                    //RaceTable
                    JSONObject jsonObject3 = jsonObject2.getJSONObject("RaceTable");


                    //Races
                    JSONArray jsonArray = jsonObject3.getJSONArray("Races");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject4 = jsonArray.getJSONObject(i);


                        JSONObject circuit=jsonObject4.getJSONObject("Circuit");
                        JSONObject Location=circuit.getJSONObject("Location");
                        Lat=Location.getString("lat");
                        Longitude=Location.getString("long");
                        Locality=Location.getString("locality");


                        JSONArray results = jsonObject4.getJSONArray("Results");
                        for (int j = 0; j < results.length(); j++) {
                            JSONObject res = results.getJSONObject(j);

                            JSONObject constructor = res.getJSONObject("Constructor");
                            Bean b = new Bean();
                            b.setLat(Lat);
                            b.setSeries(Seris);
                            b.setLongitute(Longitude);
                            b.setLocality(Locality);
                            b.setNationaliti(constructor.getString("nationality"));


                            arrayList.add(b);
                        }


                        MyAdapter adpt=new MyAdapter(getApplicationContext(),arrayList);
                        listView.setAdapter(adpt);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        asyncLoader.execute();

    }
}




