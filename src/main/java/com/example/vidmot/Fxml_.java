package com.example.vidmot;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

// bolti  //


public class Fxml_ {
    public static void lesaFxml(Object o, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Fxml_.class.getResource(fxml));
        fxmlLoader.setRoot(o);
        fxmlLoader.setController(o);
        fxmlLoader.load();
    }
}
