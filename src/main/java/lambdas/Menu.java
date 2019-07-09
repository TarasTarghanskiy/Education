package lambdas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Menu {

  private static HashMap<String, Command> menu = new HashMap<>();
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  static {
    menu.put("play", (name) -> System.out.println("start to play, " + name));
    menu.put("attack", Menu::attack);
    menu.put("heal", new Command() {
      @Override
      public void execute(String name) {
        System.out.println("start to heal, " + name);
      }
    });
    menu.put("o", new CommandClass());
    menu.put("help", (name) -> {
      System.out.println("list of command, " + name);
      menu.keySet().forEach(System.out::println);
    });
  }

  public Menu() {
  }

  public static void run() {
    String name = input("enter name");
    while (true) {
      String s = input("enter string");
      if (s.equals("exit")) {
        return;
      }
      if (menu.get(s) != null) {
        menu.get(s).execute(name);
      } else {
        System.out.println("wrong command");
      }
    }
  }

  static class CommandClass implements lambdas.Command {

    @Override
    public void execute(String name) {
      System.out.println("start to o" + name);
    }
  }

  private static void attack(String name) {
    System.out.println("start to attack" + name);
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
