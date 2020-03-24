package ch.g_7.berrybush.common;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewController {

    private Navigator navigator;
    private FXMLScene<?> scene;
    private Parent parent;


    void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    void setParent(Parent parent) {
        this.parent = parent;
    }

    void setScene(FXMLScene<?> scene) {
        this.scene = scene;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public FXMLScene<?> getScene() {
        return scene;
    }

    public Parent getParent() {
        return parent;
    }
}
