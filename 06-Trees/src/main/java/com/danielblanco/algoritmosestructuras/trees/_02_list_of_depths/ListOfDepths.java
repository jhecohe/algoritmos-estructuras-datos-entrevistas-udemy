package com.danielblanco.algoritmosestructuras.trees._02_list_of_depths;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Implementa un algoritmo que devuelva una lista enlazada con los nodos de cada nivel. Si el árbol tiene
 * N niveles debes devolver N listas enlazadas.
 *
 * Ejemplo:
 *  Input:
 *        4
 *     2     7
 *   1   3  6  9
 *
 *  Output:
 *    4
 *    2->7
 *    1->3->6->9
 */
public class ListOfDepths {

  public List<LinkedList<Node>> listOfDepths(Node root) {
    List<LinkedList<Node>> listas = new ArrayList<>();
    LinkedList<Node> nivel = new LinkedList<>();
    nivel.add(root);

    while(!nivel.isEmpty()) {
      listas.add(nivel);
      LinkedList<Node> temp = nivel;
      nivel = new LinkedList<>();

      for (Node n: temp){
        if (n.left != null) nivel.add(n.left);
        if (n.right != null) nivel.add(n.right);
      }

    }
    return listas;
  }
}
