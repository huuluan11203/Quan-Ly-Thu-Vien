
package BUS;


import DTO.Accounts;
import DAO.*;
import DTO.NhanVien;
import java.util.ArrayList;
import raven.toast.Notifications;




public class Account_BUS {

    private static ArrayList<Accounts> ACC_ArrayList;

    public Account_BUS() {
       ACC_ArrayList = AccountsDAO.getInstance().selectAll();
    }
    
    public boolean checkLogin(String username, String passwd){
        if (username.trim().equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Tài khoản không được để trống.");
            
            return false;
        }
        
        if (passwd.trim().equals("")) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Mật khẩu không được để trống.");
            
            return false;
        }
        
        
        if (AccountsDAO.getInstance().login(username, passwd)){
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,
                    "Đăng nhập thành công.");
            
            return true;
        }
       
        
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
            "Sai tài khoản hoặc mật khẩu.");
        return false;
            
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
    
    public boolean isExsit(int ma){
        Accounts acc = AccountsDAO.getInstance().selectByID(ma);
        if (acc != null) {
            return true;
        }
        return false;
    }
    
    public boolean register(String username, String psswd, String confirm){
        
        
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
        
        if(AccountsDAO.getInstance().insert(acc) == 1) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
            "Tạo tài khoản thành công.");
            
            return true;
        }
        
        // something wrongs
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng khởi động lại ứng dụng.");
        return false;
        
    }
    
    
    public boolean DoiThongTin(Accounts acc){
        if (acc != null) {
            
            NhanVien nv = NhanVienDAO.getInstance().selectByID(acc.getMaTaiKhoan());
            
            if (nv == null) {
                 Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Nhân viên không tồn tại.");
                return false;
            }
            
            
            
            if (isExsit(nv.getMaNV())) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Tài khoản " + acc.getMaTaiKhoan() + " đã được sử dụng.");
                return false;
            }
            

                   
            if (acc.getMatKhau().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Mật khẩu không được rỗng.");
                return false;
            }   
            
            AccountsDAO.getInstance().update(acc);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Sửa thông tin thành công.");
            return true;
        }
        return false;
    }
 
}
