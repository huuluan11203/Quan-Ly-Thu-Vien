
package DAO;

import DTO.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import DataBaseConnect.JDBCUltil;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class NhanVienDAO implements DAOInterface<NhanVien>{
    
     public static NhanVienDAO getInstance(){
        return new NhanVienDAO();
    }
    

    @Override
    public int insert(NhanVien t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO nhanvien (MaNV, TenNV, NamSinh, "
                    + "GioiTinh, Sdt, DiaChi, NgayBatDau, HinhAnh, Luong) " 
                  +  "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNV());
            statement.setString(2, t.getTenNV());
            statement.setDate(3, Date.valueOf(t.getNamsinh()));
            statement.setString(4, t.getGioiTinh());
            statement.setString(5, t.getSDT());
            statement.setString(6, t.getDiaChi());
            statement.setDate(7, Date.valueOf(t.getNgayBatDau()));
            statement.setString(8, t.getHinhAnh());
            statement.setInt(9, t.getLuong());
            
            //Thuc thi cau lenh SQL
            statement.executeUpdate();
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(NhanVien t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE nhanvien SET TenNV = ?, Namsinh = ?, GioiTinh = ?, Sdt = ?, DiaChi = ?,"
                    + "NgayBatDau = ?, HinhAnh = ?, Luong = ? WHERE MaNV = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, t.getTenNV());
            statement.setDate(2, Date.valueOf(t.getNamsinh()));
            statement.setString(3, t.getGioiTinh());
            statement.setString(4, t.getSDT());
            statement.setString(5, t.getDiaChi());
            statement.setDate(6, Date.valueOf(t.getNgayBatDau()));            
            statement.setString(7, t.getHinhAnh());
            statement.setInt(8, t.getLuong());
            statement.setInt(9, t.getMaNV());
            
            //Thuc thi cau lenh SQL
            int kq = statement.executeUpdate();
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
           
            return kq;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    @Override
    public int delete(NhanVien t) {
try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM nhanvien WHERE MaNV = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNV());

            
            //Thuc thi cau lenh SQL
            int kq = statement.executeUpdate();
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
            
            return kq;
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;      
    }

    @Override
    public ArrayList<NhanVien> selectAll() {
                  
        ArrayList<NhanVien> nv_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhanvien";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                NhanVien nv = new NhanVien();
                nv.setMaNV(resultSet.getInt("MaNV"));
                nv.setTenNV(resultSet.getString("TenNV"));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setSDT(resultSet.getString("Sdt"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setHinhAnh(resultSet.getString("HinhAnh"));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setLuong(resultSet.getInt("Luong"));
                nv.setNamsinh(resultSet.getDate("NamSinh").toLocalDate());
                nv.setNgayBatDau(resultSet.getDate("NgayBatDau").toLocalDate());
             
                nv_ArrayList.add(nv);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return nv_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NhanVien selectByID(NhanVien t) {
        NhanVien nv = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhanvien WHERE MaNV = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNV());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int manv = resultSet.getInt("MaNV");
                String tennv = resultSet.getString("TenNV");
                String DiaChi = resultSet.getString("DiaChi");
                String SDT = resultSet.getString("Sdt");
                String GioiTinh = resultSet.getString("GioiTinh");
                String HinhAnh = resultSet.getString("HinhAnh");
                int Luong = resultSet.getInt("Luong");
                LocalDate  Namsinh = resultSet.getDate("NamSinh").toLocalDate();
                LocalDate NgayBatDau = resultSet.getDate("NgayBatDau").toLocalDate();
              
               nv = new NhanVien(manv, tennv, Namsinh, GioiTinh, SDT, DiaChi, NgayBatDau, HinhAnh, Luong); 
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nv;
    }
    
    public NhanVien selectByID(int ma) {
        NhanVien nv = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhanvien WHERE MaNV = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int manv = resultSet.getInt("MaNV");
                String tennv = resultSet.getString("TenNV");
                String DiaChi = resultSet.getString("DiaChi");
                String SDT = resultSet.getString("Sdt");
                String GioiTinh = resultSet.getString("GioiTinh");
                String HinhAnh = resultSet.getString("HinhAnh");
                int Luong = resultSet.getInt("Luong");
                LocalDate  Namsinh = resultSet.getDate("NamSinh").toLocalDate();
                LocalDate NgayBatDau = resultSet.getDate("NgayBatDau").toLocalDate();
              
               nv = new NhanVien(manv, tennv, Namsinh, GioiTinh, SDT, DiaChi, NgayBatDau, HinhAnh, Luong); 
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nv;
    }

    @Override
    public ArrayList<NhanVien> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
