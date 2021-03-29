package com.destiny.bearingo;
import android.app.ProgressDialog;
import android.os.Bundle;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class list_item extends Box{
    ListView listView;
    ListAdapter adapter;
    ProgressDialog loading;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-4457607627039532/6800958289");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        listView = findViewById(R.id.myLIst);

        getItems();

    }


    private void getItems() {

        loading =  ProgressDialog.show(this,"Loading","please wait",false,true);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbxwtsc3GjNoVrH7uWANjkOECaJSwp_2TiZPVzAX04iuN3evqaaZ/exec?action=getItems",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseItems(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        int socketTimeOut = 50000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }


    private void parseItems(String jsonResposnce) {

        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        try {
            JSONObject jobj = new JSONObject(jsonResposnce);
            JSONArray jarray = jobj.getJSONArray("Deep_Groove");

            for (int i = 0; i < jarray.length(); i++) {

                JSONObject jo = jarray.getJSONObject(i);

                String bearingNumber = jo.getString("bearingNumber");
                String ID = jo.getString("ID");
                String OD = jo.getString("OD");
                String Thick = jo.getString("Thick");

                HashMap<String, String> item = new HashMap<>();
                item.put("bearingNumber", bearingNumber);
                item.put("ID", ID);
                item.put("OD",OD);
                item.put("Thick",Thick);


                list.add(item);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        adapter = new SimpleAdapter(this,list,R.layout.list_item_row,
                new String[]{"bearingNumber","ID","OD","Thick"},new int[]{R.id.id1,R.id.id2,R.id.id3,R.id.id4});


        listView.setAdapter(adapter);
        loading.dismiss();
    }

}
