package com.example.appsegundamano

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity

object ProductoConexionHelper {

    /**
     * Añado un producto a la bbdd
     */
    fun addProducto(contexto: AppCompatActivity, p:Producto):Long{

        //Creo una instancia para poder conectarme a la bbdd
        val admin = AdminSQLIteConexion(contexto)

        //Permito modificar la bbdd
        val bd: SQLiteDatabase = admin.writableDatabase

        val registro = ContentValues()
        registro.put("id", p.id) //Añado el id del producto nuevo
        registro.put("nombre", p.nombre) //Añado el nombre del producto nuevo
        registro.put("precio", p.precio) //Añado el precio del producto nuevo
        registro.put("urlImagen", p.urlImagen) //Añado la url del producto nuevo

        //Inserto en la bbdd
        //.insert devuelve el id de la fila insertada
        val idFilaInsertada = bd.insert("productos", null, registro)

        //Cierro la conexion
        bd.close()

        //Devuelvo el id de la fila insertada o -1 en caso de error
        return idFilaInsertada

    }


    /**
     * Borramos un producto de la bbdd
     */
    fun borrarProducto(contexto: AppCompatActivity, id:Int):Int{

        //Creo una instancia para poder conectarme a la bbdd
        val admin = AdminSQLIteConexion(contexto)

        //Permito modificar la bbdd
        val bd: SQLiteDatabase = admin.writableDatabase

        //Borro un producto cuyo id es el pasado por parametro
        //Devuelve el numero de filas afectadas
        val cantFilasAfectadas = bd.delete("productos", "id=?", arrayOf(id.toString()))

        //Cierro la conexion
        bd.close()

        //Devuelvo el numero de filas afectadas
        return cantFilasAfectadas
    }


    /**
     * Modificas un usuario de la bbdd
     */
    fun modificarProducto(contexto: AppCompatActivity, id:Int, p:Producto):Int{

        //Creo la instancia a la bbdd
        val admin = AdminSQLIteConexion(contexto)

        //Permito modificar la bbdd
        val bd: SQLiteDatabase = admin.writableDatabase

        val registro = ContentValues()
        registro.put("id", p.id)
        registro.put("nombre", p.nombre)
        registro.put("precio", p.precio)
        registro.put("urlImagen", p.urlImagen)

        //Actualizo los datos en la bbdd
        //Devuelve el numero de filas afectadas
        val numeroFilasAfectadas = bd.update("productos", registro, "id=?", arrayOf(id.toString()))

        //Cierro la conexion
        bd.close()

        //Devuelvo el numero de filas afectadas
        return numeroFilasAfectadas
    }


    /**
     * Buscar el producto que tenga el id pasado por parametro
     */
    fun buscarProducto(contexto: AppCompatActivity, id:Int):Producto? {

        //Creo un objeto producto
        var p:Producto? = null

        //Creo la instancia
        val admin = AdminSQLIteConexion(contexto)

        //Permito que solo pueda leer
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultset con los usuarios recogidos de la bbdd
        val fila =bd.rawQuery(
            "SELECT id, nombre, precio, urlImagen FROM productos WHERE id=?",
            arrayOf(id.toString())
        )

        //Si hay datos .moveToFirst devuelve true, si no false
        if (fila.moveToFirst()) {
            //Creo un objeto usuario dandole los valores de un usuario recogido
            p = Producto( fila.getInt(0), fila.getString(1), fila.getDouble(2), fila.getString(3) );
        }
        bd.close()
        return p
    }


    /**
     * Te devuelve todos los productos de la bbdd
     */
    fun obtenerProductos(contexto: AppCompatActivity):ArrayList<Producto> {

        //ArrayList para meter los usuarios de la bbdd
        var productos:ArrayList<Producto> = ArrayList(1)

        //Abres la conexion en la bbdd
        val admin = AdminSQLIteConexion(contexto)

        //Permisos de solo lectura
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultSet
        val fila = bd.rawQuery("select id,nombre,precio,urlImagen from productos", null)

        while (fila.moveToNext()) { //Si fila (ResultSet) tiene mas contenido del leido
            //Creo un producto
            var p:Producto = Producto( fila.getInt(0), fila.getString(1), fila.getDouble(2), fila.getString(3) )
            //Lo guardo en la lista
            productos.add(p)
        }

        //Cierro la conexion
        bd.close()

        //Devuelvo la lista de usuarios
        return productos
    }
}
























