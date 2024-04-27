
package DTO;


public class ChiTietPhieuNhap {
    
    private int maCTPN;
    private int maPhieuNhap;
    private int maSach;
    private int gia;
    private int soLuong;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(int maCTPN, int maPhieuNhap, int maSach, int gia, int soLuong) {
        this.maCTPN = maCTPN;
        this.maPhieuNhap = maPhieuNhap;
        this.maSach = maSach;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public int getMaCTPN() {
        return maCTPN;
    }

    public void setMaCTPN(int maCTPN) {
        this.maCTPN = maCTPN;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhap{" + "maCTPN=" + maCTPN + ", maPhieuNhap=" +
        maPhieuNhap + ", maSach=" + maSach + ", gia=" + gia + ", soLuong=" + soLuong + '}';
    }
    
    
}
