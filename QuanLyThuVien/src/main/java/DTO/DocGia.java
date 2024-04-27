
package DTO;



public class DocGia {
    
    private int maDocGia;
    private String tenDocGia;
    private String namSinh;
    private String gioiTinh;
    private String SDT;
    private String hinhanh;
    private int maThe;
    

    public DocGia() {
    }

    public DocGia(int maDocGia, String tenDocGia, String namSinh, String gioiTinh, String Sdt, String hinhanh, int maThe) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.SDT = Sdt;
        this.hinhanh = hinhanh;
        this.maThe = maThe;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }
    
    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return SDT;
    }

    public void setSdt(String Sdt) {
        this.SDT = Sdt;
    }

    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    
    
    @Override
    public String toString() {
        return "DocGia{" + "tenDocGia=" + tenDocGia + ", maThe=" + maThe + '}';
    }
    
    
    
    
}
