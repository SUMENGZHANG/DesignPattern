package MyEventBus;


import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>>();


    /**
     * 注册
     * @param observer
     */
    public void register(Object observer){

        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for(Map.Entry<Class<?>,Collection<ObserverAction>> entry:observerActions.entrySet()){
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions  = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registerEventActions = registry.get(eventType);
            if(registerEventActions==null){
                registry.putIfAbsent(eventType,new CopyOnWriteArraySet<ObserverAction>());
                registerEventActions = registry.get(eventType);
            }
            registerEventActions.addAll(eventActions);

        }

    }

    public List<ObserverAction> getMatchedObserverActions(Object event){
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for(Map.Entry<Class<?>,CopyOnWriteArraySet<ObserverAction>> entry:registry.entrySet()){
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions  = entry.getValue();
            if(postedEventType.isAssignableFrom(eventType)){
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;

    }


    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>,Collection<ObserverAction>> observerActions = new HashMap<Class<?>, Collection<ObserverAction>>();

        Class<?> clazz  = observer.getClass();
        for(Method method:getAnnotateMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<ObserverAction>());
            }

            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;

    }

    private List<Method> getAnnotateMethods(Class<?> clazz) {
        List<Method> annotationMethods = new ArrayList<Method>();
        for(Method method:clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Subscribe.class)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                annotationMethods.add(method);
            }
        }
        return annotationMethods;
    }


}
