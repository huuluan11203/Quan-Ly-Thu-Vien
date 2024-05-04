
package DAO;

import DTO.PhieuPhat;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class PhieuPhatDAO implements DAOInterface<PhieuPhat>{

    public static PhieuPhatDAO getInstance(){
        return new PhieuPhatDAO();
    }
    
    @Override
    public int insert(PhieuPhat t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO phieuphat (MaPP, MaPM, NgayTra,"
                    + " LyDo, SoTien) VALUES (?,?,?,?,?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPP());
            statement.setInt(2, t.getMaPM());
            statement.setDate(3, Date.valueOf(t.getNgaytra()));
            statement.setString(4, t.getLyDo());
            statement.setInt(5, t.getSoTien());
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
    public int update(PhieuPhat t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE phieuphat SET MaPM = ?, NgatTra = ?, LyDo = ?, SoTien = ? WHERE MaPP = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPM());
            statement.setDate(2, Date.valueOf(t.getNgaytra()));
            statement.setString(3, t.getLyDo());
            statement.setInt(4, t.getSoTien());
            statement.setInt(5, t.getMaPP());

            
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
    public int delete(PhieuPhat t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM phieuphat WHERE MaPP = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPP());

            
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
    public ArrayList<PhieuPhat> selectAll() {
        ArrayList<PhieuPhat> pp_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieuphat";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                PhieuPhat tg = new PhieuPhat();
                tg.setMaPP(resultSet.getInt("MaPP"));
                tg.setMaPM(resultSet.getInt("MaPM"));
                tg.setNgaytra(resultSet.getDate("NgayTra").toLocalDate());
                tg.setLyDo(resultSet.getString("LyDo"));
                tg.setSoTien(resultSet.getInt("SoTien"));
                pp_ArrayList.add(tg);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return pp_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PhieuPhat selectByID(PhieuPhat t) {
         
        PhieuPhat pp = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieuphat WHERE MaPP = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPP());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mapp = resultSet.getInt("MaPP");
                String lydo= resultSet.getString("LyDo");
                LocalDate ngaytra = resultSet.getDate("NgayTra").toLocalDate();
                int mapm = resultSet.getInt("MaPM");
                int st = resultSet.getInt("SoTien");
                
                pp = new PhieuPhat(mapp, mapm, ngaytra, st,lydo);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return pp;
        
    }
    
     public PhieuPhat selectByID(int ma) {
         
        PhieuPhat pp = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM phieuphat WHERE MaPP = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mapp = resultSet.getInt("MaPP");
                String lydo= resultSet.getString("LyDo");
                LocalDate ngaytra = resultSet.getDate("NgayTra").toLocalDate();
                int mapm = resultSet.getInt("MaPM");
                int st = resultSet.getInt("SoTien");
                
                pp = new PhieuPhat(mapp, mapm, ngaytra, st,lydo);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return pp;
        
    }

    @Override
    public ArrayList<PhieuPhat> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
