import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorMatricesCiudadesTest {

    @Test
    void agregarEstacion() {
        GestorMatricesCiudades matriz = new GestorMatricesCiudades();

        // Agregar una estación válida
        matriz.agregarEstacion("Ciudad A", "Ciudad B", "5");
        assertTrue(matriz.contains("Ciudad A"));
        assertTrue(matriz.contains("Ciudad B"));
        assertEquals(2, matriz.getCiudadesSize());

        // Verificar la distancia
        assertEquals(5, matriz.distancia("Ciudad A", "Ciudad B"));

        // Intentar agregar la misma estación nuevamente
        matriz.agregarEstacion("Ciudad A", "Ciudad B", "10");
        assertEquals(10, matriz.distancia("Ciudad A", "Ciudad B")); // La distancia no debe cambiar

        // Agregar otra estación
        matriz.agregarEstacion("Ciudad A", "Ciudad C", "8");
        assertEquals(3, matriz.getCiudadesSize());
    }

    @Test
    void EliminarArco() {
        GestorMatricesCiudades matriz = new GestorMatricesCiudades();

        // Agregar un arco válido
        matriz.agregarEstacion("Ciudad A", "Ciudad B", "5");
        assertTrue(matriz.contains("Ciudad A"));
        assertTrue(matriz.contains("Ciudad B"));
        assertEquals(5, matriz.distancia("Ciudad A", "Ciudad B"));

        // Eliminar el arco
        matriz.eliminarArco("Ciudad A", "Ciudad B");
        assertEquals(999999, matriz.distancia("Ciudad A", "Ciudad B")); // La distancia debe ser infinito
    }
    @Test
    void agregarArco() {
        GestorMatricesCiudades matriz = new GestorMatricesCiudades();
        matriz.agregarEstacion("Ciudad A", "Ciudad B", "5");

        // Agregar un arco válido
        matriz.agregarArco("Ciudad A", "Ciudad B", 5);
        assertTrue(matriz.contains("Ciudad A"));
        assertTrue(matriz.contains("Ciudad B"));
        assertEquals(5, matriz.distancia("Ciudad A", "Ciudad B"));

        // Verificar que se agregó correctamente
        assertEquals(5, matriz.getDistancia()[matriz.ciudades.indexOf("Ciudad A")][matriz.ciudades.indexOf("Ciudad B")]);
    }


}