
package BUS;


import DTO.Accounts;
import DAO.*;
import java.util.ArrayList;
import raven.toast.Notifications;




public class Account_BUS {

    private static ArrayList<Accounts> ACC_ArrayList;

    public Account_BUS() {
       ACC_ArrayList = AccountsDAO.getInstance().selectAll();
    }
    
    public boolean Check_Login(String username, String passwd){

        ACC_ArrayList = AccountsDAO.getInstance().selectAll();
        if (username.equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Tài khoản không được để trống.");
            return false;
        }
        if (passwd.equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Mật khẩu không được để trống.");
            return false;
        }
        
        for (Accounts ACC_ArrayListounts : ACC_ArrayList) {
            
            if (ACC_ArrayListounts.getTenDangNhap().equals(username) && ACC_ArrayListounts.getMatKhau().equals(passwd)){
                
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,
                    "Đăng nhập thành công.");

                return true;
                
            }
        }
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Sai tài khoản hoặc mật khẩu.");
        return false;
            
    }
    
    public Accounts SelectedAcc(int ma){
        Accounts acc = AccountsDAO.getInstance().selectByID(ma);
        return acc;
    }
    
    public Accounts getAccounts(String username){
        Accounts acc = AccountsDAO.getInstance().selectByID(username);
        return acc;
    }
    
    public boolean isExsit(String username){
        Accounts acc = getAccounts(username);
        if (acc != null) {
            return true;
        }
        return false;
    }
    
    public boolean Check_Signup(String username, String psswd, String confirm){
        
        ACC_ArrayList = AccountsDAO.getInstance().selectAll();
        
        if (username.equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Tài khoản không được để trống.");
            return false;
        }

        if (psswd.equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Mật khẩu không được để trống.");
            return false;
        }
                
        if (confirm.equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Mật khẩu nhập lại không được để trống.");
            return false;
        }
        
        if (!confirm.equals(psswd)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Mật khẩu nhập lại không khớp.");
            return false;
        }
        
        if (isExsit(username)) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Tài khoản đã tồn tại.");
            return false;
        }
        
        Accounts acc = new Accounts(username, psswd);
        AccountsDAO.getInstance().insert(acc);
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
            "Tạo tài khoản thành công.");
        return true;
    }
    
    
    public boolean DoiMatKhau(Accounts acc){
        if (acc != null) {
            AccountsDAO.getInstance().update(acc);
            return true;
        }
        return false;
    }
 
}
