package com.example.appsegundamano.model

import android.app.Activity
import android.database.sqlite.SQLiteDatabase

object ProductoConexionHelper {

    /**
     * Te devuelve todos los productos de la bbdd
     */
    fun obtenerProductos(contexto: Activity):ArrayList<Producto> {

        //ArrayList para meter los productos de la bbdd
        var productos:ArrayList<Producto> = ArrayList(1)

        //Abres la conexion en la bbdd
        val admin = AdminSQLiteConexion(contexto)

        //Permisos de solo lectura
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultSet
        val fila = bd.rawQuery("SELECT id,nombre,precio,categoria,urlImagen FROM productos", null)

        while (fila.moveToNext()) { //Si fila (ResultSet) tiene mas contenido del leido
            //Creo un producto
            var p: Producto = Producto( fila.getInt(0), fila.getString(1), fila.getDouble(2), fila.getString(3), fila.getString(4) )
            //Lo guardo en la lista
            productos.add(p)
        }

        //Cierro la conexion
        bd.close()

        //Devuelvo la lista de usuarios
        return productos
    }


    /**
     * Te muestra todos los productos que hay en una categoria concreta que le pases por parametro
     */
    fun obtenerProductosPorCategoria(contexto: Activity, categoria:String):ArrayList<Producto>{
        //ArrayList para meter los productos obtenidos
        var productos:ArrayList<Producto> = ArrayList(1)

        //Abres la conexion en la bbdd
        val conexion = AdminSQLiteConexion(contexto)

        //Permisos de solo lectura
        val bd: SQLiteDatabase = conexion.readableDatabase

        //Devielve un resultSet
        val fila = bd.rawQuery("SELECT id,nombre,precio,categoria,urlImagen FROM productos WHERE categoria = ?", arrayOf(categoria))


        while (fila.moveToNext()) { //Cada vez que haya registros...
            //Creo un producto con los datos del producto extraido de la bbddd
            var p: Producto = Producto ( fila.getInt(0), fila.getString(1), fila.getDouble(2), fila.getString(3), fila.getString(4) )

            //Lo añado a la lista
            productos.add(p)
        }
        return productos
    }

}
























