package hust.soict.globalict.aims.screen.controller;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.screen.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AddCompactDiscToStoreController {
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
    @FXML
    private TextField artistTf;

    public AddCompactDiscToStoreController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/addCompactDiscToStore.fxml"));
        loader.setController(this);
        try {
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handleAddBtn(ActionEvent event) {
        Main.addMediaToStore(new CompactDisc(Main.getStoreAmount() + 1, titleTf.getText(), categoryTf.getText(), Float.parseFloat(costTf.getText()), directorTf.getText(), Integer.parseInt(lengthTf.getText()), artistTf.getText()));
        Main.callPage("store");
    }

    @FXML
    public void showStore(ActionEvent event) {
        Main.callPage("store");
    }

    @FXML
    public void showCart(ActionEvent event) {
        Main.callPage("cart");
    }

    @FXML
    public void showAddBook(ActionEvent event) {
        Main.callPage("add-book");
    }

    @FXML
    public void showAddCD(ActionEvent event) {
        Main.callPage("add-cd");
    }

    @FXML
    public void showAddDVD(ActionEvent event) {
        Main.callPage("add-dvd");
    }

    public void add(VBox box) {
        box.getChildren().add(root);
    }
}
