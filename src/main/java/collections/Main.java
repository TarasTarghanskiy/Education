package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    s();
  }

  /* Create a container that encapsulates an array of String, and that only adds
  Strings and gets Strings, so that there are no casting issues during use. If the
  internal array isn’t big enough for the next add, your container should
  automatically resize it. In main( ), compare the performance of your
  container with an ArrayList holding Strings. */
  private static void four() {
    StringContainer stringContainer = new StringContainer(2);
    String typicalUserString = "biba+buba";

    List<String> stringList = new ArrayList<>(2);

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
      stringList.add(typicalUserString);
    }
    stringList.forEach(System.out::println);

    long f = System.currentTimeMillis() - startTime;
    startTime = System.currentTimeMillis();

    for (int i = 0; i < 100; i++) {
      stringContainer.addString(typicalUserString);
    }

    for (int i = 0; i < 100; i++) {
      System.out.println(stringContainer.getString(i));
    }
    long g = +System.currentTimeMillis() - startTime;
    System.out.println("time for my container: " + g + " time for ArrayList: " + f);

  }
  /*Дано два масиви. Сформувати третій масив, що складається з тих елементів, які:
  а) присутні в обох масивах;
  б) присутні тільки в одному з масивів. */
  private static void threeMassives(){
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


  private static void s(){
    List<Integer> integerQueue = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      integerQueue.add((int)(Math.random()*10)+1);
    }
    System.out.println(integerQueue);
    //sort(integerQueue);
    sort2(integerQueue);
    System.out.println(integerQueue);
  }

  // B. Видалити в масиві всі числа, які повторюються більше двох разів.
  private static void sort(List<Integer> sort){
    sort.sort(Comparator.comparingInt(Integer::intValue));
    if (sort.size() < 3) return;
    for (int i = 0; i < sort.size()-2;) {
      if (sort.get(i).equals(sort.get(i+1)) && sort.get(i+1).equals(sort.get(i+2)))
        sort.remove(i+2);
      else i++;
    }
  }

  //Знайти в масиві всі серії однакових елементів, які йдуть підряд,
  //і видалити з них всі елементи крім одного.
  private static void sort2(List<Integer> list) {
    if (list.size() < 2) return;
    for (int i = 0; i < list.size()-1;) {
      if (list.get(i).equals(list.get(i+1)))
        list.remove(i+1);
      else i++;
    }
  }
}
