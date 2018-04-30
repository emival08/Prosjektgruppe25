package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Button button, button1, button3, button2, button4, button5, button6, button7, button8,
            button9, button10, button11;
    private TableView table1 = new TableView();
    private TableView table2 = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setScene(new Scene(root, 600, 470));

        primaryStage.setTitle("Velkommen");
        primaryStage.show();*/


        window = primaryStage;
        window.setTitle("Title");

        Text hText = new Text("Library");
        hText.getStyleClass().add("hText");

        button = new Button("Help!");
        button1 = new Button("List all magazines");
        button2 = new Button("List all books");
        button3 = new Button("Close");
        button4 = new Button("Back");
        button5 = new Button("Back");
        button6 = new Button("List all magazines");
        button7 = new Button("Placeholder for search");
        button8 = new Button("List all books");
        button9 = new Button("Placeholder for search");
        button10 = new Button("List book");
        button11 = new Button("Add new book");

        //List all books table
        table1.getStyleClass().add("table");

        TableColumn<Book, String> titleCol = new TableColumn<Book, String>("Title: ");
        //titleCol.setCellValueFactory();
        TableColumn<Book, String> authorCol = new TableColumn<Book, String>("Author: ");
        TableColumn<Book, String> publisherCol = new TableColumn<Book, String>("Publisher: ");
        TableColumn<Book, String> yearCol = new TableColumn<Book, String>("Year: ");
        TableColumn<Book, String> genreCol = new TableColumn<Book, String>("Genre: ");
        TableColumn<Book, String> editCol = new TableColumn<Book, String>("Editor: ");


        /*TableColumn titleCol = new TableColumn("Title");
        TableColumn authorCol = new TableColumn("Author");
        TableColumn publisherCol = new TableColumn("Publisher");
        TableColumn yearCol = new TableColumn("Year");
        TableColumn genreCol = new TableColumn("Genre");
        TableColumn editCol = new TableColumn("Series");*/

        table1.getColumns().addAll(titleCol, authorCol, publisherCol, yearCol,
                genreCol, editCol);

        titleCol.prefWidthProperty().bind(table1.widthProperty().divide(6));
        authorCol.prefWidthProperty().bind(table1.widthProperty().divide(6));
        publisherCol.prefWidthProperty().bind(table1.widthProperty().divide(6));
        yearCol.prefWidthProperty().bind(table1.widthProperty().divide(6));
        genreCol.prefWidthProperty().bind(table1.widthProperty().divide(6));
        editCol.prefWidthProperty().bind(table1.widthProperty().divide(6));

        //List all magazines table
        table2.getStyleClass().add("table");

        TableColumn titleCol2 = new TableColumn("Title");
        TableColumn authorCol2 = new TableColumn("Author");
        TableColumn publisherCol2 = new TableColumn("Publisher");
        TableColumn dateCol = new TableColumn("Release Date");
        TableColumn genreCol2 = new TableColumn("Genre");
        TableColumn editCol2 = new TableColumn("Edition");

        table2.getColumns().addAll(titleCol2, authorCol2, publisherCol2,
                dateCol, genreCol2, editCol2);

        titleCol2.prefWidthProperty().bind(table2.widthProperty().divide(6));
        authorCol2.prefWidthProperty().bind(table2.widthProperty().divide(6));
        publisherCol2.prefWidthProperty().bind(table2.widthProperty().divide(6));
        dateCol.prefWidthProperty().bind(table2.widthProperty().divide(6));
        genreCol2.prefWidthProperty().bind(table2.widthProperty().divide(6));
        editCol2.prefWidthProperty().bind(table2.widthProperty().divide(6));

        //Scene 1
        VBox layout = new VBox(10);
        layout.getChildren().addAll(hText, button2, button1, button, button10, button3);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 800, 600);


        //Scene 2
        Text bookHeader = new Text("List all books");
        bookHeader.getStyleClass().add("tText");

        HBox bookTopBtns = new HBox();
        Region r = new Region();
        Region rr = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        HBox.setHgrow(rr, Priority.ALWAYS);
        bookTopBtns.getChildren().addAll(button6, rr,  button11, r, button7);

        VBox bookTop = new VBox(10);
        bookTop.getChildren().addAll(bookHeader, bookTopBtns);
        bookTop.setAlignment(Pos.CENTER);

        ImageView litImg = new ImageView();
        Label titleLab = new Label("Title: ");
        Label authLab = new Label("Author: ");
        // osv

        Button editBtn = new Button("Edit book");
        editBtn.getStyleClass().add("edBtn");

        VBox litView = new VBox(10);
        litView.getStyleClass().add("bookView");
        Region r3 = new Region();
        VBox.setVgrow(r3, Priority.ALWAYS);
        Region r4 = new Region();
        VBox.setVgrow(r4, Priority.ALWAYS);
        litView.getChildren().addAll(litImg, r4, titleLab, authLab, r3, editBtn);
        litView.setAlignment(Pos.CENTER);

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(bookTop);
        borderpane.setCenter(table1);
        borderpane.setBottom(button4);
        borderpane.setRight(litView);
        borderpane.setAlignment(bookTop,Pos.CENTER);
        borderpane.setAlignment(table1, Pos.CENTER);
        borderpane.setAlignment(button4,Pos.CENTER);
        borderpane.setMargin(bookTop, new Insets(15, 15, 15, 15));
        borderpane.setMargin(table1, new Insets(0, 15, 0, 15));
        borderpane.setMargin(button4, new Insets(15, 15, 15, 15));
        borderpane.setMargin(litView, new Insets(0, 15, 0, 0));

        Scene scene2 = new Scene(borderpane, 800, 600);

        //Scene 3
        Text magHeader = new Text("List all magazines");
        magHeader.getStyleClass().add("tText");

        HBox magTopBtns = new HBox();
        Region r2 = new Region();
        HBox.setHgrow(r2, Priority.ALWAYS);
        magTopBtns.getChildren().addAll(button8, r2, button9);

        VBox magTop = new VBox(10);
        magTop.getChildren().addAll(magHeader, magTopBtns);
        magTop.setAlignment(Pos.CENTER);

        Pane pane2 = new Pane();
        pane2.getStyleClass().add("bookView");

        BorderPane borderpane2 = new BorderPane();
        borderpane2.setTop(magTop);
        borderpane2.setCenter(table2);
        borderpane2.setBottom(button5);
        borderpane2.setRight(pane2);
        borderpane2.setAlignment(magTop,Pos.CENTER);
        borderpane2.setAlignment(table2, Pos.CENTER);
        borderpane2.setAlignment(button5,Pos.CENTER);
        borderpane2.setMargin(magTop, new Insets(15, 15, 15, 15));
        borderpane2.setMargin(table2, new Insets(0, 15, 0, 15));
        borderpane2.setMargin(button5, new Insets(15, 15, 15, 15));
        borderpane2.setMargin(pane2, new Insets(0, 15, 0, 0));
        Scene scene3 = new Scene(borderpane2, 800, 600);


        //Eventhandling for buttons
        button.setOnAction(e -> AlertBox.displayInfo("tittel", "header", "message"));
        button1.setOnAction(e -> window.setScene(scene3));
        button2.setOnAction(e -> window.setScene(scene2));
        button3.setOnAction(e -> closeProgram());
        button4.setOnAction(e -> window.setScene(scene1));
        button5.setOnAction(e -> window.setScene(scene1));
        button6.setOnAction(e -> window.setScene(scene3));
        button8.setOnAction(e -> window.setScene(scene2));
        //button10.setOnAction(e -> );


        window.setScene(scene1);
        window.show();

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene3.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


    }

    private void closeProgram() {
        System.out.println("Saved");
        Boolean answer = AlertBox.displayConfC();
        if(answer) {
            window.close();
        }
    }
}

