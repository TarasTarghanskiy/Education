package generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    Ship<Droid> droidShip = new Ship<>();
    Queue<BattleDroid> battleDroids = new PriorityQueue<>(droidComparator);
    for (int i = 0; i < 10; i++) {
      battleDroids.add(new BattleDroid((int)(Math.random()*100)));
      droidShip.add(new HealDroid((int)(Math.random()*100)));
    }
    droidShip.add(battleDroids);
    System.out.println("show");
    droidShip.printAll();

    List<? super Object> numberList = new ArrayList<>();
    numberList.add(4);
    numberList.add(5);
    numberList.add(6);
    numberList.add("seven");
    numberList.add(8);
    numberList.forEach(System.out::print);

    System.out.println();

    MyPriorityQueue<BattleDroid> queue = new MyPriorityQueue<>();
    for (int i = 0; i < 5; i++) {
      int number = (int) (Math.random()*100);
      System.out.println(number);
      queue.add(new BattleDroid(number));
    }
    System.out.println(queue.size());
    System.out.println(queue.peek());
    System.out.println(queue.size());
    System.out.println(queue.poll());
    System.out.println(queue.size());
    System.out.println(queue.poll());
    System.out.println(queue.size());
    queue.addAll(battleDroids);
    System.out.println(queue.size());
  }

  private static Comparator<Droid> droidComparator = Comparator.comparingInt(Droid::getId);
}
