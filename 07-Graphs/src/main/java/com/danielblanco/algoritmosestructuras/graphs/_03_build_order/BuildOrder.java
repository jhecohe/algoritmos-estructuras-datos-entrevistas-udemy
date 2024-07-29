package com.danielblanco.algoritmosestructuras.graphs._03_build_order;

import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.DepthFirstSearch;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.Graph;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNode;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNodeStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Dada una lista de proyectos y las dependencias entre ellos, devuelve un orden de
 * compilación válido para dichos proyectos.
 *
 * La lista de dependencias es una lista de pares de strings (a, b), que indican que el
 * proyecto b depende del a (el a debe ser compilado con antelación).
 *
 * Ejemplo 1:
 *  Input:
 *    projects: a, b, c, d
 *    dependencies: [(a, b), (a, c), (a, d), (c, b), (d, b), (d, c)]
 *  Output: a, d, c, b
 *
 * Ejemplo2:
 *  Input:
 *    projects: a, b, c, d
 *    dependencies: [(a, b), (b, c), (c, d), (d, a)]
 *  Output: Lanza excepción. No se puede construir ya que se forma un ciclo.
 *
 */
public class BuildOrder {

  public List<String> buildOrder(String[] projects, String[][] dependencies) {

    Graph grafos = crearGrafo(projects, dependencies);
    List<String> proyectos = new ArrayList<>();

    for (GraphNode node : grafos.nodes.values()){
      depthFirstSearch(node, proyectos);
    }

    Collections.reverse(proyectos);

    return proyectos;
  }

  private void depthFirstSearch(GraphNode node, List<String> proyectos) {
    if (node == null) return;

    if (node.status == GraphNodeStatus.Unvisited){
      node.status = GraphNodeStatus.Visiting;
      for (GraphNode n : node.adjacents.values()){
        depthFirstSearch(n, proyectos);
      }

      node.status = GraphNodeStatus.Visited;
      proyectos.add(node.value);
    } else if (node.status == GraphNodeStatus.Visiting) {
      throw  new RuntimeException();
    }
  }


  private Graph crearGrafo(String[] projects, String[][] dependencies) {

    Graph grafo = new Graph();

    for (String p : projects){
      grafo.getOrCreateNode(p);
    }

    for (String[] dep : dependencies){
      grafo.addEdge(dep[0], dep[1]);
    }

    return grafo;
  }
}
