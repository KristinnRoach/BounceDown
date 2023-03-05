package com.example.vidmot;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class BoltiC extends ImageView {

    protected Image bMynd;
    public BoltiC() throws IOException {
        FXML_Lestur.lesa(this,"bolti-view.fxml");
        // this.bMynd = new Image("com/example/vidmot/myndir/kidPilot_Appo.jpg");

    }
}
