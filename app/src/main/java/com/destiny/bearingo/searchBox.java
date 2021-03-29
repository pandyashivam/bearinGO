package com.destiny.bearingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
//import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class searchBox extends AppCompatActivity {
    private MyAdapter adapter;
    private EditText bearingNumber, bearingId, bearingOd, bearingThickness;
    private ArrayList<Bearing > mBaringArrayList = new ArrayList<>();
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_box);
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-6491182242162559/2299200050");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-4457607627039532/2539754420");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ListView listView = findViewById(R.id.LIst);
        bearingNumber = findViewById(R.id.et_text);
        bearingId = findViewById(R.id.et_text2);
        bearingOd = findViewById(R.id.et_text3);
        bearingThickness = findViewById(R.id.et_text4);

        bearingNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        bearingId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        bearingOd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        bearingThickness.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                System.out.println("(" + i + ", " + i1 + ", " + i2 + ")");
                adapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        System.out.println("Calling parsItems()");
        getItems();

        adapter = new MyAdapter(this, mBaringArrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        showAdvertisement();
//        super.onBackPressed();
    }
    private void showAdvertisement() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            finish();
        }
    }
    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        interstitialAd.loadAd(adRequest);
    }

    private void getItems() {
        final ProgressBar loading = findViewById(R.id.pgbar);
        loading.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbxLdHloS_7DAMZXElNEVMr24YL3iaLcpM0nzHgFsPBAWAUL-PY/exec?action=getItems",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseItems(response);
                        loading.setVisibility(View.GONE);
                        adapter.notifyDataSetChanged();
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
    private void parseItems(String jsonResposnce){

        try {
            JSONObject jobj = new JSONObject(jsonResposnce);
            JSONArray jarray = jobj.getJSONArray("All");

            for (int i = 0; i < jarray.length(); i++) {

                JSONObject jo = jarray.getJSONObject(i);

                String bNumberLocal = jo.getString("bearingNumber");
                String iDLocal = jo.getString("ID");
                String oDLocal = jo.getString("OD");
                String thickLocal = jo.getString("Thick");
                String typeLocal = jo.getString("Type");

                mBaringArrayList.add(new Bearing(bNumberLocal, iDLocal, oDLocal, thickLocal,typeLocal));
            }
            System.out.println("List size:"+mBaringArrayList.size());
        } catch (JSONException e) {
            System.out.println("Json EXCEPTION: " + e);
        }
    }

    public class MyAdapter extends BaseAdapter implements Filterable {
        private ArrayList<Bearing> mOriginalValues;
        private ArrayList<Bearing> mDisplayedValues;
        LayoutInflater inflater;

        public MyAdapter(searchBox context, ArrayList<Bearing> orgList) {
            this.mOriginalValues = orgList;
            this.mDisplayedValues = orgList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if(mDisplayedValues != null)
                return mDisplayedValues.size();
            else
                return 0;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            //LinearLayout llContainer;
            TextView bearingNumber, ID, OD, Thick,Type;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.search_row, parent,false );

                holder.bearingNumber = convertView.findViewById(R.id.ids1);
                holder.ID = convertView.findViewById(R.id.ids2);
                holder.OD = convertView.findViewById(R.id.ids3);
                holder.Thick = convertView.findViewById(R.id.ids4);
                holder.Type = (TextView) convertView.findViewById(R.id.ids5);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.bearingNumber.setText(mDisplayedValues.get(position).getBearingNumber());
            holder.ID.setText(mDisplayedValues.get(position).getID());
            holder.OD.setText(mDisplayedValues.get(position).getOD());
            holder.Thick.setText(mDisplayedValues.get(position).getThick());
            holder.Type.setText(mDisplayedValues.get(position).getType());

            return convertView;
        }

        @Override
        public Filter getFilter(){
            Filter filter = new Filter(){
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();
                    ArrayList<Bearing> FilteredArrayList = new ArrayList<>();

                    if(mOriginalValues == null){
                        mOriginalValues = new ArrayList<>(mDisplayedValues);
                    }

                    if(constraint == null || constraint.length() == 0) {
                        results.count = mOriginalValues.size();
                        results.values = mOriginalValues;
                    }
                    else {
                        for(int i = 0; i < mOriginalValues.size(); i++){
                            String bNumber = mOriginalValues.get(i).getBearingNumber();
                            String bId = mOriginalValues.get(i).getID();
                            String bOd = mOriginalValues.get(i).getOD();
                            String bThick = mOriginalValues.get(i).getThick();
                            String bType = mOriginalValues.get(i).getType();

                            String cNumber = bearingNumber.getText().toString().toUpperCase();
                            String cId = bearingId.getText().toString();
                            String cOd = bearingOd.getText().toString();
                            String cThick = bearingThickness.getText().toString();

                            if(bNumber.startsWith(cNumber) || cNumber.length() == 0){

                                if(bId.equals(cId) || cId.length() == 0){

                                    if(bOd.equals(cOd) || cOd.length() == 0){

                                        if(bThick.equals(cThick) || cThick.length() == 0){

                                            FilteredArrayList.add(new Bearing(bNumber, bId, bOd, bThick,bType));

                                        }
                                    }
                                }
                            }
                        }
                        results.count = FilteredArrayList.size();
                        results.values = FilteredArrayList;
                    }
                    return results;
                }

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence charSequence, FilterResults results) {
                    mDisplayedValues = (ArrayList<Bearing>) results.values;
                    notifyDataSetChanged();
                }
            };

            return filter;
        }
    }
}