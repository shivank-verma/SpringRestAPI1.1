
 $(document).ready(function () {
	 
	var getUserList = function()
	{
		 $.ajax({
  type: "GET",
  contentType : "application/json",
  url: "http://localhost:8080/mongomvc/User/GetUserList",    
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
  url: "http://localhost:8080/mongomvc/User/addUser",    
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
		var phn_no =$(this).attr("data-phn_no");
		var name =$(this).attr("data-name");
		var email = $(this).attr("data-email");
		var comment =$(this).attr("data-comment");
	
		 $.ajax({
  type: "GET",
  contentType : "application/json",
  url: "http://localhost:8080/mongomvc/User/deleteUser",    
  data:{ user_id : userID,Name:name ,email:email,phn_no:phn_no,comment:comment},
  success: function(){
  swal("Done","User Deleted !", "success");
  getUserList();
  },
  error: function(){      
   swal("Oops!","Something went wrong!","error")
  }
 });
  
	});
	
	
	$("body").on( "click", "#edit_btn" , function() {
		
		 var userID =$("#user_idEdit").val();
		 if (userID==="")
		 {
			 userID = $("#user_idEdit").attr("placeholder");
		 }
	 var name =$("#nameEdit").val();
	 if (name==="")
		 {
			 name = $("#nameEdit").attr("placeholder");
		 }
	 var Email =$("#emailEdit").val();
	 if (Email==="")
		 {
			 Email = $("#emailEdit").attr("placeholder");
		 }
	 var phnNo =$("#phoneEdit").val();
	 if (phnNo==="")
		 {
			 phnNo = $("#phoneEdit").attr("placeholder");
		 }
	 var comments =$("#commentEdit").val();
	 if (comments==="")
		 {
			 comments = $("#commentEdit").attr("placeholder");
		 }
		
		
		$.ajax({
  type: "GET",
  contentType : "application/json",
  url: "http://localhost:8080/mongomvc/User/edituser",    
  data:{ user_id : userID,Name:name ,email:Email,phn_no:phnNo,comment:comments},
  success: function(){
  swal("Done","User Edited !", "success");
  getUserList();
  },
  error: function(){      
   swal("Oops!","Something went wrong!","error")
  }
 });
	});
	
	
	
	 getUserList();
	


$("#searchbar").keyup(function () {
    var userInput = $(this).val();
    $("#tablerowid tr").map(function (index, value) {
        $(value).toggle($(value).text().toLowerCase().indexOf(userInput) >= 0);
    });
});	
 });