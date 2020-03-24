package ch.g_7.berrybush.common;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

public class Formular {

    private final Map<Node, Function<Node, Boolean>> formFields;

    public Formular() {
        this.formFields = new HashMap<>();
    }

    public <T extends Node> void add(T node, Function<T, Boolean> validator){
        formFields.put(node, (Function<Node, Boolean>) validator);
    }

    public void addTextField(TextField node, Function<String, Boolean> validator){
        add(node, (TextField n)->{
                if(validator.apply(n.getText())){
                    node.setStyle("-fx-text-inner-color: black;");
                    return true;

                }else{
                    node.setStyle("-fx-text-inner-color: red;");
                    return false;
                }
        });
    }



    public boolean validate(){
        boolean valid = true;
        for (Map.Entry<Node, Function<Node, Boolean>> entry : formFields.entrySet()) {
            valid = valid && entry.getValue().apply(entry.getKey());
        }
        return valid;
    }

    public void wrapSubmit(Button button, EventHandler<MouseEvent> handler){
        button.setOnMouseClicked((e)->{
            if(validate()) handler.handle(e);
            else  Util.showAlert("Invalid Input", "Please check your input again");
        });
    }
}
