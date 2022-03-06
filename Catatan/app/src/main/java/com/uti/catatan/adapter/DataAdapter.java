package com.uti.catatan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uti.catatan.R;
import com.uti.catatan.activities.UpdateDataActivity;
import com.uti.catatan.model.ModelKegiatan;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ModelKegiatan> dataKegiatan;

    public DataAdapter(Context context, ArrayList<ModelKegiatan> dataKegiatan) {
        this.context = context;
        this.dataKegiatan = dataKegiatan;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvKegiatan;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_list_nama);
            tvKegiatan = itemView.findViewById(R.id.tv_list_kegiatan);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item_data, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //set data
        holder.tvNama.setText(dataKegiatan.get(position).getNama());
        holder.tvKegiatan.setText(dataKegiatan.get(position).getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, UpdateDataActivity.class);
                pindah.putExtra("DATA_ID", dataKegiatan.get(position).getId());
                pindah.putExtra("DATA_NAMA", dataKegiatan.get(position).getNama());
                pindah.putExtra("DATA_KEGIATAN", dataKegiatan.get(position).getAlamat());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataKegiatan.size();
    }

}
