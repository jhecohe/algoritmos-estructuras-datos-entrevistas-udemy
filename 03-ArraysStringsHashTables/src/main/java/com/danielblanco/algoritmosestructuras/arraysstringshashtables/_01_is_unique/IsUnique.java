package com.danielblanco.algoritmosestructuras.arraysstringshashtables._01_is_unique;

import java.util.HashSet;
import java.util.Set;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUnique {

  public boolean isUnique(String s) {
    
    Set<Character> unique = new HashSet<>();
    
    for (int i=0; i < s.length(); i++) {
        Character c = s.charAt(i);
        if (unique.contains(c)) {
            return false;
        }
        unique.add(c);
    }
    return true;
  }
}
