package collections;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyDeque<E> {

  private Object[] dequeList;
  private int last;
  private int first;

  public MyDeque() {
    this.dequeList = new Object[10];
    this.last = 5;
    this.first = 5;
  }

  public void addFirst(E e) {
    if (e == null) {
      throw new NullPointerException();
    }
    if (first == 0) {
      updateSize();
    }
    if (dequeList[first] == null) {
      first++;
    }
    first--;
    dequeList[first] = e;
  }


  public void addLast(E e) {
    if (e == null) {
      throw new NullPointerException();
    }
    if (last == dequeList.length - 1) {
      updateSize();
    }
    if (dequeList[last] == null) {
      last--;
    }
    last++;
    dequeList[last] = e;
  }

  private void updateSize() {
    int size = size();
    Object[] newDequeList = new Object[dequeList.length * 2];
    int newFirst = ((newDequeList.length - size) / 2);
    this.last = newFirst + size-1;
    System.arraycopy(dequeList, first, newDequeList, newFirst, size);
    this.first = newFirst;
    this.dequeList = newDequeList;
  }

  public E removeFirst() {
    E e = pollFirst();
    if (e == null) {
      throw new NoSuchElementException();
    }
    return e;
  }

  public E removeLast() {
    E e = pollLast();
    if (e == null) {
      throw new NoSuchElementException();
    }
    return e;
  }

  public E pollFirst() {
    if (dequeList[first] == null) {
      return null;
    }
    E e = (E) dequeList[first];
    dequeList[first] = null;
    if (dequeList[first + 1] != null) {
      first++;
    }
    return e;
  }

  public E pollLast() {
    if (dequeList[last] == null) {
      return null;
    }
    E e = (E) dequeList[last];
    dequeList[last] = null;
    if (dequeList[last - 1] != null) {
      last--;
    }
    return e;
  }

  public E getFirst() {
    E e = peekFirst();
    if (e == null) {
      throw new NoSuchElementException();
    }
    return e;
  }

  public E getLast() {
    E e = peekLast();
    if (e == null) {
      throw new NoSuchElementException();
    }
    return e;
  }

  public E peekFirst() {

    if (dequeList[first] == null) {
      return null;
    }
    return (E) dequeList[first];
  }

  public E peekLast() {
    if (dequeList[last] == null) {
      return null;
    }
    return (E) dequeList[last];
  }

  public boolean removeFirstOccurrence(Object o) {
    if (o == null) {
      return false;
    }
    for (int i = first; i <= last; i++) {
      if (dequeList[i] != null && o.equals(dequeList[i])) {
        delete(i);
        return true;
      }
    }
    return false;
  }

  public boolean removeLastOccurrence(Object o) {
    if (o == null) {
      return false;
    }
    for (int i = last; i >= first; i--) {
      if (dequeList[i] != null && o.equals(dequeList[i])) {
        delete(i);
        return true;
      }
    }
    return false;
  }

  private boolean delete(int i) {
    if (dequeList[i] == null && (i < first || i > last)) {
      return false;
    }
    System.arraycopy(dequeList, first, dequeList, first + 1, i - first);
    first++;
    return true;
  }

  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }

  public boolean addAll(Collection<? extends E> c) {
    Object[] objects = c.toArray();
//    if (objects.length + size() < dequeList.length){
//      Object[] newDecueList = new Object[objects.length+size()];
//      System.arraycopy(objects, 0, newDecueList, 0, objects.length);
//      System.arraycopy(dequeList, first, newDecueList, objects.length, size());
//      dequeList = newDecueList;
//    } else
    for (int i = 0; i < objects.length; i++) {
      addLast((E) objects[i]);
    }
    return false;
  }

  public void removeAll(Collection<?> c) {
    Object[] objects = c.toArray();
    for (Object object : objects) {
      while (contains(object)) {
        removeFirstOccurrence(object);
      }
    }
  }

  public void retainAll(Collection<?> c) {
    Object[] objects = c.toArray();
    for (int i = first; i < last; i++) {
      if (dequeList[i] == null) {
        continue;
      }
      if (!c.contains(dequeList[i])) {
        delete(i);
      }
    }
  }

  public void clear() {
    this.dequeList = new Object[10];
    this.last = 5;
    this.first = 4;
  }

  public boolean contains(Object o) {
    if (o == null) {
      return false;
    }
    for (int i = first; i <= last; i++) {
      if (dequeList[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  public int size() {
    if (last == first && dequeList[last] == null) {
      return 0;
    }
    return 1 + last - first;
  }

  public boolean isEmpty() {
    return dequeList[last] == null && dequeList[first] == null;
  }

  public Object[] toArray() {
    Object[] objects = new Object[size()];
    System.arraycopy(dequeList, first, objects, 0, size());
    return objects;
  }

  @Override
  public String toString() {
    return "MyDeque{" +
        "size=" + dequeList.length +
        ", real size = " + size() +
        ", last=" + last +
        ", first=" + first +
        '}';
  }
}
