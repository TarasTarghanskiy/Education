package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int input(String s) {
    int num;
    while (true) {
      try {
        System.out.println(s);
        num = Integer.valueOf(br.readLine());
        System.out.println("number " + num + " was added");
        if (num != 0) {
          break;
        }
      } catch (NumberFormatException | IOException e) {
        e.printStackTrace();
      }
    }
    return num;
  }

  public static void main(String[] args) {

    try (MyMath myMath = new MyMath()) {

      System.out.println("square rectangle equals " + myMath
          .squareRectangle(input("enter number a"), input("enter number b")));
    } catch (Exception e) {
      e.printStackTrace();
    }

    List<Plants> plants = new ArrayList<>();
    try {
      plants.add(new Plants(0, null, null));
      plants.add(new Plants(0, Type.ROSE, Color.RED));
      plants.add(new Plants(0, null, Color.valueOf("PIZ")));
      plants.add(new Plants(0, Type.valueOf("LL"), null));
      plants.add(new Plants(0, null, null));
    } catch (TypeException | ColorException e) {
      e.printStackTrace();
    }
  }
}
