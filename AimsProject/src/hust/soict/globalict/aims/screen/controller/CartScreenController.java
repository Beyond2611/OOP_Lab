package hust.soict.globalict.aims.screen.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.screen.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class CartScreenController {
    private final Cart cart;
    private final BorderPane root;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;
    @FXML
    private Label total;

    public CartScreenController(Cart cart) {
        this.cart = cart;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/cart.fxml"));
        loader.setController(this);
        try {
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void updateButtonBar(Media media) {
        btnPlay.setVisible(true);
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    public void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        setTotal(cart.totalCost() + " $");
    }

    @FXML
    public void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).playString().toString());
            alert.showAndWait();
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void placeOrder(ActionEvent event) {
        float total = cart.totalCost();
        cart.clearCart();
        setTotal(cart.totalCost() + " $");
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "An order is created . Total cost is " + total + " $");
        alert.showAndWait();
    }

    public void setTable() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        setTotal(cart.totalCost() + " $");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        if (newValue != null) updateButtonBar(newValue);
                    }
                }
        );
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    public void add(VBox box) {
        box.getChildren().add(root);
    }

    public void setTotal(String s) {
        total.setText(s);
    }

    void showFilteredMedia(String filter) {
        String filterType;
        if (radioBtnFilterTitle.isSelected()) filterType = "title";
        else if (radioBtnFilterId.isSelected()) filterType = "id";
        else filterType = "";

        FilteredList<Media> list = new FilteredList<>(cart.getItemsOrdered(), null);
        list.setPredicate(media -> media.filterProperty(filter, filterType));

        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(list);
        }
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


}
