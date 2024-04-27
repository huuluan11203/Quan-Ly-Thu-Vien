
package DTO;

import java.time.LocalDate;


public class TacGia {
    
    private int maTacGia;
    private String tenTacGia;
    private LocalDate namSinh;
    private String diachi;
    private String hinhanh;
    private String gioiThieu;

    public TacGia() {
    }

    public TacGia(int maTacGia, String tenTacGia, LocalDate namSinh, String diachi,String hinhanh, String gioithieu) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.namSinh = namSinh;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
        this.gioiThieu = gioithieu;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    
    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public LocalDate getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(LocalDate namSinh) {
        this.namSinh = namSinh;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }



    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return tenTacGia;
    }
    
     
    
}
