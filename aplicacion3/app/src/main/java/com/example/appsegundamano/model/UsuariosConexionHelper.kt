package com.example.appsegundamano.model

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity

object UsuariosConexionHelper {

    /**
     * Buscar el usuario que tenga el id pasado por parametro
     */
    fun buscarUsuario(contexto: AppCompatActivity, nombre:String):Usuario? {

        //Creo un objeto usuario
        var u:Usuario? = null

        //Creo la instancia
        val admin = AdminSQLiteConexion(contexto)

        //Permito que solo pueda leer
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultset con los usuarios recogidos de la bbdd
        val fila =bd.rawQuery(
            "SELECT id,nombre,password,urlImagen FROM usuarios WHERE nombre=?",
            arrayOf(nombre)
        )

        //Si hay datos .moveToFirst devuelve true, si no false
        if (fila.moveToFirst()) {
            //Creo un objeto usuario dandole los valores de un usuario recogido
            u = Usuario( fila.getInt(0), fila.getString(1), fila.getString(2), fila.getString(3) );
        }
        bd.close()
        return u
    }


    /**
     * Te devuelve todos los usuarios de la bbdd
     */
    fun obtenerUsuarios(contexto: AppCompatActivity):ArrayList<Usuario>{

        //ArrayList para meter los usuarios de la bbdd
        var usuarios:ArrayList<Usuario> = ArrayList(1)

        //Abres la conexion en la bbdd
        val admin = AdminSQLiteConexion(contexto)

        //Permisos de solo lectura
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultSet
        val fila = bd.rawQuery("select id,nombre,password,urlImagen from usuarios", null)

        while (fila.moveToNext()) { //Si fila (ResultSet) tiene mas contenido del leido
            //Creo un usuario
            var u: Usuario = Usuario( fila.getInt(0), fila.getString(1), fila.getString(2), fila.getString(3) )
            //Lo guardo en la lista
            usuarios.add(u)
        }
        //Cierro la conexion
        bd.close()
        //Devuelvo la lista de usuarios
        return usuarios
    }

}