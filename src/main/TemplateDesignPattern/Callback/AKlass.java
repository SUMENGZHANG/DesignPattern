package Callback;

public class AKlass {
    public static void main(String[] args) {
        BKlass b  = new BKlass();
        b.setAge(10);
        b.process(new ICallBack() {
            public void methodToCallBack() {
                System.out.println(" Call back me, run A code");
            }
        });
    }
}
