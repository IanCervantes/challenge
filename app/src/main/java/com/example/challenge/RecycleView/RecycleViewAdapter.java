package com.example.challenge.RecycleView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.challenge.Animales.Animales;
import com.example.challenge.Animales_Activity;
import com.example.challenge.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{
    private Context mContext;
    private List<Animales> mData;
    RequestOptions option;
    public RecycleViewAdapter(Context mContext, List<Animales> mData){
        this.mContext=mContext;
        this.mData=mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view;
        LayoutInflater inflater= LayoutInflater.from(mContext);
        view= inflater.inflate(R.layout.activity_animales_,parent,false);
        final MyViewHolder viewHolder= new MyViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animales animales= mData.get(viewHolder.getAdapterPosition());
                Toast.makeText(mContext,"",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(mContext, Animales_Activity.class);
                intent.putExtra("animales", animales);
                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.nombre.setText(mData.get(i).getNombre());
        myViewHolder.descripcion.setText(mData.get(i).getDescripcion());

        Glide.with(mContext).load(mData.get(i).getImagen()).apply(option).into(myViewHolder.image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, descripcion;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            image = itemView.findViewById(R.id.card);
        }

    }
}
