import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
Universidad del Valle
Facultad de Ingeniería
Algoritmos Estructura de Datos
Vianka Castro
23201

Clase lector que recorre el txt y lo manda hacia main
 */
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
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    gestor.agregarEstacion(parts[0], parts[1], parts[2]);
                } else {
                    System.out.println("Formato de línea incorrecto: " + line);
                }
            }
            bufferedReader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
