package sample;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class DataHandler extends DefaultHandler {
    private StringBuilder currentValue = new StringBuilder();
    ArrayList<Record> result;
    Record currentRecord;
    private String currentAttr = "";
    Data data = new Data();

    public Data getResult(){
        return data;
    }

    @Override
    public void startDocument(){
        data.records = new ArrayList<Record>();
    }

    @Override
    public void endDocument(){
        // end of this document
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        currentValue.setLength(0);


        if(qName.equalsIgnoreCase("record")){
            currentRecord = new Record();
        }


        if (qName.equalsIgnoreCase("field")) {
            String key = attributes.getValue("key");
            currentRecord.setKey(key);
            currentAttr = attributes.getValue(0);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){



        if (qName.equalsIgnoreCase("title")) {
            data.title = currentValue.toString();
        }

        if (qName.equalsIgnoreCase("xlabel")) {
            data.xAxisLabel = currentValue.toString();
        }

        if(qName.equalsIgnoreCase("field")){
            switch (currentAttr){
                case "Name":
                    currentRecord.setName(currentValue.toString());
                    break;
                case "Country":
                    currentRecord.setCountry(currentValue.toString());
                    break;
                case "Year":
                    currentRecord.setYear(currentValue.toString());
                    break;
                case "Value":
                    currentRecord.setValue(Integer.parseInt(currentValue.toString()));
                    break;
                case "Category":
                    currentRecord.setCategory(currentValue.toString());
                    break;
                default:
                    break;
            }
        }

        if (qName.equalsIgnoreCase("record")) {
            data.records.add(currentRecord);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {

        currentValue.append(ch, start, length);

    }
}

