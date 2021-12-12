package com.example.appcatalogovideojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityPerfil extends AppCompatActivity {

    //Declarar las variables
    private TextView ed_Correo,ed_Nombres,ed_Apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //Se Recibe y se muestra Correo
        ed_Correo=(TextView) findViewById(R.id.txt_P_Correo);
        String Correo=getIntent().getStringExtra("Correo");
        ed_Correo.setText(Correo);

        //Se Recibe y se muestra Nombres
        ed_Nombres=(TextView) findViewById(R.id.txt_P_Nombres);
        String Nombres=getIntent().getStringExtra("Nombres");
        ed_Nombres.setText(Nombres);

        //Se recibe y se muestra Apellidos
        ed_Apellidos=(TextView) findViewById(R.id.txt_P_Apellidos);
        String Apellidos=getIntent().getStringExtra("Apellidos");
        ed_Apellidos.setText(Apellidos);
        
    }
    public void IrARegistro (View view) {
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
}