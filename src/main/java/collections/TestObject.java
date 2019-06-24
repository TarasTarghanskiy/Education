package collections;

import java.util.Comparator;

public class TestObject implements Comparable<TestObject> {

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

  @Override
  public int compareTo(TestObject o) {
    return Integer.valueOf(firstString) - Integer.valueOf(o.firstString);
  }
}
