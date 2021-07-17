package View;

import Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;

public class MazeGenerator extends Application {
    public GridPane gridPane;
    public TextField heightField;
    public TextField widthField;

    public void gameBoard() {
        gridPane.getChildren().clear();
        char[][] maze = Controller.getInstance().generateMaze(2 * Integer.parseInt(heightField.getText()) + 1, 2 * Integer.parseInt(widthField.getText()) + 1);
        for (int i = 0; i < 2 * Integer.parseInt(heightField.getText()) + 1; ++i) {
            for (int j = 0; j < 2 * Integer.parseInt(widthField.getText()) + 1; ++j) {
                Rectangle rectangle = new Rectangle();
                rectangle.setHeight(46);
                rectangle.setWidth(46);
                if (maze[i][j] == '0') {
                    rectangle.setFill(Color.WHITE);
                } else if (maze[i][j] == '1') {
                    rectangle.setFill(Color.BLACK);
                } else if (maze[i][j] == 'e') {
                    rectangle.setFill(Color.GREEN);
                } else {
                    rectangle.setFill(Color.RED);
                }
                gridPane.add(rectangle, i, j);
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL mazeUrl = getClass().getResource("/fxml/mazePage.fxml");
        Parent root = FXMLLoader.load(mazeUrl);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        root.setId("root");
        stage.setTitle("Maze Generator");
        stage.getIcons().add(new Image(new FileInputStream("src/main/resources/images/block-maze-1128083.png")));
        scene.getStylesheets().addAll(this.getClass().getResource("/css/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    public void initialize() {
        gameBoard();
    }
}
