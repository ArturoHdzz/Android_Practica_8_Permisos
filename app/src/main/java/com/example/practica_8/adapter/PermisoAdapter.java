package com.example.practica_8.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_8.R;
import com.example.practica_8.model.Permiso;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.PermisoViewHolder>{


    List<Permiso> Lista_permisos;

    public PermisoAdapter(List<Permiso> lista_permisos) {
        Lista_permisos = lista_permisos;
    }

    @NonNull
    @Override
    public PermisoAdapter.PermisoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly= LayoutInflater.from(parent.getContext());
        View v= ly.inflate(R.layout.itempermisos, parent, false);
        return new PermisoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.PermisoViewHolder holder, int position) {
        Permiso p= Lista_permisos.get(position);
        holder.setData(p);
    }

    @Override
    public int getItemCount() {
        return Lista_permisos.size();
    }

    public class PermisoViewHolder extends RecyclerView.ViewHolder {

        TextView txtPermiso;
        TextView txtDesc;
        Permiso pp;

        public PermisoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso= itemView.findViewById(R.id.txtPermiso);
            txtDesc= itemView.findViewById(R.id.txtDesc);
        }

        public void setData(Permiso p) {
            pp = p;
            txtPermiso.setText(pp.getPermiso());
            txtDesc.setText(pp.getDescripcion());
        }
    }
}