/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5vedika;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6303129
 */
public class Lab5Vedika extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }
    
    //create a gridPane which is the root 

    @Override
    public void start(Stage stage){
        ListView<String> bagTypes = new ListView<>();
        bagTypes.getItems().addAll("Full decorative", "Beaded", "Pirate Design", "Fringed", "leather", "plain");
        
        bagTypes.setPrefHeight(120);
        
        //create comboBox 
        ComboBox<String> quantityComboBox = new ComboBox<>();
        quantityComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        VBox vbox = new VBox(bagTypes);
       
        //RadioButtons  //need to add these buttons too 
        Label sizeLabel = new Label("Select Size : ");
        RadioButton small = new RadioButton();
        RadioButton medium = new RadioButton();
        RadioButton large = new RadioButton();
        
         //add the labels for the radioButtons 
        Label mediumLabel = new Label("medium");                                             
        Label smallLabel = new Label("small");
        Label largeLabel = new Label("large");
        
        //add to a gridPane
        //apply code handeling on this 
        
        GridPane paneButtons = new GridPane();
        paneButtons.add(smallLabel, 0, 0);  //colums //row 
        paneButtons.add(small, 1, 0);
        paneButtons.add(mediumLabel, 2,2);
        //paneButtons.add(medium, 3, 0);
        //paneButtons.add(largeLabel, 0,9); 
        //paneButtons.add(large, 0,11);
      
        
        ToggleGroup radioGroup = new ToggleGroup();
        Button buttonQuantity = new Button("Button quantity");
        small.setToggleGroup(radioGroup);
        medium.setToggleGroup(radioGroup);
        large.setToggleGroup(radioGroup);
        
        //add the size box : 
        HBox sizeBox = new HBox(15, small, medium, large);
        sizeBox.setAlignment(Pos.CENTER_LEFT);
        
        
        //add buttons 
        Button order = new Button("Place order");
        Button clear = new Button("Clear selection");
        
        HBox hboxButtons = new HBox(20, order, clear);
        hboxButtons.setAlignment(Pos.CENTER);
        
        //labels 
        Label select = new Label ("Select Bag Style");
        
        Label messageLabel = new Label();
        
        
        //handle ListView user interaction 
        quantityComboBox.getSelectionModel().selectedItemProperty().addListener(event -> {
            //write event handeling code here 
            String selected = quantityComboBox.getSelectionModel().getSelectedItem(); //get the selected name
            messageLabel.setText(selected); //display the selected name in the label 
            
        });
       
         //root
        GridPane root = new GridPane();
        root.add(select, 0, 5);
        root.add(vbox, 11, 11);
        root.add(hboxButtons, 15, 15);
        root.add(messageLabel, 6,6);
        root.add(paneButtons, 0,2);
        
        //need to fix the layout and make it more clear 
        
        
        
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
}

