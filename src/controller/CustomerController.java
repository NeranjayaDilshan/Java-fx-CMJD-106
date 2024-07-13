package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import tm.CustomerTM;

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
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TableColumn<CustomerTM, String> colAction;

    @FXML
    private TableColumn<CustomerTM, String> colAddress;

    @FXML
    private TableColumn<CustomerTM, Integer> colID;

    @FXML
    private TableColumn<CustomerTM, String> colName;

    @FXML
    private TableColumn<CustomerTM, Double> colSalary;

    public void initialize() throws ClassNotFoundException, SQLException {
        colID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        
        getAllCustomer();
    }

    public void getAllCustomer() throws ClassNotFoundException, SQLException {
        // Connection connection = DBConnection.getInstance().getConnection();
        // PreparedStatement statement = connection.prepareStatement("SELECT * FROM
        // customer");
        PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM customer");
        ResultSet cusomterSet = statement.executeQuery();

        ArrayList<Customer> customerList = new ArrayList<Customer>();

        while (cusomterSet.next()) {
            Customer customer = new Customer(
                    cusomterSet.getInt(1),
                    cusomterSet.getString(2),
                    cusomterSet.getString(3),
                    cusomterSet.getDouble(4));

            System.out.println(customer);
            customerList.add(customer);
        }

        System.out.println("customerList : " + customerList);

        /////////////////////////////////////////////////

        ObservableList<CustomerTM> customerTMList = FXCollections.observableArrayList();

        for (Customer cust : customerList) {
            Button button = new Button("Delete");

            CustomerTM customerTM = new CustomerTM(
                    cust.getCustomerID(),
                    cust.getName(),
                    cust.getAddress(),
                    cust.getSalary(),
                    button);

            customerTMList.add(customerTM);
        }

        System.out.println(customerTMList);

        tblCustomer.setItems(customerTMList);
    }

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

        Customer customer = new Customer(id, name, address, salary);
        System.out.println(customer);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");

        statement.setObject(1, customer.getCustomerID());
        statement.setObject(2, customer.getName());
        statement.setObject(3, customer.getAddress());
        statement.setObject(4, customer.getSalary());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Customer Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved Successfully!!!").show();
        } else {
            System.out.println("Error While Saving Customer");
            new Alert(Alert.AlertType.ERROR, "Error While Saving Customer").show();
        }
    }

    @FXML
    void btnLoadAllCustomerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        getAllCustomer();
    }

}
