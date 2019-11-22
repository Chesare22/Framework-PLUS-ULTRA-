package config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Action {
    private final String actionName;
    private final String className;
    private final String methodName;
    private String paramTypeName;
    private Method method;
    private Object instance;

    public Action(String actionName, String className, String methodName) {
        this.actionName = actionName;
        this.className = className;
        this.methodName = methodName;
    }
    public Action(String actionName, String className, String methodName, String paramTypeName) {
        this.actionName = actionName;
        this.className = className;
        this.methodName = methodName;
        this.paramTypeName = paramTypeName;
    }

    public void createInstance() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName(className);
        Constructor<?>[] cons = c.getConstructors();
        instance = cons[0].newInstance();
    }
    public Object getInstance() {
        return instance;
    }

    public void createMethod() throws ClassNotFoundException,  NoSuchMethodException {
        Class<?> c = Class.forName(className);
        if(paramTypeName == null){
            method = c.getMethod(methodName);
        }else{
            method = c.getMethod(methodName, Class.forName(paramTypeName));
        }
    }

    public Method getMethod() {
        return method;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return "Action: " + actionName +
                "\n  Class: " + className +
                "\n  Method: " + methodName;
    }
}
