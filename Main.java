import java.sql.*;

class dbconnect {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public dbconnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/oopkiosk", "NEWuser", "smr@2016G");
            st = conn.createStatement();
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }

    }

    public void getdata() {
        try {
            String query = "select *from login";
            rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("username");
                String age = rs.getString("password");
                System.out.println(name + " " + age);
            }
        } catch(Exception e){
            System.out.println("**");
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samar
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("now");
        dbconnect connect=new dbconnect();
        connect.getdata();
    }
}
