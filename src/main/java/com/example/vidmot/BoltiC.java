package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


public class BoltiC extends ImageView implements LeikHluturInterface {

    @FXML
    private BoltiC fxBolti;
    private PallurC onIt = null;
    private BouncingController bc;

    public PallurC getOnIt() {
        return onIt;
    }

    public void setOnIt(PallurC Corn) {
        this.onIt = Corn;
    }

    public void setStefna(int gradur) {
        fxBolti.setRotate(gradur);
    }

    public BoltiC() {
        FXML_Lestur.lesa(this, "bolti-view.fxml");
        // fxBolti.setImage(new Image("src/main/resources/com/example/vidmot/myndir/boltiDwnLeft.png"));

    }

    @Override
    public void afram() {
        if (fxBolti.getRotate() == Stefna.HAEGRI.getGradur()) {
            fxBolti.setLayoutX(fxBolti.getLayoutX() + 15);
        } else if (fxBolti.getRotate() == Stefna.VINSTRI.getGradur()) {
            //fxBolti.setTranslateZ(fxBolti.getBoundsInLocal().getWidth() / 2.0);
            //fxBolti.setRotationAxis(Rotate.Y_AXIS);
            fxBolti.setLayoutX(fxBolti.getLayoutX() - 15);
        } else if (fxBolti.getRotate() == Stefna.NIDUR.getGradur()) {
            fxBolti.setLayoutY(fxBolti.getLayoutY() + 10);
        } else if (fxBolti.getRotate() == Stefna.UPP.getGradur()) {
            fxBolti.setLayoutY(fxBolti.getLayoutY() - 50);
        }
    }
}

/*
@Override
public void afram() {
    TranslateTransition tr = new TranslateTransition();
    tr.setNode(fxBolti);
    tr.setDuration(Duration.millis(1000));
    if (fxBolti.getRotate() == Stefna.HAEGRI.getGradur()) {

    } else if (fxBolti.getRotate() == Stefna.VINSTRI.getGradur()) {

    } else if (fxBolti.getRotate() == Stefna.NIDUR.getGradur()) {

    } else if (fxBolti.getRotate() == Stefna.UPP.getGradur()) {
        tr.setByY(250);
        tr.play();
    }
 */



