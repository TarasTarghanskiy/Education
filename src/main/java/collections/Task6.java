package collections;

import collections.MyDeque;

//Сreate a Deque class and test it.
public class Task6 {

  public static void main(String[] args) {
    MyDeque<String> myDeque = new MyDeque<>();
    System.out.println("SIZE = " + myDeque.size());
    for (int i = 0; i < 50; i++) {
      myDeque.addFirst("e" + (i + 1));
    }

    System.out.println(myDeque);
    System.out.println("SIZE = " + myDeque.size());


    myDeque.removeFirstOccurrence("e2");

    System.out.println(myDeque);
    System.out.println("SIZE = " + myDeque.size());

    while (!myDeque.isEmpty()) {
      System.out.println(myDeque.pollFirst());
    }


    System.out.println(myDeque);
    System.out.println("SIZE = " + myDeque.size());
  }
}
