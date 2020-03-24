package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.common.ViewController;
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
import javafx.util.converter.NumberStringConverter;

import java.awt.*;

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



    private ISessionService sessionService;

    public NewGameController() {
        sessionService = RemoteUtil.getService(ServiceType.SESSION);
    }

    @FXML
    public void initialize() {
        name.setText(RemoteUtil.invoke(sessionService::randomName));
        open.setOnMouseClicked((e)->{
            passwordLabel.setDisable(!passwordLabel.isDisabled());
            password.setDisable(!password.isDisabled());
        });
        create.setOnMouseClicked((e)->createGame());
        maxPlayers.textProperty().addListener((observable, oldValue, newValue) -> validateMaxPlayers());

        back.setOnMouseClicked((e)->getNavigator().goTo(SceneType.MAIN_MENU));
    }

    private void validateMaxPlayers() {
        if(!Util.isInBounds(maxPlayers.getText(), 2, 16)){
            maxPlayers.setStyle("-fx-text-inner-color: red;");
        }else{
            maxPlayers.setStyle("-fx-text-inner-color: black;");
        }
    }

    private void createGame() {
        if(!Util.isInBounds(maxPlayers.getText(), 2, 16)){
            validateMaxPlayers();
            Util.showAlert("Invalid Input", "Max Players must be Integer");
            return;
        }
        if(open.isSelected()){
            if(RemoteUtil.invoke(()->sessionService.create(
                    new Session(name.getText(), Integer.valueOf(maxPlayers.getText()), Const.getUserName())))){

            }
        }

    }

}
