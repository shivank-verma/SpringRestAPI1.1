package org.shivank.princeton.Dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.shivank.princeton.bean.User;

public class UserDaoImpl implements UserDao{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 

	@Override
	public void createUser(User user) {
		String SQL = "insert into user_details (idUser_details,User_Name, mobile_no, User_email, User_comments) values (?,?,?,?,?)";
		Object[] parameters=new Object[]{user.getUser_id(),user.getName(),user.getphn_no(),user.getEmail(),user.getComment()};
		   int[]types= new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		    
		
		jdbcTemplate.update(SQL,parameters,types );
	}

	@Override
	public void UpdateUser(User user) {
		String SQL = "update user_details set User_Name = ?,mobile_no=?,User_email=?,User_comments=? where idUser_details = ?";
		   Object[] parameters=new Object[]{user.getName(),user.getphn_no(),user.getEmail(),user.getComment(),user.getUser_id()};
		   int[]types= new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		   jdbcTemplate.update(SQL,parameters,types );
	}

	@Override
	public void deleteUser(User user) {
		String SQL = "delete from user_details where idUser_details = ?";
		   Object[] parameters=new Object[]{user.getUser_id()};
		   int[]types= new int[]{Types.VARCHAR};
		   jdbcTemplate.update(SQL,parameters,types );
	}

	@Override
	public List<User> GetUserlist() {
		
		String sql = "SELECT * FROM user_details";
		
	    @SuppressWarnings("unchecked")
		List<User> listUser =jdbcTemplate.query(sql,new UserMapper());
	 
	    return listUser;
		
	}
   
	


   
  
}