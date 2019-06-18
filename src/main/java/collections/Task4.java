package collections;

import java.util.ArrayList;
import java.util.List;

public class Task4 {

  /* Create a container that encapsulates an array of String, and that only adds
    Strings and gets Strings, so that there are no casting issues during use. If the
    internal array isn’t big enough for the next add, your container should
    automatically resize it. In main( ), compare the performance of your
    container with an ArrayList holding Strings. */
  public void start() {
    System.out.println("Task 4: ");
    StringContainer stringContainer = new StringContainer(2);
    String typicalUserString = "biba+buba";

    List<String> stringList = new ArrayList<>(2);

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      stringList.add(typicalUserString);
    }
    //stringList.forEach(System.out::println);

    long f = System.currentTimeMillis() - startTime;
    startTime = System.currentTimeMillis();

    for (int i = 0; i < 10000; i++) {
      stringContainer.addString(typicalUserString);
    }

//    for (int i = 0; i < 100; i++) {
//      System.out.println(stringContainer.getString(i));
//    }
    long g = +System.currentTimeMillis() - startTime;
    System.out.println("time for my container: " + g + " time for ArrayList: " + f);

  }
}
