package com.danielblanco.algoritmosestructuras._03_nth_node_to_last;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

import java.util.Queue;

/*
 * Dada una lista enlazada simple y un valor N, devuelve el nodo N empezando por el final
 *
 * Ejemplo:
 *  Input: 1->2->4->6, 2
 *  Output: 4
 *
 * First solution is iterating over the list and subtract the number of elements
 *
 * Optimized solution, use two pointers
 */
public class NthNodeToLast {

  public Node nthNodeToLast(Node head, int n) {

    Node p1 = head;
    Node p2 = head;

    for (int i = 0; i < n; i++) {
      if (p1 == null) return null;
      p1 = p1.next;
    }

    while(p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p2;
  }

//  public Node nthNodeToLast(Node head, int n) {
//
//    Node temp = head;
//    int count = 0;
//    while (temp != null) {
//      count++;
//      temp = temp.next;
//    }
//
//    if( count < n) return null;
//
//    int index = count - n;
//
////    Node select = null;
//    for (int i = 0; i < index; i++) {
//      head = head.next;
//    }
//
//    return head;
//  }
}
