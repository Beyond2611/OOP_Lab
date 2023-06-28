package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private static Controller controller;

    public static void callPage(String page) {
        controller.moveToPage(page);
    }

    public static void addMediaToStore(Media media) {
        controller.addMediaToStore(media);
    }

    public static void addMediaToCart(Media media) {
        controller.addMediaToCart(media);
    }

    public static int getStoreAmount() {
        return controller.getStoreAmount();
    }

    public static int getCartAmount() {
        return controller.getCartAmount();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/layout.fxml"));
        controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("AIMS");
        stage.setScene(scene);
        stage.show();
        callPage("store");
    }
}
