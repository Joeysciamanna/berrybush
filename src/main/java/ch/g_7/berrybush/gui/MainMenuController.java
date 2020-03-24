package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.common.ViewController;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.name.INameService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController extends ViewController {

    @FXML
    private Button newGame;

    @FXML
    private Button joinGame;

    @FXML
    private Button exit;

    @FXML
    private TextField name;


    private INameService nameService;
    private boolean valid;

    public MainMenuController() {
        nameService = RemoteUtil.getService(ServiceType.NAME);
    }

    @FXML
    public void initialize() {
        name.setText(RemoteUtil.invoke(nameService::randomName));
        name.textProperty().addListener((observable, oldValue, newValue) -> saveName(oldValue, newValue));


        newGame.setOnMouseClicked((e)->{
            if(valid) getNavigator().goTo(SceneType.NEW_GAME);
        });
        joinGame.setOnMouseClicked((e)->{
            if(valid) getNavigator().goTo(SceneType.JOIN_GAME);
        });
        exit.setOnMouseClicked((e)-> Platform.exit());
    }

    private void saveName(String old, String nev) {
        RemoteUtil.invokeVoid(()->nameService.free(old));
        if(!RemoteUtil.invoke(()->nameService.register(nev))){
            name.setStyle("-fx-text-inner-color: red;");
            valid = false;
        }else{
            name.setStyle("-fx-text-inner-color: black;");
            valid = true;
            Const.setUserName(nev);
        }
    }


}
