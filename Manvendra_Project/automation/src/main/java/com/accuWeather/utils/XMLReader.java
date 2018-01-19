package com.accuWeather.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Manvendra Singh
 */

public class XMLReader
{
    /**
     * get all dom elements present in XML corresponding to elementName
     * @param fileName
     * @param elementName
     * @return map consisting all dom elements representing elementName
     */
    protected HashMap<String, String> getDOMElements(String fileName, String elementName)
    {
        HashMap<String, String> domElements = new HashMap<String, String>();
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/main/java/com/accuWeather/" + fileName));

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for(int i=0; i<nodeList.getLength(); i++)
            {
                Node parentElementNode = nodeList.item(i);
                if(parentElementNode.getNodeName().equals("element"))
                {
                    String attName = parentElementNode.getAttributes().item(0).getTextContent();

                    if(attName.equals(elementName))
                    {
                        NodeList childDomNodes =  parentElementNode.getChildNodes();
                        for(int j=0; j<childDomNodes.getLength(); j++)
                        {
                            String childNodeName = childDomNodes.item(j).getNodeName();
                            String childNodeContent = childDomNodes.item(j).getTextContent();
                          if(childNodeName.equals("id"))
                            {
                                domElements.put("id", childNodeContent);
                            }
                            else if(childNodeName.equals("name"))
                            {
                                domElements.put("name", childNodeContent);
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return domElements;
    }

}
