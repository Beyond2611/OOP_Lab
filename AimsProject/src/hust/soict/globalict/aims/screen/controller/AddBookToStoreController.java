package hust.soict.globalict.aims.screen.controller;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.screen.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AddBookToStoreController {
    private final BorderPane root;
    @FXML
    private TextField titleTf;
    @FXML
    private TextField categoryTf;
    @FXML
    private TextField costTf;

    public AddBookToStoreController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/addBookToStore.fxml"));
        loader.setController(this);
        try {
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handleAddBtn(ActionEvent event) {
        Main.addMediaToStore(new Book(Main.getStoreAmount() + 1, titleTf.getText(), categoryTf.getText(), Float.parseFloat(costTf.getText())) );
        Main.callPage("store");
    }

    @FXML
    public void showStore(javafx.event.ActionEvent event) {
        Main.callPage("store");
    }

    @FXML
    public void showCart(javafx.event.ActionEvent event) {
        Main.callPage("cart");
    }

    @FXML
    public void showAddBook(javafx.event.ActionEvent event) {
        Main.callPage("add-book");
    }

    @FXML
    public void showAddCD(javafx.event.ActionEvent event) {
        Main.callPage("add-cd");
    }

    @FXML
    public void showAddDVD(javafx.event.ActionEvent event) {
        Main.callPage("add-dvd");
    }

    public void add(VBox box) {
        box.getChildren().add(root);
    }
}
