
package sockettcp;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author TheBigG
 */

public class Servidor {

    static final int PUERTO = 5000;

    public Servidor() {
        // Crear un mapa para asociar letras con provincias
        Map<String, String> provincias = new HashMap<>();
        provincias.put("A", "Azuay");
        provincias.put("B", "Bolívar");
        provincias.put("U", "Cañar");
        provincias.put("X", "Cotopaxi");
        provincias.put("H", "Chimborazo");
        provincias.put("O", "El Oro");
        provincias.put("E", "Esmeraldas");
        provincias.put("Q", "Francisco de Orellana");
        provincias.put("W", "Galápagos");
        provincias.put("G", "Guayas");
        provincias.put("I", "Imbabura");
        provincias.put("L", "Loja");
        provincias.put("R", "Los Ríos");
        provincias.put("M", "Manabí");
        provincias.put("V", "Morona Santiago");
        provincias.put("N", "Napo");
        provincias.put("S", "Pastaza");
        provincias.put("P", "Pichincha");
        provincias.put("Y", "Santa Elena");
        provincias.put("J", "Santo Domingo de los Tsáchilas");
        provincias.put("K", "Sucumbíos");
        provincias.put("T", "Tungurahua");
        provincias.put("Z", "Zamora Chinchipe");

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en el puerto " + PUERTO);

            while (true) {
                // Aceptar una conexión de cliente
                Socket skCliente = servidor.accept();
                System.out.println("Cliente conectado");

                // Recibir la letra desde el cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
                String letra = entrada.readLine().toUpperCase();

                // Buscar la provincia asociada a la letra
                String respuesta = provincias.getOrDefault(letra, "Provincia no encontrada");

                // Enviar la respuesta al cliente
                PrintWriter salida = new PrintWriter(skCliente.getOutputStream(), true);
                salida.println(respuesta);

                // Cerrar la conexión con el cliente
                skCliente.close();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}

