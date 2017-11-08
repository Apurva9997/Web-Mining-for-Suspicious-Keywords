/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoorv;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Apoorv
 */
public class Insert_Dictionary {
    
    public static void main(String[] args){
        ResultSet rs=null;
        PreparedStatement pst=null;
        //StringTokenizer tokenizer;
        String line,token;
    try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Insert_Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con=null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mining_data","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Insert_Dictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter FileName");
            String FileName=sc.nextLine();
            BufferedReader input=new BufferedReader(new FileReader(FileName));
            line=input.readLine();
            while(!(line==null)){
                System.out.println("while invoked");
             String[] array=line.split(",");
            String sql= "insert into suspicious_words(word,category)values(?,?)";
            try{
            pst=con.prepareStatement(sql);
            System.out.println(array[0]+"  "+array[1]);
            pst.setString(1, array[0]);pst.setString(2, array[1]);
            System.out.println("Trying to execute query");
            pst.execute();
            }
            catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e); 

            }
            line=input.readLine();
            }System.out.println("while finished");
            }
            
            catch (FileNotFoundException e) {
            System.out.println("Unable to open file ");
            } catch (IOException e) {
    System.out.println("Unable to read from file ");
}
}
}
