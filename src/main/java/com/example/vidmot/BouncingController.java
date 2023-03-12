package com.example.vidmot;

import com.example.vinnsla.Leikur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Random;

public class BouncingController {
    private Leikur leikurinn;
    private Timeline gameTime;
    @FXML
    private Label fxStig;
    @FXML
    private Label fxTester;
    @FXML
    private LeikbordC fxLeikbord;
    @FXML
    public MediaView mediaView;
    @FXML
    public Button fxAudioTest;



    // public MediaView getMediaView() { return mediaView; }


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
        fxTester.setText("GAME ON");
    }
    @FXML
    protected void sfxJump() {
        try {
            String path = "";
            Media[] media = new Media[6];
            URI[] uri = new URI[6];
            for(int i = 0; i < 6; i++) {
                path = "src/main/resources/com/example/vidmot/Audio/jump" + (i + 1) + ".aif";
                uri[i] = new File(path).toURI();
                media[i] = new Media(uri[i].toString());
            }
            Random rand = new Random();
            int randInt = rand.nextInt(6);
            MediaPlayer jump = new MediaPlayer(media[randInt]);
            mediaView.setMediaPlayer(jump);
            jump.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void startGame() {
        KeyFrame k = new KeyFrame(Duration.millis(30),    // hvert tímabil er 50 millisek.
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
    }


    private void leikLokid(String s) {
        gameTime.stop();
        fxTester.setText(s);
    }


    public void orvatakkar() {

        // setjum upp beina aðganginn frá örvatökkunum og í hornið
        stefnaMap.put(KeyCode.RIGHT, Stefna.HAEGRI);
        stefnaMap.put(KeyCode.LEFT, Stefna.VINSTRI);
        stefnaMap.put(KeyCode.UP, Stefna.UPP);


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