package model;

public class Customer {
    private int customerID;
    private String name;
    private String Address;
    private double salary;

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Customer(int customerID, String name, String address, double salary) {
        this.customerID = customerID;
        this.name = name;
        Address = address;
        this.salary = salary;
    }
    public Customer() {
    }
    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", name=" + name + ", Address=" + Address + ", salary=" + salary
                + "]";
    }
    
}
