/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoorv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Apoorv
 */
public class presaving {
    FileWriter to_be;
    String fileName;
    int a,b,c,d;
    BufferedReader input;
    //StringTokenizer tokenizer;
    
    public presaving(int a,int b,int c,int d){
        this.a=a;this.b=b;this.c=c;this.d=d;
    }
    public void presave(){
        try{
            try{    
            Files.deleteIfExists(Paths.get("output2.txt"));
            }
            catch(NoSuchFileException e)
            {
                System.out.println("No such file/directory exists");
            }
            catch(DirectoryNotEmptyException e)
            {
                System.out.println("Directory is not empty.");
            }
            catch(IOException e)
            {
                System.out.println("Invalid permissions.");
            }
            System.out.println("Deletion successful.");
            to_be= new FileWriter("output2.txt");
            
            to_be.write(a+","+b+","+c+","+d);
            
            to_be.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("Unable to open file ");
            } catch (IOException e) {
                System.out.println("Unable to read from file ");
            }
            }
}


