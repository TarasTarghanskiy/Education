package basic_oop.game_room.implementation;

import basic_oop.game_room.Toy;
import basic_oop.game_room.material.IronToy;
import basic_oop.game_room.type.TrainToy;

public class IronTrainToy extends Toy implements TrainToy, IronToy {

  private boolean onTrack;


  public IronTrainToy(int price, String name, int weigth) {
    super(price, name, weigth);
  }

  public void hitOnIron() {
    System.out.println("you hit iron train");
  }

  public void play() {
    if (onTrack) {
      System.out.println("Iron train " + super.getName() + " move");
    } else {
      System.out.println("Iron train " + super.getName() + " isn't on track");
    }
  }

  public boolean isOnTrack() {
    return onTrack;
  }

  public void setOnTrack(boolean onTrack) {
    this.onTrack = onTrack;
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
