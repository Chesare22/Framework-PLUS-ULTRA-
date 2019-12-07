package framework;

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

public class XMLReader {
    private NodeList createNodeList(String pathName, String tag) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(pathName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(tag);
    }

    private Action[] parseNodeListToActions(NodeList nodeList) throws IllegalAccessException, InvocationTargetException {
        int nodeLength = nodeList.getLength();
        Action[] actions = new Action[nodeLength];

        for (int index = 0; index < nodeLength; index++) {
            Node node = nodeList.item(index);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                String className = element.getElementsByTagName("class").item(0).getTextContent();
                String methodName = element.getElementsByTagName("method").item(0).getTextContent();
                try {
                    actions[index] = new Action(element.getAttribute("id"), className, methodName);
                } catch (ClassNotFoundException e) {
                    System.out.println("No se encontró la clase " + className);
                    System.exit(1);
                } catch (NoSuchMethodException e) {
                    System.out.println("No se encontró el método " + methodName);
                    System.exit(1);
                } catch (InstantiationException e) {
                    System.out.println("El primer constructor para " + className +
                            " recibe parámetros, y el framework no tiene contemplado este caso");
                    System.exit(1);
                }
            }
        }

        return actions;
    }

    public Action[] readActions(String fileName) throws IOException, SAXException, ParserConfigurationException, InvocationTargetException, IllegalAccessException {
        return parseNodeListToActions(createNodeList(fileName, "action"));
    }
}
