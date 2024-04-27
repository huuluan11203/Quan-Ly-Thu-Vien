
package DTO;

import java.time.LocalDate;


public class PhieuNhap {

    private int maPhieuNhap;
    private int maNCC;
    private int maNV;
    private LocalDate ngayNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPhieuNhap, int maNCC, int maNV, LocalDate ngayNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }


    @Override
    public String toString() {
        return "PhieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", maNCC=" + maNCC + 
                ", maNV=" + maNV + ", ngayNhap=" + ngayNhap + '}';
    }
    
    
}
