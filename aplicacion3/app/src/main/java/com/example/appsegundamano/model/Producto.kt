package com.example.appsegundamano.model

/**
 * Clase producto
 *  id --> Id del producto
 *  Nombre --> Nombre del producto
 *  Precio --> Precio del producto
 *  Categoria --> Categoria del producto
 *  UrlImagen --> Imagen del producto
 */
data class Producto(var id:Int, var nombre:String, var precio:Double, var categoria:String, var urlImagen:String)
