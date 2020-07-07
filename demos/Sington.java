public class Sington {
    private volatile static Sington uniqueInstance;
    private Sington() {};
    public synchronized Sington getSington() {
        if (uniqueInstance == null) {
            uniqueInstance = new Sington();
        }
        return uniqueInstance;
    }
}