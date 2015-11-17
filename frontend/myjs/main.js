
 $(document).ready(function () {
	 
	var getUserList = function()
	{
		 $.ajax({
  type: "GET",
  contentType : "application/json",
  url: "http://localhost:8080/shivank/User/GetUserList",    
  data:{},
  success: function(response){
  //var data = JSON.stringify(response);
  var dataFinal = JSON.stringify(response);
   var d1 = eval('(' +dataFinal+ ')');
  var tmpScrpt = $("#row-template").html(); 
  var tmp = Handlebars.compile (tmpScrpt);
	var html =tmp(d1);
    $("#tablerowid").html(html); 
  },
  error: function(){      
   alert('Error while request..');
  }
 });
		
		
	}
	
	
	 
	 $( "#btnSubmit" ).on( "click", function() {
		 
		 var userID =$("#user_id").val();
	 var name =$("#name").val();
	 var Email =$("#email").val();
	 var phnNo =$("#phone").val();
	 var comments =$("#comment").val();
	
		 $.ajax({
  type: "GET",
  contentType : "application/json",
  url: "http://localhost:8080/shivank/User/addUser",    
  data:{ user_id : userID ,Name:name ,email:Email,phn_no:phnNo,comment:comments},
  success: function(){
  swal("Done","User added !","success");
  getUserList();
  $("#regform")[0].reset();
  },
  error: function(){      
   swal("Oops!","Something went wrong!","error")
  }
 });
  
	});
	
	
	
	
	 $("body").on( "click", ".del_btn" , function() {
		
		 var userID =$(this).attr("data-user_id");
	 
	
		 $.ajax({
  type: "GET",
  contentType : "application/json",
  url: "http://localhost:8080/shivank/User/deleteUser",    
  data:{ user_id : userID},
  success: function(){
  swal("Done","User Deleted !", "success");
  getUserList();
  },
  error: function(){      
   swal("Oops!","Something went wrong!","error")
  }
 });
  
	});
	
	
	
	 getUserList();
	 
 });