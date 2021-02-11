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
        <h1 class="h2">${Name}</h1>
      </div>
      <form class="needs-validation" id="form" novalidate>
	      <div class="form-group col-md-6">
		    <label for="company">Category</label>
		    <select class="form-control" id="category" name="category">
		      <c:forEach var="item" items="${data}" varStatus="status">
		      	<option value="${item.getValue()}">${item.getName()}</option>
			  </c:forEach>
		    </select>
		  </div>
		  <div class="form-group col-md-6">
		    <label for="nationalid">Category Name</label>
		    <input type="text" class="form-control" id="name" name="name" placeholder="Input category name." required>
		    <div class="invalid-feedback">
	        	Input category name.
	      	</div>
		  </div>
		  <div class="form-group col-md-6">
		    <label for="nationalid">Category ShortCut</label>
		    <input type="text" class="form-control" id="shortcut" name="shortcut" placeholder="Input category shortcut name." required>
		    <div class="invalid-feedback">
	        	Input category shortcut name.
	      	</div>
		  </div>
		  <div class="form-group col-md-6 r-1">
		    <button class="btn btn-primary w-30" value="1" name="action" type="submit">Create</button>
		    <button class="btn btn-secondary w-30" value="2" name="action" type="submit">Modify</button>
		    <button class="btn btn-danger w-30" value="3" onClick="Javascript:Submit()" type="button">Delete</button>
		  </div>
		  
      </form>
    </main>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
<script>

	$(document).ready(function() {
		var msg = '${msg}';
		  if(msg != ""){
			  alert(msg);
		  }
		  
		  
	});

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
	
	function Submit(){
		var vName = $('#category option:selected').html();
		var vProductCode = $('#category').val();
		if (confirm('Are you sure you want to delete \"' + vName + '\" item?')) {
			// Save it!
			var location = window.location.href = "?category=" + vProductCode + "&action=3";
			window.location.href = location;
		} else {
			// Do nothing!
			
		}
	}
</script>
</html>

