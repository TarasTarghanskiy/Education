package collections.taskD;

public class Door {
  private boolean isEnemy;
  private boolean heroWasHere;
  private int power;

  public Door(boolean isEnemy, int power) {
    this.isEnemy = isEnemy;
    this.heroWasHere = false;
    this.power = power;
  }

  public boolean isEnemy() {
    return isEnemy;
  }

  public boolean isHeroWasHere() {
    return heroWasHere;
  }

  public int getPower() {
    return power;
  }

  public void setHeroWasHere(boolean heroWasHere) {
    this.heroWasHere = heroWasHere;
  }

  @Override
  public String toString() {
    return "\n   Door{" + (isEnemy?"Enemy   " : "Artifact") + ", power=" + power + '}';
  }
}
