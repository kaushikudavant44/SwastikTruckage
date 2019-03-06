<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Swastik Truckage</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">
<link rel="apple-touch-icon" href="apple-icon.png">
<link rel="shortcut icon" href="favicon.ico">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/normalize.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/flag-icon.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/cs-skin-elastic.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/scss/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>
	
	<%-- <link
	href="${pageContext.request.contextPath}/resources/assets/css/style.css"
	rel='stylesheet' type='text/css'> --%>

<style type="text/css">
.right {
	text-align: right;
}

.left {
	text-align: left;
}

 table.dataTable tbody tr.selected {
        color: white !important;
        background-color: #5172a0 !important;  /* Not working */
    }
</style>

<c:url var="getVehicalOwnerDetails" value="/getVehicalOwnerDetails" />
<c:url var="saveMemoDetails" value="/saveMemoDetails" />
</head>
<body id="bgbdy">


	<!-- Left Panel -->
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<!-- Left Panel -->


	<!-- Header-->
	<jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>
	<!-- Header-->


	<!-- <div class="breadcrumbs">
		<div class="col-sm-4">
			<div class="page-header float-left">
				<div class="page-title">
					<h1>Dashboard</h1>
				</div>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="page-header float-right">
				<div class="page-title">
					<ol class="breadcrumb text-right">
						<li><a href="#">Dashboard</a></li>
						<li><a href="#">Memo Details</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div> -->

	<div class="content mt-3">
		<div class="animated fadeIn">
		
			<div class="row">

				<div class="col-xs-12 col-sm-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong>Create Memo</strong>
						</div>
						<div class="card-body card-block">
							<form action=""
								method="post">
								<div class="row">
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">From</div>
											<div class="col-md-3">
											<input type="hidden" id="staffId" name="staffId" value="${staffDetails.staffId}" />
												<div class="input-group">
													<select id="fromId" name="fromId" class="standardSelect"
														tabindex="1" required="required">
														<option value=""></option>
														<c:forEach items="${officeList}" var="officeList">

															<c:choose>
																<c:when
																	test="${officeList.officeId==staffDetails.staffOfficeId}">
																	<option selected value="${officeList.officeId}">${officeList.officeName}
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${officeList.officeId}" disabled>${officeList.officeName}
																	</option>
																</c:otherwise>
															</c:choose>

														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="col-md-2">To</div>
											<div class="col-md-3">
											<input type="hidden" id="staffId" name="staffId" value="${staffDetails.staffId}" />
												<div class="input-group">
													<select id="toId" name="toId" class="standardSelect"
														tabindex="1" required="required">
														<option value=""></option>
														<c:forEach items="${officeList}" var="officeList">

															<c:choose>
																<c:when
																	test="${officeList.officeId==staffDetails.staffOfficeId}">
																	<option disabled value="${officeList.officeId}">${officeList.officeName}
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${officeList.officeId}">${officeList.officeName}
																	</option>
																</c:otherwise>
															</c:choose>

														</c:forEach>
													</select>
												</div>
											</div>
											
											
											
											

											<div class="col-md-2"></div>

											
										</div>
									</div>

									&nbsp;
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											

											<div class="col-md-2">Vehical No.:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="ownerId" name="ownerId"
														class="standardSelect" tabindex="1"
														onchange="getVehicalOwner()">
													
														<option value=""></option>
													<c:forEach items="${vehicalDetailsList}" var="vehicalDetailsList">
														<option value="${vehicalDetailsList.ownerId}">${vehicalDetailsList.vehNo}</option>
													</c:forEach>	


													</select> <a href="${pageContext.request.contextPath}/showVehicleReg"><span
														style="color: blue">If Vehical not found?</span></a>
												</div>
											</div>

											
											<div class="col-md-2">Driver:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="driverId" name="driverId"
														class="standardSelect" tabindex="1"
														onchange="getVehicalOwner()">
													
														<option value=""></option>
													<c:forEach items="${vehicleDriverList}" var="vehicleDriverList">
														<option value="${vehicleDriverList.driverId}">${vehicleDriverList.driverName}</option>
													</c:forEach>	


													</select> <a href="${pageContext.request.contextPath}/showVehicleDriverReg" onclick="openModel()"><span
														style="color: blue">If driver not found?</span></a>
												</div>
											</div>
											
											<div class="col-md-2"></div>
										</div>
									</div>
									
									<div class="col-xs-12 col-sm-12">
										<div class="row">
										
											<div class="col-md-2">Vehical Owner:</div>
											<div class="col-md-3">
												<div class="input-group">
													<input type="text" id="vehicalOwner" value=""  disabled/>
													
												</div>
											</div>
											<div  class="col-md-7"></div>
										</div>
										</div>

									
								</div>							
							</form>
						</div>


					</div>




				</div>

			</div>
		
		
		
			<div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Memo Details</strong>
						</div>
						<div class="card-body">

							<table id="bootstrap-data-table1"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										
										<th>Sr. No.</th>
										<th>Office Name</th>
										<th>LR Number</th>
										<th>Invoice Number</th>
										<th>LR Date</th>
										<th>Consignor</th>
										<th>Consignee</th>
										<th>Particular</th>
										<th>Quantity</th>
										<th>Total Amount</th>
										<th>Payment By</th>
										

									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lrDetailsList}" var="lrDetailsList" varStatus="count">
									<tr data-value="${lrDetailsList.lrHeaderId}">
										
										<td>${count.index+1 }</td>
										<td>${lrDetailsList.officeName}</td>
										<td><strong>${lrDetailsList.lrNo}</strong></td>
											<td>${lrDetailsList.invNo}</td>
										<td>${lrDetailsList.lrDate}</td>
										<td>${lrDetailsList.consignor}</td>
										<td>${lrDetailsList.consignee}</td>
										<td>${lrDetailsList.particular}</td>
										<td>${lrDetailsList.quantity}</td>
										<td>${lrDetailsList.amount}</td>
										<td>
										<c:choose>
										
										<c:when test="${lrDetailsList.paymentBy==0}">
										To Be bill
										</c:when>
										<c:otherwise>
										To pay
										</c:otherwise>
										</c:choose>
										
										</td>
										
										<%-- <td><input type="button" value="edit" onclick="editOfficeDetails()"/><input type="button" value="delete" onclick="deleteOffice(${officeList.officeId})"/></td> --%>
									</tr>
								</c:forEach>


								</tbody>
							</table>

						</div>
					</div>
				</div>


			</div>
			<div class="row">
			<div class="col-lg-12" align="center">
			<div class="card">
						<div class="card-header">

									<button type="submit" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;" onclick="saveMemoDetails()">
										Submit</button>
								</div></div></div>
		</div>
		</div>
		<!-- .animated -->
	</div>
	<!-- .content -->


<div id="id01" class="w3-modal">
	<div class="w3-modal-content w3-card-4">
		<!-- <header class="w3-container w3-teal"> 
        
        <h2>Modal Header</h2>
      </header> -->
		<%-- <div class="row">

			<div class="col-xs-12 col-sm-12">
				<div class="cardview">
					<div class="cardview-header">
						<strong>Add New Client</strong> <span
							onclick="document.getElementById('id01').style.display='none'"
							class="w3-button w3-display-topright">&times;</span>
					</div>
					<div class="card-body card-block">

						<form action="#">

							<div class="row">
								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">Full Name</label> <input
											required name="name" id="name" class="form-control"
											style="text-transform: uppercase;" onblur="nameValidation()">
									</div>
									<p id="validationMsg" style="position: absolute; color: red;"></p>
								</div>

								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">Contact No</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-phone"></i>
											</div>
											<input class="form-control" name="contactNo" id="contactNo">
										</div>
									</div>
								</div>

								<div class="col-sm-6 col-md-6">

									<label class=" form-control-label">Select State</label> <select
										data-placeholder="Choose a state" class="standardSelect"
										id="stateId" name="stateId" onchange=getCityList()>

										<option value=""></option>

										<c:forEach items="${stateList}" var="state">

											<option value="${state.stateId}">${state.stateName}
											</option>

										</c:forEach>
									</select>



								</div>

								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">Select City</label> <select
											required class="standardSelect form-control" id="cityId"
											name="cityId">
											<option value=""></option>
										</select>
									</div>
								</div>

								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">Address</label>
										<textarea required class="form-control" name="address"
											id="address"></textarea>
									</div>
								</div>

								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">Bill Name</label> <input
											class="form-control" name="billName" id="billName"
											style="text-transform: uppercase;">
									</div>
								</div>

								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">Pincode</label> <input
											class="form-control" id="pincode" name="pincode">
									</div>
								</div>

								<div class="col-sm-6 col-md-6">
									<div class="form-group">
										<label class=" form-control-label">GST</label> <input
											name="gst" id="gst1" class="gstinnumber">
									</div>
								</div>



								<br> <br>
								<div class="clearfix"></div>
								<br>
								<hr>
								<div class="col-sm-12 text-center">

									<button type="button" class="btn btn-primary"
										onclick="saveClientDetails()">Submit</button>
								</div>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div> --%>

	</div>
</div>



	<!-- Footer -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- Footer -->





	<script
		src="${pageContext.request.contextPath}/resources/assets/js/vendor/jquery-2.1.4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/datatables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/jszip.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/pdfmake.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/vfs_fonts.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/buttons.html5.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/buttons.print.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/buttons.colVis.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/data-table/datatables-init.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/chosen/chosen.jquery.min.js"></script>


	<script>
        jQuery(document).ready(function() {
            jQuery(".standardSelect").chosen({
                disable_search_threshold: 3,
                no_results_text: "Oops, nothing found!",
                width: "100%"
            });
        });
    </script>

	<script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table1').DataTable();
        } );
    </script>
<script type="text/javascript">

	var selectedRowList =[];
	$(document).ready(function() {
	    var table = $('#bootstrap-data-table1').DataTable();
	 
	    $('#bootstrap-data-table1 tbody').on( 'click', 'tr', function () {
	   	
	    	 if ( $(this).hasClass('selected') ) {
	    		 
	    		 var index=selectedRowList.indexOf( $(this).data('value'));
	    		 
	    		 if(index >-1){
	    			 
	    			 selectedRowList.splice(index,1);
	    			 
	    		 }
	    		 
	    		
	             $(this).removeClass('selected');
					
	    	 }else{
	    		 selectedRowList.push($(this).data('value'));
	    		 

	            $(this).addClass('selected');
	    }
	      
	    } );
	 	  
	} );
	
	
	function saveMemoDetails(){
		
		var officeId=document.getElementById("fromId").value;
		
		var toId=document.getElementById("toId").value;
		
		var ownerId=$("#ownerId option:selected").html();
		
		var driverId=document.getElementById("driverId").value;
		
		var staffId=document.getElementById("staffId").value;
		
		$('#loader').addClass("loader");
		$('#bgbdy').addClass("bg-body");
		$.getJSON('${saveMemoDetails}', {
			
			
			officeId:officeId,
			ownerId: ownerId,
			driverId:driverId,
			staffId:staffId,
			toId:toId,
			selectedRowList:JSON.stringify(selectedRowList),
			
			ajax : 'true'
			
		}, function(data) {
			
			location.reload();
			window.open("${pageContext.request.contextPath}/memoPreview/"+data.message,'_self')
			
			 $('#loader').addClass("hide-loader");
			 $('#bgbdy').removeClass("bg-body");
			
				
		
		});
		
	}
	
	</script>
<script type="text/javascript">

function getVehicalOwner(){
	
	var ownerId=document.getElementById("ownerId").value;
	
	
	$.getJSON('${getVehicalOwnerDetails}', {
		
		ownerId: ownerId,
		ajax : 'true'
		
	}, function(data) {
		
		
		document.getElementById("vehicalOwner").value=data.ownerName;
	});
}



var flag;
function openModel(type){
	
	flag=type;
document.getElementById('id01').style.display='block'

}

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>

</body>
<div id="loader">
		</div>
</html>