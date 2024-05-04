
package DTO;

import java.time.LocalDate;


public class ChiTietPhieuMuon {
    
    private int maCTPM;
    private int maPhieuMuon;
    private int maSach;
    private LocalDate ngayTra;
    private String ghiChu;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(int maCTPM, int maPhieuMuon, int maSach, LocalDate ngayTra, String ghiChu) {
        this.maCTPM = maCTPM;
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
    }

    public int getMaCTPM() {
        return maCTPM;
    }

    public void setMaCTPM(int maCTPM) {
        this.maCTPM = maCTPM;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }



    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuMuon{" + "maCTPM=" + maCTPM + ", maPhieuMuon=" + maPhieuMuon + ", maSach=" + maSach + ", ngayTra=" + ngayTra + ", ghiChu=" + ghiChu + '}';
    }
    
    
}
