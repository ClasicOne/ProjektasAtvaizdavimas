package projektinis;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Nepasirinkta {
    public static void DisplayErr(String text){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pasirinkio klaida");
        Label label = new Label(text);
        GridPane gridPane = new GridPane();
        gridPane.add(label, 0,0);
        Button button = new Button("Pabandyti is naujo");
        button.setOnAction(event -> window.close());
        gridPane.add(button,0,1,1,1);
        button.setStyle("-fx-background-color: \n" +
                "        red,\n" +
                "        linear-gradient(red 0%, red 20%, red 100%),\n" +
                "        linear-gradient(red,red),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, red, red);\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"Arial Black\";\n" +
                "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-padding: 10 10 10 10;");
        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }
}
