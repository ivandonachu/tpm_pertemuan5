package com.example.pertemuan5;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import com.example.pertemuan5.database.Datadiri;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Datadiri[] list;
    private Context context;

    public Adapter(Datadiri[] list, Context context){
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    final  Datadiri item = list[position];
    holder.tvNama.setText(item.getNama());
    holder.tvAlamat.setText(item.getAlamat());
    holder.tvKelamin.setText("" + item.getJkelamin());
    holder.layout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, update.class);
            intent.putExtra("nama", item.getNama());
            intent.putExtra("alamat", item.getAlamat());
            intent.putExtra("kelamin", item.getJkelamin());
            intent.putExtra("id", item.getId());
            context.startActivity(intent);

        }
    });

    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvKelamin, tvAlamat;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_namaa);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvKelamin = itemView.findViewById(R.id.tv_jeniskel);
            layout = itemView.findViewById(R.id.layout);

        }

    }
}