package com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.repositories;

import com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
