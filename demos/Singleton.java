public class Singleton {
    private volatile static Singleton uniquSingleton = new Singleton();
    private Singleton() {};
    public Singleton gSingleton() {
        return uniquSingleton;
    }
}