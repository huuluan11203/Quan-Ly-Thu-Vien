
package BUS;


import DTO.Accounts;
import DAO.*;
import java.util.ArrayList;




public class Account_BUS {

    private static ArrayList<Accounts> acc;

    public Account_BUS() {
       acc = AccountsDAO.getInstance().selectAll();
    }
    
    public boolean Check_Login(String username, String passwd){

        for (Accounts accounts : acc) {
            if (accounts.getTenDangNhap().equals(username) 
                && accounts.getMatKhau().equals(passwd)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean Check_Signup(String username, String psswd){
        
        for (Accounts accounts : acc){
            if (accounts.getTenDangNhap().equals(username)) {
                return false;
            }
        }
        Accounts account = new Accounts(username, psswd);
        AccountsDAO.getInstance().insert(account);
        return true;
    }
 
}
