package EventBus;

import com.google.common.base.Objects;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.applet.AudioClip;
import java.util.List;
import java.util.concurrent.Executors;

public class UserController {
    private UserService userService;
    private EventBus eventBus;
    private static final int DEFAULT_POOL_SIZE = 20;

    public UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_POOL_SIZE));
        userService = new UserService();
    }

    public void setRegObserver(List<Object> observers){
        for(Object observer: observers){
            eventBus.register(observer);
        }
    }
    public Long userRegister(String name,String password ){
        long userId = userService.add(name,password);
        eventBus.post(userId);

        return userId;
    }



}
