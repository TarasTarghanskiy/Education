package collections2;

import java.util.Comparator;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {
    MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>(
        Comparator.comparingInt(Integer::intValue));
    for (int i = 0; i < 25; i++) {
      int num = (int) (Math.random() * 100) + 1;
      System.out.println("put number " + num);
      myTreeMap.put(num, String.valueOf(num));
      myTreeMap.sout();
    }
  }
}
