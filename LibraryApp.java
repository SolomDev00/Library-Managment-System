import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LibraryApp extends Application {

    private final BookManager bookManager = new BookManager();
    private final ObservableList<Book> bookList = FXCollections.observableArrayList();

    @SuppressWarnings({ "unused", "deprecation", "unchecked" })
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #f4f4f4;");

        Label titleLabel = new Label("Library Management System");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField titleField = new TextField();
        titleField.setPromptText("Enter book title");

        TextField authorField = new TextField();
        authorField.setPromptText("Enter book author");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Enter book category");

        HBox inputFields = new HBox(10, titleField, authorField, categoryField);
        inputFields.setPadding(new Insets(10, 0, 10, 0));

        Button addButton = new Button("Add Book");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        addButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String category = categoryField.getText();
            if (!title.isEmpty() && !author.isEmpty() && !category.isEmpty()) {
                Book book = new Book(title, author, category);
                bookManager.addBook(book);
                bookList.add(book);
                titleField.clear();
                authorField.clear();
                categoryField.clear();
                showAlert("Success", "Book added successfully!", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "Please fill all fields!", Alert.AlertType.ERROR);
            }
        });

        Button showButton = new Button("Show Books");
        showButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold;");

        TableView<Book> bookTable = new TableView<>(bookList);
        bookTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        bookTable.getColumns().addAll(titleCol, authorCol, categoryCol);

        showButton.setOnAction(e -> bookTable.setItems(FXCollections.observableArrayList(bookManager.getBooks())));

        root.getChildren().addAll(titleLabel, inputFields, new HBox(10, addButton, showButton), bookTable);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
