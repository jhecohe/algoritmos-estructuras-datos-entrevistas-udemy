package com.danielblanco.algoritmosestructuras._05_swap_nodes_in_pairs;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo que intercambie parejas de nodos adyacentes sin
 * modificar el valor interno de los nodos.
 *
 * Ejemplo:
 *  Input: 1->2->4->6->8
 *  Output: 2->1->6->4->8
 */
public class SwapNodesInPairs {

  public Node swapNodesInPairs(Node head) {

    Node current = head;
    while(current != null && current.next != null){
      int temp = current.value;;
      current.value = current.next.value;
      current.next.value = temp;
      current = current.next.next;
    }

    return head;
  }
}
