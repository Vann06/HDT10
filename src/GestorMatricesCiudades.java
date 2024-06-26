import java.util.Vector;
/*
Universidad del Valle
Facultad de Ingeniería
Algoritmos Estructura de Datos
Vianka Castro
23201
Clase encargada de gestionar las matrices de las ciudades
 */
public class GestorMatricesCiudades {

    protected Vector<String> ciudades;
    private int[][] distancia;
    private int[][] rutas;

    public GestorMatricesCiudades() {
        ciudades = new Vector<>();
        distancia = new int[90][90];
        rutas = new int[90][90];

        for (int i = 0; i < 90; i++) {
            for (int j = 0; j < 90; j++) {
                if (i == j) {
                    distancia[i][j] = 0;
                } else {
                    distancia[i][j] = 999999;
                }
                rutas[i][j] = 999999;
            }
        }
    }

    public int getCiudadesSize() {
        return ciudades.size();
    }

    public int[][] getDistancia() {
        return distancia;
    }

    public int[][] getRutas() {
        return rutas;
    }

    public int distancia(String city1, String city2) {
        return distancia[ciudades.indexOf(city1)][ciudades.indexOf(city2)];
    }

    public void ciudadesEnTrayectoria(String city1, String city2) {
        int i = ciudades.indexOf(city1);
        int j = ciudades.indexOf(city2);
        Vector<String> ruta = new Vector<>();
        ruta.add("---> " + ciudades.get(i));

        if (distancia[i][j] == 999999 || distancia[i][j] == 0) {
            System.out.println("No hay camino.\n");
        } else {
            while (i != j) {
                i = rutas[i][j];
                ruta.add(ciudades.get(i));
            }
        }

        int n = ruta.size();
        System.out.print("Las ciudades por las que debe pasar son: \n ");
        for (int l = 0; l < n - 1; l++) {
            System.out.print(ruta.get(l) + " ---> ");
        }
        System.out.print(ruta.get(n - 1) + "\n");
    }

    public void agregarEstacion(String city1, String city2, String dist) {
        if (!ciudades.contains(city1)) {
            ciudades.add(city1);
        }
        if (!ciudades.contains(city2)) {
            ciudades.add(city2);
        }

        int i = ciudades.indexOf(city1);
        int j = ciudades.indexOf(city2);
        distancia[i][j] = Integer.parseInt(dist);

        if (dist.equals("999999")) {
            rutas[i][j] = 999999;
        } else {
            rutas[i][j] = j;
        }
    }

    public void show() {
        System.out.println("Rutas Disponibles: ");
        for (int a = 0; a < ciudades.size(); a++) {
            for (int b = 0; b < ciudades.size(); b++) {
                System.out.print(rutas[a][b] + " ");
            }
            System.out.println("");
        }

        System.out.println("Distancia entre ciudades: ");
        for (int a = 0; a < ciudades.size(); a++) {
            for (int b = 0; b < ciudades.size(); b++) {
                System.out.print(distancia[a][b] + " ");
            }
            System.out.println("");
        }
    }

    public boolean contains(String city1) {
        return ciudades.contains(city1);
    }

    public void eliminarArco(String ciudadA, String ciudadB) {
        if (!contains(ciudadA) || !contains(ciudadB)) {
            System.out.println("Una o ambas ciudades no existen en el grafo.");
            return;
        }

        int i = ciudades.indexOf(ciudadA);
        int j = ciudades.indexOf(ciudadB);

        distancia[i][j] = 999999;
        rutas[i][j] = 999999;
    }

    public void agregarArco(String ciudadA, String ciudadB, int dist) {
        // Verificar si las ciudades existen en el grafo
        if (!contains(ciudadA) || !contains(ciudadB)) {
            System.out.println("Una o ambas ciudades no existen en el grafo.");
            return;
        }

        // Obtener los índices de las ciudades en el vector
        int i = ciudades.indexOf(ciudadA);
        int j = ciudades.indexOf(ciudadB);

        // Actualizar la matriz de distancias y la matriz de rutas
        distancia[i][j] = dist;
        rutas[i][j] = j; // Se asume que la ruta directa va a la ciudad B
    }


    public String calcularCentroGrafo() {
        int minMax = Integer.MAX_VALUE;
        int centro = -1;

        for (int i = 0; i < ciudades.size(); i++) {
            int maxDistancia = Integer.MIN_VALUE;

            for (int j = 0; j < ciudades.size(); j++) {
                if (distancia[i][j] > maxDistancia) {
                    maxDistancia = distancia[i][j];
                }
            }

            if (maxDistancia < minMax) {
                minMax = maxDistancia;
                centro = i;
            }
        }

        return ciudades.get(centro);
    }
    /*
    public boolean contains(String city1, String city2) {
        return ciudades.contains(city1) && ciudades.contains(city2);
    }

     */
}
