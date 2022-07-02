/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmicalculatorfrancais;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sa
 */
public class BmiCalculatorFrancais extends Application {
    
    private TextField CustName = new TextField();
    private TextField CustAge = new TextField();
    private TextField CustWeight = new TextField();
    private TextField CustHeight = new TextField();
    private TextField CustBmi = new TextField();
    private TextField HisStatus = new TextField();
    private Button btCalculate = new Button("Calculer");
    private Button btReset = new Button("Reset");
    
    private TextArea t = new TextArea();
    
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane g = new GridPane();
        g.setHgap(5);
        g.setVgap(5);
        g.add(new Label("Nom:"), 0, 0);
        g.add(CustName, 1, 0);
        g.add(new Label("Age:"), 0, 1);
        g.add(CustAge, 1, 1);
        g.add(new Label("Poids en Kg:"), 0, 2);
        g.add(CustWeight, 1, 2);
        g.add(new Label("Taille en m:"), 0, 3);
        g.add(CustHeight, 1, 3);
        g.add(new Label("Indice Masse Corporelle:"), 0, 6);
        g.add(CustBmi, 1, 6);
        g.add(new Label("Resultat:"), 0, 7);
        g.add(HisStatus, 1, 7);
        g.add(btCalculate, 1, 4);
        g.add(t, 1, 12);
        g.add(btReset, 1, 15);
        
        g.setAlignment(Pos.CENTER);
        //CustName.setAlignment(Pos.BOTTOM_RIGHT);
        //CustAge.setAlignment(Pos.BOTTOM_RIGHT);
        //CustWeight.setAlignment(Pos.BOTTOM_RIGHT);
        //CustHeight.setAlignment(Pos.BOTTOM_RIGHT);
        //CustBmi.setAlignment(Pos.BOTTOM_RIGHT);
        //HisStatus.setAlignment(Pos.BASELINE_RIGHT);
        HisStatus.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        CustBmi.setEditable(false);
        
        btCalculate.setOnAction(e -> calculateBmi());
        btReset.setOnAction(e -> resetEverything());
        
        
        
        
        Scene scene = new Scene(g, 300, 250);
        
        primaryStage.setTitle("Indice Masse Corporelle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void calculateBmi(){
        
        String name = CustName.getText();
        double weight = Double.parseDouble(CustWeight.getText());
        double height = Double.parseDouble(CustHeight.getText());
        int age = Integer.parseInt(CustAge.getText());
        
        BmiFrancais bmi = new BmiFrancais(name, age, weight, height);
        
        //CustBmi.setText(String.format("$.2f", bmi.getBmi()));   
        CustBmi.setText(String.format("%.2f", bmi.getBmi()));
        HisStatus.setText(bmi.getStatus());
        t.setText(bmi.getName() + " a "+ bmi.getAge()+" ans, avec une Indice de Masse Corporelle de " + bmi.getBmi() +" et " + bmi.getStatus() );
    }
    private void resetEverything(){
       CustName.clear();
       CustAge.clear();
       CustWeight.clear();
       CustHeight.clear();
       CustBmi.clear();
       HisStatus.clear();
       t.clear();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
