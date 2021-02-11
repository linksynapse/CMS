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
        <h1 class="h2">Create Account</h1>
      </div>
	<form class="needs-validation" id="form" action="javascript:submitCreate()" novalidate>
	  <div class="form-group">
	    <label for="badge">Badge Number</label>
	    <input type="text" class="form-control" id="badge" name="badge" placeholder="000000" required>
	    <div class="invalid-feedback">
        	Please Enter a valid badge.
      	</div>
	  </div>
	  <div class="form-group">
	    <label for="nationalid">National ID</label>
	    <input type="text" class="form-control" id="nationalid" name="nationalid" placeholder="National ID or Passport Number" required>
	    <div class="invalid-feedback">
        	Please Enter a valid National ID or Passport Number.
      	</div>
	  </div>
	  <div class="form-group">
	    <label for="name">Name</label>
	    <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
	    <div class="invalid-feedback">
        	Please Enter a valid Name.
      	</div>
	  </div>
	  <div class="form-group">
	    <label for="national">National</label>
	    <select class="form-control" id="national" name="national">
	      <c:forEach var="item" items="${National}" varStatus="status">
	      	<option value="${item.getValue()}">${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="gender">Gender</label>
	    <select class="form-control" id="gender" name="gender">
	      <c:forEach var="item" items="${Gender}" varStatus="status">
	      	<option value="${item.getValue()}">${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="position">Position</label>
	    <select class="form-control" id="position" name="position">
	      <c:forEach var="item" items="${Position}" varStatus="status">
	      	<option value="${item.getValue()}">${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	    <label for="company">1st Company</label>
	    <select class="form-control" id="company" name="company">
	      <c:forEach var="item" items="${Company}" varStatus="status">
	      	<option value="${item.getValue()}">${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  
	  <div class="form-group">
	    <label for="company_2">2st Company</label>
	    <select class="form-control" id="company_2" name="company_2">
	    	<option value="9999">N/A</option>
	      <c:forEach var="item" items="${Company}" varStatus="status">
	      	<option value="${item.getValue()}">${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  
	  <div class="form-group">
	    <label for="camp">Residence</label>
	    <select class="form-control" id="camp" name="camp">
	      <c:forEach var="item" items="${Camp}" varStatus="status">
	      	<option value="${item.getValue()}">${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  
	  <div class="form-group">
	    <label for="cardnumber">Mobile Number</label>
	    <input type="text" class="form-control" id="mobiles" name="mobiles" placeholder="Input Mobile Number" required>
	    <div class="invalid-feedback">
        	Please Enter a valid mobile number.
      	</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="cardnumber">Notes</label>
	    <input type="text" class="form-control" id="notes" name="notes" placeholder="Input Notes">
	    <div class="invalid-feedback">
        	Please Enter a valid note.
      	</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="cardnumber">Date Of Issuance</label>
	    <input type="text" class="form-control" id="DateOfIssuance" name="DateOfIssuance" placeholder="Input Date Of Issuance (dd/MM/YY)" required>
	    <div class="invalid-feedback">
        	Please Enter a valid Date.
      	</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="cardnumber">CardNumber</label>
	    <input type="text" class="form-control" id="cardnumber" name="cardnumber" placeholder="Input CardNumber" minlength="8" maxlength="8" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');">
	    <div class="invalid-feedback">
        	Please Enter a valid CardNumber.
      	</div>
	  </div>
	  <div class="form-group">
	    <label for="projectsite">Project Site</label>
	    <select class="form-control" id="projectsite" name="projectsite" multiple>
	      <c:forEach var="item" items="${ProjectSite}" varStatus="status">
	      	<option value="${item.getValue()}" selected>${item.getName()}</option>
		  </c:forEach>
	    </select>
	  </div>
	  <button class="btn btn-primary" value="Apply" type="submit">Apply</button>
	</form>
    </main>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
<script>
(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
	})();
	
	function submitCreate(){
		if($('#cardnumber').val().length < 8 && $('#cardnumber').val().length != 0 && $('#cardnumber').val().length > 8){
			alert('Retry input valid CardNumber.');
			return false;
		}
		
		arr = []
		$('#projectsite option:selected').each(function(i, x){
			arr.push($(x).val());
		});
	    // process the form
	    $.ajax({
	        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	        url         : 'crtuser', // the url where we want to POST
	        data        : {
	        	badge:$('#badge').val(),
	        	nationalid:$('#nationalid').val(),
	        	name:$('#name').val(),
	        	national:$('#national option:selected').val(),
	        	gender:$('#gender option:selected').val(),
	        	position:$('#position option:selected').val(),
	        	company:$('#company option:selected').val(),
	        	company_2:$('#company_2 option:selected').val(),
	        	camp:$('#camp option:selected').val(),
	        	cardnumber:$('#cardnumber').val(),
	        	mobiles:$('#mobiles').val(),
	        	notes:$('#notes').val(),
	        	DateOfIssuance:$('#DateOfIssuance').val(),
	        	projectsite:arr
	        }, // our data object
	        dataType    : 'json', // what type of data do we expect back from the server
	        encode      : true
	    })
	    // using the done promise callback
	    .done(function(data) {
           if(data.Code == 0){
        	   alert(data.Msg);
           }else{
        	   alert(data.Msg);
           }
	    })
	    .fail(function(data){
	    	alert("error");
	    });
	}
</script>
</html>

