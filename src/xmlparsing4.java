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

public class xmlparsing4 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("laptops.xml"));
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("laptop");
        for (int i = 0;i< nodeList.getLength();i++){
            Node laptop = nodeList.item(i);
            if(laptop.getNodeType() == Node.ELEMENT_NODE){
                Element laptopElement = (Element) laptop;
                System.out.println(laptopElement.getAttribute("name"));
            }
            NodeList nodeList1 = laptop.getChildNodes();
            for (int j =0;j<nodeList1.getLength();j++ ){
                Node laptopDetails = nodeList1.item(j);
                if(laptopDetails.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) laptopDetails;
                    System.out.println(element.getTagName()+"--"+element.getAttribute("value"));
                }
            }
        }

    }
}
