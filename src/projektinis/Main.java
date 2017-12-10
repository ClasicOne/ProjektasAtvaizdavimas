package projektinis;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application  {
    static ListView<String> listView = new ListView<>();
    static String output = "";
    static String[] komplektoStr = {"Brangus", "Vidutinis", "Pigus"};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Kompiuterių detalių prekybos programga");
        GridPane gridPane = new GridPane();

        {
            gridPane.setAlignment(Pos.TOP_LEFT);
            gridPane.setVgap(10);
            gridPane.setHgap(80);
            gridPane.setPadding(new Insets(10, 10, 10, 10));


            Label cpuLable = new Label("Procesorius:");
            gridPane.add(cpuLable,0,0);
            Button cpuButton = new Button();
            cpuButton.setText("Rodyti procesorių sąrašą");

            cpuButton.setOnAction(event -> {
                try {
                    DisplayData.display("Procesorių sąrašas","Hi","cpu");
                  //  cpuButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            cpuButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(cpuButton,0, 1,1,1);

            Label motherboadrLable = new Label("Pagrindinė plokštė:");
            gridPane.add(motherboadrLable,1,0);
            Button mbButton = new Button("Rodyti pagrindinių plokščių sąraša");
            mbButton.setOnAction(event -> {
                try {
                    DisplayData.display("Pagrindių plokščiu sąrašas","Hi","mb");
                   // mbButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            mbButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(mbButton,1, 1,1,1);

            Label gpuLabel = new Label("Vaizdo plokštė:");
            gridPane.add(gpuLabel,2,0);
            Button gpuButton = new Button("Rodyti vaizdo plokščių sąrašą");
            gpuButton.setOnAction(event -> {
                try {
                     DisplayData.display("Vaizdo plokščiu sąrašas","Hi","gpu");
                    //gpuButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gpuButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(gpuButton,2, 1,1,1);

            Label ramLabel = new Label("Operativioji atmintis:");
            gridPane.add(ramLabel,0,2);
            Button ramButton = new Button("Rodyti operatyviųjų atminčių sąrašą");
            ramButton.setOnAction(event -> {
                try {
                    DisplayData.display("Operativių atminčiu sąrašas","Hi","ram");
                    //ramButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            ramButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(ramButton,0, 3,1,1);

            Label storageLabel = new Label("HDD/SSD diskai:");
            gridPane.add(storageLabel,1,2);
            Button storageButton = new Button("Rodyti HDD/SSD sąrašą");
            storageButton.setOnAction(event -> {
                try {
                    DisplayData.display("HDD/SSD diskai","Hi","storage");
                    //storageButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            storageButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(storageButton,1, 3,1,1);

            Label powerLabel = new Label("Maitinimo bloku:");
            gridPane.add(powerLabel,2,2);
            Button powerButton = new Button("Rodyti matinimo blokų sąraša");
            powerButton.setOnAction(event -> {
                try {
                    DisplayData.display("Maitinimo blokų sąrašas","Hi","power");
                    //powerButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            powerButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(powerButton,2, 3,1,1);

            Label caseLabel = new Label("Korpusai:");
            gridPane.add(caseLabel,1,4);
            Button caseButton = new Button("Rodyti korpusų sąrašą");
            caseButton.setOnAction(event -> {
                try {
                    DisplayData.display("Korpusu sąrašas","Hi","case");
                   // caseButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            caseButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(caseButton,1, 5,1,1);
            Label delelteLable = new Label("Ištrinti");
            Button deleteButton = new Button("Pašalinti iš sąrašo");
            deleteButton.setOnAction(event -> {
                        listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
                    });
            deleteButton.setStyle("-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(red 0%, #ff2839 20%, darkred 100%),\n" +
                    "        linear-gradient(#ff4f52, #ff001a),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");

            //gridPane.add(delelteLable, 6,5);
            gridPane.add(deleteButton, 2,5,1,1);
            Button saveData = new Button("Save data");
            saveData.setOnAction(event -> {
                try {
                    BufferedWriter  bufferWriter= new BufferedWriter(new FileWriter("test.txt"));
                    bufferWriter.write(output);
                    bufferWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            });
            //gridPane.add(saveData,0,5,1,1);
            gridPane.add(listView, 0,6,3,1);
            listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println(newValue.toString()+"\n");
                output += newValue.toString()+ "\n";
            });
            Label komplektaiLabel = new Label("Komplektai :");
            gridPane.add(komplektaiLabel, 0,4);
            ComboBox<String> selectionComboBox = new ComboBox<>();
            selectionComboBox.getItems().addAll(komplektoStr);
            selectionComboBox.setValue("Pasirinkti");
            selectionComboBox.setOnAction(event -> {
                System.out.println(selectionComboBox.getValue());
                switch (selectionComboBox.getValue()){
                    case "Brangus":
                        try {
                            if (!listView.getItems().isEmpty()) {
                                listView.getItems().clear();
                                komplektuIdejimas("expencivePC.txt");
                            }else
                                komplektuIdejimas("expencivePC.txt");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Vidutinis":
                        try {
                            if (!listView.getItems().isEmpty()) {
                                listView.getItems().clear();
                                komplektuIdejimas("midium.txt");
                            }else
                                komplektuIdejimas("midium.txt");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Pigus":
                        try {
                            if (!listView.getItems().isEmpty()) {
                                listView.getItems().clear();
                                komplektuIdejimas("cheap.txt");
                            }else
                                komplektuIdejimas("cheap.txt");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            });
            selectionComboBox.setStyle(
                    "-fx-background-color: \n" +
                    "        #090a0c,\n" +
                    "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "        linear-gradient(#20262b, #191d22),\n" +
                    "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 5,4,3,5;\n" +
                    "    -fx-background-insets: 0,1,2,0;\n" +
                    "    -fx-text-fill: white;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "    -fx-font-family: \"Arial Black\";\n" +
                    "    -fx-font-size: 12px;\n" +
                    "    -fx-padding: 10 10 10 10;");
            gridPane.add(selectionComboBox,0,5,1,1);
        }
        Scene scene = new Scene(gridPane, Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void komplektuIdejimas(String name) throws IOException{
        Scanner scanner = new Scanner(new FileReader(name));
        String[] data;
        String[] temp;
        while (scanner.hasNextLine()){
            data = scanner.nextLine().split("[?]]");
            for (String dump : data){
                temp = dump.split("`");
                for(String tempo: temp){
                    listView.getItems().add(tempo+"\n");
                    tempo.replaceAll("[?]","");

                }



            }
        }
        scanner.close();
    }

}
