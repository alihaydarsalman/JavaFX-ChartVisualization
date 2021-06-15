
package sample;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public abstract class Chart {
    //Feel free to add other necessary variables
    private String title;
    private String xAxisLabel;

    final NumberAxis xAxis = new NumberAxis();
    final CategoryAxis yAxis = new CategoryAxis();

    public CategoryAxis getyAxis() {
        return yAxis;
    }

    public NumberAxis getxAxis() {
        return xAxis;
    }

    public Chart(String title, String xAxisLabel) {
        this.title = title;
        this.xAxisLabel = xAxisLabel;
    }
    // Sets the caption of this chart.
    public void setCaption(String caption) {
        title = caption;
    }
    // Removes all of the records from this chart.
    public void reset() {

    }


//Feel free to add other necessary method
}
