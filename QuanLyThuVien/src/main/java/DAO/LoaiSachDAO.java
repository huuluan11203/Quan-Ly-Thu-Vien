
package DAO;

import DTO.LoaiSach;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoaiSachDAO implements DAOInterface<LoaiSach>{
    
    public static LoaiSachDAO getInstance(){
        return new LoaiSachDAO();
    } 

    @Override
    public int insert(LoaiSach t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO loaisach (MaLoaiSach, TenLoaiSach) VALUES (?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaLoaiSach());
            statement.setString(2, t.getTenLoaiSach());

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
    public int update(LoaiSach t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE loaisach SET TenLoaiSach = ? WHERE MaLoaiSach = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, t.getTenLoaiSach());
            statement.setInt(2, t.getMaLoaiSach());

            
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
    public int delete(LoaiSach t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM loaisach WHERE MaLoaiSach = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaLoaiSach());

            
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
    public ArrayList<LoaiSach> selectAll() {
        
        ArrayList<LoaiSach> LS_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM loaisach";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();           

            while (resultSet.next()) { 
                
                LoaiSach ls = new LoaiSach();
                ls.setMaLoaiSach(resultSet.getInt("MaLoaiSach"));
                ls.setTenLoaiSach(resultSet.getString("TenLoaiSach"));
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
    public LoaiSach selectByID(LoaiSach t) {
     
        LoaiSach ls = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM loaisach WHERE MaLoaiSach = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaLoaiSach());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mals = resultSet.getInt("MaLoaiSach");
                String tenls = resultSet.getString("TenLoaiSach");                
                ls = new LoaiSach(mals, tenls);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ls;
    }
    
    public LoaiSach selectByID(int ma) {
     
        LoaiSach ls = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM loaisach WHERE MaLoaiSach = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mals = resultSet.getInt("MaLoaiSach");
                String tenls = resultSet.getString("TenLoaiSach");                
                ls = new LoaiSach(mals, tenls);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ls;
    }
    

    @Override
    public ArrayList<LoaiSach> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
