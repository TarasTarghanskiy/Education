package lambdas;

import java.util.Comparator;
import java.util.stream.Stream;

public class Lamdas {

  public static void main(String[] args) {

    /* Create functional interface with method that accepts three int
       values and return int value. Create lambda functions (as
       variables in main method) what implements this interface:*/
    //First lambda returns max value
    //ThreeValues maxValue = (a,b,c)-> Integer.max(Integer.max(a,b), Integer.max(b,c));
    ThreeValues maxValue = (a,b,c)-> Stream.of(a,b,c).max(Integer::compareTo).get();
    //Second – average
    //ThreeValues averageValue = (a,b,c) -> Integer.min(Integer.max(a,b), Integer.max(b,c));
    ThreeValues averageValue = (a,b,c) -> (int) Stream.of(a,b,c).mapToInt(Integer::intValue).average().getAsDouble();
    //Invoke thous lambdas.
    System.out.println(maxValue.threeValues(1, 3, 1));
    System.out.println(averageValue.threeValues(1, 2, 3));
    System.out.println(averageValue.threeValues(1, 1, 1));
    System.out.println(averageValue.threeValues(1, 2, 2));

    /* Implement pattern Command. Each command has its name
      (with which it is invoked) and one string argument. You should
      implement 4 commands with next ways: command as lambda
      function, as method reference, as anonymous class, as object of
      command class. User enters command name and argument into
      console, your app invokes corresponding command. */
    Menu.run();

  }
}
