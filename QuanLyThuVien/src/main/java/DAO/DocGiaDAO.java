
package DAO;

import DTO.DocGia;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class DocGiaDAO implements DAOInterface<DocGia>{
    
    public static DocGiaDAO getInstance(){
        return new DocGiaDAO();
    } 

    @Override
    public int insert(DocGia t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO docgia (`MaDocGia`, `TenDG`, `NamSinh`, `GioiTinh`, `Sdt`, `HinhAnh`, `MaThe`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaDocGia());
            statement.setString(2, t.getTenDocGia());
            statement.setDate(3, Date.valueOf(t.getNamSinh()));
            statement.setString(4, t.getGioiTinh());
            statement.setString(6, t.getHinhanh());
            statement.setInt(7, t.getMaThe());
            
            statement.setString(5, t.getSdt());


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
    public int update(DocGia t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE docgia SET TenDG = ? NamSinh = ? GioiTinh = ? Sdt = ? HinhAnh = ? MaThe = ? WHERE MaDocGia = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);

            statement.setString(1, t.getTenDocGia());
            statement.setDate(2, Date.valueOf(t.getNamSinh()));
            statement.setString(3, t.getGioiTinh());
            statement.setString(5, t.getHinhanh());
            statement.setInt(6, t.getMaThe());
            
            statement.setString(4, t.getSdt());  
             
            statement.setInt(7, t.getMaDocGia());

            
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
    public int delete(DocGia t) {
    
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM docgia WHERE MaDocGia = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaDocGia());

            
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
    public ArrayList<DocGia> selectAll() {
        ArrayList<DocGia> LS_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM docgia";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();           

            while (resultSet.next()) { 
                
                DocGia ls = new DocGia();
                ls.setMaDocGia(resultSet.getInt("MaDocGia"));
                ls.setTenDocGia(resultSet.getString("TenDG"));
                ls.setGioiTinh(resultSet.getString("GioiTinh"));
                ls.setHinhanh(resultSet.getString("HinhAnh"));
                ls.setMaThe(resultSet.getInt("MaThe"));
                ls.setNamSinh(resultSet.getDate("NamSinh").toLocalDate());
                ls.setSdt(resultSet.getString("Sdt"));
                
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
    public DocGia selectByID(DocGia t) {
        DocGia ls = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM docgia WHERE MaDocGia = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaDocGia());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int madg = resultSet.getInt("MaDocGia");
                int mathe = resultSet.getInt("MaThe");
                String ten = resultSet.getString("TenDG");
                String hinhanh = resultSet.getString("HinhAnh");
                String gt = resultSet.getString("GioiTinh");
                String sdt = resultSet.getString("Sdt");
                LocalDate date = resultSet.getDate("NamSinh").toLocalDate();
                ls = new DocGia(madg, ten, date, gt, sdt, hinhanh, mathe);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ls;
    }

     public DocGia selectByID(int ma) {
        DocGia ls = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM docgia WHERE MaDocGia = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int madg = resultSet.getInt("MaDocGia");
                int mathe = resultSet.getInt("MaThe");
                String ten = resultSet.getString("TenDG");
                String hinhanh = resultSet.getString("HinhAnh");
                String gt = resultSet.getString("GioiTinh");
                String sdt = resultSet.getString("Sdt");
                LocalDate date = resultSet.getDate("NamSinh").toLocalDate();
                ls = new DocGia(madg, ten, date, gt, sdt, hinhanh, mathe);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ls;
    }
    
    @Override
    public ArrayList<DocGia> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
