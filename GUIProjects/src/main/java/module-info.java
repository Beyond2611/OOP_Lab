module hust.soict.globalict.swing {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires java.desktop;

    opens hust.soict.globalict.swing to javafx.fxml;
    opens hust.soict.globalict.javafx to javafx.fxml;
    exports hust.soict.globalict.javafx;
    exports hust.soict.globalict.swing;
}