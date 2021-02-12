package com.example.curso3semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvName, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    Button btnEditarDatos;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        bundle = getIntent().getExtras();

        tvName = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        tvName.setText(bundle.getString("Name"));
        tvFecha.setText(bundle.getString("Fecha"));
        tvTelefono.setText(bundle.getString("Telefono"));
        tvEmail.setText(bundle.getString("Email"));
        tvDescripcion.setText(bundle.getString("Descripcion"));

        btnEditarDatos = findViewById(R.id.btnEditarDatos);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = tvName.getText().toString();
                String Telefono = tvTelefono.getText().toString();
                String Fecha = tvFecha.getText().toString();
                String Descripcion = tvDescripcion.getText().toString();
                String Email = tvEmail.getText().toString();

                Intent x = new Intent(ConfirmarDatos.this, MainActivity.class);
                x.putExtra("Name", Name);
                x.putExtra("Fecha", Fecha);
                x.putExtra("Telefono", Telefono);
                x.putExtra("Email", Email);
                x.putExtra("Descripcion", Descripcion);
                startActivity(x);
            }
        });
    }
}