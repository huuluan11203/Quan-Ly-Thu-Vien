

package DTO;


public class NhaCungCap {
    
   private int maNCC;
   private String tenNCC;

    public NhaCungCap() {
    }

    public NhaCungCap(int maNCC, String tenNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    @Override
    public String toString() {
        return tenNCC;
    }
   
   
}
