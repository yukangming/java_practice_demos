import java.util.*;

public class GenericExample {

  public static void main(String[] args) {
      Point<String> point = new Point<>();
      point.setVar("yukangming");
      System.out.println(point.getVar());
  }
}

class Point<T> {
    private T var;

    public T getVar() {
      return var;
    }

    public void setVar(T var) {
      this.var = var;
    }
}
