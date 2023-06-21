package com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.controllers;

import com.ejercicios.SpringSesion7_8_9Ejercicios1_2_3.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
    Ejercicio 3:
    Crear casos de test para el controlador de Laptop desde Spring Boot. Con clic derecho dentro del código de la
    clase LaptopController utilizar la opción Generate > Test para generar la clase con todos los tests unitarios
    e implementarlos según el proceso visto en clase.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar 'buscar todos los laptops' desde controladores Spring REST")
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());

    }

    @DisplayName("Testar la búsqueda de un laptop por su 'id' desde controladores Spring REST")
    @Test
    void findOneById() {

        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "brand": "Laptop creado desde Spring Test",
                        "model": "Vivobook S 14 Flip",
                        "processor": "AMD Ryzen5 7530U",
                        "ram": 16,
                        "hardDrive": 512,
                        "screenSize": 14,
                        "screenResolution": 2000,
                        "batteryCapacity": 50,
                        "price": 1099.99,
                        "operatingSystem": "Windows 11 Pro",
                        "wifi": true,
                        "bluetooth": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Laptop creado desde Spring Test", result.getBrand());

    }

    @Test
    void update() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "id": 1,
                        "brand": "Laptop creado desde Spring Test",
                        "model": "Modelo actualizado desde Spring Test",
                        "processor": "AMD Ryzen5 7530U",
                        "ram": 16,
                        "hardDrive": 512,
                        "screenSize": 14,
                        "screenResolution": 2000,
                        "batteryCapacity": 50,
                        "price": 1099.99,
                        "operatingSystem": "Windows 11 Pro",
                        "wifi": true,
                        "bluetooth": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/{id}", HttpMethod.PUT, request, Laptop.class, 1);

        Laptop result = response.getBody();

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Modelo actualizado desde Spring Test", result.getModel());

    }

    @Test
    void delete() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Void> response = testRestTemplate.exchange("/api/laptops/1", HttpMethod.DELETE, request, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

    @Test
    void deleteAll() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Void> response = testRestTemplate.exchange("/api/laptops", HttpMethod.DELETE, request, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

}