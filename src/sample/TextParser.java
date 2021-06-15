package sample;

import java.io.*;

public class TextParser extends Parser {
    static Data Parse(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Data data = new Data();

        for (int i = 0; i < 2; i++){
            if (i == 0)
                data.title = reader.readLine();
            else
                data.xAxisLabel = reader.readLine();
        }
        while((line = reader.readLine()) != null){
            if (line.length() >= 2 && line.length() <= 4){
                data.recordsNumber.add(Integer.parseInt(line));
            }else if(line.length() > 1){
                String[] arr = line.split(",");
                Record record = new Record();
                record.setYear(arr[0]);
                record.setName(arr[1]);
                record.setCountry(arr[2]);
                record.setValue(Integer.parseInt(arr[3]));
                record.setCategory(arr[4]);
                data.records.add(record);
            }
        }
        data.type = "txt";
        return data;
    }
}
