import java.util.*;

 public class GenericExample2 {

    public static void main(String[] args) {
      Notepad<String,String> notepad = new Notepad<>();
      notepad.setKey("yukangming");
      notepad.setValue("a handsome boy");
      System.out.println("the name is "+notepad.getKey()+" and the value is "+notepad.getValue());


    }
 }

 class Notepad<K,V> {
   private K key;
   private V value;

   public K getKey() {
     return key;
   }

   public void setKey(K key) {
     this.key = key;
   }

   public V getValue() {
     return value;
   }

   public void setValue(V value) {
     this.value = value;
   }

 }
