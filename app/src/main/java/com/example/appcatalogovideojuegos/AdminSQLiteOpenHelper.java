package com.example.appcatalogovideojuegos;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //metodoque permite validar si el usuario existe
    //Throws SQLException es un Control de errores
    public Cursor ConsultarUsuPas(String user,String password) throws SQLException {
        Cursor unregistro=null;
        unregistro=this.getReadableDatabase().query("Usuarios",new String[]{"Email","Contraseña","Nombres","Apellidos"},"email_usuario like '"+user+"' and contraseña_usuario like'"+password+"'",null,null,null,null);
        return unregistro;
    }
    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table Usuarios(id_Usuario int primary key,email_usuario text,contraseña_usuario text,nombres_usuario text,apellidos_usuario text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
