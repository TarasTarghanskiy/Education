package basic_oop.game_room.implementation;

import basic_oop.game_room.Toy;
import basic_oop.game_room.material.PlasticToy;
import basic_oop.game_room.type.WarriorToy;

public class PlasticWarriorToy extends Toy implements WarriorToy, PlasticToy {


  public PlasticWarriorToy(int price, String name, int weight) {
    super(price, name, weight);
  }

  public void damagePlasticToy(int weight) {
    if (super.getWeight() - weight > 0) {
      System.out.println("plastic warrior toy " + super.getName() + " was damaged");
      super.setWeight(super.getWeight() - weight);
    } else {
      System.out.println("too much damage");
    }
  }

  public void battleCry() {
    System.out.println("I'm plastic warrior toy " + super.getName() + " and it's my battle cry");
  }

  @Override
  public void play() {
    System.out.println("Plastic warrior toy " + super.getName() + " is moving");
  }

  @Override
  public int getPrice() {
    return super.getPrice();
  }

  @Override
  public void setPrice(int price) {
    super.setPrice(price);
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }

  @Override
  public int getWeight() {
    return super.getWeight();
  }

  @Override
  public void setWeight(int weight) {
    super.setWeight(weight);
  }
}
