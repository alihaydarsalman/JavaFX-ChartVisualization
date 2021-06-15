package sample;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class XMLParser extends Parser{
    static Data Parse(File file) {
        Data data;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        DataHandler dataHandler = new DataHandler();
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(file, dataHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        data = dataHandler.getResult();
        data.type = "xml";
        return data;
    }
    static Data Parse(String url) {
        Data data = new Data();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        DataHandler dataHandler = new DataHandler();
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(url, dataHandler);
            data = dataHandler.getResult();
            data.setSuccess(1);
            data.type = "xml";
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // e.printStackTrace();
        }
        return data;
    }


}
