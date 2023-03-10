package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class LeikbordC extends Pane implements LeikHluturInterface {
    public BoltiC getFxBolti() {
        return fxBolti;
    }

    @FXML
    private BoltiC fxBolti;
    @FXML
    private PallurC fxPallur1;
    @FXML
    private PallurC fxPallur2;
    @FXML
    private PallurC fxPallur3;


    public LeikbordC() {
        try {
            FXML_Lestur.lesa(this, "leikbord-view.fxml");
        } catch (Exception e) {
            System.out.println("lesaFxml error í leikbord");
        }
    }

    @Override
    public void afram() {
        if (!boltiABotni() && fxBolti.getCorn()==null){
            fxBolti.setRotate(Stefna.NIDUR.getGradur());
            fxBolti.afram();
        }
    }

    public boolean boltiABotni() {
        if (fxBolti.getLayoutY() >= getHeight() - fxBolti.getFitHeight()) {
            return true;
        }
        return false;
    }

    public void setjaBoltaAPall (PallurC p){
        fxBolti.setCorn(p);
    }

    public void hendaBoltaAfPalli (PallurC p){
        fxBolti.setCorn(null);
    }

    public void athugaBoltiAPalli(PallurC p){
        if(fxBolti.getBoundsInParent().intersects(p.getBoundsInParent())){
            setjaBoltaAPall(p);
            fxBolti.setLayoutY(fxBolti.getCorn().getLayoutY() - fxBolti.getFitHeight());
        } else if (p == fxBolti.getCorn()){
            hendaBoltaAfPalli(p);
        }
    }
}