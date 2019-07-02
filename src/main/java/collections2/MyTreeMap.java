package collections2;

import java.util.Comparator;
import java.util.Objects;

public class MyTreeMap<K, V> {

  private Element<K, V> root;
  Comparator<? super K> comparator;
  private int size;
  private int height;

  public MyTreeMap(Comparator<? super K> comparator) {
    this.comparator = comparator;
  }

  public V getValue(K key) {
    Element<K, V> element = find(key);
    if (element == null)
      return null;
    return element.value;
  }

  private Element<K,V> find(K key){
    Element<K, V> pointer = root;
    int cmp;
    while (true) {
      if (pointer == null) {
        return null;
      }
      cmp = comparator.compare(key, pointer.key);
      if (cmp < 0) {
        pointer = pointer.left;
      } else if (cmp > 0) {
        if (pointer.ally == null){
          pointer = pointer.right;
        } else {
          pointer = pointer.ally;
        }
      } else {
        return pointer;
      }
    }
  }

  public void put(K key, V value) {
    if (key == null) {
      throw new NullPointerException();
    }
    if (root == null) {
      root = new Element<>(key, value);
      size = 1;
      height = 1;
    } else {
      insert(key, value);
    }
  }

  private void insert(K key, V value) {
    Element<K, V> pointer = root;
    while (true) {
      if (pointer.left == null) {
        addNewElement(new Element<>(key, value), pointer);
        break;
      }
      int cmp = this.comparator.compare(key, pointer.key);
      if (cmp < 0) {
        pointer = pointer.left;
      } else if (cmp > 0) {
        if (pointer.ally != null) {
          pointer = pointer.ally;
        } else {
          pointer = pointer.right;
        }
      } else {
        pointer.value = value;
        break;
      }
    }
  }

  private void swap(Element<K, V> element1, Element<K, V> element2) {
    K key = element1.key;
    V value = element1.value;
    element1.key = element2.key;
    element1.value = element2.value;
    element2.key = key;
    element2.value = value;
  }

  private void addNewElement(Element<K, V> unstableElement, Element<K, V> thisElement) {
    int cmp = this.comparator.compare(unstableElement.key, thisElement.key);
    int allyCmp = 0;
    if (thisElement.ally != null) {
      allyCmp = this.comparator.compare(unstableElement.key, thisElement.ally.key);
    }

    if (cmp == 0) {
      thisElement.value = unstableElement.value;
      return;
    } else if (cmp < 0) {
      swap(unstableElement, thisElement);
    }

    if (thisElement.ally == null) {
      thisElement.ally = unstableElement;
      size++;
    } else if (thisElement.ally != null && allyCmp < 0) {
      updateTree(unstableElement, thisElement);
      size++;
    } else if (thisElement.ally != null && allyCmp > 0) {
      Element<K, V> swap = thisElement.ally;
      thisElement.ally = unstableElement;
      updateTree(swap, thisElement);
      size++;
    } else if (thisElement.ally != null && allyCmp == 0) {
      thisElement.ally.value = unstableElement.value;
    }
  }

  private void updateTree(Element<K, V> unstableElement, Element<K, V> thisElement) {
    Element<K, V> parent = thisElement.parent;
    while (true) {
      if (parent == null) {
        root = unstableElement;
        unstableElement.left = thisElement;
        unstableElement.right = thisElement.ally;
        thisElement.parent = unstableElement;
        thisElement.ally.parent = unstableElement;
        if (thisElement.ally.left != null) {
          thisElement.ally.left.parent = thisElement.ally;
          thisElement.ally.right.parent = thisElement.ally;
        }
        thisElement.ally = null;
        height++;
        break;
      }

      int cmp = this.comparator.compare(unstableElement.key, parent.key);
      int allyCmp = 0;
      if (parent.ally != null) {
        allyCmp = this.comparator.compare(unstableElement.key, parent.ally.key);
      }

      if (cmp < 0 && parent.ally == null) {
        swap(unstableElement, parent);
        parent.ally = unstableElement;
        unstableElement.right = parent.right;
        parent.right = thisElement.ally;
        unstableElement.left = thisElement.ally;
        thisElement.ally.parent = parent;
        thisElement.ally = null;
        break;
      } else if (cmp < 0 && parent.ally != null) {
        swap(unstableElement, parent);
        parent.right = thisElement.ally;
        thisElement.ally.parent = parent;
        if (thisElement.ally.left != null) {
          thisElement.ally.left.parent = thisElement.ally;
          thisElement.ally.right.parent = thisElement.ally;
        }
        thisElement.ally = null;

        thisElement = parent;
        parent = parent.parent;
      } else if (cmp > 0 && parent.ally == null) {
        parent.ally = unstableElement;
        unstableElement.right = thisElement.ally;
        unstableElement.left = thisElement;
        parent.right = thisElement;
        thisElement.ally.parent = parent;
        if (thisElement.ally.left != null) {
          thisElement.ally.left.parent = thisElement.ally;
          thisElement.ally.right.parent = thisElement.ally;
        }
        thisElement.ally = null;
        break;
      } else if (cmp > 0 && parent.ally != null && allyCmp < 0) {
        parent.ally.left = thisElement.ally;
        parent.right = thisElement;
        thisElement.ally.parent = parent;
        if (thisElement.ally.left != null) {
          thisElement.ally.left.parent = thisElement.ally;
          thisElement.ally.right.parent = thisElement.ally;
        }
        thisElement.ally = null;

        thisElement = parent;
        parent = parent.parent;
      } else if (cmp > 0 && parent.ally != null && allyCmp > 0) {
        swap(parent.ally, unstableElement);
        parent.ally.right = thisElement.ally;
        parent.ally.left = thisElement;
        thisElement.ally.parent = parent;
        if (thisElement.ally.left != null) {
          thisElement.ally.left.parent = thisElement.ally;
          thisElement.ally.right.parent = thisElement.ally;
        }
        thisElement.ally = null;

        thisElement = parent;
        parent = parent.parent;
      }
    }
  }

  public void remove(K key){
    Element<K,V> element = find(key);
    if (element != null)
      element.value = null;
  }

  class Element<K, V> {

    K key;
    V value;
    Element<K, V> ally;
    Element<K, V> parent;
    Element<K, V> right;
    Element<K, V> left;


    public Element(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Element<?, ?> element = (Element<?, ?>) o;
      return Objects.equals(key, element.key) &&
          Objects.equals(value, element.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }

    @Override
    public String toString() {
      return "Element{" +
          "key=" + key +
          ", value=" + value +
          '}';
    }
  }

  public void sout() {
    int height = (this.height * 3);
    sout(height, root);
    System.out.println();
  }

  private void sout(int height, Element<K, V> pointer) {
    if (pointer != null) {
      height -= 3;
      sout(height, pointer.left);
      for (int i = 0; i < height; i++) {
        System.out.print("  ");
      }
      System.out.println(pointer.key + "-" + pointer.value);
      sout(height, pointer.right);
      if (pointer.ally != null) {
        for (int i = 0; i < height; i++) {
          System.out.print("  ");
        }
        System.out.println(pointer.ally.key + "-" + pointer.ally.value);
        sout(height, pointer.ally.right);
      }
    }
  }
}
