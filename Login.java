package com.example.ecommerce;

import java.sql.ResultSet;

public class Login {

    public Customer customerLogin(String username , String password ) {
        String query = "select * from customer_demoquery WHERE email = '" + username + "' AND password = '" + password + "'";
        DbConnection connection = new DbConnection();
        try {
            ResultSet rs = connection.getQueryTable(query);
            if (rs.next()) {
                return new Customer(rs.getInt("id"),
                        rs.getString("name") , rs.getString("email"), rs.getString("mobile"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("ankit@123.in", "cbc123");
        System.out.println("Welcome :" +customer.getName());
       // System.out.println(login.customerLogin("ankit@123.in", "cbc123"));


    }
}
