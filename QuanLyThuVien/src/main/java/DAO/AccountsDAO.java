
package DAO;

import DTO.Accounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import DataBaseConnect.JDBCUltil;
import Utils.PasswordUtil;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountsDAO implements DAOInterface<Accounts> {
    
    public static AccountsDAO getInstance(){
        return new AccountsDAO();
    }
    
    public boolean login(String username, String password) {
        boolean rs = false;
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "SELECT * FROM accounts WHERE TenDN=?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            
            // Thực thi câu lệnh SQL và lấy kết quả
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {          
                if(PasswordUtil.checkPassword(password, resultSet.getString("MatKhau")))
                    rs = true; // Có tài khoản khớp
            }    
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    
    @Override
    public int insert(Accounts t) {
        int rs = 0;
        try {
             //Tao ket noi
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "INSERT INTO accounts (MaTaiKhoan, TenDN, MatKhau, Access) " 
                  +  "  VALUES (?, ?, ?, ?)";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaTaiKhoan());
            statement.setString(2, t.getTenDangNhap());
            statement.setString(3, PasswordUtil.hashPassword(t.getMatKhau()));
            statement.setInt(4, t.getAccess());
            
            //Thuc thi cau lenh SQL
            rs = statement.executeUpdate();
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
   
    @Override
    public int update(Accounts t) { 
        try {
            
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "UPDATE accounts set MatKhau = ? WHERE MaTaiKhoan = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, t.getMatKhau());
            statement.setInt(2, t.getMaTaiKhoan());
            
            //Thuc thi cau lenh SQL
            statement.executeUpdate();
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(Accounts t) {
        try {
            
            Connection conn = JDBCUltil.getConnection();
        
            String sql = "DELETE FROM accounts WHERE MaTaiKhoan = ?";
        
            //Tao doi tuong
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaTaiKhoan());
            
            //Thuc thi cau lenh SQL
            statement.executeUpdate();
   
            //Ngat ket noi
            JDBCUltil.CloseConnection(conn);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ArrayList<Accounts> selectAll() {
  
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM accounts";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            ArrayList<Accounts> accounts = new ArrayList<>();
            while (resultSet.next()) {                
                Accounts acc = new Accounts();
                acc.setMaTaiKhoan(resultSet.getInt("MaTaiKhoan"));
                acc.setTenDangNhap(resultSet.getString("TenDN"));
                acc.setMatKhau(resultSet.getString("MatKhau"));
                acc.setAccess(resultSet.getInt("Access"));
                accounts.add(acc);
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            resultSet.close();
            
            return accounts;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public int get_CurrentMTK_DAO(){
        
        try {
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT MAX(MaTaiKhoan) FROM accounts";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            
            if (resultSet.next()) {
                int mtk = resultSet.getInt(1);
                JDBCUltil.CloseConnection(conn);
                resultSet.close();
                statement.close();
                return mtk;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } 
        return -1;
    }

    @Override
    public Accounts selectByID(Accounts t) {
            Accounts nxb = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM accounts WHERE MaTaiKhoan = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getMaTaiKhoan());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matk = resultSet.getInt("MaTaiKhoan");
                String tentk = resultSet.getString("TenDN");
                String mk = resultSet.getString("MatKhau");
                int aces = resultSet.getInt("Access");
                
                nxb = new Accounts(tentk, mk, matk, aces);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nxb;    
    }
    
    public Accounts selectByID(String tendangnhap) {
            Accounts nxb = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM accounts WHERE TenDN = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setString(1, tendangnhap);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matk = resultSet.getInt("MaTaiKhoan");
                String tentk = resultSet.getString("TenDN");
                String mk = resultSet.getString("MatKhau");
                int aces = resultSet.getInt("Access");
                
                nxb = new Accounts(tentk, mk, matk, aces);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nxb;    
    }
    
    public Accounts selectByID(int ma) {
            Accounts nxb = null;
        try {
           
            Connection conn = JDBCUltil.getConnection();
            
            String sql = "SELECT * FROM accounts WHERE MaTaiKhoan = ?";
            
            PreparedStatement  statement = conn.prepareStatement(sql);
            statement.setInt(1, ma);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int matk = resultSet.getInt("MaTaiKhoan");
                String tentk = resultSet.getString("TenDN");
                String mk = resultSet.getString("MatKhau");
                int aces = resultSet.getInt("Access");
                
                nxb = new Accounts(tentk, mk, matk, aces);
                
            }
            
            JDBCUltil.CloseConnection(conn);
            statement.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nxb;    
    }


    @Override
    public ArrayList<Accounts> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
