package lambdas;

@FunctionalInterface
public interface ThreeValues {
  int threeValues(int first, int second, int three);
  static int average(int a, int b, int c ){
    return b;
  }
}
