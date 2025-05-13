import com.tasasdecambio.CalculosMonedas;
import com.tasasdecambio.ConsultaConversion;
import com.tasasdecambio.MenuPrograma;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crea una instancia del Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Crea una instancia de ConsultaConversion (para hacer las solicitudes a la API)
        ConsultaConversion consultaConversion = new ConsultaConversion();

        // Crea una instancia de CalculosMoneda, pasando consultaConversion como parametro
        CalculosMonedas calculosMoneda = new CalculosMonedas(consultaConversion);

        // Crea una instancia de MenuPrograma, pasando calculosMoneda y scanner como parametros
        MenuPrograma menuPrograma = new MenuPrograma(calculosMoneda, scanner);

        // Llama al metodo mostrarMenu() para iniciar el programa
        menuPrograma.mostrarMenu();
    }
}
