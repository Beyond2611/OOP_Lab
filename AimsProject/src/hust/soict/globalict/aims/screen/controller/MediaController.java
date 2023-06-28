package hust.soict.globalict.aims.screen.controller;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MediaController {
    private final Media media;
    private final VBox root;
    @FXML
    private HBox option;
    @FXML
    private Label title;
    @FXML
    private Label type;

    public MediaController(Media media) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/media.fxml"));
        this.media = media;
        loader.setController(this);
        try {
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setTitle(String s) {
        title.setText(s);
    }

    public void setType() {
        if (media instanceof Book) type.setText("Book");
        else if (media instanceof CompactDisc) type.setText("CD");
        else if (media instanceof DigitalVideoDisc) type.setText("DVD");
    }

    public void setPlayButton() {
        if (type.getText().equals("CD") || type.getText().equals("DVD")) {
            Button playBtn = new Button("Play");
            playBtn.setOnAction(this::handlePlay);
            option.getChildren().add(playBtn);
        }
    }

    public void add(GridPane box, int col, int row) {
        box.add(root, col, row);
    }

    @FXML
    public void handlePlay(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).playString().toString());
            alert.showAndWait();
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void addToCart(ActionEvent event) {
        Main.addMediaToCart(media);
    }
}
