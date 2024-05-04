
package DAO;

import DTO.PhieuMuon;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class PhieuMuonDAO implements DAOInterface<PhieuMuon>{
    
    public static PhieuMuonDAO getInstance(){
        return new PhieuMuonDAO();
    } 

    @Override
    public int insert(PhieuMuon t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO phieumuon (MaPhieuMuon, MaNV, MaDocGia, NgayMuon, TinhTrang) VALUES (?, ?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuMuon());
            statement.setInt(2, t.getMaNV());
            statement.setInt(3, t.getMaDocGia());
            statement.setDate(4, Date.valueOf(t.getNgayMuon()));            
            statement.setString(5, t.getTinhTrang());

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
    public int update(PhieuMuon t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE phieumuon SET MaNV = ?, MaDocGia = ?, NgayMuon = ?, TinhTrang = ? WHERE MaPhieuMuon = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(5, t.getMaPhieuMuon());
            statement.setInt(1, t.getMaNV());
            statement.setInt(2, t.getMaDocGia());
            statement.setDate(3, Date.valueOf(t.getNgayMuon()));            
            statement.setString(4, t.getTinhTrang());
            
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
    public int delete(PhieuMuon t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM phieumuon WHERE MaPhieuMuon = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuMuon());

            
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
    public ArrayList<PhieuMuon> selectAll() {
         ArrayList<PhieuMuon> LS_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieumuon";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();           

            while (resultSet.next()) { 
                
                PhieuMuon ls = new PhieuMuon();
                ls.setMaPhieuMuon(resultSet.getInt("MaPhieuMuon"));
                ls.setMaNV(resultSet.getInt("MaNV"));
                ls.setMaDocGia(resultSet.getInt("MaDocGia"));
                ls.setNgayMuon(resultSet.getDate("NgayMuon").toLocalDate());
                ls.setTinhTrang(resultSet.getString("TinhTrang"));
                LS_ArrayList.add(ls);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return LS_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PhieuMuon selectByID(PhieuMuon t) {
        PhieuMuon ls = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieumuon WHERE MaPhieuMuon = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuMuon());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mapm = resultSet.getInt("MaPhieuMuon");
                String tinhtrang = resultSet.getString("TinhTrang");
                int manv = resultSet.getInt("MaNV");
                int madg = resultSet.getInt("MaDocGia");
                LocalDate date = resultSet.getDate("NgayMuon").toLocalDate();
                
                ls = new PhieuMuon(mapm, manv, madg, date, tinhtrang);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ls;
    }
    
     public PhieuMuon selectByID(int ma) {
        PhieuMuon ls = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieumuon WHERE MaPhieuMuon = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mapm = resultSet.getInt("MaPhieuMuon");
                String tinhtrang = resultSet.getString("TinhTrang");
                int manv = resultSet.getInt("MaNV");
                int madg = resultSet.getInt("MaDocGia");
                LocalDate date = resultSet.getDate("NgayMuon").toLocalDate();
                
                ls = new PhieuMuon(mapm, manv, madg, date, tinhtrang);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ls;
    }

    @Override
    public ArrayList<PhieuMuon> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
