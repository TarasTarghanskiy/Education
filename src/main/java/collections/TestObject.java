package collections;

public class TestObject {
  private String firstString;
  private String secondString;

  public TestObject(String firstString, String secondString) {
    this.firstString = firstString;
    this.secondString = secondString;
  }

  public String getFirstString() {
    return firstString;
  }

  public void setFirstString(String firstString) {
    this.firstString = firstString;
  }

  public String getSecondString() {
    return secondString;
  }

  public void setSecondString(String secondString) {
    this.secondString = secondString;
  }

  @Override
  public String toString() {
    return "\nTestObject{" +
        "firstString='" + firstString + '\'' +
        ", secondString='" + secondString + '\'' +
        '}';
  }
}
