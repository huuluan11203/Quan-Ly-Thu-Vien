
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(NhaXuatBan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(NhaXuatBan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhaXuatBan> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
