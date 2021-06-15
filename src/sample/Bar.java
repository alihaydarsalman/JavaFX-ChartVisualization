package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bar implements Comparable<Bar> {
    //Feel free to add other necessary variables
// Creates a new bar.
    long width;
    String name;
    String category;
    int value;
    String country;
    String year;
    Rectangle bar;
    public Bar(String name, String category, int value, String country, String year,long width) {
        this.name = name;
        this.category = category;
        this.value = value;
        this.country = country;
        this.year = year;
        this.bar = new Rectangle(width,25);
        this.bar.setFill(Color.BLACK);
    }
    // Returns the name of this bar.
    public String getName() {
        return  name;
    }
    // Returns the category of this bar.
    public String getCategory() {
        return category;
    }
    // Returns the value of this bar.
    public int getValue() {
        return value;
    }
    public String getCountry() {
        return country;
    }

    public String getYear() {
        return year;
    }
    // Compares two bars by value.
    public int compareTo(Bar other) {
        return Integer.compare(this.value, other.value);
    }
//Feel free to add other necessary method
}
