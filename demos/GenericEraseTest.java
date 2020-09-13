import java.util.*;

public class GenericEraseTest {

  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("yukangming is a good boy");

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(1540622095);

    System.out.println(list1.getClass() == list2.getClass());

    ArrayList<Integer> list3 = new ArrayList<>();
    list3.add(101804694);
    try {
      list3.getClass().getMethod("add", Object.class).invoke(list3, "yukangming work hard");

    }catch(Exception e) {
        System.out.println("there is a exception");
    }
    for (int i = 0; i < list3.size(); i ++) {
      System.out.println(list3.get(i));
    }
  }
}
