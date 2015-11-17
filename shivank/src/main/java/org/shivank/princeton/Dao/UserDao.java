package org.shivank.princeton.Dao;

import java.util.List;
 
import org.shivank.princeton.bean.User;
 

public interface UserDao {
    
	public void createUser(User user ); 
	
    public void UpdateUser(User user);
     
    public void deleteUser(User user);
     
    public List<User> GetUserlist();
}