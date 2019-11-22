package config;

public class Action {
    private final String actionName;
    private final String className;
    private final String methodName;
    private Object instance;

    public Action(String actionName, String className, String methodName) {
        this.actionName = actionName;
        this.className = className;
        this.methodName = methodName;
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
