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
public class Preprocessing {
    FileWriter to_be;
    String fileName;
    BufferedReader input;
    //StringTokenizer tokenizer;
    
    public Preprocessing(String fname){
        this.fileName=fname;
    }
    public void preprocess(){
        try{
            try{    
            Files.deleteIfExists(Paths.get("output.txt"));
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
            to_be= new FileWriter("output.txt");
            input = new BufferedReader(new FileReader(fileName));
            String line=input.readLine();
            while(line != null){
            //C:/Users/hp/Desktop/article2.html
            System.out.println(line);
            String noHTMLString = line.replaceAll("\\<.*?\\>", "");
            System.out.println(noHTMLString);
            Pattern pt = Pattern.compile("[^a-zA-Z0-9\\s]");
            Matcher match= pt.matcher(noHTMLString);
            while(match.find())
            {
                String s= match.group();
            noHTMLString=noHTMLString.replaceAll("\\"+s, "");
            }
            to_be.write(noHTMLString);
            line = input.readLine();
            }
            input.close();
            to_be.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("Unable to open file ");
            } catch (IOException e) {
                System.out.println("Unable to read from file ");
            }
            }
}

