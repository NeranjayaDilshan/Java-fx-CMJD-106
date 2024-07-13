package tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private int customerId;
    private String name;
    private String address;
    private double salary;
    private Button btnDelete;
    
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    public CustomerTM(int customerId, String name, String address, double salary, Button btnDelete) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.btnDelete = btnDelete;
    }
    public CustomerTM() {
    }
    @Override
    public String toString() {
        return "CustomerTM [customerId=" + customerId + ", name=" + name + ", address=" + address + ", salary=" + salary
                + ", btnDelete=" + btnDelete + "]";
    }

    
}
