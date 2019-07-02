package collections2;

public class Elem {
  private String string;
  private MyMethod myMethod;

  public Elem(String string, MyMethod myMethod) {
    this.string = string;
    this.myMethod = myMethod;
  }

  public void use(){
    myMethod.use();
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public MyMethod getMyMethod() {
    return myMethod;
  }

  public void setMyMethod(MyMethod myMethod) {
    this.myMethod = myMethod;
  }

  @Override
  public String toString() {
    return  string ;
  }
}
