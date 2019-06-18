package collections;

public class StringContainer {

  private String[] strings;
  private int maxSize;
  private int realSize = 0;

  public StringContainer() {
    this.strings = new String[10];
    this.maxSize = 10;
  }

  public StringContainer(int size) {
    this.strings = new String[size];
    this.maxSize = size;
  }

  public String getString(int i) {
    return strings[i];
  }

  public void addString(String s) {
    if (maxSize == realSize) {
      maxSize = maxSize * 2;
      String[] newStrings = new String[maxSize];
      for (int i = 0; i < strings.length; i++) {
        newStrings[i] = strings[i];
      }
      strings = newStrings;
    }
    strings[realSize] = s;
    realSize++;
  }
}
