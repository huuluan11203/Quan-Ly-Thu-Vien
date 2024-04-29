
package DAO;


import DTO.NhaXuatBan;
import DataBaseConnect.JDBCUltil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class NhaXuatBanDAO implements DAOInterface<NhaXuatBan>{
    
    public static NhaXuatBanDAO getInstance(){
        return new NhaXuatBanDAO();
    } 

    @Override
    public int insert(NhaXuatBan t) {
       try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO nhaxuatban (MaNXB, TenNXB, DiaChi, Sdt) VALUES (?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNXB());
            statement.setString(2, t.getTenNXB());
            statement.setString(3, t.getDiaChi());
            statement.setString(4, t.getSdt());
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
    public int update(NhaXuatBan t) {
         try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE nhaxuatban SET TenNXB = ?, DiaChi = ?, Sdt = ? WHERE MaNXB = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, t.getTenNXB());
            statement.setString(2, t.getDiaChi());
            statement.setString(3, t.getSdt());
            statement.setInt(4, t.getMaNXB());

            
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
    public int delete(NhaXuatBan t) {
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM nhaxuatban WHERE MaNXB = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNXB());

            
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
    public ArrayList<NhaXuatBan> selectAll() {
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhaxuatban";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            ArrayList<NhaXuatBan> NXB_ArrayList = new ArrayList<>();
            while (resultSet.next()) {                
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setMaNXB(resultSet.getInt("MaNXB"));
                nxb.setTenNXB(resultSet.getString("TenNXB"));
                nxb.setDiaChi(resultSet.getString("DiaChi"));
                nxb.setSdt(resultSet.getString("Sdt"));
                NXB_ArrayList.add(nxb);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return NXB_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NhaXuatBan selectByID(NhaXuatBan t) {
        NhaXuatBan nxb = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhaxuatban WHERE MaNXB = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaNXB());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int manxb = resultSet.getInt("MaNXB");
                String tennxb = resultSet.getString("TenNXB");
                String diachi = resultSet.getString("DiaChi");
                String sdt = resultSet.getString("Sdt");
                
                nxb = new NhaXuatBan(manxb, tennxb, diachi, sdt);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nxb;
    }
    
    public NhaXuatBan selectByID(int ma) {
        NhaXuatBan nxb = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhaxuatban WHERE MaNXB = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int manxb = resultSet.getInt("MaNXB");
                String tennxb = resultSet.getString("TenNXB");
                String diachi = resultSet.getString("DiaChi");
                String sdt = resultSet.getString("Sdt");
                
                nxb = new NhaXuatBan(manxb, tennxb, diachi, sdt);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nxb;
    }

    @Override
    public ArrayList<NhaXuatBan> selectByCondition(String condition) {
         ArrayList<NhaXuatBan> NhaXuatBan_ArrayList = new ArrayList<>();
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM nhaxuatban WHERE ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, condition);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {                
                NhaXuatBan tg = new NhaXuatBan();
                tg.setDiaChi(resultSet.getString("DiaChi"));
                tg.setMaNXB(resultSet.getInt("MaNXB"));
                tg.setSdt(resultSet.getString("Sdt"));
                tg.setTenNXB(resultSet.getString("TenNXB"));
                NhaXuatBan_ArrayList.add(tg);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return NhaXuatBan_ArrayList;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
