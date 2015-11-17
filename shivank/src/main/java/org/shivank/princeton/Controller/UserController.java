package org.shivank.princeton.Controller;
 
import org.shivank.princeton.Dao.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.shivank.princeton.bean.User;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class UserController {
	
	@Autowired
	private UserDaoImpl dao;
	
	@RequestMapping(value="/User/addUser", method=RequestMethod.GET)
	 public @ResponseBody
	 void addUser(HttpServletRequest request, HttpServletResponse response)
	   throws Exception {

	  User user = new User();

	 String name = request.getParameter("Name");
	  String email = request.getParameter("email");
	  String comment = request.getParameter("comment");
	  String phn_no = request.getParameter("phn_no");
	  String user_id = request.getParameter("user_id");
	  
	  user.setUser_id(user_id);
	  user.setEmail(email);
	  user.setName(name);
	  user.setComment(comment);
	  user.setphn_no(phn_no);
	  
	
	  dao.createUser(user);
	  
	 }
	
	
	@RequestMapping(value="/User/edituser", method=RequestMethod.GET)
	 public @ResponseBody
	 void editUser(HttpServletRequest request, HttpServletResponse response)
	   throws Exception {

	  User user = new User();
	  String name = request.getParameter("Name");
	  String email = request.getParameter("email");
	  String comment = request.getParameter("comment");
	  String phn_no = request.getParameter("phn_no");
	  
	  user.setEmail(email);
	  user.setName(name);
	  user.setComment(comment);
	  user.setphn_no(phn_no);
	  
	 
	  dao.UpdateUser(user);
	 
	 }
	
	
	@RequestMapping(value="/User/deleteUser", method=RequestMethod.GET)
	 public @ResponseBody
	 void deleteUser(HttpServletRequest request, HttpServletResponse response)
	   throws Exception {

	  User user = new User();

	 String user_id = request.getParameter("user_id");
	 
	  
	  user.setUser_id(user_id);
	  
	 
	  dao.deleteUser(user);
	 }
	
	@RequestMapping(value="/User/GetUserList")
	 public @ResponseBody
	 List <User> GetUserList(HttpServletRequest request, HttpServletResponse response)
	   throws Exception {

		
		  List <User> user=dao.GetUserlist();
	  
	  return user;
	 }
	
	}
	
	


