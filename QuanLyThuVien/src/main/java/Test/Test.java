/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAO.AccountsDAO;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author X
 */
public class Test {
    
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
     public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    
    public static void main(String[] args) {
       
        
        
        System.out.println("check: " + hashPassword("admin"));
       
    
    
    }
}
