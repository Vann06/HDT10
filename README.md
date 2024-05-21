# Proyecto de Rutas y Centros de Grafos

## Introducción

Este proyecto consiste en la implementación de un sistema para gestionar una red de ciudades, calcular rutas más cortas entre ellas, y determinar el centro del grafo. Utilizando el algoritmo de Floyd-Warshall, el sistema permite encontrar el camino más corto entre cualquier par de ciudades y muestra la excentricidad mínima para identificar el centro del grafo.

## Explicación del Programa

### Lenguaje y Plataforma

El proyecto está desarrollado en Java, utilizando principios de programación orientada a objetos. La plataforma utilizada para el desarrollo es IntelliJ IDEA, que proporciona herramientas avanzadas para la codificación y depuración del código.

### Algoritmo

El algoritmo principal utilizado es el algoritmo de Floyd-Warshall, que permite encontrar las rutas más cortas entre todas las parejas de ciudades en un grafo. Este algoritmo es eficiente y adecuado para grafos con pesos en los arcos.

- **Floyd-Warshall**: Este algoritmo actualiza iterativamente las matrices de distancias y rutas para reflejar las distancias más cortas entre todas las ciudades. La implementación se basa en actualizar una matriz de distancias y una matriz de rutas, lo que permite rastrear los caminos mínimos.

## Funcionalidades

### Ingresar Datos de Ciudades y Arcos

El programa permite leer datos de un archivo para cargar una red de ciudades y sus distancias. Además, se pueden agregar y eliminar arcos manualmente.

### Menú Principal

El menú principal del programa ofrece las siguientes opciones:

1. **Consultar distancia entre ciudades**: Permite al usuario ingresar dos ciudades y consultar la distancia entre ellas.
2. **Mostrar rutas del grafo**: Muestra la matriz de distancias y rutas entre todas las ciudades.
3. **Encontrar camino más corto entre ciudades**: Permite al usuario encontrar y mostrar el camino más corto entre dos ciudades específicas.
4. **Agregar arco**: Permite al usuario agregar una nueva conexión entre dos ciudades.
5. **Eliminar arco**: Permite al usuario eliminar una conexión existente entre dos ciudades.
6. **Calcular centro del grafo**: Calcula y muestra el centro del grafo, indicando la ciudad con la mínima excentricidad.
7. **Salir**: Sale del programa.


### Integrantes

- Vianka Vanessa Castro Ordoñez 23201
