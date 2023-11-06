package com.example.practica_8.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_8.R;
import com.example.practica_8.model.Permiso;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.PermisoViewHolder>{


    List<Permiso> Lista_permisos;
    Context context;

    public PermisoAdapter(List<Permiso> lista_permisos, Context context) {
        Lista_permisos = lista_permisos;
        this.context = context;
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
        Switch swPermiso;
        Permiso pp;

        public PermisoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso= itemView.findViewById(R.id.txtPermiso);
            txtDesc= itemView.findViewById(R.id.txtDesc);
            swPermiso= itemView.findViewById(R.id.switch1);

            swPermiso.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    if (ContextCompat.checkSelfPermission(context, pp.getPermisos()) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{pp.getPermisos()}, 204);
                    }
                } else {
                    pp.setEstado(false);
                }
            });
        }

        public void setData(Permiso p) {
            pp = p;
            txtPermiso.setText(pp.getPermiso());
            txtDesc.setText(pp.getDescripcion());
            swPermiso.setChecked(pp.isEstado());
        }
    }
}
