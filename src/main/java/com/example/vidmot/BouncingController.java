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
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class BouncingController {
    private Leikur leikurinn;
    private Timeline gameTime;
    //private Animation animation = new Animation();
    @FXML
    protected BorderPane fxRoot;
    @FXML
    private Label fxStig;
    @FXML
    private Label fxTester;
    @FXML
    private LeikbordC fxLeikbord;
    @FXML
    public MediaView mediaView;
    @FXML
    public Button fxRestart;
    private Audio audio = new Audio();

    public BouncingController() throws IOException { }

    // public MediaView getMediaView() { return mediaView; }

    public LeikbordC getFxLeikbord() {
        return fxLeikbord;
    }

    private final HashMap<KeyCode, Stefna> stefnaMap = new HashMap<KeyCode, Stefna>();

    @FXML
    private void initialize() {
        leikurinn = new Leikur();
        this.fxStig.textProperty().bind(leikurinn.stiginProperty().asString());
        fxTester.setText("GAME ON");
    }
/*    private void displayApplication() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    (new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    @FXML
    public void restart(){
        leikLokid("Restarting!");
        BouncingApplication BA = new
    }
*/
    @FXML
    protected void sfxJump() { audio.sfxAudioJump(); }
    @FXML
    protected void muteAudio() {
        if (audio.getMp().isMute()) {
            audio.getMp().setMute(false);
        } else {
            audio.getMp().setMute(true);
        }
    }

    public void startGame() {
        KeyFrame k = new KeyFrame(Duration.millis(10),
                e -> {
                    fxLeikbord.afram();
                    leikurinn.haekkaStigin();
                    if (fxLeikbord.boltiABotni()) {
                        leikLokid("ónóóó");
                    }
                });
        gameTime = new Timeline(k);
        gameTime.setCycleCount(Timeline.INDEFINITE);
        gameTime.play();
        audio.sfxPlayAudio();
    }


    private void leikLokid(String s) {
        gameTime.stop();
        fxTester.setText(s);
        //animation.paint(0, 0, 0);
    }


    public void orvatakkar() {

        // setjum upp beina aðganginn frá örvatökkunum og í hornið
        stefnaMap.put(KeyCode.RIGHT, Stefna.HAEGRI);
        stefnaMap.put(KeyCode.LEFT, Stefna.VINSTRI);
        stefnaMap.put(KeyCode.UP, Stefna.UPP);


        Scene s = fxStig.getScene();
        s.addEventFilter(KeyEvent.ANY,
                event -> { onActionKeys(event); } );
    }

   private void onActionKeys(KeyEvent event) {
       try {
            if (stefnaMap.get(event.getCode()) == null) {
                event.consume();
            } else {
                fxLeikbord.getFxBolti().setStefna(stefnaMap.get(event.getCode()).getGradur());
                fxLeikbord.getFxBolti().afram();
                if(event.getCode() == KeyCode.UP) { sfxJump(); }
        }
        } catch (NullPointerException e) {
            event.consume();
        }
    }
}