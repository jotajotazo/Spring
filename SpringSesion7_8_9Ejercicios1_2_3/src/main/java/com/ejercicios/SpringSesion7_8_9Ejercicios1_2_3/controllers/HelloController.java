package com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Ejercicio 1: Crear un proyecto Spring Boot con las dependencias:

    * H2.
    * Spring Data JPA.
    * Spring Web.
    * Spring Boot Dev tools.

    Crear una clase HelloController que sea un controlador REST. Dentro de la clase crear un método que retorne un saludo.

    Probar que retorna el saludo desde el navegador y desde Postman.
 */

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String saludoREST(){

        return "¡Saludos desde el ejercicio 1 de las sesiones 7,8 y 9!";
    }


}
