package generic;

import java.util.Comparator;

public class DroidComparator implements Comparator<Droid> {

  @Override
  public int compare(Droid o1, Droid o2) {

    return o1.getId() - o2.getId();
  }
}
