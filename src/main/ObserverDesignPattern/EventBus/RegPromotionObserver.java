package EventBus;

import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver {
    private PromotionService promotionService;

    @Subscribe
    public void handleRegSuccess(Long userId){
        System.out.println("促销："+userId);
    }
}
