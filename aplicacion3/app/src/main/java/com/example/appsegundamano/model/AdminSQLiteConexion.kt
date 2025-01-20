package com.example.appsegundamano.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class AdminSQLiteConexion(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        //Versión de la bbdd
        const val DATABASE_VERSION: Int = 1

        //Nombre de la base de datos
        const val DATABASE_NAME: String = "bbddappSegundaMano.db"
    }

    constructor(context: Context) : this(context, DATABASE_NAME, null, DATABASE_VERSION){

    }

    /**
     * Función que se ejecuta automáticamente cuando se ejecuta SQLite por primera vez.
     */
    override fun onCreate(db: SQLiteDatabase) {
        Log.e("SQLite", "Paso por onCreate del AdminSQLiteConexion")

        //Creo las tablas
        db.execSQL("CREATE TABLE usuarios(id INTEGER PRIMARY KEY, nombre TEXT, password TEXT, urlImagen TEXT)")
        db.execSQL("CREATE TABLE productos(id INTEGER PRIMARY KEY, nombre text, precio REAL, categoria TEXT, urlImagen TEXT)")

//-----------------------------------------------------------------------------------------------------------------------------------------------------------

        //Creo los usuarios
        db.execSQL("INSERT INTO usuarios (id, nombre, password, urlImagen) VALUES (1, 'Jorge', 'Admin123', 'chico')")
        db.execSQL("INSERT INTO usuarios (id, nombre, password, urlImagen) VALUES (2, 'Santa', 'Admin123', 'chica')")
        db.execSQL("INSERT INTO usuarios (id, nombre, password, urlImagen) VALUES (3, 'Mateo', 'Admin123', 'chico')")
        db.execSQL("INSERT INTO usuarios (id, nombre, password, urlImagen) VALUES (4, 'Jota', 'Admin123', 'chico')")
        db.execSQL("INSERT INTO usuarios (id, nombre, password, urlImagen) VALUES (5, 'Silvia', 'Admin123', 'chica')")

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
        //Creo los productos por categoria

        //CATEGORIA TECNOLOGIA
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (1, 'TempesRGB', 1500.00, 'Tecnologia', 'torre1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (2, 'ForegeonARGB', 1200.67, 'Tecnologia', 'torre2')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (3, 'Monitor200Hz', 170.00, 'Tecnologia', 'monitor1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (4, 'Monitor180Hz', 170.00, 'Tecnologia', 'monitor2')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (5, 'PortatilEstudio', 400.00, 'Tecnologia', 'portatil1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (6, 'PortatilGaming', 1000.00, 'Tecnologia', 'portatil2')")

        //CATEGORIA MODA
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (7, 'SudaderaAzul', 23.55, 'Moda', 'sudadera1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (8, 'SudaderaRosa', 45.99, 'Moda', 'sudadera2')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (9, 'PantalonMarron', 67.56, 'Moda', 'pantalon3')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (10, 'JerseyVeige', 89.00, 'Moda', 'jersey3')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (11, 'JerseyVerde', 70.00, 'Moda', 'jersey1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (12, 'JerseyMarron', 40.00, 'Moda', 'jersey2')")

        //CATEGORIA DEPORTES
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (13, 'PantalonChandalVerde', 44.99, 'Deporte', 'pantalon1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (14, 'PantalonChandalNegro', 47.99, 'Deporte', 'pantalon2')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (15, 'ZapatillasRunning', 135.00, 'Deporte', 'zapatillas1')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (16, 'ZapatillasLiveStile', 69.99, 'Deporte', 'zapatillas2')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (17, 'ZapatillasNike', 69.99, 'Deporte', 'zapatillas3')")
        db.execSQL("INSERT INTO productos (id, nombre, precio, categoria, urlImagen) VALUES (18, 'CamisetaRunning', 69.99, 'Deporte', 'camiseta1')")

    }

    /**
     * Si la bbdd existe entra a este método. Como ya existe la bbdd no queremos que haga cambios por eso no tiene nada el método
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        //Imprimimos un mensaje en el log
        Log.e("SQLite", "Paso por onUpgrade del AdminSQLiteConexion")

    }

}
