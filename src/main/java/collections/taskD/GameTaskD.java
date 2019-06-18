package collections.taskD;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameTaskD {
  /* D. Герой комп'ютерної гри, що володіє силою в 25 балів, знаходиться в круглому залі,
  з якого ведуть 10 закритих дверей. За кожними дверима героя чекає або магічний артефакт,
  що дарує силу від 10 до 80 балів, або монстр, який має силу від 5 до 100 балів, з яким
  герою потрібно битися. Битву виграє персонаж, що володіє найбільшою силою;
  якщо сили рівні, перемагає герой.
  1. Організувати введення інформації про те, що знаходиться за дверима, або заповнити її,
  використовуючи генератор випадкових чисел.
  2. Вивести цю саму інформацію на екран в зрозумілому табличному вигляді.
  3. Порахувати, за скількома дверима героя чекає смерть. Рекурсивно.
  4. Вивести номери дверей в тому порядку, в якому слід їх відкривати герою, щоб залишитися в живих, якщо таке можливо. */

  public void start() {
    Room room = new Room(); //1
    System.out.println(room); //2
    System.out.println("count of emergency doors: " + doorsObserve(room.getDoorList())); //3
    play(room.getDoorList()); //4
  }

  private int doorsObserve(List<Door> doorList) {
    if (doorList.isEmpty()) {
      return 0;
    }
    Door door = doorList.get(0);
    doorList.remove(0);

    if (door.isEnemy() && door.getPower() > 25) {
      return 1 + doorsObserve(doorList);
    } else {
      return doorsObserve(doorList);
    }
  }

  private void play(List<Door> doorList) {
    Map<Door, Integer> winMap = new LinkedHashMap<>();
    int heroPower = 25;
    boolean someChange = false;
    while (true) {
      for (Door door : doorList) {
        if (!door.isEnemy() || door.getPower() <= heroPower) {
          if (!door.isEnemy()) {
            heroPower += door.getPower();
          }
          winMap.put(door, heroPower);
          someChange = true;
        }
      }
      doorList.removeAll(winMap.keySet());
      if (someChange) {
        someChange = false;
      } else {
        break;
      }
    }
    if (!doorList.isEmpty()) {
      System.out.println("hero will die anyway");
    } else {
      System.out.println("way for hero winning:\n" + winMap);
    }
  }
}
