package generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ship<T> {

  private Queue<? super T> queue;
  private Comparator<T> comparator;

  public Ship(Comparator<T> comparator) {
    this.comparator = comparator;
    this.queue = new PriorityQueue<>(comparator);
  }

  public void printAll() {
    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }

  public void add(T t) {
    queue.add(t);
  }

  public void add(Queue<? extends T> queue) {
    this.queue.addAll(queue);
  }

}
