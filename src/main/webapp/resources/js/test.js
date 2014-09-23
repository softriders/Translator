$(document).ready(function(){
  $("#submit").click(function(){
	  var input = $("#in").val();
	  $.ajax({  
			     type : "POST",   
			     url : "conv",   
			     data : "input=" +input,
	//		     encodeURIComponent(input),
//			     contentType: 'text/plain; charset=utf-8',
			     success : function(response) {  
			      $("#out").val(response)
			    	// $("#out").val("කසුන්");
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

