package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;

public class BarChart extends Chart{
    private Color[] colorArray = {Color.web("#008080"), Color.web("#556b2f"), Color.web("#800000"), Color.web("#483d8b"), Color.web("#008000"), Color.web("#008080"), Color.web("#b8860b"), Color.web("#000080"), Color.web("#9acd32"), Color.web("#8b008b"), Color.web("#ff0000"), Color.web("#00ced1"), Color.web("#00ff00"), Color.web("#00fa9a"), Color.web("#8a2be2"), Color.web("#00ffff"), Color.web("#00bfff"), Color.web("#0000ff"), Color.web("#ff00ff"), Color.web("#1e90ff"), Color.web("#db7093"), Color.web("#f0e68c"), Color.web("#ff1493"), Color.web("#ffa07a"), Color.web("#ee82ee")};
    private HashMap<String, Color> colorMap= new HashMap<String, Color>();
    int startStop = 0;
    int isFinished = 0;
    static int status = 0;
    int i, k = 0;
    Text barText;
    Text valueText;
    Timeline timeline = new Timeline();
    ArrayList<Record> topTen = new ArrayList<Record>();
    long  maxValue;
    ArrayList<Text> values = new ArrayList<Text>();
    ArrayList<Bar> barList = new ArrayList<Bar>();
    ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
    ArrayList<Text> barTextList = new ArrayList<Text>();
    ArrayList<Text> categories = new ArrayList<Text>();
    public BarChart(String title, String xAxisLabel,Text titleText,Text labelText) {
        super(title, xAxisLabel);
        getxAxis().setLabel(xAxisLabel);
        getyAxis().setLabel("y-axis");
        titleText.setText(title);
        labelText.setText(xAxisLabel);
    }
    public void createBarChart(Data data, FlowPane flowPane, VBox vBox, VBox vBoxText, VBox vBoxValue, Button AnimationButton,Text textYear){
        maxValue = data.type.equals("txt") ?  (data.records.get(data.records.size()-data.recordsNumber.get(data.recordsNumber.size()-1)).getValue()) : (data.records.get(data.records.size()-data.recordsNumber.get(data.recordsNumber.size()-2)).getValue());
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        if (status == 1) {
            k = 0;
            categories.clear();
            timeline.getKeyFrames().clear();
            flowPane.getChildren().clear();
        }

        for (int i = 0; i < data.categories.size();i++) {
            categories.add(new Text(data.categories.get(i)));
            colorMap.put(data.categories.get(i), colorArray[i]);
            categories.get(i).setFill(colorMap.get(data.categories.get(i)));

        }
        flowPane.getChildren().addAll(categories);
        startStop++;
        if (isFinished!=1 && startStop % 2 == 0 && !AnimationButton.getText().equals("Start Animation")){
            k = 0;
            timeline.stop();
            AnimationButton.setText("Restart Animation");
            return;
        }
        for (i = 0;(data.type.equals("xml") && i <= data.recordsNumber.get(1)) || i <= data.recordsNumber.size();i++){

            this.status = 1;
            vBox.setSpacing(20);
            vBox.setStyle("-fx-background-color: #c3c3c3;");
            vBoxText.setSpacing(30);
            vBoxValue.setSpacing(30);

            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i * 100), actionEvent -> {
                if (i >= 0 && (i <= data.recordsNumber.size() || (data.type.equals("xml") && i <= data.recordsNumber.get(1)))){

                    if (data.type.equals("txt")) {
                        k += data.recordsNumber.get(data.recordsNumber.size() - (i));
                    }
                    else {
                        k += data.recordsNumber.get(0);
                    }
                }
                for (int j = k; j < k + 10;j++) {
                    Record record = data.records.get(j);
                    Bar bar = new Bar(record.getName(),record.getCategory(),record.getValue(),record.getCountry(),record.getYear(), ((long) (record.getValue() * vBox.getWidth()) / maxValue));
                    barList.add(bar);
                    topTen.add(record);
                    bar.bar.setFill(colorMap.get(bar.getCategory()));
                    rect.add(bar.bar);
                    valueText = new Text(String.valueOf(record.getValue()));
                    valueText.setFont(new Font(11));
                    values.add(valueText);
                    barText = new Text(record.getName());
                    barText.setFont(new Font(11));
                    barTextList.add(barText);
                }
                for (Record record:topTen) {
                    System.out.println(record.toString());
                }
                System.out.println("-----------------------------------------");
                vBox.getChildren().addAll(rect);
                vBoxText.getChildren().addAll(barTextList);
                vBoxValue.getChildren().addAll(values);
                textYear.setText(topTen.get(0).getYear());
                if (i == 2){
                    isFinished = 1;
                }
                if(isFinished == 0){
                    AnimationButton.setText("Stop Animation");
                }
                else {
                    AnimationButton.setText("Start Animation");
                    isFinished = 0;
                }
            }));
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i * 100 + 100), actionEvent -> {
                vBox.getChildren().clear();
                vBoxText.getChildren().clear();
                vBoxValue.getChildren().clear();


            }));
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i * 100 + 100), actionEvent -> {
                values.clear();
                topTen.clear();
                barList.clear();
                rect.clear();
                barTextList.clear();
                i--;
            }));
        }
        timeline.setCycleCount(1);
        for (int i = 0; i < 5; i++){
            timeline.getKeyFrames().remove(timeline.getKeyFrames().size() - 1);
        }
        timeline.play();
    }

}