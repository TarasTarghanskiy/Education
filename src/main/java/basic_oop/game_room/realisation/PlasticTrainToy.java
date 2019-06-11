package basic_oop.game_room.realisation;

import basic_oop.game_room.Toy;
import basic_oop.game_room.material.PlasticToy;
import basic_oop.game_room.type.TrainToy;

public class PlasticTrainToy extends Toy implements PlasticToy, TrainToy {
  private boolean onTrack;

  public PlasticTrainToy(int price, String name, int weight) {
    super(price, name, weight);
  }

  @Override
  public boolean isOnTrack() {
    return onTrack;
  }

  @Override
  public void setOnTrack(boolean onTrack) {
    this.onTrack = onTrack;
  }

  @Override
  public void play() {
    if (onTrack) {
      System.out.println("Plastic train "+ super.getName() +" move");
    } else {
      System.out.println("Plastic train " + super.getName() + " isn't on track");
    }
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
