package com.danielblanco.algoritmosestructuras.trees._06_first_common_ancestor;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Devuelve el primer ancestro común de dos nodos.
 *
 * Ejemplo:
 *  Input:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *  firstCommonAncestor(1, 7) = 4
 *  firstCommonAncestor(1, 4) = null
 *  firstCommonAncestor(1, 3) = 5
 *
 */
public class FirstCommonAncestor {

  class AncestorNode {
    boolean nodeFound;
    Node ancestor;
  }

  public Node firstCommonAncestor(Node root, Node firstNode, Node secondNode) {
    return postOrderSearch(root, firstNode, secondNode).ancestor;
  }

  private AncestorNode postOrderSearch(Node root, Node firstNode, Node secondNode) {

    if (root == null) return new AncestorNode();

    AncestorNode left = postOrderSearch(root.left, firstNode, secondNode);
    // Si encontramos en el ancestro podemos retornar ese nodo
    if (left.ancestor != null) return left;

    AncestorNode right = postOrderSearch(root.right, firstNode, secondNode);
    if (left.ancestor != null) return right;

    AncestorNode result  = new AncestorNode();

    if (left.nodeFound && right.nodeFound) {
      result.ancestor = root;
      return result;
    }

    result.nodeFound = root == firstNode || root == secondNode || left.nodeFound || right.nodeFound;
    return result;
  }
}
