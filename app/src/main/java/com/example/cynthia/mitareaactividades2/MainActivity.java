package com.example.cynthia.mitareaactividades2;


import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView fechaDisplay;
    private Button pickDate;
    private int year, mes, dia;
    static final int DATE_DIALOG_ID = 0;
    private EditText nombre;
    private EditText telefono;
    private EditText email;
    private EditText descripcion;
    private EditText fechaNac;
    private Button btnSiguiente;
    private SimpleDateFormat formatFecha;
    private Calendar calendar;

    private DatePickerDialog pickerFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        nombre = (EditText) findViewById(R.id.inNombre);
        telefono = (EditText) findViewById(R.id.inTelefono);
        email = (EditText) findViewById(R.id.inEmail);
        descripcion = (EditText) findViewById(R.id.inDescripcion);
        fechaNac = (EditText) findViewById(R.id.displayFecha);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, mes+1, dia);

        Bundle parametros = getIntent().getExtras();
        if (parametros!=null) {
            nombre.setText(parametros.getString("nombre"));
            telefono.setText(parametros.getString("telefono"));
            email.setText(parametros.getString("email"));
            descripcion.setText(parametros.getString("descripcion"));
            fechaNac.setText(parametros.getString("fecha"));

        }

    }

    public void elegirFecha(View view) {
        showDialog(999);

        //  OnDateSetListener mDateSetListener = null;
        //updateDisplay();
        // DatePickerDialog d = new DatePickerDialog(this, mDateSetListener,2016,9,20);
        // d.show();

        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }


    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, mes, dia);
        }
        return null;
    }


    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker arg0, int year, int mes, int dia) {
            showDate(year, mes+1, dia);
        }
    };

    private void showDate(int year, int month, int day) {
        fechaNac.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    public void pasarMostrarDatos(View v)  {

        Intent intent = new Intent(MainActivity.this,TareaMostrarDatos.class);

        intent.putExtra ("nombre",nombre.getText().toString());
        intent.putExtra ("descripcion",descripcion.getText().toString());
        intent.putExtra ("telefono",telefono.getText().toString());
        intent.putExtra ("email",email.getText().toString());
        intent.putExtra ("fecha",fechaNac.getText().toString());

        startActivity(intent);
        finish();
    }


}

