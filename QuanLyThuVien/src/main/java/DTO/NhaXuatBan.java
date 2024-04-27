
package DTO;


public class NhaXuatBan {
    
    private int maNXB;
    private String tenNXB;
    private String diaChi;
    private String SDT;

    public NhaXuatBan() {
    }

    public NhaXuatBan(int maNXB, String tenNXB, String diaChi, String Sdt) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.SDT = Sdt;
    }

    public int getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(int maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return SDT;
    }

    public void setSdt(String Sdt) {
        this.SDT = Sdt;
    }

    @Override
    public String toString() {
        return tenNXB;
    }
    
    
}
