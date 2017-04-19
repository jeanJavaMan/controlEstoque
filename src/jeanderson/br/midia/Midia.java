/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.midia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Midia extends Application {

    Media media;

    public void iniciarTuto() {
        launch();

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        String local = "file:/C:/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Media/Tutorial.mp4";
        media = new Media(local.replace(" ", "%20").replace("\\", "/"));
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        StackPane raiz = new StackPane();
        raiz.getChildren().add(mediaView);
        Scene cena = new Scene(raiz, 900, 500);
        palco.setTitle("Novidades da Versão");
        palco.setScene(cena);
        palco.show();
        mediaPlayer.play();

    }

}
