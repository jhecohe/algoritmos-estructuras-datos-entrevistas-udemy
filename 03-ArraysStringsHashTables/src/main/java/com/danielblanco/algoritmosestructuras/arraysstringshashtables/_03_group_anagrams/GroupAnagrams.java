package com.danielblanco.algoritmosestructuras.arraysstringshashtables._03_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 * 
 * Add to a list if the wrod contains the same number of letters 
 * Return hashmap each word in the array
 */
public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] words) {
    Map<String, List<String>> map = anagramMap(words);

    return new ArrayList<>(map.values());
  }

  private Map<String, List<String>> anagramMap(String[] words) {
    Map<String, List<String>> map = new HashMap<>();

    for (String word : words) {
      String hash = getAnagram(word);
      if (!map.containsKey(hash)) {
        map.put(hash, new ArrayList<>());
      }
      map.get(hash).add(word);
    }

    return map;
  }

  private String getAnagram(String word) {
    int[] letterCount = new int[26];

    for (int c : word.toCharArray()) {
      letterCount[c - 'a']++;
    }

    return Arrays.toString(letterCount);
  }
}
