
package DTO;

import java.time.LocalDate;


public class PhieuPhat {
    
    private int maPP;
    private int maPM;
    private int soTien;
    private String lyDo;
    private LocalDate ngaytra;

    public PhieuPhat() {
    }

    public PhieuPhat(int maPP, int maPM, LocalDate ngay, int soTien, String lyDo) {
        this.maPP = maPP;
        this.maPM = maPM;
        this.soTien = soTien;
        this.ngaytra = ngay;
        this.lyDo = lyDo;
    }

    public int getMaPP() {
        return maPP;
    }

    public void setMaPP(int maPP) {
        this.maPP = maPP;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public LocalDate getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(LocalDate ngaytra) {
        this.ngaytra = ngaytra;
    }

    
    
    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    @Override
    public String toString() {
        return "PhieuPhat{" + "maPP=" + maPP + ", maPM=" + maPM + ", soTien=" + soTien + ", lyDo=" + lyDo + '}';
    }
    
    
}
