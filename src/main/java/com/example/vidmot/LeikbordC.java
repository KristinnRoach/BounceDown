package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class LeikbordC extends Pane implements LeikHluturInterface {
    @FXML
    private BoltiC fxBolti;
    public BoltiC getFxBolti() {
        return fxBolti;
    }
   // @FXML
    //protected PallurC fxPallur1;

    public PallurC getFxPallur1() { return fxPallur1; }



    public LeikbordC() {
        try {
            FXML_Lestur.lesa(this, "leikbord-view.fxml");
        } catch (Exception e) {
            System.out.println("lesaFxml error í leikbord");
        }
    }

    @Override
    public void afram() {
        if (!boltiABotni() && fxBolti.getOnIt()==null){
            fxBolti.setRotate(Stefna.NIDUR.getGradur());
            fxBolti.afram();
           // athugaBoltiAPalli(fxPallur1);
        }
    }
    public void aframPallar() {
        for (PallurC p : fxPallar) {
            p.afram();
            athugaBoltiAPalli(p);
        }
    }

    public boolean boltiABotni() {
        if (fxBolti.getLayoutY() >= getHeight() - fxBolti.getFitHeight()) {
            return true;
        }
        return false;
    }

    public void setjaBoltaAPall (PallurC p){
        fxBolti.setOnIt(p);
    }

    public void hendaBoltaAfPalli (PallurC p){
        fxBolti.setOnIt(null);
    }

    public void athugaBoltiAPalli(PallurC p){
        if(fxBolti.getBoundsInParent().intersects(p.getBoundsInParent())){
            setjaBoltaAPall(p);
            fxBolti.setLayoutY(fxBolti.getOnIt().getLayoutY() - fxBolti.getFitHeight());
        } else if (p == fxBolti.getOnIt()){
            hendaBoltaAfPalli(p);
        }
    }
}