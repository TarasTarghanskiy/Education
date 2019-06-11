package basic_oop.game_room.material;

public interface IronToy {

  default void hitOnIron() {
    System.out.println("zero damage on iron toy");
  }
}
