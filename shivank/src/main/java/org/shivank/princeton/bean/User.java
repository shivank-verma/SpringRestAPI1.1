package org.shivank.princeton.bean;  
  
public class User{  
   
 private String cellphone_no,user_id;  
 private String Name,email,comment;
 
 
 public String getphn_no() {  
  return cellphone_no;  
 }  
 public void setphn_no(String cellphone_no) {  
  this.cellphone_no = cellphone_no;  
 }  
 public String getName() {  
  return Name;  
 }  
 public void setName(String Name) {  
  this.Name = Name;  
 }   
 public String getEmail() {  
	  return email;  
	 }  
	 public void setEmail(String email) {  
	  this.email = email;  
	 }   
	 
	 public String getComment() {  
		  return comment;  
		 }  
		 public void setComment(String comment) {  
		  this.comment = comment;  
		 }  
		 public String getUser_id() {  
			  return user_id;  
			 }  
			 public void setUser_id(String user_id) {  
			  this.user_id = user_id;  
			 }  
   
}  