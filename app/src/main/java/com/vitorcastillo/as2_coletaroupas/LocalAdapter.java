package com.vitorcastillo.as2_coletaroupas;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LocalAdapter extends
        RecyclerView.Adapter<LocalAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        public ViewHolder(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.loja_rec);
            textView2 = itemView.findViewById(R.id.tipo_rec);
            textView3 = itemView.findViewById(R.id.endereco_rec);
            textView4 = itemView.findViewById(R.id.contato_rec);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.recycler_item,
                parent,
                false
        );
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Local p = DataModel.getInstance().locais.get(position);
        holder.textView1.setText(p.getNome());
        holder.textView2.setText(""+p.getTipo());
        holder.textView3.setText(""+p.getEndereco());
        holder.textView4.setText(""+p.getContato());
        Log.v("LocalAdapter", "Item[" + position + "]:" + p.getNome());
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().locais.size();
    }
}
