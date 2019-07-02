package collections2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;

public class Menu {

  private static HashMap<Integer, Elem> map;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static MyTreeMap<Integer, String> myTreeMap;

  static {
    map = new HashMap<>();
    map.put(1, new Elem("1) - create tree map", Menu::create));
    map.put(2, new Elem("2) - add note", Menu::add));
    map.put(3, new Elem("3) - show", Menu::show));
    map.put(4, new Elem("4) - remove", Menu::remove));
    map.put(0, new Elem("0) - exit", null));
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

  private Menu() {
  }

  public static void call(){
    while (true) {
      map.forEach((integer, elem) -> System.out.println(elem));
      int i = inputInteger("choose number");
      if (i == 0) break;
      map.get(i).use();
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
