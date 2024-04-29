
package DAO;

import DTO.TacGia;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

public class TacGiaDAO implements DAOInterface<TacGia> {
    
     public static TacGiaDAO getInstance(){
        return new TacGiaDAO();
    }

    @Override
    public int insert(TacGia t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO tacgia (MaTacGia, TenTacGia, NamSinh,"
                    + " DiaChi, HinhAnh, GioiThieu) VALUES (?,?,?,?,?,?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaTacGia());
            statement.setString(2, t.getTenTacGia());
            statement.setDate(3, Date.valueOf(t.getNamSinh()));
            statement.setString(4, t.getDiachi());
            statement.setString(5, t.getHinhanh());
            statement.setString(6, t.getGioiThieu());
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
    public int update(TacGia t) {
           try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE tacgia SET TenTacGia = ?, NamSinh = ?, DiaChi = ?, HinhAnh = ?, GioiThieu = ? WHERE MaTacGia = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, t.getTenTacGia());
            statement.setDate(2, Date.valueOf(t.getNamSinh()));
            statement.setString(3, t.getDiachi());
            statement.setString(4, t.getHinhanh());
            statement.setString(5, t.getGioiThieu());
            statement.setInt(6, t.getMaTacGia());

            
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
    public int delete(TacGia t) {
       try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM tacgia WHERE MaTacGia = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaTacGia());

            
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
    public ArrayList<TacGia> selectAll() {
        
        ArrayList<TacGia> TacGia_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM tacgia";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                TacGia tg = new TacGia();
                tg.setMaTacGia(resultSet.getInt("MaTacGia"));
                tg.setTenTacGia(resultSet.getString("TenTacGia"));
                tg.setNamSinh(resultSet.getDate("NamSinh").toLocalDate());
                tg.setDiachi(resultSet.getString("DiaChi"));
                tg.setGioiThieu(resultSet.getString("GioiThieu"));
                tg.setHinhanh(resultSet.getString("HinhAnh"));
                TacGia_ArrayList.add(tg);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return TacGia_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TacGia selectByID(TacGia t) {
        
        TacGia tacgia = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM tacgia WHERE MaTacGia = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaTacGia());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matacgia = resultSet.getInt("MaTacGia");
                String tentacgia = resultSet.getString("TenTacGia");
                LocalDate namsinh = resultSet.getDate("NamSinh").toLocalDate();
                String diachi = resultSet.getString("DiaChi");
                String gioithieu = resultSet.getString("GioiThieu");
                String hinhanh = resultSet.getString("HinhAnh");
                
                tacgia = new TacGia(matacgia, tentacgia, namsinh, diachi, hinhanh, gioithieu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return tacgia;
    }
    
    public TacGia selectByID(int mtg) {
        
        TacGia tacgia = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM tacgia WHERE MaTacGia = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, mtg);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matacgia = resultSet.getInt("MaTacGia");
                String tentacgia = resultSet.getString("TenTacGia");
                LocalDate namsinh = resultSet.getDate("NamSinh").toLocalDate();
                String diachi = resultSet.getString("DiaChi");
                String gioithieu = resultSet.getString("GioiThieu");
                String hinhanh = resultSet.getString("HinhAnh");
                
                tacgia = new TacGia(matacgia, tentacgia, namsinh, diachi, hinhanh, gioithieu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return tacgia;
    }
    
    public TacGia selectByID(String ten) {
        
        TacGia tacgia = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM tacgia WHERE TenTacGia = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, ten);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matacgia = resultSet.getInt("MaTacGia");
                String tentacgia = resultSet.getString("TenTacGia");
                LocalDate namsinh = resultSet.getDate("NamSinh").toLocalDate();
                String diachi = resultSet.getString("DiaChi");
                String gioithieu = resultSet.getString("GioiThieu");
                String hinhanh = resultSet.getString("HinhAnh");
                
                tacgia = new TacGia(matacgia, tentacgia, namsinh, diachi, hinhanh, gioithieu);
                
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return tacgia;
    }

    @Override
    public ArrayList<TacGia> selectByCondition(String condition) {
            
        ArrayList<TacGia> TacGia_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM tacgia WHERE ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, condition);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {                
                TacGia tg = new TacGia();
                tg.setMaTacGia(resultSet.getInt("MaTacGia"));
                tg.setTenTacGia(resultSet.getString("TenTacGia"));
                tg.setNamSinh(resultSet.getDate("NamSinh").toLocalDate());
                tg.setDiachi(resultSet.getString("DiaChi"));
                tg.setGioiThieu(resultSet.getString("GioiThieu"));
                tg.setHinhanh(resultSet.getString("HinhAnh"));
                TacGia_ArrayList.add(tg);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return TacGia_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
