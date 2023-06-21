package com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.services;

import com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.entities.Laptop;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {


    @Test
    void calculatePriceTest() {

        // Configuración de la prueba
        Laptop laptop = new Laptop(1L, "IBM","ThinkPad T40", "Intel i5 647op",
                32, 1024, 17, 2000, 80, 1395.99,
                "Windows 11 Pro", true, true);
        LaptopPriceCalculator calculator = new LaptopPriceCalculator();

        // Se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(laptop);
        System.out.println(price);

        // Comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(1403.98,price);


    }
}