
package DAO;

import DTO.ChiTietPhieuMuon;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class ChiTietPhieuMuonDAO implements DAOInterface<ChiTietPhieuMuon>{

     public static ChiTietPhieuMuonDAO getInstance(){
        return new ChiTietPhieuMuonDAO();
    }
    @Override
    public int insert(ChiTietPhieuMuon t) {
       try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO chitietphieumuon (MaCTPM, MaPhieuMuon, MaSach, NgayTra, GhiChu) VALUES (?, ?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaCTPM());
            statement.setInt(2, t.getMaPhieuMuon());
            statement.setInt(3, t.getMaSach());
            statement.setDate(4, Date.valueOf(t.getNgayTra()));
            statement.setString(5, t.getGhiChu());

            //Thuc thi cau lenh SQL
            int kq = 0;
           try {
               kq = statement.executeUpdate();
           } catch (SQLException sQLException) {
               kq = -1;
           }
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
            
            return kq;
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(ChiTietPhieuMuon t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE chitietphieumuon SET MaPhieuMuon = ?, MaSach = ?, NgayTra = ?, GhiChu = ? WHERE MaCTPM = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(5, t.getMaCTPM());
            statement.setInt(1, t.getMaPhieuMuon());
            statement.setInt(2, t.getMaSach());
            statement.setDate(3, Date.valueOf(t.getNgayTra()));
            statement.setString(4, t.getGhiChu());

            //Thuc thi cau lenh SQL
             int kq = 0;
             try {
                 kq = statement.executeUpdate();
             } catch (SQLException sQLException) {
                 kq = -1;
             }
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
           
            return kq;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(ChiTietPhieuMuon t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM chitietphieumuon WHERE MaCTPM = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaCTPM());

            
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
    public ArrayList<ChiTietPhieuMuon> selectAll() {

        ArrayList<ChiTietPhieuMuon> CTPM_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM chitietphieumuon";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                ChiTietPhieuMuon pn = new ChiTietPhieuMuon();
                pn.setMaCTPM(resultSet.getInt("MaCTPM"));
                pn.setMaPhieuMuon(resultSet.getInt("MaPhieuMuon"));
                pn.setNgayTra(resultSet.getDate("NgayTra").toLocalDate());
                pn.setMaSach(resultSet.getInt("MaSach"));
                pn.setGhiChu(resultSet.getString("GhiChu"));
                CTPM_ArrayList.add(pn);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return CTPM_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChiTietPhieuMuon selectByID(ChiTietPhieuMuon t) {
         ChiTietPhieuMuon pn = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM chitietphieumuon WHERE MaCTPM = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaCTPM());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mapm = resultSet.getInt("MaPhieuMuon");
                int manctpm = resultSet.getInt("MaCTPM");
                int masach = resultSet.getInt("MaSach");
                String ghichu = resultSet.getString("GhiChu");
                LocalDate date = resultSet.getDate("NgayTra").toLocalDate();
               
                
                pn = new ChiTietPhieuMuon(manctpm, mapm, masach, date, ghichu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return pn;
    }
    
     public ChiTietPhieuMuon selectByID(int ma) {
         ChiTietPhieuMuon pn = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM chitietphieumuon WHERE MaCTPM = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mapm = resultSet.getInt("MaPhieuMuon");
                int manctpm = resultSet.getInt("MaCTPM");
                int masach = resultSet.getInt("MaSach");
                String ghichu = resultSet.getString("GhiChu");
                LocalDate date = resultSet.getDate("NgayTra").toLocalDate();
               
                
                pn = new ChiTietPhieuMuon(manctpm, mapm, masach, date, ghichu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return pn;
    }

    @Override
    public ArrayList<ChiTietPhieuMuon> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
