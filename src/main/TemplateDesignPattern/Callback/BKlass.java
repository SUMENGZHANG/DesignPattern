package Callback;

public class BKlass {

    private int age;
    public void setAge(int age){

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void process(ICallBack callBack){
        System.out.println("run b code"+age);
        callBack.methodToCallBack();
    }
}
