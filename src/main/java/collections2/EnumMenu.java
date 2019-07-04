package collections2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public enum EnumMenu {
  CREATE(1,"1) - create tree map", EnumMenu::create),
  ADD(2, "2) - add note", EnumMenu::add),
  SHOW(3, "3) - show", EnumMenu::show),
  REMOVE(4, "4) - remove", EnumMenu::remove),
  EXIT(0, "0) - exit", null);

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static MyTreeMap<Integer, String> myTreeMap;

  private int number;
  private String string;
  private MyMethod myMethod;

  EnumMenu(int n, String s, MyMethod m) {
    number = n;
    string = s;
    myMethod = m;
  }

  public static void call() {
    while (true) {
      Arrays.stream(EnumMenu.values()).map(value -> value.string).forEach(System.out::println);
      int i = inputInteger("choose number");
      if (i == 0) {
        break;
      }
      for (EnumMenu value : EnumMenu.values()) {
        if (value.number == i) {
          value.myMethod.use();
        }
      }
    }
  }

  private static void create() {
    if (myTreeMap != null) {
      if (inputInteger("tree map already exist\n1- delete\nother-back") != 1) {
        return;
      }
    }
    myTreeMap = new MyTreeMap<>(Comparator.comparingInt(Integer::intValue));
    System.out.println("new tree map was created");
  }

  private static void add() {
    if (myTreeMap != null) {
      myTreeMap.put(inputInteger("enter key(integer)"), input("and value(string)"));
    } else {
      System.out.println("tree map does not exist");
    }
  }

  private static void show() {
    myTreeMap.sout();
  }

  private static void remove() {
    myTreeMap.remove(inputInteger("enter key(integer)"));
  }

  private static String input(String s) {
    System.out.print(s + ": ");
    try {
      s = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      input(s);
    }
    return s;
  }

  private static int inputInteger(String s) {
    while (true) {
      try {
        return Integer.valueOf(input(s));
      } catch (NumberFormatException e) {
        System.out.println("enter number");
      }
    }
  }
}
