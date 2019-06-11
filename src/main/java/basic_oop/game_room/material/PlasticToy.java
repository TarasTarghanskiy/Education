package basic_oop.game_room.material;

public interface PlasticToy {
  default void damagePlasticToy(int weight){
    System.out.println("this plastic toy is too strong");
  }
}
