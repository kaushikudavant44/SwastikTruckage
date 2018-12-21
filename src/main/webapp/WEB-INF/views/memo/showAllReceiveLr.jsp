<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Data Table</title>


<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/resources/apple-icon.png">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/favicon.ico">

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
	href="${pageContext.request.contextPath}/resources/assets/css/lib/datatable/dataTables.bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/scss/style.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

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

<c:url var="receivedLr" value="/receivedLr" />

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
						<li><a href="#">Lr Details</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="content mt-3">
		<div class="animated fadeIn">
			<div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Lr Details</strong>
						</div>
						<div class="card-body">

							<table id="bootstrap-data-table1"
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
										

									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lrDetailsList}" var="lrDetailsList" varStatus="count">
									<tr data-value="${lrDetailsList.lrHeaderId}">
										<td>${count.index+1 }</td>
										<td>${lrDetailsList.officeName}</td>
										<td>${lrDetailsList.lrNo}</td>
										<td>${lrDetailsList.lrDate}</td>
										<td>${lrDetailsList.consignor}</td>
										<td>${lrDetailsList.consignee}</td>
										<td>${lrDetailsList.particular}</td>
										<td>${lrDetailsList.quantity}</td>
										<td>${lrDetailsList.amount}</td>
										<%-- <td><div class="fa-hover col-lg-3 col-md-6">
										<a
														href="${pageContext.request.contextPath}/editLRDetails/${lrDetailsList.lrHeaderId}"><i
														class="fa fa-edit"></i> <span class="text-muted"></span></a></div>
														<div class="fa-hover col-lg-3 col-md-6">
														<a
														href="${pageContext.request.contextPath}/deleteLr/${lrDetailsList.lrHeaderId}"><i
														class="fa fa-trash-o"></i> <span class="text-muted"></span></a>
														
														</div>
										
										</td> --%>
										
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
										style="align-content: center; width: 226px; margin-left: 80px;" onclick="updateReceivedLr()">
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


	<script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table1').DataTable({
        	  columnDefs: [
      	        { targets: [1], className:"right" },
      	    ]
          });
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
	    		 alert(JSON.stringify(selectedRowList));

	            $(this).addClass('selected');
	    }
	      
	    } );
	 	  
	} );
	
	
	
	
function updateReceivedLr(){
		
			
		$('#loader').addClass("loader");
		$('#bgbdy').addClass("bg-body");
		$.getJSON('${receivedLr}', {
			
			selectedRowList:JSON.stringify(selectedRowList),
			
			ajax : 'true'
			
		}, function(data) {
			alert(data.message);
			location.reload();
			 $('#loader').addClass("hide-loader");
			 $('#bgbdy').removeClass("bg-body");
			
				
		
		});
		
	}
    </script>



</body>
<div id="loader">
		</div>
</html>