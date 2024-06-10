import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("YESH");

        // Directory shit
        File initialDirectory = new File("images");

        // Create a FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(initialDirectory);
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Create a Button and ImageView
        Button button = new Button("Pick an Image");
        ImageView imageView = new ImageView();

        // Set the button action to open the FileChooser
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
                imageView.setFitWidth(300);
                imageView.setPreserveRatio(true);
            }
        });

        // Create a VBox layout and add the button and ImageView
        VBox vbox = new VBox(button, imageView);
        Scene scene = new Scene(vbox, 400, 400);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
