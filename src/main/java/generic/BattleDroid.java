package generic;

public class BattleDroid extends Droid {

  public BattleDroid(int id) {
    setId(id);
  }

  @Override
  public String toString() {
    return "BattleDroid#" + getId();
  }
}
