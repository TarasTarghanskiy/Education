package exception;

import java.util.Arrays;

public enum Type {
  ROSE, ORCHID, TYPE_2, TYPE_3, TYPE_6;

  static boolean exist(Type type) {
    return Arrays.stream(Type.values()).anyMatch(value -> value == type);
  }

}
