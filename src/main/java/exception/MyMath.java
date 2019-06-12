package exception;

class MyMath implements AutoCloseable {

  public MyMath() {
  }

  int squareRectangle(int a, int b) throws MyException {
    if (a < 0 || b < 0) {
      throw new MyException("incorrect number " + (a < 0 ? "a" : "b"));
    }
    return a * b;
  }

  @Override
  public void close() throws Exception {
    System.out.println("math class was closed");
  }
}
