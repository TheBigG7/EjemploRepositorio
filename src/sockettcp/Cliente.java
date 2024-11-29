package sockettcp;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author TheBigG
 */


public class Cliente {

    static final String HOST = "localhost";
    static final int PUERTO = 5000;

    public Cliente() {
        try {
            // Conectar al servidor
            Socket skCliente = new Socket(HOST, PUERTO);

            // Crear flujo de salida para enviar la letra al servidor
            PrintWriter salida = new PrintWriter(skCliente.getOutputStream(), true);

            // Pedir la letra al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese una letra para identificar la provincia: ");
            String letra = scanner.nextLine();

            // Enviar la letra al servidor
            salida.println(letra);

            // Crear flujo de entrada para recibir la respuesta del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            String respuesta = entrada.readLine();

            // Mostrar la respuesta del servidor
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar la conexión
            skCliente.close();
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}

