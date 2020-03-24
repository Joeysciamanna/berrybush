package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.ViewController;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.session.ISessionService;
import ch.g_7.berrybush.server.session.Session;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class JoinGameController extends ViewController {

    @FXML
    public Button join;

    @FXML
    private Button back;

    @FXML
    private TableView<Session> table;

    private ISessionService sessionService;

    public JoinGameController() {
        sessionService = RemoteUtil.getService(ServiceType.SESSION);
    }

    @FXML
    public void initialize() {
        back.setOnMouseClicked((e)->getNavigator().goTo(SceneType.MAIN_MENU));

        TableColumn<Session, String> nameCol = new TableColumn<>();
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameCol);
        TableColumn<Session, String> players = new TableColumn<>();
        nameCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        table.getColumns().add(players);
        TableColumn<Session, String> open = new TableColumn<>();
        nameCol.setCellValueFactory(new PropertyValueFactory<>("access"));
        table.getColumns().add(open);
        TableColumn<Session, String> host = new TableColumn<>();
        nameCol.setCellValueFactory(new PropertyValueFactory<>("host"));
        table.getColumns().add(host);

        try {
            table.setItems(FXCollections.observableList(sessionService.getAll()));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }


        table.setItems(FXCollections.observableList(new ArrayList<>()));

        join.setOnMouseClicked((e)->getNavigator().goTo(SceneType.JOIN_GAME));

    }

}
