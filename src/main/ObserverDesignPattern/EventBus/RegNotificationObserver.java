package EventBus;


import MyEventBus.Subscribe;

public class RegNotificationObserver {

    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId){
        System.out.println("通知:"+userId);
    }


}
