import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        UserRegister userRegister = new UserRegister();
        List<IRegObserver> list = new ArrayList<IRegObserver>();
        list.add(new MidPlatformRegister());
        list.add(new BigDataObserver());
        userRegister.setObservers(list);
        userRegister.register("simon",14);
    }
}
