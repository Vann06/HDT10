import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorMatricesCiudades gestor = new GestorMatricesCiudades();
        AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();
        Scanner scan = new Scanner(System.in);

        // Leer datos del archivo y cargar en el gestor
        LectorArchivo.leerArchivo("guategrafo.txt", gestor);

        // Ejecutar el algoritmo de Floyd-Warshall
        algoritmo.floydWarshall(gestor);

        // Menú principal
        System.out.println("Bienvenido al programa de rutas:");
        boolean salir = false;
        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Consultar distancia entre ciudades");
            System.out.println("2. Mostrar rutas del grafo");
            System.out.println("3. Encontrar camino más corto entre ciudades");
            System.out.println("4. Agregar arco entre ciudades");
            System.out.println("5. Quitar arco entre ciudades");
            System.out.println("6. Salir");

            int opcion = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    opcion = Integer.parseInt(scan.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                }
            }

            switch (opcion) {
                case 1:
                    // Consultar distancia entre ciudades
                    System.out.println("Ingrese la ciudad de salida:");
                    String ciudadSalida = scan.nextLine().trim();
                    System.out.println("Ingrese la ciudad de destino:");
                    String ciudadDestino = scan.nextLine().trim();

                    if (gestor.contains(ciudadSalida) && gestor.contains(ciudadDestino)) {
                        int distancia = gestor.distancia(ciudadSalida, ciudadDestino);
                        if (distancia == 999999) {
                            System.out.println("No hay una conexión directa entre las ciudades.");
                        } else {
                            System.out.println("La distancia recorrida es de: " + distancia + " km");
                        }
                    } else {
                        System.out.println("¡Error! Una o ambas ciudades no existen.");
                    }
                    break;
                case 2:
                    // Mostrar rutas del grafo
                    gestor.show();
                    break;
                case 3:
                    // Encontrar camino más corto entre ciudades
                    System.out.println("Ingrese la ciudad de salida:");
                    String ciudadInicio = scan.nextLine().trim();
                    System.out.println("Ingrese la ciudad de destino:");
                    String ciudadFin = scan.nextLine().trim();

                    if (gestor.contains(ciudadInicio) && gestor.contains(ciudadFin)) {
                        gestor.ciudadesEnTrayectoria(ciudadInicio, ciudadFin);
                    } else {
                        System.out.println("¡Error! Una o ambas ciudades no existen.");
                    }
                    break;
                case 4:
                    // Agregar arco
                    System.out.println("Ingrese la ciudad de salida:");
                    String ciudadA = scan.nextLine().trim();
                    System.out.println("Ingrese la ciudad de destino:");
                    String ciudadB = scan.nextLine().trim();
                    System.out.println("Ingrese la distancia:");
                    String distancia = scan.nextLine();
                    if (validarCiudades(gestor, ciudadA, ciudadB) && validarDistancia(distancia)) {
                        gestor.agregarEstacion(ciudadA, ciudadB, distancia);
                        System.out.println("Arco agregado con éxito.");
                    }
                    break;
                case 5:
                    // Eliminar arco
                    System.out.println("Ingrese la ciudad de salida:");
                    String ciudadX = scan.nextLine().trim();
                    System.out.println("Ingrese la ciudad de destino:");
                    String ciudadY = scan.nextLine().trim();
                    if (validarCiudades(gestor, ciudadX, ciudadY)) {
                        gestor.eliminarArco(ciudadX, ciudadY);
                        System.out.println("Arco eliminado con éxito.");
                    }
                    break;
                case 6:
                    // Salir del programa
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("¡Opción inválida!");
                    break;
            }
        }
        scan.close();
    }

    private static boolean validarCiudades(GestorMatricesCiudades gestor, String ciudad1, String ciudad2) {
        if (!gestor.contains(ciudad1) || !gestor.contains(ciudad2)) {
            System.out.println("Una o ambas ciudades no existen en el grafo.");
            return false;
        }
        return true;
    }

    private static boolean validarDistancia(String distancia) {
        try {
            int valor = Integer.parseInt(distancia);
            if (valor < 0) {
                System.out.println("La distancia no puede ser negativa.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("La distancia debe ser un número entero positivo.");
            return false;
        }
        return true;
    }
}
