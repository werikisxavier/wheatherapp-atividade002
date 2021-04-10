package model.impli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.WeatherData;
import model.interfaces.Log;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLLog implements Log {

    private static Log instence = null;
    private File file = null;

    public static Log getInstance() {
        if (instence == null) {
            instence = new XMLLog();
        }
        return instence;
    }

    @Override
    public void escreve(String operation, WeatherData weatherdata) {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element element = document.createElement(operation);
            document.appendChild(element);

            Node weather = document.getFirstChild();

            //CRIANDO NODE
            Element dados = document.createElement("Dados");
            weather.appendChild(dados);

            //TEMPERARATURA
            Attr temperature = document.createAttribute("Temperatura");
            temperature.setValue(String.valueOf(weatherdata.getTemperature()));
            dados.setAttributeNode(temperature);

            //HUMIDADE
            Attr humidity = document.createAttribute("Humidade");
            humidity.setValue(String.valueOf(weatherdata.getHumidity()));
            dados.setAttributeNode(humidity);

            //HUMIDADE
            Attr pressure = document.createAttribute("Pressão");
            pressure.setValue(String.valueOf(weatherdata.getPressure()));
            dados.setAttributeNode(pressure);

            //HUMIDADE
            Attr date = document.createAttribute("Data");
            date.setValue(String.valueOf(weatherdata.getDate()));
            dados.setAttributeNode(date);
   
            String path = "out.xml";

            FileWriter fileWritter = new FileWriter(new File(path), true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(bufferWritter);
             
            transformer.transform(source, result);


        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

}
