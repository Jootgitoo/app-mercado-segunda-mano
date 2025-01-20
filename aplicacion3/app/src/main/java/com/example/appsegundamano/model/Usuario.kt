package com.example.appsegundamano.model


/**
 * Id --> Id del usuario
 * Nombre --> Nombre del usuario
 * Password --> Contraseña del usuario para que pueda acceder a la bbdd
 * UrlImagen --> Imagen del usuario --> Chico cuando el usuario es chico y se le pone una imagen de un chico y si es chica se pone una imagen de una chica
 */
data class Usuario(val id:Int, val nombre:String, val password:String, val urlImagen:String)
