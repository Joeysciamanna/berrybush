package ch.g_7.berrybush.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javax.swing.text.View;
import java.io.IOException;
import java.io.InputStream;

public class FXMLScene<T extends ViewController> extends BaseScene {

    protected T viewController;

    public FXMLScene(String fxmlPath, Navigator navigator) {
        this(loadFXML(fxmlPath), navigator);
        viewController.setScene(this);
    }

    private FXMLScene(T viewController, Navigator navigator){
        super(viewController.getParent(), navigator);
    }

    private static <T extends ViewController> T  loadFXML(String fxmlPath){
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream fxmlStream = FXMLScene.class.getResourceAsStream(fxmlPath);
        if(fxmlStream == null){
            throw new RuntimeException("Can't find fxml ["+fxmlPath+"]");
        }
        Parent parent;
        T viewController;
        try{
            parent = fxmlLoader.load(fxmlStream);
            viewController = fxmlLoader.getController();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        viewController.setParent(parent);

        return viewController;
    }


    public T getViewController() {
        return viewController;
    }


}
