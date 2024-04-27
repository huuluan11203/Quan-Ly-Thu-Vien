
package DTO;

import DAO.*;

public class Accounts {
    
    //access = 0 : ADMIN
    //access = 1 : USER
    
    private String tenDangNhap;
    private String matKhau;
    private int maTaiKhoan ;
    private int access;

    public Accounts(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maTaiKhoan = AccountsDAO.getInstance().get_CurrentMTK_DAO()+1;
        this.access = 1;
    }

    public Accounts() {
        super();
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }
    
    public void setMaTaiKhoan(int mataikhoan){
        this.maTaiKhoan = mataikhoan;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Accounts{" + "tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + '}';
    }
    
    
}
