package config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Action {
    private final String actionName;
    private Method method;
    private Object instance;

    public Action(String actionName, String className, String methodName) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        this.actionName = actionName;

        Class<?> instanceClass = Class.forName(className);
        Constructor<?>[] cons = instanceClass.getConstructors();
            instance = cons[0].newInstance();


        method = instanceClass.getMethod(methodName, Class.forName("config.Event"));
    }

    public Object getInstance() {
        return instance;
    }

    public Object callMethod(Event event) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(instance, event);
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return "Action: " + actionName;
    }
}
