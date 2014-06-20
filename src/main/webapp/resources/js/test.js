$(document).ready(function(){
  $("#submit").click(function(){
	  var input = $("#in").val();
	  $.ajax({  
			     type : "POST",   
			     url : "conv",   
			     data : "input=" +input,  
			     success : function(response) {  
			      $("#out").val(response)
			     },  
			     error : function(e) {  
			      alert('Error msg: ' + e);   
			     }  
		    });  
  });
  $("#clear").click(function(){
	  $("#out").val("");
	  $("#in").val("");
  });
});

