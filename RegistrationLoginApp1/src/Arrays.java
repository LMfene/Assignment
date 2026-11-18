import java.util.Scanner;
import java.util.ArrayList;

public class Arrays {

    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();
    static ArrayList<String> allRecipients = new ArrayList<>();
    static ArrayList<String> allMessagesText = new ArrayList<>();
    static ArrayList<String> allFlags = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        populateTestData();
        storedMenu();
    }

    public static void populateTestData() {
    addToArrays("+27834557896", "Did you get the cake?", "12:0:DID:CAKE?", "Sent");
    addToArrays("+27838884567", "Where are you? You are late! I have asked you a thousand times.", "34:1:WHE:LATE?", "Stored");
    addToArrays("+27834484567", "Yohoooo, I am at your gate.", "45:0:YOH:GATE?", "Disregarded");
    addToArrays("0838884567", "It is dinner time !", "88:0:IT :TIME?", "Sent");
    addToArrays("+27838884567", "Ok, I am leaving without you.", "99:0:OK :LEAV?", "Stored");
    }

    public static void addToArrays(String rec, String msg, String hash, String flag) {
            if (allMessagesText.contains(msg)) {
            return;
        }
        allRecipients.add(rec);
        allMessagesText.add(msg);
        messageHashes.add(hash);
        allFlags.add(flag);
              String id = hash.split(":")[0];
                messageIDs.add(id);

        if (flag.equals("Sent")) {
            sentMessages.add(msg);
        } 
        else if (flag.equals("Stored")) {
            storedMessages.add(msg);
        } 
        else if (flag.equals("Disregarded")) {
            disregardedMessages.add(msg);
        }
    }

        public static void storedMenu() {
            
         while (true) {
             
            System.out.println("\n--- Stored Messages Menu ---");
            
            System.out.println("a. Display Sender and Recipient of all sent messages");
            
            System.out.println("b. Display longest sent message");
            
            System.out.println("c. Search for message ID");
            
            System.out.println("d. Search messages by recipient");
            
            System.out.println("e. Delete message using hash");
            
            System.out.println("f. Display full report");
            
            System.out.println("g. Quit / Back");
            
            System.out.print("Choose: ");
            String sub = scan.nextLine().toLowerCase();

            if (sub.equals("a")) {
                System.out.println(displaySendersAndRecipients());
            } 
            
            else if (sub.equals("b")) {
                System.out.println(displayLongestMessage());
                } 
            
            else if (sub.equals("c")) {
            System.out.print("Enter Message ID to search: ");
                String id = scan.nextLine();
            System.out.println(searchMessageID(id));
            } 
            
            else if (sub.equals("d")) {
            System.out.print("Enter recipient to search: ");
                String rec = scan.nextLine();
            System.out.println(searchRecipient(rec));
            } 
            
            else if (sub.equals("e")) {
            System.out.print("Enter hash to delete: ");
                String hash = scan.nextLine();
            System.out.println(deleteMessage(hash));
            } 
            
            else if (sub.equals("f")) {
            System.out.println(displayReport());
            } 
            
            else if (sub.equals("g")) {
                System.out.println("Exiting...");
                break;
            } 
            
            else {
                System.out.println("Invalid option, try again.");
            }
        }
    }
    public static String displaySendersAndRecipients() {
        String out = "--- Sent Messages ---\n";
        for (int i = 0; i < allMessagesText.size(); i++) {
            if (allFlags.get(i).equals("Sent")) {
                out += "Recipient: " + allRecipients.get(i) + ", Message: " + allMessagesText.get(i) + "\n";
            }
        }
        return out;
    }
    public static String displayLongestMessage() {
        String longest = "";
        for (String m : allMessagesText) {
            if (m.length() > longest.length()) {
                longest = m;
            }
        }
        return "Longest message: " + longest;
    }

    public static String searchMessageID(String id) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(id)) {
                return "Recipient: " + allRecipients.get(i) + "\nMessage: " + allMessagesText.get(i);
            }
        } return "Message ID not found.";
    }
    public static String searchRecipient(String rec) {
        String out = "";
        for (int i = 0; i < allRecipients.size(); i++) {
            if (allRecipients.get(i).equals(rec)) {
                out += allMessagesText.get(i) + "\n";
            }
        } if (out.equals("")) {
            return "No messages found for that recipient.";
        } return out;
    }

    public static String deleteMessage(String hash) {
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hash)) {
                String deleted = allMessagesText.get(i);
                allRecipients.remove(i);
                allMessagesText.remove(i);
                messageHashes.remove(i);
                allFlags.remove(i);
                messageIDs.remove(i);
                return "Message \"" + deleted + "\" successfully deleted.";
            }
        } return "Hash not found.";
    }
    public static String displayReport() {
        String out = "--- Full Report ---\n";
        for (int i = 0; i < allMessagesText.size(); i++) {
            out += "Hash: " + messageHashes.get(i) + "\n";
            out += "Recipient: " + allRecipients.get(i) + "\n";
            out += "Message: " + allMessagesText.get(i) + "\n";
            out += "Flag: " + allFlags.get(i) + "\n\n";
        } return out;
    }
}