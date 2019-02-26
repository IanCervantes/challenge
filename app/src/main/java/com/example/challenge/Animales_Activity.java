package com.example.challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.challenge.Animales.Animales;

public class Animales_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_);
        Animales animales=(Animales) getIntent().getSerializableExtra("animales");
        loadAnimales(animales);
    }
    private void loadAnimales(Animales animales){
        TextView nombre, descripcion;
        ImageView image;
        nombre = findViewById(R.id.nombre);
        descripcion = findViewById(R.id.descripcion);
        image = findViewById(R.id.card);
        RequestOptions option = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
        nombre.setText(animales.getNombre());
        descripcion.setText(animales.getDescripcion());
        Glide.with(this).load(animales.getImagen()).apply(option).into(image);
    }
}
