public class DoubleCheckSingleTon {
    private static Instance instance;

    public static Instance getInstance(){
        if(instance==null){
            synchronized (DoubleCheckSingleTon.class){
                if(instance==null){
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

}
