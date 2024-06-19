package com.danielblanco.algoritmosestructuras._02_valid_parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Dado un String que solamente contiene los caracteres '(', ')', '{', '}', '[' y ']',
 * implementa un algoritmo para determinar si es válido.
 *
 * Ejemplo 1:
 *  Input: "([]){}"
 *  Output: true
 *
 * Ejemplo 2:
 *  Input: "({)}"
 *  Output: false
 *
 */
public class ValidParenthesis {

  public boolean isValid(String s) {

    Deque pila = new ArrayDeque<String>();
    for(Character c: s.toCharArray())
    {
      if(c == '(' || c == '[' || c == '{'){
        if(c == '(') pila.push(')');
        if(c == '[') pila.push(']');
        if(c == '{') pila.push('}');
      }
      else {
        if(c != pila.pop()){
          return false;
        }
      }
    }
    return pila.isEmpty();
  }
}
