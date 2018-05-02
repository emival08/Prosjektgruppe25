package src.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.Alert;
import src.literature.Book;
import src.literature.Literature;
import src.literature.Magazine;
import src.literature.Registry;

import java.util.Iterator;

public class Gui{

    private Scene firstScene, booksScene, magScene;
    private Button listBooksBtn, listMagsBtn, helpBtn, closeBtn, addBooksBtn, backBtn, editBtn, search;
    private Region r, r1, r2, r3, r4;
    private Stage window, addBookWin;
    private Registry registry = new Registry();

    public Gui(Stage window){
        fillBooks();
        mainScene();
        listBooksScene();


        //eventhandling for buttons
        listBooksBtn.setOnAction(e -> window.setScene(booksScene));
        listMagsBtn.setOnAction(e -> window.setScene(magScene));
        backBtn.setOnAction(e -> window.setScene(firstScene));

        listMagsScene();

        window.setScene(firstScene);
        window.show();
    }

    private void mainScene(){
        Text hText = new Text("Library");
        hText.getStyleClass().add("hText");

        listBooksBtn = new Button("List all books");
        listMagsBtn = new Button(("List all magazines"));
        helpBtn = new Button("Help!");
        closeBtn = new Button("Close");

        //Eventhandling for buttons
        //listBooksBtn.setOnAction(e -> listBooksScene());
        //listMagsBtn.setOnAction(e -> window.setScene(scene3));
        helpBtn.setOnAction(e -> src.ui.AlertBox.displayInfo("Title", "Header", "Message"));
        closeBtn.setOnAction(e -> closeProgram());

        //Add elements to vbox and create new scene
        VBox vb = new VBox(10);
        vb.getChildren().addAll(hText, listBooksBtn, listMagsBtn, helpBtn, closeBtn);
        vb.setAlignment(Pos.CENTER);
        firstScene = new Scene(vb, 800, 600);
        firstScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

    private void listBooksScene() {
        Text bookHeader = new Text("List all books");
        bookHeader.getStyleClass().add("hText");

        addBooksBtn = new Button("Add new book");
        listMagsBtn = new Button("List all magazines");
        backBtn = new Button("Back");

        addBooksBtn.setOnAction(e -> addBookStage(addBookWin));

        //temporary button in place for search function
        search = new Button("Placeholder for search");

        HBox bookTopBtns = new HBox();
        r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        bookTopBtns.getChildren().addAll(addBooksBtn, r, search);

        HBox bookBtmBtns = new HBox(10);
        r1 = new Region();
        HBox.setHgrow(r1, Priority.ALWAYS);
        bookBtmBtns.getChildren().addAll(r1, listMagsBtn, backBtn);

        VBox bookTop = new VBox(10);
        bookTop.getChildren().addAll(bookHeader, bookTopBtns);

        /**book details**/
        ImageView litImg = new ImageView();
        Label titleLab = new Label("Title: ");
        Label authLab = new Label("Author: ");
        // osv

        editBtn = new Button("Edit Book");
        editBtn.getStyleClass().add("edBtn");

        VBox litView = new VBox(10);
        litView.getStyleClass().add("bookView");
        r2 = new Region();
        VBox.setVgrow(r2, Priority.ALWAYS);
        r3 = new Region();
        VBox.setVgrow(r3, Priority.ALWAYS);
        litView.getChildren().addAll(litImg, r2, titleLab, authLab, r3, editBtn);
        litView.setAlignment(Pos.CENTER);

        Pane pane = new Pane();

        //bookTable().setItems(this.getLiteratureList());
        BorderPane borderpane = new BorderPane();
        borderpane.setTop(bookTop);
        borderpane.setCenter(bookTable());
        borderpane.setBottom(bookBtmBtns);
        borderpane.setLeft(pane);
        borderpane.setRight(litView);
        borderpane.setAlignment(bookTop,Pos.CENTER);
        borderpane.setAlignment(bookTable(), Pos.CENTER);
        borderpane.setAlignment(bookBtmBtns,Pos.CENTER);
        borderpane.setAlignment(pane, Pos.CENTER);
        borderpane.setMargin(bookTop, new Insets(15, 15, 15, 15));
        borderpane.setMargin(bookTable(), new Insets(15, 15, 15, 0));
        borderpane.setMargin(bookBtmBtns, new Insets(15, 15, 15, 15));
        borderpane.setMargin(litView, new Insets(0, 15, 0, 15));
        borderpane.setMargin(pane, new Insets(0, 0, 0, 15));

        booksScene = new Scene(borderpane, 800, 600);
        booksScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }

    private void listMagsScene() {
        Text magHeader = new Text("List all magazines");
        magHeader.getStyleClass().add("tText");

        listBooksBtn = new Button("List all books");
        search = new Button("Placeholder for search");

        HBox magTopBtns = new HBox();
        r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        magTopBtns.getChildren().addAll(listBooksBtn, r2, search);

        VBox magTop = new VBox(10);
        magTop.getChildren().addAll(magHeader, magTopBtns);
        magTop.setAlignment(Pos.CENTER);

        Pane pane = new Pane();
        pane.getStyleClass().add("bookView");

        BorderPane borderpane2 = new BorderPane();
        borderpane2.setTop(magTop);
        borderpane2.setCenter(magTable());
        borderpane2.setBottom(backBtn);
        borderpane2.setRight(pane);
        borderpane2.setAlignment(magTop,Pos.CENTER);
        borderpane2.setAlignment(magTable(), Pos.CENTER);
        borderpane2.setAlignment(backBtn,Pos.CENTER);
        borderpane2.setMargin(magTop, new Insets(15, 15, 15, 15));
        borderpane2.setMargin(magTable(), new Insets(15, 15, 15, 15));
        borderpane2.setMargin(backBtn, new Insets(15, 15, 15, 15));
        borderpane2.setMargin(pane, new Insets(15, 15, 15, 15));

        magScene = new Scene(borderpane2, 800, 600);
        magScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }

    private TableView bookTable() {
        TableView<Book> table = new TableView<>();
        table.setEditable(true);
        table.setItems(bookList());

        TableColumn<Book, String> titleCol = new TableColumn<>("Title: ");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorCol = new TableColumn<>("Author: ");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> publisherCol = new TableColumn<>("Publisher: ");
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<Book, String> yearCol = new TableColumn<>("Year: ");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        TableColumn<Book, String> genreCol = new TableColumn<>("Genre: ");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Book, String> editCol = new TableColumn<>("Edition ");
        editCol.setCellValueFactory(new PropertyValueFactory<>("edition"));

        table.getColumns().addAll(titleCol, authorCol, publisherCol, genreCol, yearCol, editCol);

        //Set width of table divided into 4
        titleCol.prefWidthProperty().bind(table.widthProperty().divide(4));
        authorCol.prefWidthProperty().bind(table.widthProperty().divide(4));
        yearCol.prefWidthProperty().bind(table.widthProperty().divide(4));
        genreCol.prefWidthProperty().bind(table.widthProperty().divide(4));

        return table;

    }

    private TableView magTable() {
        TableView<Magazine> table = new TableView<>();
        table.setEditable(true);

        TableColumn<Magazine, String> titleCol = new TableColumn<>("Title: ");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Magazine, String> publisherCol = new TableColumn<>("Publisher: ");
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<Magazine, String> yearCol = new TableColumn<>("Year: ");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        TableColumn<Magazine, String> genreCol = new TableColumn<>("Genre: ");
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Magazine, String> editCol = new TableColumn<>("Edition ");
        editCol.setCellValueFactory(new PropertyValueFactory<>("edition"));

        table.getColumns().addAll(titleCol, publisherCol, yearCol, genreCol);

        //Width of table divided into 4
        titleCol.prefWidthProperty().bind(table.widthProperty().divide(4));
        publisherCol.prefWidthProperty().bind(table.widthProperty().divide(4));
        yearCol.prefWidthProperty().bind(table.widthProperty().divide(4));
        genreCol.prefWidthProperty().bind(table.widthProperty().divide(4));

        return table;
    }


    private GridPane addMagForm(){
        GridPane grid = new GridPane();
        initGrid(grid);

        //Header

        //define labels
        Label addTitleLabel = new Label("Title: ");
        Label addPubLabel = new Label("Publisher: ");
        Label addYearLabel = new Label("Year: ");
        Label addGenreLabel = new Label("Genre: ");
        Label addEditionLabel = new Label("Edition: ");

        //define fields
        TextField addTitleField = new TextField();
        TextField addPubField = new TextField();
        TextField addYearField = new TextField();
        TextField addGenreField = new TextField();
        TextField addEditionField = new TextField();

        //add prompts to fields
        addTitleField.setPromptText("Add a title");
        addPubField.setPromptText("Add a publisher");
        addYearField.setPromptText("Add year published");
        addGenreField.setPromptText("Add genre");
        addEditionField.setPromptText("Add edition");

        //add fields and labels to grid
        grid.add(addTitleLabel, 0, 1);
        grid.add(addTitleField, 1, 1);
        grid.add(addPubLabel, 0, 3);
        grid.add(addPubField, 1, 3);
        grid.add(addYearLabel, 0, 4);
        grid.add(addYearField, 1, 4);
        grid.add(addGenreLabel, 0,5);
        grid.add(addGenreField, 1, 5);
        grid.add(addEditionLabel, 0, 6);
        grid.add(addEditionField, 1, 6);

        return grid;

    }

    //stage add book
    private void addBookStage(Stage window){
        addBookWin = new Stage(); //new stage
        addBookWin.initModality(Modality.APPLICATION_MODAL);
        //defines a modal window that blocks events from being
        //delivered to any other application window
        addBookWin.initOwner(window);

        //Book form
        GridPane grid = new GridPane();
        initGrid(grid);

        //define labels
        Label addTitleLabel = new Label("Title: ");
        Label addAuthorLabel = new Label("Author: ");
        Label addPubLabel = new Label("Publisher: ");
        Label addYearLabel = new Label("Year: ");
        Label addGenreLabel = new Label("Genre: ");
        Label addEditionLabel = new Label("Edition: ");

        //define fields
        TextField addTitleField = new TextField();
        TextField addAuthorField = new TextField();
        TextField addPubField = new TextField();
        TextField addYearField = new TextField();
        TextField addGenreField = new TextField();
        TextField addEditionField = new TextField();

        //add prompts to fields
        addTitleField.setPromptText("Add a title");
        addAuthorField.setPromptText("Add an author");
        addPubField.setPromptText("Add a publisher");
        addYearField.setPromptText("Add year published");
        addGenreField.setPromptText("Add genre");
        addEditionField.setPromptText("Add edition");

        //add fields and labels to grid
        grid.add(addTitleLabel, 0, 1);
        grid.add(addTitleField, 1, 1);
        grid.add(addAuthorLabel, 0, 2);
        grid.add(addAuthorField, 1, 2);
        grid.add(addPubLabel, 0, 3);
        grid.add(addPubField, 1, 3);
        grid.add(addYearLabel, 0, 4);
        grid.add(addYearField, 1, 4);
        grid.add(addGenreLabel, 0,5);
        grid.add(addGenreField, 1, 5);
        grid.add(addEditionLabel, 0, 6);
        grid.add(addEditionField, 1, 6);

        //Header for window
        Text addBookHeader = new Text("Add new book");
        addBookHeader.getStyleClass().add("hText");
        HBox topHeader = new HBox(20);
        topHeader.setAlignment(Pos.CENTER);
        topHeader.getChildren().add(addBookHeader);

        //Bottom row of window
        HBox bottomBtn = new HBox(20);
        Button closeBtn = new Button("Close");
        Button addBtn = new Button("Add");
        bottomBtn.setAlignment(Pos.CENTER);
        bottomBtn.getChildren().addAll(addBtn ,closeBtn);

        addBtn.setOnAction(e -> {
            String title = addTitleField.getText();
            String author = addAuthorField.getText();
            String publisher = addPubField.getText();
            String year = addYearField.getText();
            String genre = addGenreField.getText();
            String edition = addEditionField.getText();
            registry.addNewLiterature(new Book(title, author, publisher, genre,
                    year, edition));
            System.out.println(title + ", " + author + ", " + publisher + ", " + genre +
                    ", " + year + ", " + edition);
            addBookWin.close();

        });

        BorderPane addLitPane = new BorderPane();
        addLitPane.setTop(topHeader);
        addLitPane.setBottom(bottomBtn);
        addLitPane.setCenter(grid);
        addLitPane.setMargin(topHeader, new Insets(30, 15, 0, 15));
        addLitPane.setMargin(grid, new Insets(0, 0, 0, 0));
        addLitPane.setMargin(bottomBtn, new Insets(15, 15, 15, 15));

        //close this stage when pressing cancel
        closeBtn.setOnAction(e -> addBookWin.close());

        Scene addLitScene = new Scene(addLitPane, 500, 375);
        addBookWin.setScene(addLitScene);
        addBookWin.show();

        addLitScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

    /**
     * Creates an observable list of all available books
     * @return
     */
    private ObservableList<Book> bookList(){
        Iterator<Literature> it = this.registry.getIterator();
        ObservableList <Book> tableList = FXCollections.observableArrayList();

        while (it.hasNext()) {
            Literature lit = it.next();
            if(lit instanceof Book){
                Book book = (Book) lit;
                tableList.add(book);
            }
        }
        return tableList;
    }

    private void initGrid(GridPane grid){
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
    }

    private void closeProgram() {
        System.out.println("Saved");
        Boolean answer = src.ui.AlertBox.displayConfC();
        if(answer) {
            window.close();
        }
    }

}
