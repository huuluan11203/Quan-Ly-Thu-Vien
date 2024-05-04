

package DTO;

import java.time.LocalDate;


public class TheThuVien {
    
    private int maThe;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetthuc;

    public TheThuVien() {
    }

    public TheThuVien(int maThe, LocalDate ngayBatDau, LocalDate ngayKetthuc) {
        this.maThe = maThe;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetthuc = ngayKetthuc;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    
    
    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetthuc() {
        return ngayKetthuc;
    }

    public void setNgayKetthuc(LocalDate ngayKetthuc) {
        this.ngayKetthuc = ngayKetthuc;
    }

    public int getMaThe() {
        return maThe;
    }
    
    public void setMaThe(int mt) {
        this.maThe = mt;
    }

    
    @Override
    public String toString() {
        return "TheThuVien{" + "maThe=" + maThe + ", ngayBatDau=" + ngayBatDau + ", ngayKetthuc=" + ngayKetthuc + '}';
    }
    
    
    
    
}
