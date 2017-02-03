package com.acheache.castillejo.twoapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button bfecha;
    EditText efecha;
    private  int dia,mes,ano;

    private Button btnSiguente;
    private EditText txtNombre,txtFecha,txtTelefono,txtEmail,txtDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bfecha=(Button)findViewById(R.id.btnMiBoton);

        efecha=(EditText)findViewById(R.id.txtFecha);

//        efecha.setOnClickListener(this);


        btnSiguente=(Button)findViewById(R.id.btnMiBoton);
        txtNombre = (EditText) findViewById( R.id.txtNombre );
        txtFecha = (EditText) findViewById( R.id.txtFecha );
        txtTelefono = (EditText) findViewById( R.id.txtTelefono );
        txtEmail = (EditText) findViewById( R.id.txtEmail );
        txtDescripcion = (EditText) findViewById( R.id.txtDescripcion );

//        btnSiguente.setOnClickListener(this);


        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre
            String datoFecha=(String)extras.get("fecha");
            String datoTelefono=(String)extras.get("telefono");
            String datoEmail=(String)extras.get("email");
            String datoDescripcion=(String)extras.get("descripcion");


            txtNombre.setText(datoNombre);
            txtFecha.setText(datoFecha);
            txtTelefono.setText(datoTelefono);
            txtEmail.setText(datoEmail);
           txtDescripcion.setText(datoDescripcion);
        }




    }


    @Override
    public void onClick(View v) {

            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        efecha.setOnClickListener(this);
       // }

    }

    public void Intento(View v){

    }


    public void Click(View v){
//        Intent intent=new Intent(MainActivity.this,EditarDatos.class);
//        startActivity(intent);
        Intent explicit_intent;//Declaro el Intent

        //Instanciamos el Intent dandole:
        // el contexto y la clase a la cual nos deseamos dirigir
        explicit_intent = new Intent(this,EditarDatos.class);
        String auxEdiNombre=txtNombre.getText().toString();
        String auxEdiFecha=txtFecha.getText().toString();
        String auxEdiTelefono=txtTelefono.getText().toString();
        String auxEdiEmail=txtEmail.getText().toString();
        String auxEdiDescripcion=txtDescripcion.getText().toString();

        explicit_intent.putExtra("nombre",auxEdiNombre);//Guardamos una cadena
        explicit_intent.putExtra("fecha",auxEdiFecha);
        explicit_intent.putExtra("telefono",auxEdiTelefono);//Guardamos un entero
        explicit_intent.putExtra("email",auxEdiEmail);
        explicit_intent.putExtra("descripcion",auxEdiDescripcion);

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
        btnSiguente.setOnClickListener(this);

    }



}
