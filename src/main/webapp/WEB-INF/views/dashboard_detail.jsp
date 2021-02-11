<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
    <link href="assets/css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/feather.css">
  </head>
<%@ include file="include/navigation.jsp" %>
<div class="container-fluid">
  <div class="row">
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard - ${PageName}</h1>
      </div>

      <div class="row" id="DashboardCard">
        <!-- Start Card -->
        
        <!-- End Card -->
      </div>
    </main>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
<script>
	$(document).ready(function(){
		initalize();
	});
	
	function initalize(){
		$.ajax({
		    type     : "GET",
		    url      : "implDashboardEx",
		  	data	 : {
		  		pjt:${ProjectCode}
		  	},
		    success  : function(data) {
		    	if(data.Code == 0){
		    		var Cards = "";
		   			$.each(data.Data, function(index,x){
		   				Cards += '<div class="col-md-4 mb-2">'
		   	          	Cards += '<div class="card bg-light">'
		   	          	Cards += '<div class="card-body">'
		   	          	Cards += '  <h1 class="card-title text-md-center">'+ x.name +'</h1>'
		   	          	Cards += '  <div class="card-text">'
		   	          	Cards += '    <p class="text-md-center" style="font-size: 1.5rem">' + x.count
		   	          	Cards += '      <a class="text-muted" style="font-size: 1rem"> People</a>'
		   	          	Cards += '    </p>'
		   	          	Cards += '  </div>'
		   	          	Cards += '</div>'
		   	          	Cards += '</div>'
		   	          	Cards += '</div>'
		   			});
		   			$('#DashboardCard').html(Cards);
		   			setTimeout(initalize, 10000);
		    	}else{
		    		window.location.href = "sign"
		    	}
		    },
		    error: function(data){
		    	alert(data.Msg);
		    }
		});
	}
</script>
</html>

