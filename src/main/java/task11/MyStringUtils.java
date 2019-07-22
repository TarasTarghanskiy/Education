package task11;

import java.util.Arrays;

public class MyStringUtils {
private static MyStringUtils m;


  private MyStringUtils(){

  }

  private <T extends Object> String merge(T ... objects){
    return String.join("", Arrays.toString(objects));
  }

  public static <T extends Object> String concat(T ... objects){
    if (m == null) m = new MyStringUtils();
    return m.merge(objects);
  }

}
