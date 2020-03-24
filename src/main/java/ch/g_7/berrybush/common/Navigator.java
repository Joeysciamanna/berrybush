package ch.g_7.berrybush.common;

import javafx.stage.Stage;
import ch.g_7.berrybush.gui.SceneType;

import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Map<SceneType, BaseScene> viewMap = new HashMap<SceneType, BaseScene>();
    private Stage stage;
    private BaseScene activeScene;

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(SceneType enumScene, BaseScene scene) {
        viewMap.put(enumScene, scene);
    }

    public void goTo(SceneType scene) {
        if (activeScene != null) {
            activeScene.onClose();
        }
        activeScene = viewMap.get(scene);
        stage.setScene(activeScene);
        activeScene.onOpen();
    }

    @SuppressWarnings("unchecked")
    public <T> void goTo(SceneType scene, T data){
        if (activeScene != null) {
            activeScene.onClose();
        }
        activeScene = viewMap.get(scene);
        stage.setScene(activeScene);
        if(activeScene instanceof IDataReceiver){
            ((IDataReceiver<T>) activeScene).receive(data);
        }else{
            throw new RuntimeException(scene + " does not require data");
        }
        activeScene.onOpen();
    }

}
