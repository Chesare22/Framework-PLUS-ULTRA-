package example;

import config.Action;
import config.Event;
import config.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class RunExample {
    public static void main(String[] args) {
        XMLReader reader = new XMLReader();
        Action[] actions;
        try {
            actions = reader.readActions("config.xml");
            actions[0].callMethod(new Event("Rico", 2));
        } catch (ParserConfigurationException | InvocationTargetException | IllegalAccessException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
