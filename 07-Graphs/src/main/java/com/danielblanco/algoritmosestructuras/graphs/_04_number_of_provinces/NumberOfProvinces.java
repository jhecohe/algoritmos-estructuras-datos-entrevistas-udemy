package com.danielblanco.algoritmosestructuras.graphs._04_number_of_provinces;


/*
 * Tenemos N ciudades y queremos calcular el número de provincias existentes.
 * Una provincia la forman todas las ciudades que están conectadas entre sí.
 *
 * Ejemplo:
 *  Input:
 *
 *     a b c
 *   a 1 1 0
 *   b 1 1 0
 *   c 0 0 1
 *
 *  Output: 2
 *
 *  Creamos un contador para llevar el numero de provincias
 *  Creamos un arreglo para almacenar las ciudades viditadas
 *  Iteramos todos las filas.
 *  Creamos un metodo para una busqueda en profundidad (deep first search)
 *
 *  Complejidad lineal, ya que maximo se toca cada nodo una sola vez
 */
public class NumberOfProvinces {

  public int numberOfProvinces(int[][] isConnected) {

    int provincias = 0;
    boolean[] visitado = new boolean[isConnected.length];

    for (int i = 0; i < isConnected.length; i++) {
      if (!visitado[i]){
        provincias++;
        dfs(isConnected, visitado, i);
      }
    }

    return provincias;
  }

  /*
    Iteramos las columnas otraCiudad, como es una matriz cuadrade podemos tomar el largo
    de cualquier fila.
    Validamos en un if,
    1- Que la ciudad que estamos iterando no sea la misma con la que estamos comparando
    2- Que la posicion en la matriz que estamos evaluando sea igual a 1, osea conectado
    3- Y que la ciudad no haya sido visitada.
    Usamos la recursividad para validar cada una de las ciudades y validar que todas las
    ciudades han sido visitadas.
   */
  private void dfs(int[][] isConnected, boolean[] visitado, int ciudad) {
    System.out.println("numero  de la ciudad en dfs -> "+ ciudad);
    for (int OCiudad = 0; OCiudad < isConnected[0].length; OCiudad++) {
      if (OCiudad != ciudad && isConnected[ciudad][OCiudad] == 1 && !visitado[OCiudad]){
        visitado[OCiudad] = true;
        dfs(isConnected, visitado, OCiudad);
      }
    }
  }
}
