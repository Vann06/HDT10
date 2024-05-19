import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {

    /**
     * Lee el archivo y procesa su contenido.
     * @param filePath La ruta del archivo a leer.
     * @param gestor La instancia de la clase GestorMatricesCiudades donde se agregarán los datos leídos.
     */
    public static void leerArchivo(String filePath, GestorMatricesCiudades gestor) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;

            // Lee el archivo línea por línea
            while ((line = bufferedReader.readLine()) != null) {
                // Divide la línea en partes usando el espacio como delimitador
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    // Agrega las estaciones y conexiones al gestor de matrices de ciudades
                    gestor.agregarEstacion(parts[0]);
                    gestor.agregarEstacion(parts[1]);
                    gestor.agregarConexion(parts[0], parts[1], Integer.parseInt(parts[2]));
                } else {
                    System.out.println("Formato de línea incorrecto: " + line);
                }
            }

            // Cierra el BufferedReader
            bufferedReader.close();
        } catch (IOException | NumberFormatException e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
    }
}
