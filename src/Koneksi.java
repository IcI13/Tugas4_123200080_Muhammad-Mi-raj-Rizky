import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author D15kY
 */
public class Koneksi {
    String dbUrl = "jdbc:mysql://localhost/tugasjdbc";
    String dbUsername = "root";
    String dbPassword = "";
   
    Connection konek;
    String data[] = new String[2];
    static String[] username;
    Statement statement; 
    public Koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            konek = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
        
    }
    void masukanData(String username, String password) {
        try {
            if(!cekUser(username)){
                String query = "INSERT INTO `users`(`username`,`password`) "
                    + "VALUES('" + username + "','" + password + "')";

                statement = konek.createStatement();
                statement.executeUpdate(query);

                System.out.println("Masuk Berhasil!");
                JOptionPane.showMessageDialog(null, "Register telah Berhasil!");
            }else{
                JOptionPane.showMessageDialog(null, "Username Sudah Ada!!");
            }
            
        } catch (Exception ex) {
            System.out.println("masuk tidak berhasil!");
        }
    }
    
    
    
    boolean cekLogin(String username, String password){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = konek.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while(rs.next()){ 
                data[0] = rs.getString("username"); 
                data[1] = rs.getString("password");
            }
            statement.close();
             System.out.println(data[1].toString());
             System.out.println(password);
            if(data[1].toString().equals(password)){
                return true;
            }else{
                return false;
            }
            
         } catch (Exception e) {
            return false;
         }
       
     }
    
    boolean cekUser(String username){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = konek.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while(rs.next()){ 
                data[0] = rs.getString("username"); 
            }
            statement.close();
            data[0].toString();
            return true;
         } catch (Exception e) {
            return false;
         }
       
     }
    
    
}
