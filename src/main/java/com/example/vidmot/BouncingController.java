package com.example.vidmot;

import com.example.vinnsla.Leikur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.util.HashMap;

public class BouncingController {
    private Leikur leikurinn;
    private Timeline gameTime;
    private Timeline pallaTime;

    @FXML
    private Label fxStig;
    @FXML
    private Label fxTester;
    @FXML
    private LeikbordC fxLeikbord;

    public LeikbordC getFxLeikbord() {
        return fxLeikbord;
    }

    private final HashMap<KeyCode, Stefna> stefnaMap = new HashMap<KeyCode, Stefna>();


    // Skoða FRACTAL animation!! Setja inn ef hægt ok takk bæ
    // ( gæti komið bara þegar mar deyr eðeikkað einfalt

/*         Bindings.createDoubleBinding(()  -> {    // til að binda y gildið á boltanum við pallinn (breyta úr clock dæminu)
            Date date = control.timePoperty().get();   // þegar boltinn snertir setja binding á og taka af þegar snertir ekki
            return date == null ? "" : FORMAT.format(date);
        }, control.timeProp));

 */


    @FXML
    private void initialize() {
        leikurinn = new Leikur();
        this.fxStig.textProperty().bind(leikurinn.stiginProperty().asString());
        fxTester.setText("yoyoyoyoo");
    }

    public void startGame() {
        KeyFrame k = new KeyFrame(Duration.millis(40),    // hvert tímabil er 50 millisek.
                e -> {
                    fxLeikbord.afram();
                    leikurinn.haekkaStigin();
                    if (fxLeikbord.boltiABotni()) {
                        leikLokid("ónóóó");
                    }
                });
        gameTime = new Timeline(k);           // tengjum timeline og tímabilið
        gameTime.setCycleCount(Timeline.INDEFINITE);   // hve lengi tímalínan keyrist
        gameTime.play();
        KeyFrame p = new KeyFrame(Duration.millis(30),    // hvert tímabil er 50 millisek.
                e -> {
                    fxLeikbord.aframPallar();
                });
        pallaTime = new Timeline(p);
        pallaTime.setCycleCount(Timeline.INDEFINITE);
        pallaTime.play();
        fxTester.setText("GAME ON");
    }


    private void leikLokid(String s) {
        gameTime.stop();
        pallaTime.stop();
        fxTester.setText(s);
    }


    public void orvatakkar() {

        // setjum upp beina aðganginn frá örvatökkunum og í hornið
        stefnaMap.put(KeyCode.RIGHT, Stefna.HAEGRI);
        stefnaMap.put(KeyCode.LEFT, Stefna.VINSTRI);

        Scene s = fxStig.getScene();
        s.addEventFilter(KeyEvent.ANY,      //KeyEvents eru sendar á Scene
                event -> {      // lambda fall - event er parameter
                    // flettum upp horninu fyrir KeyCode í map
                    onActionKeys(event);
                });
    }


   private void onActionKeys(KeyEvent event) {
        try {
            if (stefnaMap.get(event.getCode()) == null) {
                event.consume();
            } else {
                fxLeikbord.getFxBolti().setStefna(stefnaMap.get(event.getCode()).getGradur());
                fxLeikbord.getFxBolti().afram();
        }
        } catch (NullPointerException e) {
            event.consume();
        }
    }


   /* public void testBolti() {
        fxLeikbord.getFxBolti().setRotate(Stefna.NIDUR.gradur);
        for (int i = 0; i < 50; i++) {
            fxLeikbord.getFxBolti().afram();
        }
    } */
}