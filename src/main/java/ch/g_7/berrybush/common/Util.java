package ch.g_7.berrybush.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;

public class Util {


    public static int random(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public static <T> T randomFormList(List<T> list){
        int i = random(0, list.size() - 1);
        return list.get(i);
    }

    @SafeVarargs
    public static <T> T randomFormList(T... ts){
        return randomFormList(Arrays.asList(ts));
    }


    public static boolean isInteger(String value){
        if (value == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isValidString(String string){
        return Pattern.matches("[a-zA-Z_]+[0-9a-zA-Z_]*", string);
    }

    public static boolean isInBounds(String integer, int min, int max){
        if(Util.isInteger(integer)){
            int val = Integer.parseInt(integer);
            return val >= min && val <= max;
        }
        return false;
    }



    public static void showAlert(String title, String description){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(description);
        alert.showAndWait();
    }
}
