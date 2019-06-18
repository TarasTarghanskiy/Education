package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/* Create a class containing two String objects and make it Comparable so that
the comparison only cares about the first String. Fill an array and an ArrayList
with objects of your class by using a custom generator (eg, which generates
pairs of Country-Capital). Demonstrate that sorting works properly. Now
make a Comparator that only cares about the second String and
demonstrate that sorting works properly. Also perform a binary search using
your Comparator. */

public class Task5 {
  List<TestObject> testObjects = new ArrayList<>();

  public void start(){
    System.out.println("Task 5 :");

    for (int i = 0; i < 10; i++) {
      testObjects.add(new TestObject("firstString#" + (int)(Math.random()*10), "secondString#" + (100-i) ));
    }
    //only cares about the first String
    testObjects.sort(Comparator.comparingInt(o -> (Integer.valueOf(o.getFirstString().split("#")[1]))));
    System.out.println(testObjects);

    //only cares about the second String
    testObjects.sort(Comparator.comparingInt(o -> (Integer.valueOf(o.getSecondString().split("#")[1]))));
    System.out.println(testObjects);


  }
}
