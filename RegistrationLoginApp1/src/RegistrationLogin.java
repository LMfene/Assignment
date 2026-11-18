
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
class main{
    

   
    public static void main(String [] args){
        
        Scanner key = new Scanner(System.in);
        
        System.out.println("Enter the username");
        String user = key.nextLine();
        
        if(RegistrationLogin.checkUsername(user)){
        System.out.println("Correct format");
        }else{
            System.out.println("Incorrect format");
        }
        System.out.println("Enter password");
        String pass = key.nextLine();
        
        if (RegistrationLogin.checkPasswordComplexity(pass)){
            System.out.println("Correct format");
        }else{
            System.out.println("Incorrect format");
        }
        System.out.println("Enter the CellphoneNumber");
        String number = key.nextLine();
        if(RegistrationLogin.checkCellPhoneNumber(number)){
            System.out.println("Correct format");
        }
    }
        
       
    }

public class RegistrationLogin {
    public static boolean checkUsername(String username){
        if(username.contains("_") && username.length() <=5){
            
            return true;
        }
        else{
    }
        return false;
}
        private String storedUsername;
        private String storedPassword;
    
    public static boolean checkPasswordComplexity(String password){
       
        boolean length = password.length() >= 8;
        boolean hasUpper = password.matches(",*[A-Z],*");
        boolean hasDigit = password.matches(",*[0-9],*");
        boolean hasSpecial = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        
        return length && hasUpper && hasDigit && hasSpecial;
    }
    public static boolean checkCellPhoneNumber(String Cellnumber){
        
       if(Cellnumber.startsWith("+27") && Cellnumber.length() == 12){
        return true;
       }
       else{
       return false;
    }
    } 
    public String registerUser(String username, String password) {
        
        if (!RegistrationLogin.checkUsername(username)){
            return "Username not formatted correctly, please make sure username contains an underscore and is no more than 5 characters in length";
        }
        if (!RegistrationLogin.checkPasswordComplexity(password)){
        return "Password not correctly formatted, please make sure password contians at least 8 characters, a capital letter, number and special character.";
    }
       this.storedUsername = username;
       this.storedPassword = password;
       
        return "The two conditions above have been met and user registered successfully.";
    }
    
    public boolean LoginUser (String enteredUsername, String enteredPassword){
         if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)){
             return true;
         }else{
             return false;
         }
    }
    
    public String returnLoginStatus (boolean isLoggedIn){
        if (isLoggedIn){
            return "Welcome! Great to see you again.";
        }
        else {
            return "Username or password incorrect, try again.";
        }
    }
    }
