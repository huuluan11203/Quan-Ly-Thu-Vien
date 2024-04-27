
package DTO;


public class PhieuMuon {
    
    private int maPhieuMuon;
    private int maNV;
    private int maDocGia;
    private String ngayMuon;
    private String tinhTrang;

    public PhieuMuon() {
    }

    public PhieuMuon(int maPhieuMuon, int maNV, int maDocGia, String ngayMuon, String tinhTrang) {
        this.maPhieuMuon = maPhieuMuon;
        this.maNV = maNV;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.tinhTrang = tinhTrang;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" + "maPhieuMuon=" + maPhieuMuon + ", maNV=" + maNV + ", maDocGia=" + maDocGia + ", ngayMuon=" + ngayMuon + ", tinhTrang=" + tinhTrang + '}';
    }
    
    
}
