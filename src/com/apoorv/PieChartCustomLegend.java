package com.apoorv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;

public class PieChartCustomLegend extends Application {
    int a,b,c,d;
    
  @Override public void start(Stage stage) {
      try {
            BufferedReader input=new BufferedReader(new FileReader("output2.txt"));
            StringTokenizer tokenizer=new StringTokenizer(input.readLine(),",");
            a=Integer.parseInt(tokenizer.nextToken());
            b=Integer.parseInt(tokenizer.nextToken());
            c=Integer.parseInt(tokenizer.nextToken());
            d=Integer.parseInt(tokenizer.nextToken());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PieChartCustomLegend.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(PieChartCustomLegend.class.getName()).log(Level.SEVERE, null, ex);
            }
    Scene scene = new Scene(new Group(), 500, 500);
    stage.setTitle("Words Distribution");

    ObservableList<PieChart.Data> pieChartData =
      FXCollections.observableArrayList(
        new PieChart.Data("Adult", a),
        new PieChart.Data("Terrorism", b),
        new PieChart.Data("Religious", c),
        new PieChart.Data("Others", d));
    final PieChart chart = new PieChart(pieChartData);
    chart.setTitle("Words Distribution");

    ((Group) scene.getRoot()).getChildren().add(chart);
    stage.setScene(scene);
    stage.show();

    Set<Node> items = chart.lookupAll("Label.chart-legend-item");
    int i = 0;
    // these colors came from caspian.css .default-color0..4.chart-pie
    Color[] colors = { Color.web("#f9d900"), Color.web("#a9e200"), Color.web("#22bad9"), Color.web("#0181e2"), Color.web("#2f357f") };
    for (Node item : items) {
      Label label = (Label) item;
      final Rectangle rectangle = new Rectangle(10, 10, colors[i]);
      final Glow niceEffect = new Glow();
      niceEffect.setInput(new Reflection());
      rectangle.setEffect(niceEffect);
      label.setGraphic(rectangle);
      i++;
    }
  }
  public static void main(String[] args){
      launch(args);
  }
}