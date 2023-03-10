package com.example.vidmot;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PallurC extends ImageView implements LeikHluturInterface {

    private BouncingController bc;
    // private LeikbordC leikbord;
    @FXML
    private PallurC fxPallur;
    public PallurC() {
        try {
            FXML_Lestur.lesa(this, "pallur-view.fxml");
        } catch (Exception e) {
            System.out.println("lesaFxml error í pallur");
        }
    }
    @Override
    public void afram() {
        // leikbord = (LeikbordC) this.getParent();
        LeikbordC leikbord = bc.getFxLeikbord();
        if (fxPallur.getLayoutY() <= 0){
            int a = (int) (Math.random() * leikbord.getWidth()-fxPallur.getFitWidth());
            int b = (int) (Math.random() * leikbord.getWidth()-fxPallur.getFitWidth());
            fxPallur.setLayoutY(b + leikbord.getHeight());
            fxPallur.setLayoutX(a);
        }
        fxPallur.setLayoutY(fxPallur.getLayoutY()-4);
    }
    }



