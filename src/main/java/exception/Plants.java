package exception;

public class Plants {

  int size;
  Type type;
  Color color;

  public Plants(int size, Type type, Color color) throws TypeException, ColorException {
    if (type == null || !Type.exist(type) || color == null || !Color.exist(color)) {
      throw new TypeException((Type.exist(type)? "type " + type : "color " + color)  + " doesn't exist");
    }

    this.size = size;
    this.type = type;
    this.color = color;
  }
}
