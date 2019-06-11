package basic_oop.game_room;

public abstract class Toy {

  private int price;
  private String name;
  private int weight;

  public Toy(int price, String name, int weight) {
    this.price = price;
    this.name = name;
    this.weight = weight;
  }

  public abstract void play();

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
