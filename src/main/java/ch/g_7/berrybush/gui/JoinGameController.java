package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.Formular;
import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.common.ViewController;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.game.IGameService;
import ch.g_7.berrybush.server.session.ISessionService;
import ch.g_7.berrybush.server.session.Session;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Optional;

public class JoinGameController extends ViewController {

    @FXML
    public Button join;

    @FXML
    private Button back;

    @FXML
    private Button refresh;

    @FXML
    private TableView<Session> table;

    private ISessionService sessionService;
    private Formular formular;

    public JoinGameController() {
        sessionService = RemoteUtil.getService(ServiceType.SESSION);
    }

    @FXML
    public void initialize() {
        formular = new Formular();

        back.setOnMouseClicked((e)->getNavigator().goTo(SceneType.MAIN_MENU));

        TableColumn<Session, String> nameCol = new TableColumn<>("Game Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameCol);

        TableColumn<Session, String> players = new TableColumn<>("Players");
        players.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPlayers() + "/" + param.getValue().getMaxPlayers()));
        table.getColumns().add(players);

        TableColumn<Session, String> open = new TableColumn<>("Access");
        open.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().isOpen() ? "public" : "private"));
        table.getColumns().add(open);

        TableColumn<Session, String> host = new TableColumn<>("Host");
        host.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getHost()));
        table.getColumns().add(host);

        formular.add(table, (t)->!t.getSelectionModel().isEmpty());
        formular.wrapSubmit(join, (e)->joinGame());

        refresh.setOnMouseClicked((e)->refresh());
        table.autosize();
        refresh();
    }

    private void joinGame() {
        Session session = table.getSelectionModel().getSelectedItem();
        IGameService gameService;
        if(session.isOpen()) {
            gameService = RemoteUtil.get(() -> sessionService.join(session.getName(), Const.getUserName()));
        }else{
            Optional<String> pw = Util.showInputDialog("Password Required", "Please enter the Password");
            if(pw.isEmpty())
                return;
            gameService = RemoteUtil.get(()->sessionService.join(session.getName(), Const.getUserName(), pw.get()));
        }
        if(gameService == null){
            Util.showAlertDialog("Can't connect", "Can't join selected Server, password may be wrong");
        }else{
            getNavigator().goTo(SceneType.GAME, gameService);
        }
    }

    private void refresh(){
        List<Session> sessions = RemoteUtil.get(()->sessionService.getAll());
        table.setItems(FXCollections.observableList(sessions));
    }

}
