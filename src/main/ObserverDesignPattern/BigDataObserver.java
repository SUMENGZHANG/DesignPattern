public class BigDataObserver implements IRegObserver {
    public void afterRegister(long uid) {
        System.out.println("BI获取用户数据开始工作");
    }
}
