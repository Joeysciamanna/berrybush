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

    public MainMenuController() {
        nameService = RemoteUtil.getService(ServiceType.NAME);
    }

    @FXML
    public void initialize() {
        name.setText(RemoteUtil.invoke(nameService::randomName));
        validateName();

        saveName("", name.getText());
        name.textProperty().addListener((observable, oldValue, newValue) -> validateName());


        newGame.setOnMouseClicked((e)->{
            if(validateName()) getNavigator().goTo(SceneType.NEW_GAME);
        });
        joinGame.setOnMouseClicked((e)->{
            if(validateName()) getNavigator().goTo(SceneType.JOIN_GAME);
        });
        exit.setOnMouseClicked((e)-> Platform.exit());
    }

    private boolean validateName() {
        if(Util.validate(name, ()->Util.isValidString(name.getText()))){

        }

        if(RemoteUtil.invoke(()->nameService.exists(name.getText()))){
            return true;
        }
        Util.showAlert("Invalid UserName", "UserName is not set correctly");
        return false;
    }

    private boolean lastWrong;
    private void saveName(String old, String nev) {
        System.out.println("ddd");
        if(!lastWrong) RemoteUtil.invokeVoid(()->nameService.free(old));
        if(!RemoteUtil.invoke(()->nameService.register(nev))){
            name.setStyle("-fx-text-inner-color: red;");
            lastWrong = true;
        }else{
            name.setStyle("-fx-text-inner-color: black;");
            lastWrong = false;
            Const.setUserName(nev);
        }
    }


}
