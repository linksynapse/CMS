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
        <h1 class="h2">User Profile</h1>
        <div class="row float-right">
	  </div>
      </div>
		<div class="row">
			<div class="col-md-12">
				<form id="form" action="javascript:submitCreate()">
					<div class="form-group row">
						<label for="badge" class="col-4 col-form-label float-right">Badge Number</label> 
						<div class="col-8">
							<input id="badge" name="badge" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getBadge()}" readonly>
	                    </div>
					</div>
					<div class="form-group row">
						<label for="nationalid" class="col-4 col-form-label float-right">National ID*</label> 
						<div class="col-8">
							<input id="nationalid" name="nationalid" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getNPNumber()}">
	                    </div>
					</div>
					<div class="form-group row">
						<label for="username" class="col-4 col-form-label float-right">User Name*</label> 
						<div class="col-8">
							<input id="username" name="username" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getName()}">
	                    </div>
					</div>
					<div class="form-group row">
						<label for="national" class="col-4 col-form-label float-right">Nationality*</label> 
						<div class="col-8">
							<select class="form-control" id="national" name="national">
						      <c:forEach var="item" items="${National}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
	                    </div>
					</div>
					<div class="form-group row">
						<label for="gender" class="col-4 col-form-label float-right">Gender*</label> 
						<div class="col-8">
							<select class="form-control" id="gender" name="gender">
						      <c:forEach var="item" items="${Gender}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
	                    </div>
					</div>
					<div class="form-group row">
						<label for="position" class="col-4 col-form-label float-right">Position*</label> 
						<div class="col-8">
							<select class="form-control" id="position" name="position">
						      <c:forEach var="item" items="${Position}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
	                    </div>
					</div>
					<div class="form-group row">
						<label for="company" class="col-4 col-form-label float-right">1st Company*</label> 
						<div class="col-8">
							<select class="form-control" id="company" name="company">
						      <c:forEach var="item" items="${Company}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
	                    </div>
					</div>
					
					<div class="form-group row">
						<label for="company" class="col-4 col-form-label float-right">2nd Company*</label> 
						<div class="col-8">
							<select class="form-control" id="company_2" name="company_2">
								<option value="9999">N/A</option>
						      <c:forEach var="item" items="${Company}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
	                    </div>
					</div>
					
					<div class="form-group row">
						<label for="camp" class="col-4 col-form-label float-right">Residence*</label> 
						<div class="col-8">
							<select class="form-control" id="camp" name="camp">
						      <c:forEach var="item" items="${Camp}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
	                    </div>
					</div>
					<div class="form-group row">
						<label for="username" class="col-4 col-form-label float-right">Mobile Number*</label> 
						<div class="col-8">
							<input id="mobiles" name="mobiles" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getMobile()}">
	                    </div>
					</div>
					<div class="form-group row">
						<label for="username" class="col-4 col-form-label float-right">Notes*</label> 
						<div class="col-8">
							<input id="notes" name="notes" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getNotes()}">
	                    </div>
					</div>
					<div class="form-group row">
						<label for="cardnumber" class="col-4 col-form-label float-right">Date Of Issuance*</label> 
						<div class="col-8">
							<input id="DateOfIssuance" name="DateOfIssuance" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getDateOfIssuance()}">
	                    </div>
					</div>
					<div class="form-group row">
						<label for="cardnumber" class="col-4 col-form-label float-right">CardNumber</label> 
						<div class="col-8">
							<input id="cardnumber" name="cardnumber" placeholder="N/A" class="form-control here" type="text" value="${Userinfo.getCardNumber()}">
	                    </div>
					</div>
					<div class="form-group row">
						<label for="expire" class="col-4 col-form-label float-right">Expire Date</label> 
						<div class="col-8">
							<input id="expire" name="expire" placeholder="N/A" class="form-control here" required="required" type="text" value="${Userinfo.getExpire()}" readonly>
	                    </div>
					</div>
					<div class="form-group row">
					    <label for="projectsite" class="col-4 col-form-label float-right">Project Site</label>
					    <div class="col-8">
						    <select class="form-control here" id="projectsite" name="projectsite" multiple>
						      <c:forEach var="item" items="${ProjectSite}" varStatus="status">
						      	<option value="${item.getValue()}">${item.getName()}</option>
							  </c:forEach>
						    </select>
					    </div>
					</div>
	                <div class="form-group row">
						<div class="col-2">
							<button type="submit" class="btn btn-primary w-100">Update</button>
						</div>
						<div class="col-2">
							<button type="button" class="btn btn-secondary w-100" onClick="javascript:Extension(30)">Extension 30 day</button>
						</div>
						<div class="col-2">
							<button type="button" class="btn btn-secondary w-100" onClick="javascript:Extension(60)">Extension 60 day</button>
						</div>
						<div class="col-2">
							<button type="button" class="btn btn-secondary w-100" onClick="javascript:Extension(180)">Extension 180 day</button>
						</div>
						<c:set var = "used" value = "${Userinfo.getUsed()}"/>
						<c:if test = "${used != 1}">
							<div class="col-2">			         
						         <button type="button" class="btn btn-danger w-100" onClick="javascript:Enable()">Card Used</button>
							</div>
						</c:if>
						<c:if test = "${used == 1}">
							<div class="col-2">
								<button type="button" class="btn btn-danger w-100" onClick="javascript:Disable(0)">Card Return</button>
							</div>
							<div class="col-2">
								<button type="button" class="btn btn-danger w-100" onClick="javascript:Disable(2)">Card Loss</button>
							</div>
						</c:if>
					</div>
				</form>
			</div>
		</div>
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
		$('#camp').val("${Userinfo.getCamp()}");
		$('#company').val("${Userinfo.getCompany()}");
		$('#company_2').val("${Userinfo.getCompany_2()}");
		$('#position').val("${Userinfo.getPosition()}");
		$('#gender').val("${Userinfo.getGender()}");
		$('#national').val("${Userinfo.getNationality()}");
		
		
		var values = "";
		<c:forEach var="item" items="${Userinfo.getPermit()}" varStatus="status">
  			values += ${item};
  			values += ",";
  		</c:forEach>
		
	    options = Array.from(document.querySelectorAll('#projectsite option'));
		try{
			values.split(',').forEach(function(v) {
				  options.find(c => c.value == v).selected = true;
				});
		}catch(e){
			
		}
		
	});
	
	function submitCreate(){
		arr = []
		$('#projectsite option:selected').each(function(i, x){
			arr.push($(x).val());
		});
	    // process the form
	    $.ajax({
	        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	        url         : 'modifyuser', // the url where we want to POST
	        data        : {
	        	badge:$('#badge').val(),
	        	nationalid:$('#nationalid').val(),
	        	name:$('#username').val(),
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
        	   location.reload(true);
        	   
           }else{
        	   alert(data.Msg);
           }
	    })
	    .fail(function(data){
	    	alert("error");
	    });
	}
	
	function Extension(day){
		$.ajax({
	        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	        url         : 'extUser', // the url where we want to POST
	        data        : {
	        	badge:$('#badge').val(),
	        	days:day
	        }, // our data object
	        dataType    : 'json', // what type of data do we expect back from the server
	        encode      : true
	    })
	    // using the done promise callback
	    .done(function(data) {
           if(data.Code == 0){
        	   alert(data.Msg);
        	   location.reload(true);
           }else{
        	   alert(data.Msg);
           }
	    })
	    .fail(function(data){
	    	alert("error");
	    });
	}
	
	function Disable(reason){
		$.ajax({
	        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	        url         : 'disable', // the url where we want to POST
	        data        : {
	        	badge:$('#badge').val(),
	        	reason:reason
	        }, // our data object
	        dataType    : 'json', // what type of data do we expect back from the server
	        encode      : true
	    })
	    // using the done promise callback
	    .done(function(data) {
           if(data.Code == 0){
        	   alert(data.Msg);
        	   location.reload(true);
           }else{
        	   alert(data.Msg);
           }
	    })
	    .fail(function(data){
	    	alert("error");
	    });
	}
	
	function Enable(){
		$.ajax({
	        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	        url         : 'enable', // the url where we want to POST
	        data        : {
	        	badge:$('#badge').val(),
	        }, // our data object
	        dataType    : 'json', // what type of data do we expect back from the server
	        encode      : true
	    })
	    // using the done promise callback
	    .done(function(data) {
           if(data.Code == 0){
        	   alert(data.Msg);
        	   location.reload(true);
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

