public class MidPlatformRegister implements IRegObserver {

    public void afterRegister(long uid) {
        System.out.println("中台获取用户ID开始工作");
    }
}
