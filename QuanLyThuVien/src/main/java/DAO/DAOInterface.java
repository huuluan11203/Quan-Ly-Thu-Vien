
package DAO;

import java.util.ArrayList;


// Data Access Object
// Truc tiep thao tac voi co so du lieu
 
public interface DAOInterface<T> {
    public int insert(T t);
    
    public int update(T t);
    
    public int delete(T t);
    
    public ArrayList<T> selectAll();
    
    public T selectByID(T t);
    
    public ArrayList<T> selectByCondition(String condition);
    
}
