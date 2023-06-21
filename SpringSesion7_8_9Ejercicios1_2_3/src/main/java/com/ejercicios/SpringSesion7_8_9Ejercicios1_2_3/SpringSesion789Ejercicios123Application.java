package com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3;

import com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.entities.Laptop;
import com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class SpringSesion789Ejercicios123Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringSesion789Ejercicios123Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// Los objetos Laptop se pueden insertar desde el método main de la clase principal:

		// Crear laptops:
		Laptop laptop1 = new Laptop(null, "Asus","Vivobook S 14 Flip", "AMD Ryzen5 7530U",
				16, 512, 14, 2000, 50, 1099.99,
				"Windows 11 Pro", true, true);
		Laptop laptop2 = new Laptop(null, "Dell", "Latitude 5430", "INTEL i7-1255U",
				16, 512, 14, 1920, 58, 1282.61,
				"Windows 10 Pro", true, true);

		System.out.println("Número previo de laptops en base de datos: " + repository.findAll().size());

		// Almacenar los laptops:
		repository.save(laptop1);
		repository.save(laptop2);

		// Recuperar todos los laptops:
		System.out.println("Número actual de laptops en base de datos:: " + repository.findAll().size());

	}

}
