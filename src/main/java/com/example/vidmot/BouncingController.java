package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BouncingController {
    private Fxml_ lesaFxml;
    @FXML
    private Label fxStig;
    // @FXML
    // private Leikbord leikbord;
    @FXML
    private BoltiC fxBolti;



    private void initialize(){
        fxBolti.setImage(fxBolti.bMynd);
    }
}