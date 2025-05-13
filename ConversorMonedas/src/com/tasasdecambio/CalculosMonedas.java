// la clase CalculosMoneda, pertenece al paquete com.tasasdecambio
package com.tasasdecambio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculosMonedas {
    private final ConsultaConversion consulta;
    private double cantidad;

    // Constructor recibe la instancia de ConsultaConversion.
    public CalculosMonedas(ConsultaConversion consulta) {
        this.consulta = consulta;
    }

    // Metodo para realizar la conversión de una moneda a otra
    public void realizarConversion(String monedaBase, String monedaObjetivo, Scanner scanner) {
        // Solicita el valor que el usuario desea convertir a otra moneda
        System.out.print("Ingresa el valor que deseas convertir: ");

        // Maneja posibles excepciones (usuario debera ingresar el valor que desea convertir en formato numerico)
        try {
            this.cantidad = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingresa un valor numérico.");
            scanner.nextLine(); // Limpia el buffer (Borra la memoria y queda listo para el nuevo dato)
            return; // Sale del metodo si la entrada es incorrecta
        }

        // Se obtiene la tasa de conversión
        double tasa = consulta.obtenerTasaDeConversion(monedaBase, monedaObjetivo);

        // Comprueba si la tasa es válida y realiza la conversion de moneda
        if (tasa != 0) {
            double resultado = cantidad * tasa;

            // Imprime el resultado (valor sin redondear)
            System.out.println("El valor de " + cantidad + " [" + monedaBase + "] corresponde a " + resultado + " [" + monedaObjetivo + "]");
        } else {
            System.out.println("Hubo un error al obtener la tasa de conversión.");
        }
    }
}
