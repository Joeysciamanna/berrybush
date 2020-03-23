package ch.g_7.berrybush.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStream;

public class FXMLScene<T extends ViewController> extends BaseScene {

    protected T viewController;

    public FXMLScene(Navigator navigator, String fxmlPath) {
        super(loadFXML(fxmlPath), navigator);
        viewController.setScene(this);
    }

    private static Parent loadFXML(String fxmlPath){
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream fxmlStream = FXMLScene.class.getResourceAsStream(fxmlPath);
        if(fxmlStream == null){
            throw new RuntimeException("Can't find fxml ["+fxmlPath+"]");
        }
        Parent parent;
        try{
            parent = fxmlLoader.load(fxmlStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return parent;
    }


    public T getViewController() {
        return viewController;
    }




    private static class
}
