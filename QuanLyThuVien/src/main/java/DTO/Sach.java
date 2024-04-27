
package DTO;

import java.time.LocalDate;


public class Sach {
    
    private int maSach;
    private String tenSach;
    private String imgSach;
    private int maLoaiSach;
    private int maNXB;
    private int maTacGia;
    private LocalDate namXuatBan;
    private int soLuong;
    private String ghiChu;
    
    public Sach() {
    }

    public Sach(int maSach, String tenSach, String imgSach, int maLoaiSach, int 
        maNXB, int maTacGia, LocalDate namxb, int soLuong, String ghichu) {
        
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.imgSach = imgSach;
        this.maLoaiSach = maLoaiSach;
        this.maNXB = maNXB;
        this.maTacGia = maTacGia;
        this.namXuatBan = namxb;
        this.soLuong = soLuong;
        this.ghiChu = ghichu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getImgSach() {
        return imgSach;
    }

    public void setImgSach(String imgSach) {
        this.imgSach = imgSach;
    }

    public int getMaLoaiSach() {
        return maLoaiSach;
    }

    public void setMaLoaiSach(int maLoaiSach) {
        this.maLoaiSach = maLoaiSach;
    }

    public int getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(int maNXB) {
        this.maNXB = maNXB;
    }

    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public LocalDate getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(LocalDate namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", maLoaiSach=" + maLoaiSach + ", soLuong=" + soLuong + '}';
    }
    
    
    
    
}
