package com.example.cynthia.mitareaactividades2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TareaMostrarDatos extends AppCompatActivity {


    private TextView lblNombre,lblDescripcion,lblTelefono,lblFecha,lblEmail;
    String nombre, telefono, fecha, email, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_mostrar_datos);

        Bundle parametros = getIntent().getExtras();

        nombre   =  parametros.getString("nombre");

        telefono = parametros.getString("telefono");
        fecha  =  parametros.getString("fecha");
        email    =  parametros.getString("email");
        descripcion = parametros.getString("descripcion");

        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblNombre.setText(nombre);

        lblTelefono = (TextView) findViewById(R.id.lblTelefono);
        lblTelefono.setText(telefono);

        lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        lblDescripcion.setText(descripcion);

        lblEmail = (TextView) findViewById(R.id.lblMail);
        lblEmail.setText(email);

        lblFecha = (TextView) findViewById(R.id.lblFechaNac);
        lblFecha.setText(fecha);


    }

    protected void EditarDatos (View v) {
        Intent intent = new Intent(TareaMostrarDatos.this,MainActivity.class);

        intent.putExtra("nombre",nombre);
        intent.putExtra("telefono",telefono);
        intent.putExtra("descripcion",descripcion);
        intent.putExtra("email",email);
        intent.putExtra("fecha",fecha);

        startActivity(intent);
        finish();
    }

}
