package com.danielblanco.algoritmosestructuras._02_merge__two_sorted_lists;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo para combinar dos listas enlazadas simples ordenadas.
 * El resultado debe ser una única lista enlazada ordenada. Devuelve su head.
 *
 * Ejemplo:
 *  Input: 1->2->4->6, 2->3->5
 *  Output: 1->2->2->3->4->5->6
 */
public class MergeTwoSortedLists {

  public Node mergeTwoLists(Node list1, Node list2) {

    Node merge = new Node(Integer.MIN_VALUE);
    Node current = merge;

    while (list1 != null && list2 != null) {
      if(list1.value <= list2.value){
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }

      current = current.next;
    }

    if(list1 == null) {
      appendToList(current, list2);
    } else {
      appendToList(current, list1);
    }

    return merge.next;
  }

  private void appendToList(Node current, Node list) {
    while (list != null) {
      current.next = list;
      list = list.next;
      current = current.next;
    }
  }
}
