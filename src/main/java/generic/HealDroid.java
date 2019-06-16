package generic;

public class HealDroid extends Droid {

  public HealDroid(int id) {
    setId(id);
  }

  @Override
  public String toString() {
    return "HealDroid#" + getId();
  }
}
