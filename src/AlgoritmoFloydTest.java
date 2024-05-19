import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmoFloydTest {

    @Test
    void floydWarshall() {
        GestorMatricesCiudades matriz = new GestorMatricesCiudades();
        matriz.agregarEstacion("Ciudad A", "Ciudad B", "2");
        matriz.agregarEstacion("Ciudad A", "Ciudad C", "5");
        matriz.agregarEstacion("Ciudad B", "Ciudad C", "1");

        AlgoritmoFloyd algoritmo = new AlgoritmoFloyd();

        algoritmo.floydWarshall(matriz);

        assertEquals(3, matriz.distancia("Ciudad A", "Ciudad C"));
    }
}
