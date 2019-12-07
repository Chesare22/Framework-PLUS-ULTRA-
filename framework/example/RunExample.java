package framework.example;

import framework.ActionInvoker;
import framework.Event;

public class RunExample {
    public static void main(String[] args) {
        ActionInvoker invoker = ActionInvoker.getInstance();
        invoker.invokeAction("add_vote", new Event("Rico", 2));
    }
}
