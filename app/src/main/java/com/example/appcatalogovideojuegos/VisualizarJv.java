package com.example.appcatalogovideojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VisualizarJv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_jv);
    }
    public void IrAHome2(View view){
        Intent i= new Intent(this,HomeActivity.class);
        startActivity(i);
    }
    public void IrAPerfil(View view)
    {
        Intent i=new Intent(this,ActivityPerfil.class);
        startActivity(i);
    }
}