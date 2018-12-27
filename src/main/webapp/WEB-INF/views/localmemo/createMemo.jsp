<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Data Table</title>


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

<c:url var="getVehicalOwner" value="/getVehicalOwner" />
<c:url var="getLrDetails" value="/getLrDetails" />
<c:url var="saveDeliverMemoDetails" value="/saveDeliverMemoDetails" />

</head>
<body id="bgbdy">


	<!-- Left Panel -->
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<!-- Left Panel -->


	<!-- Header-->
	<jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>
	<!-- Header-->


	<div class="breadcrumbs">
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
	</div>

	<div class="content mt-3">
		<div class="animated fadeIn">
		
			<div class="row">

				<div class="col-xs-12 col-sm-12">
					<div class="card">
						<div class="card-header">
							<strong>Create Deliver Memo</strong>
						</div>
						<div class="card-body card-block">
							<form action=""
								method="post">
								<div class="row">
									
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											

											<div class="col-md-2">Vehical No.:</div>
											<div class="col-md-2">
												<div class="input-group">
													<select id="vehId" name="vehId"
														class="standardSelect" tabindex="1"
														onchange="getVehicalOwner()">
													
														<option value=""></option>
													<c:forEach items="${vehicalDetailsList}" var="vehicalDetailsList">
														<option value="${vehicalDetailsList.vehId}">${vehicalDetailsList.vehNo}</option>
													</c:forEach>	


													</select> <a href="${pageContext.request.contextPath}/showVehicleReg"><span
														style="color: blue">If Vehical not found?</span></a>
												</div>
											</div>

											
											<div class="col-md-2">Driver:</div>
											<div class="col-md-2">
												<div class="input-group">
													<select id="driverId" name="driverId"
														class="standardSelect" tabindex="1"
														onchange="getVehicalOwner()">
													
														<option value=""></option>
													<c:forEach items="${vehicleDriverList}" var="vehicleDriverList">
														<option value="${vehicleDriverList.driverId}">${vehicleDriverList.driverName}</option>
													</c:forEach>	


													</select> <a href="${pageContext.request.contextPath}/showVehicleDriverReg"><span
														style="color: blue">If driver not found?</span></a>
												</div>
											</div>
											
											<div class="col-md-1">DATE:</div>
											<div class="col-md-3">
												<div class="input-group">

													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input type="text" id="datepicker" name="lrDate" autocomplete="off"
														required="required">

												</div>
											</div>
										</div>
									</div>
									
									<div class="col-xs-12 col-sm-12">
										<div class="row">
										
											<div class="col-md-2">Vehical Owner:</div>
											<div class="col-md-2">
												<div class="input-group">
													<input type="text" id="vehicalOwner" value="" disabled/>
													
												</div>
											</div>
											
											<div class="col-md-2">Contact Number:</div>
											<div class="col-md-2">
												<div class="input-group">
													<input type="text" id="contactNo" value="" disabled/>
													
												</div>
											</div>
											<div class="col-md-1">PAN No:</div>
											<div class="col-md-3">
												<div class="input-group">
													<input type="text" id="panNo" value="" disabled/>
													
												</div>
											</div>
											
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
						
							<div class="col-xs-12 col-sm-12">
										<div class="row">
										
											<div class="col-md-4">Search By Lr Number</div>
											<div class="col-md-4">
												<div class="input-group">
													<input type="text" id="lrNo" name="lrNo" value="" />
													
												</div>
											</div>
											
									
											<div class="col-md-4">
												<div class="input-group">
													<button type="button" id="addLr" value="" onclick="getReceivedLrDetails()">ADD</button>
													
												</div>
											</div>
											
										</div>
										</div>
						
								&nbsp;
							<table  id="lrTable"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										
										<th>Sr. No.</th>
										<th>Office Name</th>
										<th>LR Number</th>
										<th>Lr Date</th>
										<th>Consignor</th>
										<th>Consignee</th>
										<th>Particular</th>
										<th>Quantity</th>
										<th>Total Amount</th>
										<th>Payment By</th>
										<th>Action</th>
										

									</tr>
								</thead>
								<tbody>
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

									<button type="button" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;" onclick="saveDeliverMemoDetails()">
										Submit</button>
								</div></div></div>
		</div>
		</div>
		<!-- .animated -->
	</div>
	<!-- .content -->





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
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
  $('input[id$=datepicker]').datepicker({
     
      "dateFormat": 'dd-mm-yy',
		
	    "maxDate": new Date(),
      "autoclose": true
});
  
  $( "#datepicker" ).datepicker({dateFormat:"yy/mm/dd"}).datepicker("setDate",new Date());
  </script>

	<script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table1').DataTable();
        } );
    </script>
<script type="text/javascript">
	var selectedLrHeaderId=[];
	var srNo=0;
	function getReceivedLrDetails(){
				
		var lrNo=document.getElementById("lrNo").value;
		
		$.getJSON('${getLrDetails}', {
			
			lrNo: lrNo,
			ajax : 'true'
			
		}, function(data) {
			
			
			selectedLrHeaderId.push(data.lrHeaderId);
			
							srNo++;
							var tr = $('<tr id="'+data.lrHeaderId+'"></tr>');
							tr.append($('<td></td>').html(srNo));
							tr.append($('<td></td>').html(data.officeName));
							tr.append($('<td></td>').html(data.lrNo));
							tr.append($('<td></td>').html(data.lrDate));
							tr.append($('<td></td>').html(data.consignor));
							tr.append($('<td></td>').html(data.consignee));
							tr.append($('<td></td>').html(data.particular));
							tr.append($('<td></td>').html(data.quantity));
							tr.append($('<td></td>').html(data.amount));
							if(data.paymentBy==0){
							tr.append($('<td></td>').html("To Be bill"));
							}else if(data.paymentBy==1){
								tr.append($('<td></td>').html("To Pay"));
							}else{
								tr.append($('<td></td>').html("Paid"));
							}
							tr.append($('<td></td>').html("<a style='cursor:pointer; color:blue;' onclick='deleteLr("+data.lrHeaderId+")'><i class='fa fa-trash-o'></i> </a>"));
						
				
							$('#lrTable tbody').append(tr);
						
				
						});			
			 
			
		
		
	}
	
	
	function deleteLr(lrHeaderId){
		
		 var index=selectedLrHeaderId.indexOf(lrHeaderId);
		
		 if(index >-1){
			 
			 $('#'+lrHeaderId).remove();
			 selectedLrHeaderId.splice(index,1);
			
			
		 }
		 alert(JSON.stringify(selectedLrHeaderId));
	}
	
	
</script>

<script type="text/javascript">

function getVehicalOwner(){
	
	var vehId=document.getElementById("vehId").value;
	
	
	$.getJSON('${getVehicalOwner}', {
		
		vehId: vehId,
		ajax : 'true'
		
	}, function(data) {
		
		
		document.getElementById("vehicalOwner").value=data.ownerName;
		document.getElementById("contactNo").value=data.ownerContactNo;
		document.getElementById("panNo").value=data.panNo;
	});
}



function saveDeliverMemoDetails(){
	
	
	var memoDate=document.getElementById("datepicker").value;
	var vehId=document.getElementById("vehId").value;
	var driverId=document.getElementById("driverId").value;
	$('#loader').addClass("loader");
	$('#bgbdy').addClass("bg-body");
	$.getJSON('${saveDeliverMemoDetails}', {
		
		driverId:driverId,
		vehId:vehId,
		memoDate:memoDate,
		selectedLrHeaderId:JSON.stringify(selectedLrHeaderId),
		ajax : 'true'
		
	}, function(data) {
		
		
		alert(data.message);
		 $('#loader').addClass("hide-loader");
		 $('#bgbdy').removeClass("bg-body");
		
	});
}
</script>

</body>
<div id="loader">
		</div>
</html>