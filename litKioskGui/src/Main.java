package src;

import javafx.application.Application;
import javafx.stage.Stage;
import src.ui.Gui;

public class Main extends Application {
    Gui newWin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        newWin = new Gui(primaryStage);
    }
}

