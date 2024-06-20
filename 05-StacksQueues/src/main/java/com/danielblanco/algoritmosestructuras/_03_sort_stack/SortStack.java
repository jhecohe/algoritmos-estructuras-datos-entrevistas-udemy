package com.danielblanco.algoritmosestructuras._03_sort_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Ordena un Stack de forma que los elementos más pequeños queden en el tope del Stack.
 * Puedes usar un Stack adicional, pero no está permitido copiar los elementos a otra
 * estructura de datos.
 *
 * Ejemplo:
 *  Input: (tope) 5->1->4->2
 *  Output: (tope) 1->2->4->5
 */
public class SortStack {

  public Deque<Integer> sort(Deque<Integer> stack) {
    Deque<Integer> sorted = new ArrayDeque<>();

    while (!stack.isEmpty()){
      int current = stack.pop();
      while (!sorted.isEmpty() && current > sorted.peek()) {
        stack.push(sorted.pop());
      }
      sorted.push(current);
    }

    return sorted;
  }
}
