package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.common.ViewController;
import ch.g_7.berrybush.common.Formular;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.session.ISessionService;
import ch.g_7.berrybush.server.session.Session;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewGameController extends ViewController {

    @FXML
    public TextField name;

    @FXML
    public TextField maxPlayers;

    @FXML
    public RadioButton open;

    @FXML
    public Label passwordLabel;

    @FXML
    public TextField password;

    @FXML
    public Button back;

    @FXML
    public Button create;


    private Formular formular;
    private ISessionService sessionService;

    public NewGameController() {
        sessionService = RemoteUtil.getService(ServiceType.SESSION);
    }

    @FXML
    public void initialize() {
        formular = new Formular();
        formular.addTextField(name, (s)->Util.isValidString(s) &&
                !RemoteUtil.invoke(()->sessionService.exists(s)));
        formular.addTextField(maxPlayers, (s)->Util.isInBounds(s, 2, 16));
        formular.addTextField(password, (s)->(!open.isSelected()) || !password.getText().isBlank());

        open.setOnMouseClicked((e)->{
            passwordLabel.setDisable(!passwordLabel.isDisabled());
            password.setDisable(!password.isDisabled());
        });

        formular.wrapSubmit(create, (e)->createGame());

        name.setText(RemoteUtil.invoke(sessionService::randomName));
        back.setOnMouseClicked((e)->getNavigator().goTo(SceneType.MAIN_MENU));
    }

    private void createGame() {
        Session session;
        if(open.isSelected()){
            session = new Session(name.getText(), Integer.valueOf(maxPlayers.getText()), Const.getUserName());
        }else{
            session = new Session(name.getText(), Integer.valueOf(maxPlayers.getText()), Const.getUserName(), password.getText());
        }
        if(!RemoteUtil.invoke(()->sessionService.create(session))){
            throw new RuntimeException("Invalid Name, User cant be registered");
        }
        getNavigator().goTo(SceneType.GAME, name);
    }

}
