package ch.g_7.berrybush.common;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewController {

    private FXMLScene<?> scene;
    private Parent parent;


    void setParent(Parent parent) {
        this.parent = parent;
    }

    void setScene(FXMLScene<?> scene) {
        this.scene = scene;
    }

    public FXMLScene<?> getScene() {
        return scene;
    }

    public Parent getParent() {
        return parent;
    }
}
