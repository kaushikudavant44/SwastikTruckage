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

<c:url var="getVehicalOwner" value="/getVehicalOwner" />
<c:url var="getReturnLrDetails" value="/getReturnLrDetails" />
<c:url var="updateReturnLrDeliveryStatus" value="/updateReturnLrDeliveryStatus" />

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
	
					<div class="col-md-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong class="card-title">Show Return LR</strong>
						</div>
						<div class="card-body">
							<form action="#" method="post">
							<div class="col-xs-12 col-sm-12">
										<div class="row">
										
											<div class="col-md-4">Search By LR Number</div>
											<div class="col-md-4">
												<div class="input-group">
													<input type="text" id="lrNo" name="lrNo" value="" />
													
												</div>
											</div>
											
									
											<div class="col-md-4">
												<div class="input-group">
													<button type="button" id="addLr" value="" onclick="getReturnLrDetails()">ADD</button>
													
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
										<th>LR Date</th>
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
								<%-- <c:forEach items="${getAllDeliverLrDetailsList}" var="getAllDeliverLrDetailsList" varStatus="count">
								<tr id="${getAllDeliverLrDetailsList.lrHeaderId}">
								<td>${count.index+1}</td>
								<td>${getAllDeliverLrDetailsList.officeName}</td>
								<td>${getAllDeliverLrDetailsList.lrNo}</td>
								<td>${getAllDeliverLrDetailsList.lrDate}</td>
								<td>${getAllDeliverLrDetailsList.consignor}</td>
								<td>${getAllDeliverLrDetailsList.consignee}</td>
								<td>${getAllDeliverLrDetailsList.particular}</td>
								<td>${getAllDeliverLrDetailsList.quantity}</td>
								<td>${getAllDeliverLrDetailsList.amount}</td>
								<c:if test="${getAllDeliverLrDetailsList.paymentBy==0}">
								<td>To Be Bill</td>
								</c:if>
								<c:if test="${getAllDeliverLrDetailsList.paymentBy==1}">
								<td>To Pay</td>
								</c:if>
								<c:if test="${getAllDeliverLrDetailsList.paymentBy==2}">
								<td>Paid</td>
								</c:if>
								<td>
								<div class="fa-hover col-lg-3 col-md-6">
														<a
														style='cursor:pointer; color:blue;' onclick="deleteLr(${getAllDeliverLrDetailsList.lrHeaderId})"><i
														class="fa fa-trash-o"></i> <span class="text-muted"></span></a>
														
														</div>
								</td>
								</tr>
								
								</c:forEach> --%>
								</tbody>
							</table>
							<div class="col-lg-12" align="center">


									<button type="button" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;" onclick="updateLrReturnStatus()">
										Submit</button>
								</div>
							</form>
						</div>
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
	function getReturnLrDetails(){
				
		var lrNo=document.getElementById("lrNo").value;
		
		$.getJSON('${getReturnLrDetails}', {
			
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
							<c:if test="${operationOfAccessRight.mdelete==1}"> 
							tr.append($('<td></td>').html("<a style='cursor:pointer; color:blue;' onclick='deleteLr("+data.lrHeaderId+")'><i class='fa fa-trash-o'></i> </a>"));
							</c:if>
				
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


</script>

<script type="text/javascript">


function updateLrReturnStatus(){
	
	$.getJSON('${updateReturnLrDeliveryStatus}', {
		
		selectedLrHeaderId: JSON.stringify(selectedLrHeaderId),
		ajax : 'true'
		
	}, function(data) {
		
		
	});
	}
	



</script>

</body>
<div id="loader">
		</div>
</html>