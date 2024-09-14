
package DAO;

import DTO.PhieuNhap;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class PhieuNhapDAO implements DAOInterface<PhieuNhap>{
    
     public static PhieuNhapDAO getInstance(){
        return new PhieuNhapDAO();
    }

    @Override
    public int insert(PhieuNhap t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO phieunhap (MaPN, MaNCC, MaNV, NgayNhap) VALUES (?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuNhap());
            statement.setInt(2, t.getMaNCC());
            statement.setInt(3, t.getMaNV());
            statement.setDate(4, Date.valueOf(t.getNgayNhap()));

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
    public int update(PhieuNhap t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE phieunhap SET MaNCC = ?, MaNV = ?, NgayNhap = ? WHERE MaPN = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);

            statement.setInt(1, t.getMaNCC());
            statement.setInt(2, t.getMaNV());
            statement.setDate(3, Date.valueOf(t.getNgayNhap()));
            statement.setInt(4, t.getMaPhieuNhap());

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
    public int delete(PhieuNhap t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM phieunhap WHERE MaPN = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuNhap());

            
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
    public ArrayList<PhieuNhap> selectAll() {
        ArrayList<PhieuNhap> PhieuNhap_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieunhap";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieuNhap(resultSet.getInt("MaPN"));
                pn.setMaNCC(resultSet.getInt("MaNCC"));
                pn.setNgayNhap(resultSet.getDate("NgayNhap").toLocalDate());
                pn.setMaNV(resultSet.getInt("MaNV"));
                PhieuNhap_ArrayList.add(pn);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return PhieuNhap_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PhieuNhap selectByID(PhieuNhap t) {
       PhieuNhap pn = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieunhap WHERE MaPN = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuNhap());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matpn = resultSet.getInt("MaPN");
                int mancc = resultSet.getInt("MaNCC");
                int manv = resultSet.getInt("MaNV");
                LocalDate ngaynhap = resultSet.getDate("NgayNhap").toLocalDate();
               
                
                pn = new PhieuNhap(matpn, mancc, manv, ngaynhap);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return pn;
    }
    
    public PhieuNhap selectByID(int ma) {
        PhieuNhap pn = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieunhap WHERE MaPN = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matpn = resultSet.getInt("MaPN");
                int mancc = resultSet.getInt("MaNCC");
                int manv = resultSet.getInt("MaNV");
                LocalDate ngaynhap = resultSet.getDate("NgayNhap").toLocalDate();
               
                
                pn = new PhieuNhap(matpn, mancc, manv, ngaynhap);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return pn;
    }
    
    @Override
    public ArrayList<PhieuNhap> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public int getMaxID(){
        int rs = -1;
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT MAX(MaPN) AS maxID FROM phieunhap";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                rs = (resultSet.getInt("maxID"));
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return rs;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }
    
}
