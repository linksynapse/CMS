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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
  </head>
<%@ include file="include/navigation.jsp" %>
<div class="container-fluid">
  <div class="row">
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Hardware Status</h1>
        <div class="row float-right">
	  </div>
      </div>
		<table class="table table-bordered" style="width:100%" id="wsd">
      		<thead>
      			<tr>
      				<th>AuthKey</th>
      				<th>Serial Number</th>
      				<th>Location</th>
      				<th>Status</th>
      				<th>DoorType</th>
      				<th>Region</th>
      				<th>Action</th>
      			</tr>
      		</thead>
      		<tbody>
      		<c:forEach var="item" items="${Hardwares}" varStatus="status">
				<tr>
					<td>${item.getAuthKey()}</td>
          			<td>${item.getSerial()}</td>
          			<td>${item.getLocation()}</td>
          			<td>${item.getStatus()}</td>
          			<td>${item.getDoorType()}</td>
          			<td>${item.getRegion()}</td>
          			<td>${item.getAction()}</td>
				</tr>
			</c:forEach>
      		</tbody>
      	</table>
    </main>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.flash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.print.min.js"></script>

<script>
	$(document).ready(function(){
		$('#wsd').DataTable({
			"bFilter": false,
			dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
		});
	});
	
	function update(authkey){
		if (confirm('Are you sure you want to sync account RTE? (This work affect performance.)')) {
			$.ajax({
			    type     : "GET",
			    url      : "update",
			    data	 : {"AuthKey":authkey},
			    success  : function(data) {
			    	if(data.Code != 0){
			    		alert("Send command to RTE successful, Wait for 5 minutes.");
			   			
			    	}else{
			    		alert("Error.");
			    	}
			    },
			    error: function(data){
			    	alert(data.Msg);
			    }
			});
		} else {
			  
		}
		
	}
</script>
</html>

