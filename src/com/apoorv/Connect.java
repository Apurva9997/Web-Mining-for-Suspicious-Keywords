/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoorv;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Magneto
 */
public class Connect {
    Connection con=null;
   
        public static Connection ConnectDB(){
             try{
           
          Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mining_data","root","");
          return con;
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
}
}
}
