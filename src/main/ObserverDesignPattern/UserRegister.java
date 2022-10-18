import java.util.List;

public class UserRegister {

    private List<IRegObserver> observers;


    public void setObservers(List<IRegObserver> observers) {
        this.observers = observers;
    }

    public void register(String name, Integer age) {

        // store user info
        UserService userService = new UserService();
        long uid = userService.add(name, age);
        // then
        for (IRegObserver observer : observers) {
            observer.afterRegister(uid);
        }
    }

}
