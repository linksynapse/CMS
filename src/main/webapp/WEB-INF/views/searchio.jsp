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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  </head>
<%@ include file="include/navigation.jsp" %>
<div class="container-fluid">
  <div class="row">
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">In Out History</h1>
        <div class="row float-right align-items-center">
        <div class="input-group date w-25" id="datetimepicker7" data-target-input="nearest">
			<input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker7"/>
			<div class="input-group-append" data-target="#datetimepicker7" data-toggle="datetimepicker">
				<div class="input-group-text"><i class="fa fa-calendar"></i></div>
        	</div>
        </div>
        <p class="w-10 mr-1 ml-1" style="margin:0px">TO</p>
        <div class="input-group date w-25 mr-2" id="datetimepicker8" data-target-input="nearest">
			<input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker8"/>
			<div class="input-group-append" data-target="#datetimepicker8" data-toggle="datetimepicker">
				<div class="input-group-text"><i class="fa fa-calendar"></i></div>
			</div>
		</div>
	  	<select class="mr-1" id="Category">
	  		<option value="Badge">Badge</option>
	  		<option value="Name">Name</option>
	  		<option value="Company">Company</option>
	  		<option value="Type">Type</option>
	  		<option value="Region">Region</option>
	  		<option value="Location">Location</option>
	  	</select>
	  	<input type="text" class="mr-1" id="searchText" placeholder="Search..">
	  	<input type="button" class="mr-1" value="Search" OnClick="javascript:Search()">
	  </div>
      </div>
		<table class="table table-bordered" style="width:100%" id="wsd">
      		<thead>
      			<tr>
      				<th>Badge</th>
      				<th>Name</th>
      				<th>Company</th>
      				<th>Location</th>
      				<th>Type</th>
      				<th>DateTime</th>
      				<th>Region</th>
      			</tr>
      		</thead>
      		<tbody>
      		<c:forEach var="item" items="${Historys}" varStatus="status">
				<tr>
					<td>${item.getBadge()}</td>
          			<td>${item.getName()}</td>
          			<td>${item.getCompany()}</td>
          			<td>${item.getLocation()}</td>
          			<td>${item.getType()}</td>
          			<td>${item.getTime()}</td>
          			<td>${item.getRegion()}</td>
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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<script>
	function Search(){
		var location = "searchIO?"+$('#Category option:selected').val() + "=" + $('#searchText').val();
		location += "&Start=" + $('#datetimepicker7').datetimepicker("viewDate").format("YYYY-MM-DD HH:mm");
		location += "&End=" + $('#datetimepicker8').datetimepicker("viewDate").format("YYYY-MM-DD HH:mm");
		window.location.href = location;
	}
	
	$(document).ready(function(){
		$('#wsd').DataTable({
			"bFilter": false,
			dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
		});
		
		$('#datetimepicker7').datetimepicker({
			useCurrent: false
		});
        $('#datetimepicker8').datetimepicker();
        $("#datetimepicker7").on("change.datetimepicker", function (e) {
            $('#datetimepicker8').datetimepicker('minDate', e.date);
        });
        $("#datetimepicker8").on("change.datetimepicker", function (e) {
            $('#datetimepicker7').datetimepicker('maxDate', e.date);
        });
	});
</script>
</html>

