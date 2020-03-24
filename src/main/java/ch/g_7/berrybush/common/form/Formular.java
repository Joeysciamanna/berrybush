package ch.g_7.berrybush.common.form;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Formular {

    private final Map<Node, Function<Node, Boolean>> formFields;

    public Formular() {
        this.formFields = new HashMap<>();
    }

    public <T extends Node> void add(T node, Function<T, Boolean> validator){
        formFields.put(node, (Function<Node, Boolean>) validator);
    }

    public boolean validate(){
        boolean valid = true;
        for (Map.Entry<Node, Function<Node, Boolean>> entry : formFields.entrySet()) {
            valid = valid && entry.getValue().apply(entry.getKey());
        }
        return valid;
    }
}
