package com.example.challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.challenge.Animales.Animales;
import com.example.challenge.RecycleView.RecycleViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://api.myjson.com/bins/dr5wa" ;

    private JsonObjectRequest request ;
    private RequestQueue requestQueue ;
    private List<Animales> cards ;
    private RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cards = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recycleView);
        jsonrequest();
    }

    private void jsonrequest(){
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{

                            JSONArray cardsJSON = response.getJSONArray("animales");
                            JSONObject jsonObject = null;

                            for (int i = 0; i < cardsJSON.length(); i++){

                                jsonObject = cardsJSON.getJSONObject(i);
                                Animales animales = new Animales();
                                animales.setNombre(jsonObject.getString("nombre"));
                                animales.setDescripcion(jsonObject.getString("descripcion"));
                                animales.setImagen(jsonObject.getString("imagen"));
                                cards.add(animales);
                            }


                        }catch (JSONException jsonException){
                            jsonException.printStackTrace();

                        }

                        setRecyclerView(cards);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error del POKE server", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }
    private void setRecyclerView(List<Animales> animales){
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this,animales);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleViewAdapter);
    }
}
