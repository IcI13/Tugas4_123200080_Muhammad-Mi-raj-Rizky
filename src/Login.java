/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author D15kY
 */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame {
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    
    
    JTextField fUsername = new JTextField();
    JPasswordField fPassword = new JPasswordField();
    
    JButton btnLogin = new JButton("Login");
    JButton btnRegister = new JButton("Register");
 
    
    public Login(){
        setTitle("Login");
        setLayout(null);
        
        add(lUsername);
        add(lPassword);
        
        add(fUsername);
        add(fPassword);
        
        add(btnLogin);
        add(btnRegister);
        
        lUsername.setBounds(110,40,100,50);
        fUsername.setBounds(60,80,160,20);
        lPassword.setBounds(110,120,100,50);
        fPassword.setBounds(60,160,160,20);
        
        btnRegister.setBounds(60,220,160,40);
        btnLogin.setBounds(60,270,160,40);
        
        setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Koneksi kn = new Koneksi();
               String user = fUsername.getText();
               if(kn.cekUser(user) && user != "" && kn.cekLogin(user ,String.valueOf(fPassword.getPassword()))){
                   JOptionPane.showMessageDialog(null, "Login Berhasil");
               }else if(user.isEmpty() || String.valueOf(fPassword.getPassword()).isEmpty()){
                   JOptionPane.showMessageDialog(null, "Jangan Dikosongkan");
               }
               else if(!kn.cekUser(user)){
                   JOptionPane.showMessageDialog(null, "Username yang dimasukan Salah");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Password yang dimasukan Salah");
               }
           }
       });
        
         btnRegister.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Koneksi kn = new Koneksi();
               String userr = fUsername.getText();
               String pass = String.valueOf(fPassword.getPassword());
               if(!userr.isEmpty() && !pass.isEmpty()){
                   kn.masukanData(userr, pass);
               }
               else if(userr.isEmpty() || pass.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Jangan DiKosongkan");
               }
           }
           
       });
    }
}
