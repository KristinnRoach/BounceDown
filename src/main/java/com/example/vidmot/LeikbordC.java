package com.example.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class LeikbordC extends Pane implements LeikHluturInterface {
    private BouncingController bc;
    /**
     * Nær í controllerinn
     *
     * @return controllerinn
     */
    public BouncingController getBc() {
        return bc;
    }

    /**
     * Setur controller fyrir viðmótshlutinn
     *
     * @param bc controllerinn
     */
    public void setBc(BouncingController bc) {
        this.bc = bc;
    }
    private Audio audio = new Audio();
    @FXML
    private BoltiC fxBolti;
    public BoltiC getFxBolti() {
        return fxBolti;
    }
    @FXML
    protected PallurC fxPallur, fxPallur1, fxPallur2, fxPallur3, fxPallur4, fxPallur5, fxPallur6;

    public ObservableList<PallurC> getFxPallar() {
        return fxPallar;
    }

    ObservableList<PallurC> fxPallar= FXCollections.observableArrayList();

    public LeikbordC() {
        try {
            FXML_Lestur.lesa(this, "leikbord-view.fxml");
        } catch (Exception e) {
            System.out.println("lesaFxml error í leikbord");
        }
        fxPallar.add(fxPallur);
        fxPallar.add(fxPallur1);
        fxPallar.add(fxPallur2);
        fxPallar.add(fxPallur3);
        fxPallar.add(fxPallur4);
        fxPallar.add(fxPallur5);
        fxPallar.add(fxPallur6);
    }

    @Override
    public void afram() {
        for (PallurC p : fxPallar) {
            p.afram();
            athugaBoltiAPalli(p);
        }
        if (!boltiABotni() && fxBolti.getOnIt() == null) {
            fxBolti.setRotate(Stefna.NIDUR.getGradur());
            fxBolti.afram();
        }
    }


       /* if (fxBolti.getLayoutX() > getWidth() - fxBolti.getFitWidth()) {
            fxBolti.setLayoutX(0 + fxBolti.getFitWidth()); }
        if (fxBolti.getLayoutX() < 0 + fxBolti.getFitWidth()) {
            fxBolti.setLayoutX(getWidth() - fxBolti.getFitWidth());
        } */
   /* public void ballAtBorder(){
        if (fxBolti.getLayoutX() >= this.getWidth() - fxBolti.getFitWidth()) {
            fxBolti.setLayoutX(0);
            audio.sfxAudioJump();
        }
        if (fxBolti.getLayoutX() <= this.getWidth() - fxBolti.getFitWidth()) {
                fxBolti.setLayoutX(0);
        }
    } */


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