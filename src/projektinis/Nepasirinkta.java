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
        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();
    }
}
