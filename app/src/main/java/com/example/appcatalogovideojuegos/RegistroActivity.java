package com.example.appcatalogovideojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    //Declaraciones de objetos
    private EditText et_email,et_contraseña,et_contraseña2,et_nombres,et_apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Conexión de los objetos con los componentes de la parte gráfica
        et_email=(EditText) findViewById(R.id.et_R_Email);
        et_contraseña=(EditText) findViewById(R.id.et_R_Contraseña);
        et_contraseña2=(EditText) findViewById(R.id.et_R_Contraseña2);
        et_nombres=(EditText) findViewById(R.id.et_R_Nombres);
        et_apellidos=(EditText) findViewById(R.id.et_R_Apellidos);

    }
    public void IrAAtras(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void IrAHome(View view){
        Intent i= new Intent(this,HomeActivity.class);
        startActivity(i);
    }

    //Metodo para registrar un usuario
    public void Registrar(View view)
    {
        SQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();
        String contraseña = et_contraseña.getText().toString();
        String contraseña2 = et_contraseña2.getText().toString();
        String nombres = et_nombres.getText().toString();
        String apellidos = et_apellidos.getText().toString();


        if(!email.isEmpty()&&!contraseña.isEmpty()&&!contraseña2.isEmpty()&&!nombres.isEmpty()&&!apellidos.isEmpty())
        {
            if (contraseña.equals(contraseña2)) {
                //Creamos un nuevo registro
                ContentValues registro = new ContentValues();
                registro.put ("email_usuario",email);
                registro.put ("contraseña_usuario",contraseña);
                registro.put ("nombres_usuario",nombres);
                registro.put ("apellidos_usuario",apellidos);

                //Insertar el registro en la tabla
                BaseDeDatos.insert("Usuarios",null,registro);
                BaseDeDatos.close();
                et_email.setText("");
                et_contraseña.setText("");
                et_contraseña2.setText("");
                et_nombres.setText("");
                et_apellidos.setText("");
                Toast.makeText(this,"Usuario Registrado, pruebe devolverse e Iniciar sesión",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Las contraseñas deben coincidir",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Los campos con \"*\" son obligatorios",Toast.LENGTH_LONG).show();
        }
    }

}