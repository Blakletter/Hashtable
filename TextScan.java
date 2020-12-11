// TextScan.java
// Opens text file supplied on the command line
// Usage:  java TextScan filename
// Counts all tokens found (a token is anything delimited by a space character)
// Displays each token found to the screen
// Code may be used in part for Project 5 with proper citing. 


import java.util.Scanner;
import java.io.*;

public class TextScan {


    Scanner readFile = null;
    int count = 0;
    public static void main(String[] args) {

    }  // main

    public void openFile(String filename) {
        System.out.println();
        System.out.println("Attempting to read from file: " + filename);
        try {
            readFile = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + filename + " not found");
            System.exit(1);
        }

        System.out.println("Connection to file: " + filename + " successful");
        System.out.println();
        System.out.println("Creating HashTable");

        System.out.println();
        System.out.println(count + " Tokens found");
        System.out.println();

    }
    public String getNextToken() {
        String s = null;
        if (readFile.hasNext()) {
            s = readFile.next();
            System.out.println("Token found: " + s);
            count++;
        }
        return s;
    }

    public void closeFile() {
        try {
            readFile.close();
        } catch (Exception e) {
            System.out.println("No file was open.");
        }
    }
}  // TextScan
