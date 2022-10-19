

public class HungrySingleton {
    private static final Instance instance = new Instance();

    public static Instance getInstance(){
        return instance;
    }
}
