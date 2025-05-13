package com.tasasdecambio;

import java.util.Scanner;

public class MenuPrograma {
    private final Scanner scanner;  // Deja que el Scanner sea pasado como parámetro
    private final CalculosMonedas calculosMonetizados;

    // Constructor que recibe una instancia de CalculosMonedas y un Scanner
    public MenuPrograma(CalculosMonedas calculosMonetizados, Scanner scanner) {
        this.calculosMonetizados = calculosMonetizados;
        this.scanner = scanner;  // Ahora el Scanner es pasado como parametro
    }

    // Metodo que muestra el menu y maneja la eleccion digitada por el usuario
    public void mostrarMenu() {
        int opcion = 0;

        // Muestra el menu (opciones presentadas al usuario)
        do {
            // Muestra el menú y las opciones disponibles
            System.out.println("\n****************************\n");
            System.out.println("Bienvenido al Conversor de Monedas\n");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");

            // Lee la opción ingresada por el usuario
            System.out.print("Elija una opción válida: ");
            String input = scanner.nextLine();  // Lee la entrada de datos realizada por el usuario

            try {
                opcion = Integer.parseInt(input);  // Intenta convertir la entrada a un número
            } catch (NumberFormatException e) {
                // Si no es un número válido, muestra un mensaje y continua con el ciclo
                System.out.println("Por favor, ingrese un número válido.");
                continue;  // Retorna al principio del ciclo para que el usuario ingrese nuevamente una opcion del menu
            }

            // Según la opción seleccionada, se ejecuta el proceso de conversion de monedas
            switch (opcion) {
                case 1:
                    // Conversion de Dólar => a Peso argentino
                    calculosMonetizados.realizarConversion("USD", "ARS", scanner);
                    break;
                case 2:
                    // Conversion de Peso argentino => a Dólar
                    calculosMonetizados.realizarConversion("ARS", "USD", scanner);
                    break;
                case 3:
                    // Conversion de Dólar => a Real brasileño
                    calculosMonetizados.realizarConversion("USD", "BRL", scanner);
                    break;
                case 4:
                    // Conversion de Real brasileño => a Dólar
                    calculosMonetizados.realizarConversion("BRL", "USD", scanner);
                    break;
                case 5:
                    // Conversion de Dólar => a Peso colombiano
                    calculosMonetizados.realizarConversion("USD", "COP", scanner);
                    break;
                case 6:
                    // Conversion de Peso colombiano => a Dólar
                    calculosMonetizados.realizarConversion("COP", "USD", scanner);
                    break;
                case 7:
                    System.out.println("¡Hasta pronto! El programa ha finalizado y se cerrará.");
                    return;  // Termina la ejecución del programa
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                    break; // Envia un mensaje al usuario si digita algo que no esta en el menu
            }

            // Espera que el usuario presione Enter para continuar
            System.out.println("\nPresiona Enter para continuar...");
            scanner.nextLine();  // Este `nextLine()` asegura de que el programa espera hasta que el usuario presione Enter

        } while (opcion != 7);  // El programa sigue ejecutándose hasta que el usuario elija la opción 7
    }
}
