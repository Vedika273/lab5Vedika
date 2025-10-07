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
        
        //the list view of bag types 
        ListView<String> bagTypes = new ListView<>();
        bagTypes.getItems().addAll("Full decorative", "Beaded", "Pirate Design", "Fringed", "leather", "plain");
        
        bagTypes.setPrefHeight(120);
        
        //create comboBox fot the quantities 
        Label quantityLabel = new Label("Select Quantitiy");
        ComboBox<String> quantityComboBox = new ComboBox<>();
        quantityComboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        VBox vbox = new VBox(bagTypes);
       
        //RadioButtons  //need to add these buttons too 
        Label sizeLabel = new Label("Select Size : ");
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        
         //add the labels for the radioButtons 
        //Label mediumLabel = new Label("medium");                                             
        //Label smallLabel = new Label("small");
        //Label largeLabel = new Label("large");
        
        
        ToggleGroup sizeGroup = new ToggleGroup();
        Button buttonQuantity = new Button("Button quantity");
        small.setToggleGroup(sizeGroup);
        medium.setToggleGroup(sizeGroup);
        large.setToggleGroup(sizeGroup);
        
        HBox sizeBox = new HBox(15, small, medium, large);
        sizeBox.setAlignment(Pos.CENTER_LEFT);
        
        
        // Group the label + buttons into one section with border
            VBox sizeSection = new VBox(5, sizeLabel, sizeBox);
            sizeSection.setPadding(new Insets(10));
            sizeSection.setAlignment(Pos.CENTER_LEFT);

        
        //add buttons 
        Button order = new Button("Place order");
        Button clear = new Button("Clear selection");
        
        HBox hboxButtons = new HBox(20, order, clear);
        hboxButtons.setAlignment(Pos.CENTER);
       
        
        
        //labels 
        Label selectLabel = new Label ("Select Bag Style");
        
        Label messageLabel = new Label();
        
        
        //handle ListView user interaction 
        quantityComboBox.getSelectionModel().selectedItemProperty().addListener(event -> {
            //write event handeling code here 
            String selected = quantityComboBox.getSelectionModel().getSelectedItem(); //get the selected name
            messageLabel.setText(selected); //display the selected name in the label 
            
        });
         
         order.setOnAction(e -> {
            String selectedBag = bagTypes.getSelectionModel().getSelectedItem();
            String selectedQuantity = quantityComboBox.getValue();
            RadioButton selectedSize = (RadioButton) sizeGroup.getSelectedToggle();

            if (selectedBag == null || selectedQuantity == null || selectedSize == null) {
                messageLabel.setText("Please select a bag style, size, and quantity before ordering.");
            } else {
                messageLabel.setText("You ordered " + selectedQuantity + " "
                        + selectedSize.getText() + " " + selectedBag + " bag(s).");
            }
        });
       
         //root
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(15);
        root.setVgap(15);
        root.setAlignment(Pos.CENTER);

        root.add(selectLabel, 0, 0);
        root.add(bagTypes, 1, 0);
        root.add(quantityLabel, 0, 1);
        root.add(quantityComboBox, 1, 1);
        root.add(sizeLabel, 0, 2);
        root.add(sizeBox, 1, 2);
        root.add(hboxButtons, 0, 3, 2, 1);
        root.add(sizeSection, 1, 2);
        root.add(messageLabel, 0, 4, 2, 1);
        
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
}

