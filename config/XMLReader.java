package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XMLReader {
    public NodeList createNodeList(String pathName, String tag) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(pathName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(tag);
    }

    public Action[] parseNodeListToActions(NodeList nodeList){
        int nodeLength = nodeList.getLength();
        Action[] actions = new Action[nodeLength];

        for (int index = 0; index < nodeLength; index++) {
            Node node = nodeList.item(index);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                Node param = element.getElementsByTagName("param-type").item(0);
                if(param == null){
                    actions[index] = new Action(
                            element.getAttribute("id"),
                            element.getElementsByTagName("class").item(0).getTextContent(),
                            element.getElementsByTagName("method").item(0).getTextContent()
                    );
                }else{
                    actions[index] = new Action(
                            element.getAttribute("id"),
                            element.getElementsByTagName("class").item(0).getTextContent(),
                            element.getElementsByTagName("method").item(0).getTextContent(),
                            param.getTextContent()
                    );
                }

            }
        }

        return actions;
    }

    // Just for testing purposes
    public static void main(String[] args) {
        XMLReader reader = new XMLReader();
        Action[] actions;
        try {
            actions = reader.parseNodeListToActions(reader.createNodeList("config.xml", "action"));
            for (Action action : actions) {
                System.out.println(action);
                try {
                    action.createMethod();
                    action.createInstance();
                    Method method = action.getMethod();
                    method.invoke(action.getInstance(), new Event("Rico", 0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
