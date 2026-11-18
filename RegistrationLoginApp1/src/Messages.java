/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Student
 */
public class Messages {

    static int option;
    static int messageID;
    static String message;
    static String number;
    static int i;
    static int n;

    static Scanner scan = new Scanner(System.in);
    static int totalMessagesSent = 0;
  
            
    public static void main(String[] args) {

        do {
            System.out.println("Welcome to QuickChat");
            System.out.println("1. Send messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                sendMessages();
            } else if (option == 2) {
                readJsonile();

            } else if (option == 3) {

                System.out.println("Quit");
            }

        } while (option != 3);
    }

    public static void sendMessages() {
      
        Random no = new Random();

        System.out.println("Enter number of messages you want to send:");
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {

            int messageID = no.nextInt(1000000) + 1;

            System.out.println("Message ID: " + messageID);

            System.out.println("Enter recipient digits:");
            String number = scan.nextLine();
            
            Methodfunctionality check = new Methodfunctionality();
            
            if (number.startsWith("+27") && number.length() == 12) {

                System.out.println("Correct format");

                System.out.println("Write a message:");
                String message = scan.nextLine();

                if (message.length() <= 250) {
                    System.out.println("Message successfully captured.");
                    
                }
                else {
                    System.out.println(
                            "Enter a message of 250 characters or less."
                    );
                };
            } else {
                System.out.println("Incorrect recipient number format.");
            }
        }
    }

    private static void readJsonile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class Methodfunctionality {

    public boolean checkMessageID() {
        return false;
    }

    public boolean checkRecipientCell(String recipients) {
        return false;
    }

    public boolean createMessageHash(int messageID, int messageNumber, String messages) {
        return false;
    }

    public boolean sentMessage(String message) {
        return false;
    }

    public boolean printMessages() {
        System.out.println("No messages stored yet.");
        return true;
    }

    public int returnTotalMessages(int number) {
        return number;
    }

    public static void option1() {
        Messages k = new Messages();
        String messageString = String.valueOf(k.messageID);
        char firstNum = messageString.charAt(0);
        char secondNum = messageString.charAt(1);
        String numString = String.valueOf(firstNum + "" + secondNum);
        String[] array = k.message.split("");
        String firstWord = array[0];
        String secondWord = array[array.length - 1];
        System.out.println("Message sent");
        System.out.println("ID: " + k.messageID);
        System.out.println(numString + ":" + k.n + ":" + firstWord + ":" + secondWord);
        System.out.println("recipient number" + k.number);
        System.out.println("Short message" + k.message);
    }

    public static void writeJSONfile() {
        Messages j = new Messages();
        String jsonfile = "(\"message\": \"" + j.message + "\")";
        try {
            Files.writeString(Path.of("user.json"), jsonfile);
            System.out.println("Message saved to JSON file");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void readJsonfile() {
        try {
            String jsonfile = Files.readString(Path.of("user.json"));

            System.out.println("JSON file content: ");
            System.out.println(jsonfile);
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void storeMessages() {

    }
}
