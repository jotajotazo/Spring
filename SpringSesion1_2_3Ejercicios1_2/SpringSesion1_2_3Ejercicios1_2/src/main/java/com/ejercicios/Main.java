package com.ejercicios;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        /*
            Ejercicio 1
            1. Crear proyecto maven con la dependencia spring-context y crear una clase Saludo con un método
               imprimirSaludo que imprima un texto por consola.
            2. Crear el archivo beans.xml con un bean para la clase Saludo.
            3. Obtener el bean desde el método main y ejecutar el método imprimirSaludo.
         */

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Saludo saludo = (Saludo) context.getBean("saludoBean");

        String saludando = saludo.imprimirSaludo1();
        System.out.println(saludando);

        /*
            Ejercicio 2
            1. Crear la clase NotificationService, con un método que imprima un saludo.
            2. Crear una clase UserService que tenga un atributo de clase NotificationService.
            3. Utilizar la anotación @Component en cada clase.
            4. Habilitar el escaneo de clases en el archivo beans.xml
            5. Desde el método main, probar a obtener el bean UserService y ejecutar el método imprimirSaludo
               que tiene asociado el atributo de tipo NotificationService. De forma similar a la realizada en clase.
         */

        ApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context2.getBean("userService");
        userService.imprimirSaludo2();

    }
}