package com.danielblanco.algoritmosestructuras.arraysstringshashtables._02_two_sum;

import java.util.HashMap;

/*
 * Dado un array de números enteros y un target, retorna los índices de dos
 * números para los que la suma de ambos sea igual al target.
 *
 * Puedes asumir que hay solamente una solución.
 *
 * Ejemplo 1:
 *  Input: nums = [9,2,5,6], target = 7
 *  Output: [1,2]
 *  Explicación: nums[1] + nums[2] == 7, devolvemos [1, 2].
 *
 * Ejemplo 2:
 *  Input: nums = [9,2,5,6], target = 100
 *  Output: null
 * 
 *  9: 2,5,6 ->  return result
 *  2: 5,6 ->  return result
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {

    // Definimos un map para almacenar los numeros recorridos
    // y su posicion en el array
    HashMap<Integer, Integer> posicions = new HashMap<>();

    for (int i = 0; i < nums.length -1; i++) {
      
      // Validamos si el complemento para encontrar el target
      // se encuentra en el mapa

      int complement = target - nums[i];
      if(posicions.containsKey(complement)){
        return new int[] {posicions.get(complement), i};
      }
      // Si no se encuentra el complemento, se agrega el numero 
      // y su posicion
      posicions.put(nums[i], i);
    }

    return null;

    // Big O N^2
    // 
    // for (int i = 0; i < nums.length; i++) {
    //   for (int j = i+1; j < nums.length; j++) {
    //     if ((nums[i] + nums[j]) == target) return new int[] {i, j};
    //   }
    // }
    // return null;
  }
}
