package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class BoltiC extends ImageView implements LeikHluturInterface {

    @FXML
    private BoltiC fxBolti;

    public PallurC getCorn() {
        return Corn;
    }

    private PallurC Corn = null;

    public void setCorn(PallurC Corn) {
        this.Corn = Corn;
    }

    private Stefna stefna;

    public BoltiC() {
        FXML_Lestur.lesa(this, "bolti-view.fxml");
    }

    public void setStefna(int gradur) {
        fxBolti.setRotate(gradur);
    }

    @Override
    public void afram() {
        if (fxBolti.getRotate() == Stefna.HAEGRI.getGradur()) {
            fxBolti.setLayoutX(fxBolti.getLayoutX() + 15);
        } else if (fxBolti.getRotate() == Stefna.VINSTRI.getGradur()) {
            fxBolti.setLayoutX(fxBolti.getLayoutX() - 15);
        } else if (fxBolti.getRotate() == Stefna.NIDUR.getGradur()) {
            fxBolti.setLayoutY(fxBolti.getLayoutY() + 10);
        }
    }
}

