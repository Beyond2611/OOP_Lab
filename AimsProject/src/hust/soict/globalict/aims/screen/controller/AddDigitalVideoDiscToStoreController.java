package hust.soict.globalict.aims.screen.controller;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreController {
    private final BorderPane root;
    @FXML
    private TextField titleTf;
    @FXML
    private TextField categoryTf;
    @FXML
    private TextField costTf;
    @FXML
    private TextField directorTf;
    @FXML
    private TextField lengthTf;

    public AddDigitalVideoDiscToStoreController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/addDigitalVideoDiscToStore.fxml"));
        loader.setController(this);
        try {
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handleAddBtn(ActionEvent event) {
        Main.addMediaToStore(new DigitalVideoDisc(Main.getStoreAmount() + 1, titleTf.getText(), categoryTf.getText(), Float.parseFloat(costTf.getText()), directorTf.getText(), Integer.parseInt(lengthTf.getText())));
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
