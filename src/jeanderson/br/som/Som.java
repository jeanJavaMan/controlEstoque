/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.som;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;



/**
 *
 * @author Jeanderson S.Lopes
 */
public class Som extends Application{
    AudioClip som;
    public void tocar(int tipo){
        String local = "file:/C:/Users/"+ System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Audio/"+tipo+".mp3";
        som = new AudioClip(local.replace("\\","/").replace(" ", "%20"));
        if(som.isPlaying()){
            som.stop();
            som.play();
        }else{
            som.play();
        }
    }
    public void parar(){
        if(som.isPlaying()){
            som.stop();
        }
        
    }
    

    @Override
    public void start(Stage stage) throws Exception {
    }

    

}
