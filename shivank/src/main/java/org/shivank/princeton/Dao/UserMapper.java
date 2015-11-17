package org.shivank.princeton.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.shivank.princeton.bean.User;

public class UserMapper implements RowMapper {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
	    user.setUser_id(rs.getString("idUser_details"));
	    user.setName(rs.getString("User_Name"));
	    user.setComment(rs.getString("User_comments"));
	    user.setphn_no(rs.getString("mobile_no"));
	    user.setEmail(rs.getString("User_email"));
	    return user;
	}
   
}