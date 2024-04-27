
package DAO;

import DTO.NhaCungCap;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class NhaCungCapDAO implements DAOInterface<NhaCungCap>{

    public static NhaCungCapDAO getInsttance() {
        return  new NhaCungCapDAO();
    }

    
   
    @Override
    public int insert(NhaCungCap t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO nhacungcap (MaNCC, TenNCC) VALUES (?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNCC());
            statement.setString(2, t.getTenNCC());
         

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
    public int update(NhaCungCap t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE nhacungcap SET TenNCC = ? WHERE MaNCC = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);

            statement.setString(1, t.getTenNCC());
            statement.setInt(2, t.getMaNCC());

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
    public int delete(NhaCungCap t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM nhacungcap WHERE MaNCC = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNCC());

            
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
    public NhaCungCap selectByID(NhaCungCap t) {
        NhaCungCap ncc = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhacungcap WHERE MaNCC = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNCC());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mancc = resultSet.getInt("MaNCC");
                String tenncc = resultSet.getString("TenNCC");
              
               ncc = new NhaCungCap(mancc, tenncc); 
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ncc;
    }
    
    public NhaCungCap selectByID(int ma) {
        NhaCungCap ncc = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhacungcap WHERE MaNCC = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int mancc = resultSet.getInt("MaNCC");
                String tenncc = resultSet.getString("TenNCC");
              
               ncc = new NhaCungCap(mancc, tenncc); 
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ncc;
    }

    @Override
    public ArrayList<NhaCungCap> selectAll() {
                
        ArrayList<NhaCungCap> ncc_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhacungcap";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {                
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(resultSet.getInt("MaNCC"));
                ncc.setTenNCC(resultSet.getString("TenNCC"));
             
                ncc_ArrayList.add(ncc);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return ncc_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<NhaCungCap> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
