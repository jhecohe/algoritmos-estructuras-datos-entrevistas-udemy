package com.danielblanco.algoritmosestructuras._04_stack_min;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * ¿Cómo diseñarías un Stack que además de las operaciones de push y pop también
 * contase con una operación para obtener el mínimo?
 */
public class StackMin {

  private Deque<Integer> valuesStack = new ArrayDeque<>();
  private Deque<Integer> minsStack = new ArrayDeque<>();

  public void push(Integer data) {
    valuesStack.push(data);
    if (minsStack.isEmpty() || data < minsStack.peek()) {
      minsStack.push(data);
    }
  }

  public int pop() {
    int value = valuesStack.pop();
    if (value == minsStack.peek()){
      minsStack.pop();
    }
    return value;
  }

  public int min() {
    return minsStack.peek();
  }
}
