

package DTO;


public class TheThuVien {
    
    private int maThe;
    private String ngayBatDau;
    private String ngayKetthuc;

    public TheThuVien() {
    }

    public TheThuVien(int maThe, String ngayBatDau, String ngayKetthuc) {
        this.maThe = maThe;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetthuc = ngayKetthuc;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetthuc() {
        return ngayKetthuc;
    }

    public void setNgayKetthuc(String ngayKetthuc) {
        this.ngayKetthuc = ngayKetthuc;
    }

    public int getMaThe() {
        return maThe;
    }

    @Override
    public String toString() {
        return "TheThuVien{" + "maThe=" + maThe + ", ngayBatDau=" + ngayBatDau + ", ngayKetthuc=" + ngayKetthuc + '}';
    }
    
    
    
    
}
