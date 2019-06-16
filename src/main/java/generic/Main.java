package generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    Ship<Droid> droidShip = new Ship<>(droidComparator);
    Queue<BattleDroid> battleDroids = new PriorityQueue<>(new DroidComparator());
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
  }

  private static Comparator<Droid> droidComparator = Comparator.comparingInt(Droid::getId);
}
