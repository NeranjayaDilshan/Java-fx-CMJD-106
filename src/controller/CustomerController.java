package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.Customer;

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
    void btnSaveCustomerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("ID : " + txtCustomerId.getText());
        System.out.println("Name : " + txtCustomerName.getText());
        System.out.println("Address : " + txtAddress.getText());
        System.out.println("Salary : " + txtSalary.getText());

        int id = Integer.parseInt(txtCustomerId.getText());
        String name = txtCustomerName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        Customer customer = new Customer(id,name,address,salary);
        System.out.println(customer);
         
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
        statement.setObject(1, customer.getCustomerID());
        statement.setObject(2, customer.getName());
        statement.setObject(3, customer.getAddress());
        statement.setObject(4, customer.getSalary());

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("Customer Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved Successfully!!!").show();
        }else{
            System.out.println("Error While Saving Customer");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Customer").show();
        }
    }

}
