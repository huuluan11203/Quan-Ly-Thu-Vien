
package DTO;


public class PhieuPhat {
    
    private int maPP;
    private int maPM;
    private int soTien;
    private String lyDo;

    public PhieuPhat() {
    }

    public PhieuPhat(int maPP, int maPM, int soTien, String lyDo) {
        this.maPP = maPP;
        this.maPM = maPM;
        this.soTien = soTien;
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
