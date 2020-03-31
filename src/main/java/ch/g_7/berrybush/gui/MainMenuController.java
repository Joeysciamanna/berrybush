package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.Formular;
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

    private Formular formular;
    private INameService nameService;

    public MainMenuController() {
        nameService = RemoteUtil.getService(ServiceType.NAME);
    }

    @FXML
    public void initialize() {
        formular = new Formular();
        formular.addTextField(name, (s)->Util.isValidString(s) &&
                (s.equals(Const.getUserName()) || !RemoteUtil.get(()->nameService.exists(name.getText()))));

        formular.wrapSubmit(newGame, (e)->{
            saveName();
           getNavigator().goTo(SceneType.NEW_GAME);
        });

        formular.wrapSubmit(joinGame, (e)->{
            saveName();
            getNavigator().goTo(SceneType.JOIN_GAME);
        });

        name.setText(RemoteUtil.get(nameService::randomName));
        exit.setOnMouseClicked((e)-> Platform.exit());
    }


    private void saveName() {
        if(name.getText().equals(Const.getUserName()) || RemoteUtil.get(()->nameService.register(name.getText()))){
            Const.setUserName(name.getText());
        }else{
            throw new RuntimeException("Invalid Name, User can't be registered");
        }
    }


}
