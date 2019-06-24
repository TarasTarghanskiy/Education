package collections.taskD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Room {

  private List<Door> doorList;

  public Room() {
    this.doorList = new LinkedList<>();
  }

  public void createRandomDoors() {
    for (int i = 0; i < 10; i++) {
      boolean isEnemy = (Math.random() * 100) > 30;
      int power;
      if (isEnemy) power = (int) ((Math.random() * 70) + 10);
      else power = (int) ((Math.random() * 95) + 5);
      doorList.add(new Door(isEnemy, power));
    }
  }

  public List<Door> getDoorList() {
    return new ArrayList<>(doorList);
  }

  @Override
  public String toString() {
    return "Room{" + doorList +
        '}';
  }
}
