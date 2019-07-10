package lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lamdas {

  public static void main(String[] args) throws IOException {

    /*1 Create functional interface with method that accepts three int
       values and return int value. Create lambda functions (as
       variables in main method) what implements this interface:*/
    //First lambda returns max value
    //ThreeValues maxValue = (a,b,c)-> Integer.max(Integer.max(a,b), Integer.max(b,c));
    ThreeValues maxValue = (a, b, c) -> Stream.of(a, b, c).max(Integer::compareTo).get();
    //Second – average
    //ThreeValues averageValue = (a,b,c) -> Integer.min(Integer.max(a,b), Integer.max(b,c));
    ThreeValues averageValue = (a, b, c) -> (int) Stream.of(a, b, c).mapToInt(Integer::intValue)
        .average().getAsDouble();
    //Invoke thous lambdas.
    System.out.println(maxValue.threeValues(1, 3, 1));
    System.out.println(averageValue.threeValues(1, 2, 3));
    System.out.println(averageValue.threeValues(1, 1, 1));
    System.out.println(averageValue.threeValues(1, 2, 2));

    /*2 Implement pattern Command. Each command has its name
      (with which it is invoked) and one string argument. You should
      implement 4 commands with next ways: command as lambda
      function, as method reference, as anonymous class, as object of
      command class. User enters command name and argument into
      console, your app invokes corresponding command. */

    //Menu.run();

    /*3 Create a few methods that returns list (or array) of random
    integers. Methods should use streams API and should be
    implemented using different Streams generators.*/

    System.out.println(firstRand());
    System.out.println(secondRand());
    System.out.println(thirdRand());

    System.out.println(firstNotRand());
    System.out.println(secondNotRand());
    //System.out.println(thirdNotRand(Paths.get("test.txt")));
    System.out.println(fourthNotRand());
    System.out.println(fifthNotRand());

    /*Count average, min, max, sum of list values. Try to count
    sum using both reduce and sum Stream methods*/
    Integer[] i = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    System.out.println(Stream.of(i).min(Integer::compareTo).get());
    System.out.println(Stream.of(i).max(Integer::compareTo).get());
    System.out.println(Stream.of(i).mapToInt(Integer::intValue).average().getAsDouble());
    System.out.println(Stream.of(i).mapToInt(Integer::intValue).sum());
    double average = (double)Stream.of(i).reduce((e1, e2) -> e1 + e2).get()/Stream.of(i).count();
    System.out.println("average = " + average);
    /*Count number of values that are bigger than average*/
    System.out.println("bigger than average = " + Stream.of(i).filter(e -> e > average).count());

    /*4 Create application. User enters some number of text lines (stop
    reading text when user enters empty line). Application returns:

    Number of unique words

    Sorted list of all unique words

    Word count. Occurrence number of each word in the text
    (e.g. text “a s a” -> a-2 s-1 ). Use grouping collector.

        Occurrence number of each symbol except upper case
        characters*/
  }

  static List<Integer> firstRand() {
    return new Random().ints(30, 1, 10)
        .boxed().collect(Collectors.toList());
  }
  static List<Integer> secondRand() {
    return Stream.generate(() -> (int) (Math.random() * 10)).limit(30).collect(Collectors.toList());
  }
  static List<Integer> thirdRand() {
    return Stream.iterate((int) System.nanoTime(), n -> n + 5).limit(30).collect(Collectors.toList());
  }

  static List<Integer> firstNotRand(){
    return Stream.of(new Integer[]{1,2,3,4,5,6}).collect(Collectors.toList());
  }

  static List<Integer> secondNotRand(){
    return Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().collect(Collectors.toList());
  }

  static List<Integer> thirdNotRand(Path path) throws IOException {
    return Files.lines(path).map(Integer.class::cast).collect(Collectors.toList());
  }

  static List<Integer> fourthNotRand(){
    return "76354693796347968".chars().boxed().collect(Collectors.toList());
  }

  static List<Integer> fifthNotRand(){
    return Stream.builder().add(1).add(2).add(3).build().map(Integer.class::cast).collect(Collectors.toList());
  }
}
