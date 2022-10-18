package EventBus;

import MyEventBus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        RegNotificationObserver observer   = new RegNotificationObserver();
        Class<?> clazz =  observer.getClass();
        List<Method> list = getAnnotateMethods(clazz);
        System.out.println(list.get(0).getParameterTypes());

    }

    private static List<Method> getAnnotateMethods(Class<?> clazz) {
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
