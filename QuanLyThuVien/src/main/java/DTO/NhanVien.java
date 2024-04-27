
package DTO;

import DAO.*;
import java.time.LocalDate;

public class NhanVien {
 
    private int MaNV;
    private String TenNV;
    private LocalDate namsinh;
    private String gioiTinh;
    private String SDT;
    private String diaChi;
    private LocalDate ngayBatDau;
    private String hinhAnh;
    private int Luong;

    public NhanVien() {
        super();
    }
    
    public NhanVien(String TenNV, LocalDate namsinh, String gioiTinh, String SDT, String diaChi, LocalDate ngayBatDau, String hinhanh, int Luong) {
        this.MaNV = AccountsDAO.getInstance().get_CurrentMTK_DAO();
        this.TenNV = TenNV;
        this.namsinh = namsinh;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.ngayBatDau = ngayBatDau;
        this.hinhAnh = hinhanh;
        this.Luong = Luong;
    }

        public NhanVien(int manv ,String TenNV, LocalDate namsinh, String gioiTinh, String SDT, String diaChi, LocalDate ngayBatDau, String hinhanh, int Luong) {
        this.MaNV =manv;
        this.TenNV = TenNV;
        this.namsinh = namsinh;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.ngayBatDau = ngayBatDau;
        this.hinhAnh = hinhanh;
        this.Luong = Luong;
    }
    
    public int getMaNV() {
        return MaNV;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    
    
    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public LocalDate getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(LocalDate namsinh) {
        this.namsinh = namsinh;
    }


    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

   
    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + '}';
    }
     
    
       
}
