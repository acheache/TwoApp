package com.acheache.castillejo.twoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditarDatos extends AppCompatActivity {

    TextView Nombre,Fecha,Telefono,Email,Descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);

        Nombre = (TextView) findViewById( R.id.tvNombre );
        Fecha = (TextView) findViewById( R.id.tvFecha_Nacimiento );
        Telefono = (TextView) findViewById( R.id.tvTelefono );
        Email = (TextView) findViewById( R.id.tvEmail);
        Descripcion = (TextView) findViewById( R.id.tvDescripcion );








        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre
            String datoFecha=(String)extras.get("fecha");
            String datoTelefono=(String)extras.get("telefono");
            String datoEmail=(String)extras.get("email");
            String datoDescripcion=(String)extras.get("descripcion");


            Nombre.setText(datoNombre);
            Fecha.setText(datoFecha);
            Telefono.setText(datoTelefono);
            Email.setText(datoEmail);
            Descripcion.setText(datoDescripcion);
        }
    }


    public void hhClick(View v){

        Intent intent=new Intent(EditarDatos.this,MainActivity.class);

        String auxEdiNombre=Nombre.getText().toString();
        String auxEdiFecha=Fecha.getText().toString();
        String auxEdiTelefono=Telefono.getText().toString();
        String auxEdiEmail=Email.getText().toString();
        String auxEdiDescripcion=Descripcion.getText().toString();

       intent.putExtra("nombre",auxEdiNombre);//Guardamos una cadena
        intent.putExtra("fecha",auxEdiFecha);
       intent.putExtra("telefono",auxEdiTelefono);//Guardamos un entero
      intent.putExtra("email",auxEdiEmail);
       intent.putExtra("descripcion",auxEdiDescripcion);


        startActivity(intent);
        finish();
    }
}
