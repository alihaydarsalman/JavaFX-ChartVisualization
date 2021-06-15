package sample;

public class Record {


    private String key;
    private String year;
    private String name;
    private String country;
    private int value;
    private String category;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Record{" +
                "key='" + key + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", value=" + value +
                ", category='" + category + '\'' +
                '}';
    }
}
