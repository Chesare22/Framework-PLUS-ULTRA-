package framework;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ActionInvoker {
    private static final ActionInvoker singleton = new ActionInvoker() ;

    private final HashMap<String, Action> actions = new HashMap<>();

    private ActionInvoker() {
        XMLReader reader = new XMLReader();
        Action[] actionsArray = new Action[0];
        try {
            actionsArray = reader.readActions("src/framework/example/config.xml");
        } catch (InvocationTargetException | SAXException | ParserConfigurationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        for (Action action : actionsArray) {
            actions.put(action.getActionName(), action);
        }
    }

    public static ActionInvoker getInstance() {
        return singleton;
    }

    public Object invokeAction(String actionName, Event event) {
        try {
            return actions.get(actionName).callMethod(event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
