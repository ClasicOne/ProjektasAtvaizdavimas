package projektinis;

import java.io.IOException;
import java.lang.reflect.Field;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application  {
    static ListView<String> listView = new ListView<>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("TEst");
        GridPane gridPane = new GridPane();

        {
            gridPane.setAlignment(Pos.TOP_LEFT);
            gridPane.setVgap(20);
            gridPane.setHgap(20);
            gridPane.setPadding(new Insets(10, 10, 10, 10));


            Label cpuLable = new Label("Procesorius :");
            gridPane.add(cpuLable,0,0);
            Button cpuButton = new Button();
            cpuButton.setText("Rodyti procesorių sąrašą");
            cpuButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","cpu");
                    cpuButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(cpuButton,0, 1,1,1);

            Label motherboadrLable = new Label("Pagrindinė plokštė :");
            gridPane.add(motherboadrLable,1,0);
            Button mbButton = new Button("Rodyti pagrindinių plokščių sąraąa");
            mbButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","mb");
                    mbButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(mbButton,1, 1,1,1);

            Label gpuLabel = new Label("Vaizdo plokštė :");
            gridPane.add(gpuLabel,2,0);
            Button gpuButton = new Button("Rodyti vaizdo plokščių sąrašą");
            gpuButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","gpu");
                    gpuButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(gpuButton,2, 1,1,1);

            Label ramLabel = new Label("Operativioji atmintis :");
            gridPane.add(ramLabel,0,2);
            Button ramButton = new Button("Rodyti operativių atminčių sąrašą");
            ramButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","ram");
                    ramButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(ramButton,0, 3,1,1);

            Label storageLabel = new Label("HDD/SSD diskai :");
            gridPane.add(storageLabel,1,2);
            Button storageButton = new Button("Rodyti HDD/SSD sąrašą");
            storageButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","storage");
                    storageButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(storageButton,1, 3,1,1);

            Label powerLabel = new Label("Power :");
            gridPane.add(powerLabel,2,2);
            Button powerButton = new Button("Rodyti Power sarasa");
            powerButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","power");
                    powerButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(powerButton,2, 3,1,1);

            Label caseLabel = new Label("Korpusai :");
            gridPane.add(caseLabel,1,4);
            Button caseButton = new Button("Rodyti korpusų sąrašą");
            caseButton.setOnAction(event -> {
                try {
                    DisplayData.display("Title","Hi","case");
                    caseButton.setDisable(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            gridPane.add(caseButton,1, 5,1,1);
            //-------------
			/*ListView<String> listView = new ListView<String>();
			listView.setMinWidth(100);
			//fillListView(listView);
			listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);*/


            gridPane.add(listView, 0,6,15,1);


        }
        Scene scene = new Scene(gridPane, Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
