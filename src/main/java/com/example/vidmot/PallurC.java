package com.example.vidmot;

import javafx.scene.image.ImageView;

public class PallurC extends ImageView implements LeikHluturInterface {

    private BouncingController bc;
    // private LeikbordC leikbord;
/*
    @FXML
    private PallurC fxPallur;
 */
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
        if (leikbord.fxPallur1.getLayoutY() <= 0){
            int a = (int) (Math.random() * leikbord.getWidth()-leikbord.fxPallur1.getFitWidth());
            int b = (int) (Math.random() * leikbord.getWidth()-leikbord.fxPallur1.getFitWidth());
            leikbord.fxPallur1.setLayoutY(b + leikbord.getHeight());
            leikbord.fxPallur1.setLayoutX(a);
        }
        leikbord.fxPallur1.setLayoutY(leikbord.fxPallur1.getLayoutY()-4);
    }
    }



