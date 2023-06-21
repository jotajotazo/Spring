package com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.services;

import com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){
        double price = laptop.getPrice();

        if(laptop.getHardDrive() > 400){
            price += 5;
        }
        // envio
        price += 2.99;
        return price;
    }
}
