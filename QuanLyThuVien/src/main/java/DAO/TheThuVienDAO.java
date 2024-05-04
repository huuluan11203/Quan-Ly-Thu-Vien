
package DAO;

import DTO.TheThuVien;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class TheThuVienDAO implements DAOInterface<TheThuVien>{

    public static TheThuVienDAO getInstance(){
        return new TheThuVienDAO();
    }
    
    @Override
    public int insert(TheThuVien t) {
        
    try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO thethuvien (MaThe, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaThe());
            statement.setDate(3, Date.valueOf(t.getNgayBatDau()));
            statement.setDate(3, Date.valueOf(t.getNgayKetthuc()));
   
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
    public int update(TheThuVien t) {
    try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE thethuvien SET NgayBatDau = ?, NgayKetThuc = ? WHERE MaThe = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            
            statement.setDate(1, Date.valueOf(t.getNgayBatDau()));
            statement.setDate(2, Date.valueOf(t.getNgayKetthuc()));
            statement.setInt(3, t.getMaThe());

            
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
    public int delete(TheThuVien t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM thethuvien WHERE MaThe = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaThe());

            
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
    public ArrayList<TheThuVien> selectAll() {
     ArrayList<TheThuVien> TheThuVien_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM thethuvien";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                TheThuVien tg = new TheThuVien();
                tg.setMaThe(resultSet.getInt("MaThe"));
                tg.setNgayKetthuc(resultSet.getDate("NgayKetThuc").toLocalDate());
                tg.setNgayBatDau(resultSet.getDate("NgayBatDau").toLocalDate());

                TheThuVien_ArrayList.add(tg);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return TheThuVien_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }    
    }

    @Override
    public TheThuVien selectByID(TheThuVien t) {
        TheThuVien ttv = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM thethuvien WHERE MaThe = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaThe());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mathe = resultSet.getInt("MaThe");
                LocalDate ngaybatdau = resultSet.getDate("NgayKetThuc").toLocalDate();
                LocalDate ngaykethuc = resultSet.getDate("NgayBatDau").toLocalDate();
         
                
                ttv = new TheThuVien(mathe, ngaybatdau, ngaykethuc);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ttv;
    }
    
    public TheThuVien selectByID(int ma) {
        TheThuVien ttv = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM thethuvien WHERE MaThe = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mathe = resultSet.getInt("MaThe");
                LocalDate ngaybatdau = resultSet.getDate("NgayKetThuc").toLocalDate();
                LocalDate ngaykethuc = resultSet.getDate("NgayBatDau").toLocalDate();
         
                
                ttv = new TheThuVien(mathe, ngaybatdau, ngaykethuc);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ttv;
    }

    @Override
    public ArrayList<TheThuVien> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
