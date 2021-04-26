package quack;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import quack.controllers.MainMenuController;

import java.io.File;
public class QuackApp extends Application {

    protected Stage stage;
    private final int width = 1200;
    private final int height = 900;
    private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        music();
        stage.setTitle("Quack");
        stage.setResizable(false);

        MainMenuController winScreenController = new MainMenuController(stage);
        winScreenController.initMainMenu();
    }

    public void music() {
        String musicFile = "src/main/resources/music/GameMusic.mp3";
        Media media = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.2);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.setAutoPlay(true);
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
