
package DAO;

import DTO.ChiTietPhieuNhap;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ChiTietPhieuNhapDAO implements DAOInterface<ChiTietPhieuNhap>{
    
    public static ChiTietPhieuNhapDAO getInstance(){
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public int insert(ChiTietPhieuNhap t) {
       try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO chitietphieunhap (MaCTPN, MaPN, MaSach,"
                    + " Gia, SoLuong) VALUES (?,?,?,?,?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaCTPN());
            statement.setInt(2, t.getMaPhieuNhap());
            statement.setInt(3, t.getMaSach());
            statement.setInt(4, t.getGia());
            statement.setInt(5, t.getSoLuong());
           
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
    public int update(ChiTietPhieuNhap t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE chitietphieunhap SET MaPN = ?, MaSach = ?, Gia = ?, SoLuong = ? WHERE MaCTPN = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaPhieuNhap());
            statement.setInt(2, t.getMaSach());
            statement.setInt(3, t.getGia());
            statement.setInt(4, t.getSoLuong());
            statement.setInt(5, t.getMaCTPN());
            
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
    public int delete(ChiTietPhieuNhap t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM chitietphieunhap WHERE MaCTPN = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaCTPN());

            
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
    public ArrayList<ChiTietPhieuNhap> selectAll() {
        
        ArrayList<ChiTietPhieuNhap> ctpn_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM chitietphieunhap";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
                ctpn.setMaCTPN(resultSet.getInt("MaCTPN"));
                ctpn.setMaPhieuNhap(resultSet.getInt("MaPN"));
                ctpn.setMaSach(resultSet.getInt("MaSach"));
                ctpn.setGia(resultSet.getInt("Gia"));
                ctpn.setSoLuong(resultSet.getInt("SoLuong"));
                
                ctpn_ArrayList.add(ctpn);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return ctpn_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChiTietPhieuNhap selectByID(ChiTietPhieuNhap t) {
         ChiTietPhieuNhap ctpn = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM chitietphieunhap WHERE MaCTPN = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaCTPN());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mactpn = resultSet.getInt("MaCTPN");
                int mapn = resultSet.getInt("MaPN");
                int ms = resultSet.getInt("MaSach");
                int gia = resultSet.getInt("Gia");
                int sl = resultSet.getInt("SoLuong");
                
                ctpn = new ChiTietPhieuNhap(mactpn, mapn, ms, gia, sl);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ctpn;
    }
    
      public ChiTietPhieuNhap selectByID(int ma) {
         ChiTietPhieuNhap ctpn = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM chitietphieunhap WHERE MaCTPN = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mactpn = resultSet.getInt("MaCTPN");
                int mapn = resultSet.getInt("MaPN");
                int ms = resultSet.getInt("MaSach");
                int gia = resultSet.getInt("Gia");
                int sl = resultSet.getInt("SoLuong");
                
                ctpn = new ChiTietPhieuNhap(mactpn, mapn, ms, gia, sl);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ctpn;
    }

    @Override
    public ArrayList<ChiTietPhieuNhap> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
