package com.danielblanco.algoritmosestructuras.trees._05_is_subtree;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Determina si el árbol second es subárbol del árbol first.
 *
 * Ejemplo 1:
 *  Input:
 *    first:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *    second:
 *         4
 *      2     7
 *    1   3  5
 *
 *  Output: false
 *
 * Ejemplo 2:
 *  Input:
 *    first:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *    second:
 *         5
 *      1     3
 *    8
 *
 * Output: true
 */
public class IsSubTree {

  public boolean isSubtree(Node first, Node second) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    preOrder(first, sb1);
    preOrder(second, sb2);

    return sb1.toString().contains(sb2.toString());
  }

  public void preOrder( Node node, StringBuilder sb) {

    if (node == null){
      sb.append("X");
      return;
    }
    sb.append(node.value);

    preOrder(node.left, sb);
    preOrder(node.right, sb);
  }

//  public boolean isSubtree(Node first, Node second) {
//
//    if (first == null && second == null) return true;
//
//    boolean root = first.value == second.value;
//    boolean left = first.left.value == second.left.value;
//    boolean right = first.right.value == second.right.value;
//
//    if (!root && !left && !right) return false;
//
//    return isSubtree(first.left, second.left) && isSubtree(first.right, second.right);
//  }
}
