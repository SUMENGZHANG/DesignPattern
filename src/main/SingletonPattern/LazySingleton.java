public class LazySingleton {

    private static Instance instance;

    public static synchronized Instance getInstance(){
        if(instance==null){
            instance  = new Instance();
        }
        return instance;
    }

}
