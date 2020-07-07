public class Sington {
    private volatile static Sington uniqueInstance;
    private Sington() {};
    public Sington getSington() {
        if (uniqueInstance == null) {
            synchronized(Singleton.class) {
                if (uniqueInstance == null) 
                uniqueInstance = new Sington();
            }
        }
        return uniqueInstance;
    }
}