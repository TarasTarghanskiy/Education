package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskBC {
  // робота з масивами
  public void start(){
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
