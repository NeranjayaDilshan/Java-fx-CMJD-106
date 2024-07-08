package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private AnchorPane root;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        System.out.println("Customer Button Clicked");
        // Load New Stage
        // URL resource = this.getClass().getResource("/view/Customer.fxml");
        // Parent root = FXMLLoader.load(resource);
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Customer.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Customer Form");

        // Load to existing stage
        // this.root.getChildren().clear();
        // Parent node = FXMLLoader.load(this.getClass().getResource("/view/Customer.FXML"));
        // this.root.getChildren().add(node);


    }

    @FXML
    void btnItemOnAction(ActionEvent event) {
        System.out.println("Item Button Clicked");
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {
        System.out.println("Order Button Clicked");
    }
}
