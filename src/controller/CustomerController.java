package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CustomerController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) {
        System.out.println("ID : "+txtCustomerId.getText());
        System.out.println("Name : "+txtCustomerName.getText());
        System.out.println("Address : "+txtAddress.getText());
        System.out.println("Salary : "+txtSalary.getText());
    }

}
