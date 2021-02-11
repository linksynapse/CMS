<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>BLUZEN::Access Control System</title>

    <!-- Bootstrap core CSS -->
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="assets/css/floating-labels.css" rel="stylesheet">
  </head>
  <body>
    <form class="form-signin">
  <div class="text-center mb-4">
    <img class="mb-4" src="assets/image/logo.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
    <p>Contents Management System</p>
  </div>

  <div class="form-label-group">
    <input type="email" id="Identify" name="Identify" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputEmail">Email address</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="Password" name="Password" class="form-control" placeholder="Password" required>
    <label for="inputPassword">Password</label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="Submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted text-center">Bluzen Pte Ltd &copy; 2020</p>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$(".form-signin").bind("submit",function(){
			var id = $('#Identify').val();
			var pw = $('#Password').val();
			
			$.ajax({
	            type     : "POST",
	            url      : "login",
	            dataType : "json",
	            data     : {
	            	"Identify":id,
	            	"Password":pw
	            },
	            success  : function(data) {
	            	if(data.Code == 0){
	            		window.location.href = "dashboard";
	            	}else{
	            		alert("Invalid account.");
	            	}
					
	            },
	            error: function(data){
	            	alert(data.Msg);
	            }
	    	});
			
			return false;
		});
	});
</script>
</html>
