
package DAO;

import DTO.Sach;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;


public class SachDAO implements DAOInterface<Sach>{
    
    public static SachDAO getInstance(){
        return new SachDAO();
    }

    @Override
    public int insert(Sach t) {
        
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO sach (MaSach, TenSach, MaLoaiSach, MaNXB, "
                    + "MaTacGia, NamXuatBan, SoLuong, HinhAnh, GhiChu) " 
                  +  "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaSach());
            statement.setString(2, t.getTenSach());
            statement.setInt(3, t.getMaLoaiSach());
            statement.setInt(4, t.getMaNXB());
            statement.setInt(5, t.getMaTacGia());
            statement.setDate(6, Date.valueOf(t.getNamXuatBan()));
            statement.setInt(7, t.getSoLuong());
            statement.setString(8, t.getImgSach());
            statement.setString(9, t.getGhiChu());
            
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
    public int update(Sach t) {
       try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE sach SET TenSach = ?, MaLoaiSach = ?, MaNXB = ?, MaTacGia = ?, NamXuatBan = ?,"
                    + "SoLuong = ?, HinhAnh = ?, GhiChu = ? WHERE MaSach = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, t.getTenSach());
            statement.setInt(2, t.getMaLoaiSach());
            statement.setInt(3, t.getMaNXB());
            statement.setInt(4, t.getMaTacGia());
            statement.setDate(5, Date.valueOf(t.getNamXuatBan()));
            statement.setInt(6, t.getSoLuong());
            statement.setString(7, t.getImgSach());
            statement.setString(8, t.getGhiChu());
            statement.setInt(9, t.getMaSach());
            
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
    public int delete(Sach t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM sach WHERE MaSach = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaSach());

            
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
    public ArrayList<Sach> selectAll() {
        
        ArrayList<Sach> sach_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM sach";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                Sach sach = new Sach();
                sach.setMaSach(resultSet.getInt("MaSach"));
                sach.setTenSach(resultSet.getString("TenSach"));
                sach.setMaLoaiSach(resultSet.getInt("MaLoaiSach"));
                sach.setMaNXB(resultSet.getInt("MaNXB")); 
                sach.setMaTacGia(resultSet.getInt("MaTacGia"));
                sach.setNamXuatBan(resultSet.getDate("NamXuatBan").toLocalDate());
                sach.setSoLuong(resultSet.getInt("SoLuong"));
                sach.setImgSach(resultSet.getString("HinhAnh"));
                sach_ArrayList.add(sach);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return sach_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Sach selectByID(Sach t) {
        Sach sach = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM sach WHERE MaSach = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaSach());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int masach = resultSet.getInt("MaSach");
                int maloaisach = resultSet.getInt("MaLoaiSach");
                int manxb = resultSet.getInt("MaNXB");
                int matacgia = resultSet.getInt("MaTacGia");
                int soluong = resultSet.getInt("SoLuong");
                String hinhanh = resultSet.getString("HinhAnh");
                String tensach = resultSet.getString("TenSach");
                LocalDate namxuatban= resultSet.getDate("NamXuatBan").toLocalDate();
                String ghichu = resultSet.getString("GhiChu");
                
                
                sach = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, namxuatban, soluong, ghichu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return sach;
    }
    
     public Sach selectByID(int ms) {
        Sach sach = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM sach WHERE MaSach = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ms);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int masach = resultSet.getInt("MaSach");
                int maloaisach = resultSet.getInt("MaLoaiSach");
                int manxb = resultSet.getInt("MaNXB");
                int matacgia = resultSet.getInt("MaTacGia");
                int soluong = resultSet.getInt("SoLuong");
                String hinhanh = resultSet.getString("HinhAnh");
                String tensach = resultSet.getString("TenSach");
                LocalDate namxuatban= resultSet.getDate("NamXuatBan").toLocalDate();
                String ghichu = resultSet.getString("GhiChu");
                
                
                sach = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, namxuatban, soluong, ghichu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return sach;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> Sach_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM sach WHERE ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, condition);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {                
                Sach tg = new Sach();
                tg.setMaSach(resultSet.getInt("MaSach"));
                tg.setTenSach(resultSet.getString("TenSach"));
                tg.setMaLoaiSach(resultSet.getInt("MaLoaiSach"));
                tg.setGhiChu(resultSet.getString("GhiChu"));
                tg.setMaNXB(resultSet.getInt("MaNXB"));
                tg.setMaTacGia(resultSet.getInt("MaTacGia"));
                tg.setNamXuatBan(resultSet.getDate("NamXuatBan").toLocalDate());
                tg.setSoLuong(resultSet.getInt("SoLuong"));
                tg.setImgSach(resultSet.getString("HinhAnh"));
                Sach_ArrayList.add(tg);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return Sach_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public int TaoMaSach(){
            try {
                Connection conn = JDBCUltil.getConnection();
            
                String sql = "SELECT MAX(MaSach) FROM sach";
            
                PreparedStatement  statement = conn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                
                while (resultSet.next()) {                    
                    return resultSet.getInt(1);
                }
            
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
            
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
}
