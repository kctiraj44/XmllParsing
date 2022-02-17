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

public class XmlParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("laptops.xml"));

       document.getDocumentElement().normalize();

       NodeList nodeList = document.getElementsByTagName("laptop");

       for (int i =0;i<nodeList.getLength();i++){
          Node laptop =   nodeList.item(i);

          if(laptop.getNodeType() == Node.ELEMENT_NODE){
              Element laptopElement = (Element) laptop;
              System.out.println("*-----------------------------------------");
              System.out.println("The laptop name :"+laptopElement.getAttribute("name"));


              NodeList laptopDetails =  laptop.getChildNodes();
               for (int j = 0;j<laptopDetails.getLength();j++){
                  Node details =  laptopDetails.item(j);
                  if(details.getNodeType() ==Node.ELEMENT_NODE){
                      Element detailElement = (Element) details;
                      System.out.println("The laptop details :"+detailElement.getTagName()+"---"+detailElement.getAttribute("value"));
                  }
               }
          }

       }


    }
}
