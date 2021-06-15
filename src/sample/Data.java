package sample;

import java.util.ArrayList;

public class Data {


    private int success = 0;
    public String title;
    public String xAxisLabel;
    public ArrayList<Integer> recordsNumber = new ArrayList<Integer>();
    public ArrayList<Record> records = new ArrayList<Record>();
    public ArrayList<String> categories = new ArrayList<String>();
    public String type;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
    public  void createCategories(){
        System.out.println("Categories:");
        for (Record record:records) {
            if (categories.contains(record.getCategory())) {
                continue;
            }
            else {
                categories.add(record.getCategory());
            }
        }
        System.out.println(categories.toString());
    }
    public void printRecords(){
        int i = 1;
        int j = 0;
        for (Record record : records){
            System.out.println(record.getYear() + " " + record.getName() +  " " + record.getCountry() + " "  +  record.getValue() + " " + record.getCategory() + " " + i);
            if(type.equals("txt") && i == recordsNumber.get(j)){
                System.out.println("--------------------------------------------------------");
                j++;
                i = 0;
            }else if(type.equals("xml") && i == recordsNumber.get(0)){
                System.out.println("--------------------------------------------------------");
                i = 0;
            }
            i++;
        }
    }

}
