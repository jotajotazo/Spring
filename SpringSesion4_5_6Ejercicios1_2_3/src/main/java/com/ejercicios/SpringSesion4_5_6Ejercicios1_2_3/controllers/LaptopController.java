package com.ejercicios.SpringSesion4_5_6Ejercicios1_2_3.controllers;

import com.ejercicios.SpringSesion4_5_6Ejercicios1_2_3.entities.Laptop;
import com.ejercicios.SpringSesion4_5_6Ejercicios1_2_3.repositories.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    // Atributos:
    private LaptopRepository laptopRepository;

    // Constructores:
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // Ejercicio 2. Crear método que devuelva una lista de objetos Laptop:
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();
    }

    /*
        Ejercicio 3:
        Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y
        persistirlo en la base de datos.
        Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.
     */
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // guardar el libro recibido por parámetro en la base de datos
        return laptopRepository.save(laptop);
    }



}
