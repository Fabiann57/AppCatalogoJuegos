package com.example.appcatalogovideojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void IrARegistro(View view)
    {
        Intent i=new Intent(this,RegistroActivity.class);
        startActivity(i);
    }
    public void IrAPerfil(View view)
    {
        Intent i=new Intent(this,ActivityPerfil.class);
        startActivity(i);
    }
    public void IrAPacman(View view)
    {
        Intent i=new Intent(this,VisualizarJv.class);
        startActivity(i);
    }
}