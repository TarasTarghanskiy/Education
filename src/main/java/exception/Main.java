package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  enum Color {
    RED, BLUE, YELLOW, BLACK, GREEN, ORANGE;

    static boolean exist(Color color) {
      return Arrays.stream(Color.values()).anyMatch(value -> value == color);
    }
  }

  enum Type {
    ROSE, ORCHID, TYPE_2, TYPE_3;

    static boolean exist(Type type) {
      return Arrays.stream(Type.values()).anyMatch(value -> value == type);
    }
  }

  private static class InputClass {

    private static int input(String s) {
      int num;
      while (true) {
        try {
          System.out.println(s);
          num = Integer.valueOf(br.readLine());
          break;
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return num;
    }
  }

  public static void main(String[] args) {
    class MyException extends Exception {

      private MyException(String message) {
        super(message);
      }
    }

    class TypeException extends MyException {

      private TypeException(String message) {
        super(message);
      }
    }

    class ColorException extends MyException {

      private ColorException(String message) {
        super(message);
      }
    }

    class MyMath implements AutoCloseable {

      private MyMath() {
      }

      private int squareRectangle(int a, int b) throws MyException {
        if (a < 0) {
          throw new MyException("incorrect number a");
        }
        if (b < 0) {
          throw new MyException("incorrect number b");
        }
        return a * b;
      }

      @Override
      public void close() throws Exception {
        System.out.println("math was closed");
      }
    }

    try (MyMath myMath = new MyMath()) {

      System.out.println("square rectangle equals " + myMath
          .squareRectangle(InputClass.input("enter number a"), InputClass.input("enter number b")));
    } catch (Exception e) {
      e.printStackTrace();
    }

    class Plants {

      int size;
      Type type;
      Color color;

      public Plants(int size, Type type, Color color) throws TypeException, ColorException {
        if (type == null || !Type.exist(type)) {
          throw new TypeException("type " + type + " doesn't exist");
        }
        if (color == null || !Color.exist(color)) {
          throw new ColorException("color " + color + " doesn't exist");
        }

        this.size = size;
        this.type = type;
        this.color = color;
      }
    }

    ArrayList<Plants> plants = new ArrayList<>();
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
