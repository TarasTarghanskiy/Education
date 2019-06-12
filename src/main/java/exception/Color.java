package exception;

import java.util.Arrays;

public enum Color {
  RED, BLUE, YELLOW, BLACK, GREEN, ORANGE, COLOR_4;

  static boolean exist(Color color) {
    return Arrays.stream(Color.values()).anyMatch(value -> value == color);
  }
}
