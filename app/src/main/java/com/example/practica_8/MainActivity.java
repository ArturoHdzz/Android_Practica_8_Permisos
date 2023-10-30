package com.example.practica_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.practica_8.adapter.PermisoAdapter;
import com.example.practica_8.model.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Permiso> Lista_permisos = new ArrayList<>();
        Lista_permisos.add(new Permiso("Camara", "Permite el acceso a la camara"));
        Lista_permisos.add(new Permiso("Ubicación", "Permite el acceso a la ubicación"));
        Lista_permisos.add(new Permiso("Llamar", "Permite el acceso a la llamada"));

        PermisoAdapter pa = new PermisoAdapter(Lista_permisos);
        RecyclerView rc = findViewById(R.id.rcPermisos);
        rc.setAdapter(pa);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setHasFixedSize(true);

    }
}