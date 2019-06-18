package collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskA {

  /*Дано два масиви. Сформувати третій масив, що складається з тих елементів, які:
  а) присутні в обох масивах;
  б) присутні тільки в одному з масивів. */
  public void start(){
    System.out.println("Task A: ");
    Queue<String> stringQueue1 = new ArrayDeque<>();
    Queue<String> stringQueue2 = new ArrayDeque<>();
    for (int i = 0; i < 10; i++) {
      stringQueue1.add(String.valueOf(i));
      stringQueue2.add(String.valueOf(i*i));
    }

    Queue<String> stringQueue = new ArrayDeque<>(stringQueue1);
    stringQueue.retainAll(stringQueue2); // а) присутні в обох масивах;

    stringQueue = new ArrayDeque<>(stringQueue1);
    stringQueue.removeAll(stringQueue2); //б) присутні тільки в одному з масивів. - stringQueue1
  }
}
