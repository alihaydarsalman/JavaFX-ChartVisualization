
package sample;

public class Line{
    String name;
    String category;
    int value;
    String country;
    String year;
    // Creates a new line.
    public Line(String name, int value, String category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }
    // Returns the name of this line.
    public String getName(){
        return name;
    }
    // Returns the category of this line.
    public String getCategory() {
        return category;
    }
    //Returns the next value of this line.
    public int nexValue(int nextValue) {
        return nextValue;
    }
}

