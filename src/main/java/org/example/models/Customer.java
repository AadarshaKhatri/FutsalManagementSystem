package org.example.models;
import java.lang.String;

public class Customer {
    String customer_name;

    int customer_phone_number;

    public Customer(String customer_name, int customer_phone_number) {
        this.customer_name = customer_name;
        this.customer_phone_number = customer_phone_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getCustomer_phone_number() {
        return customer_phone_number;
    }

    public void setCustomer_phone_number(int customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }
    public void custprint(){

        String name = this.getCustomer_name();
        double phone = this.getCustomer_phone_number();
        System.out.println("Name:"+name+"\n"+"Phone number:"+phone+"\n");

    }
}
