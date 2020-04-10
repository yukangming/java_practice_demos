package emailapp;

public class EmailApp{

public static void main(String[] args) {
    Email eml = new Email("Tohn","Smith");

    //eml.setMailboxCapacity(600);
    System.out.println(eml.showInfo());
    
} 
}