package com.example.appcatalogovideojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaraciones de objetos
    private EditText et_email, et_contrasena;
    //Button btn_Ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Conexión de los objetos con los componentes de la parte gráfica
        et_email=(EditText) findViewById(R.id.et_M_Email);
        et_contrasena =(EditText) findViewById(R.id.et_M_Contraseña);
        //btn_Ingresar = (Button) findViewById(R.id.btn_1);
        //btn_Ingresar.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
            //}
        //});
    }

    public void Siguiente(View view) {
        Intent siguiente = new Intent(this, RegistroActivity.class);
        startActivity(siguiente);
    }

    //Metodo para consultar un Usuario
    public void Buscar(View view)
    {
        //Se abre la base de datos en modo lectura y escritura
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

        String email = et_email.getText().toString();
        String contrasena = et_contrasena.getText().toString();
        try {
            Cursor cursor = admin.ConsultarUsuPas(email, contrasena);
            if (cursor.getCount() > 0) {
                Intent i = new Intent(getApplicationContext(), VisualizarJv.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña incorrectos", Toast.LENGTH_LONG).show();
                et_email.setText("");
                et_contrasena.setText("");
                et_email.findFocus();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}