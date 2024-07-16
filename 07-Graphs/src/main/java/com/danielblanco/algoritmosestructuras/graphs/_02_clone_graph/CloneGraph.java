package com.danielblanco.algoritmosestructuras.graphs._02_clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Devuelve una copia profunda (clon) de un grafo conexo y no dirigido. Puedes
 * utilizar la clase Node que se ve a continuación, más simple que Graph.
 *
 * Ejemplo:
 *  Input: Nodo de grafo conexo y no dirigido (desde él se puede llegar a los demás)
 *  Output: Un clon de ese grafo (nuevos Nodos, no las mismas referencias).
 */
public class CloneGraph {

  public class Node {
    public int val;
    public List<Node> neighbors;
  }

  public Node cloneGraph(Node node) {

    HashMap<Integer, Node> clone = new HashMap<>();
    return cloneDeep(node, clone);
  }

  private Node cloneDeep(Node node, HashMap<Integer, Node> clone) {
    if (node == null) return null;
    // Validamos si el nodo ya esta en al mapa, si si, lo retornamos
    if (clone.containsKey(node.val)) return clone.get(node.val);

    Node newNode = new Node();
    newNode.val = node.val;
    newNode.neighbors = new ArrayList<>();

    clone.put(newNode.val, newNode);
    for (Node n: node.neighbors) newNode.neighbors.add(cloneDeep(n, clone));

    return newNode;
  }
}
