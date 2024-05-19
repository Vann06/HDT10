/*
Universidad del Valle
Facultad de Ingeniería
Algoritmos Estructura de Datos
Vianka Castro
23201
Clase del algoritmo
 */

public class AlgoritmoFloyd {
    public void floydWarshall(GestorMatricesCiudades matriz) {
        int size = matriz.getCiudadesSize();
        int[][] distancia = matriz.getDistancia();
        int[][] rutas = matriz.getRutas();

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (distancia[i][k] == 999999 || distancia[k][j] == 999999) {
                        continue;
                    }
                    if (distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                        rutas[i][j] = rutas[i][k];
                    }
                }
            }
        }
    }
}
