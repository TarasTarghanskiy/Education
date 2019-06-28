package generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyPriorityQueue<T extends Droid> {

  private int size = 0;
  private Droid[] droids;
  private Comparator<Droid> comparator;

  public MyPriorityQueue() {
    this.droids = new Droid[10];
  }

  public MyPriorityQueue(int size) {
    if (size <= 0) {
      size = 10;
    }
    this.droids = new Droid[size];
  }

  public MyPriorityQueue(Comparator<Droid> comparator) {
    this.comparator = comparator;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size > 0;
  }

  public boolean contains(Droid d) {
    return indexOf(d) > -1;
  }

  public int indexOf(Droid d) {
    if (d == null) {
      return -1;
    }
    for (int i = 0; i < size; i++) {
      if (droids[i].equals(d)) {
        return i;
      }
    }
    return -1;
  }

  public Droid[] toArray() {
    return Arrays.copyOf(droids, size);
  }

  public void add(Droid d) {
    if (d == null) {
      throw new NullPointerException();
    }
    if (size == droids.length) {
      updateSize();
    }
    droids[size] = d;
    sort();
    size++;
  }

  private void updateSize() {
    Droid[] droids = new Droid[size * 2];
    System.arraycopy(this.droids, 0, droids, 0, size);
    this.droids = droids;
  }

  private void updateSize(int size) {
    Droid[] droids = new Droid[size];
    System.arraycopy(this.droids, 0, droids, 0, this.size);
    this.droids = droids;
  }

  private void sort() {
    if (comparator != null) {
      sortWithComparator();
      return;
    }
    if (size > 1) {
      sortWithComparable();
    }
  }

  private void sortWithComparator() {
    for (int i = size - 1; i >= 0; i--) {
      if (comparator.compare((droids[i]), (droids[i + 1])) < 0) {
        Droid d = droids[i];
        droids[i] = droids[i + 1];
        droids[i + 1] = d;
      } else {
        break;
      }
    }
  }

  private void sortWithComparable(){
    for (int i = size - 1; i >= 0; i--) {
      if (droids[i].compareTo(droids[i + 1]) < 0) {
        Droid d = droids[i];
        droids[i] = droids[i + 1];
        droids[i + 1] = d;
      } else {
        break;
      }
    }
  }

  public boolean remove(Droid d) {
    if (!contains(d)) {
      return false;
    } else {
      if (size - 1 - indexOf(d) >= 0) {
        System.arraycopy(droids, indexOf(d) + 1, droids, indexOf(d), size - 1 - indexOf(d));
        size--;
      }
      return true;
    }
  }

  public boolean addAll(Collection c) {
    if (c.size() + size > droids.length) {
      updateSize(c.size() + size);
    }
    if (c.toArray()[0] instanceof Droid) {
      System.arraycopy(c.toArray(), 0, droids, size, c.size());
      size += c.size();
      return true;
    } else {
      return false;
    }
  }

  public void clear() {
    this.droids = new Droid[10];
    size = 0;
  }

  public T poll() {
    T d = (size == 0) ? null : (T) droids[0];
    remove(d);
    return d;
  }

  public T peek() {
    return (size == 0) ? null : (T) droids[0];
  }
}
