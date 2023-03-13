package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


public class BoltiC extends ImageView implements LeikHluturInterface {

    private PallurC onIt = null;
    private LeikbordC leikbord;
    @FXML
    private BoltiC fxBolti;

    // private LeikbordC leikbord = (LeikbordC) this.getParent();
    // private final double OFFSET = 1;

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
    }

    @Override
    public void afram() {

        /*
        fxBolti.setLayoutX((int) (fxBolti.getLayoutX() + leikbord.getWidth() + (int) Math.cos(Math.toRadians(getRotate())) * OFFSET) % (int) leikbord.getWidth());
        fxBolti.setLayoutY((int) (fxBolti.getLayoutY() + leikbord.getHeight() - (int) Math.sin(Math.toRadians(getRotate())) * OFFSET) % (int) leikbord.getHeight());
        */

        //TranslateTransition translateTransition = new TranslateTransition(Duration.millis(40));
        if (fxBolti.getRotate() == Stefna.HAEGRI.getGradur()) {
            fxBolti.setLayoutX(fxBolti.getLayoutX() + 15);
            //fxBolti.setTranslateX(getTranslateX() + 15);
        } else if (fxBolti.getRotate() == Stefna.VINSTRI.getGradur()) {
            //fxBolti.setTranslateZ(fxBolti.getBoundsInLocal().getWidth() / 2.0);
            //fxBolti.setRotationAxis(Rotate.Y_AXIS);
            fxBolti.setLayoutX(fxBolti.getLayoutX() - 15);
        } else if (fxBolti.getRotate() == Stefna.NIDUR.getGradur()) {
            fxBolti.setLayoutY(fxBolti.getLayoutY() + 10);
        } else if (fxBolti.getRotate() == Stefna.UPP.getGradur()) {
            fxBolti.setLayoutY(fxBolti.getLayoutY() - 50);
            leikbord.getBc().sfxJump();
        } // leikbord.getBc().sfxJump();

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



