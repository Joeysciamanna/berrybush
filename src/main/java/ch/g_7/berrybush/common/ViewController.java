package ch.g_7.berrybush.common;

import javafx.scene.Scene;

public class ViewController {

    private FXMLScene<?> scene;

    void setScene(FXMLScene<?> scene) {
        this.scene = scene;
    }

    public FXMLScene<?> getScene() {
        return scene;
    }
}
