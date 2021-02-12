package com.example.curso3semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Widgets
    DatePickerDialog picker;
    EditText etNombre, etTelefono, etEmail, etDescription;
    TextView tvFecha;
    Button btnSiguiente;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFecha = findViewById(R.id.tvFecha);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescription = findViewById(R.id.etDescripcion);

        bundle = getIntent().getExtras();

        try {

            etNombre.setText(bundle.getString("Name"));
            tvFecha.setText(bundle.getString("Fecha"));
            etTelefono.setText(bundle.getString("Telefono"));
            etEmail.setText(bundle.getString("Email"));
            etDescription.setText(bundle.getString("Descripcion"));

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Exception handled", Toast.LENGTH_SHORT).show();
        }


        tvFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Dialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = etNombre.getText().toString();
                String Telefono = etTelefono.getText().toString();
                String Fecha = tvFecha.getText().toString();
                String Descripcion = etDescription.getText().toString();
                String Email = etEmail.getText().toString();

                Intent i = new Intent (MainActivity.this, ConfirmarDatos.class);
                i.putExtra("Name", Name);
                i.putExtra("Fecha", Fecha);
                i.putExtra("Telefono", Telefono);
                i.putExtra("Email", Email);
                i.putExtra("Descripcion", Descripcion);
                startActivity(i);
            }
        });
    }
}