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


<c:url var="memoReceived" value="/memoReceived" />
</head>
<body>


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
							<strong>Edit Memo</strong>
						</div>
						<div class="card-body card-block">
							
								<div class="row">
								
									<form action="getMemoReceived" method="post">
										<div class="col-xs-12 col-sm-12">
										<div class="row">
										
										<div class="col-md-4">Memo Number</div>
										<div class="col-md-4">
										<div class="input-group">
											<input type="text" id="memoNo" name="memoNo" value="${memoNo}"/>
										</div>
										</div>
										<div class="col-md-4">
										<div class="input-group">
										<input type="submit" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;" />
										</div>
										</div>
										
									</div>
								</div>
	</form>			</div>
	 							
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


<div class="row" style="padding-top: 20px; padding-bottom: 20px;">
									<br>
									<hr>
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											
										
										
											<div class="col-md-2"> <strong>From</strong></div>
											<div class="col-md-2">
											
											<input type="hidden" id="memoHeaderId" name="memoHeaderId" value="${getMemoDeatails.memoHeaderId}"/>
											
												<div class="input-group">
												
												${getMemoDeatails.fromOffice}
													
												</div>
											</div>
											<div class="col-md-2"><strong>To</strong></div>
											<div class="col-md-2">
											<div class="input-group">
												
												${getMemoDeatails.toOffice}
													
												</div>
											
											</div>
											
											
											<div class="col-md-2"><strong>Vehical No.:</strong></div>
											<div class="col-md-2">
												<div class="input-group">
													
													${getMemoDeatails.vehNo}
													
												</div>
											</div>
										</div>
									</div>

									<hr>
									<div class="col-xs-12 col-sm-12">
										<div class="row">
												<div class="col-md-2"><strong>Driver Name :</strong></div>
											<div class="col-md-2">
												<div class="input-group">
													
													${getMemoDeatails.driverName}
													
												</div>
											</div>
											
											<div class="col-md-2"><strong>License No:</strong></div>
											<div class="col-md-2">
												<div class="input-group">
													
													${getMemoDeatails.licenseNo}
													
												</div>
											</div>
											
											<div class="col-md-2"><strong>Owner Name :</strong></div>
											<div class="col-md-2">
												<div class="input-group">
													
													${getMemoDeatails.ownerName}
													
												</div>
											</div>
											
										</div>
									</div>


									
								</div>	


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
										<th>Payment By</th>
										

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
										style="align-content: center; width: 226px; margin-left: 80px;" onclick="receivedMemo()">
										Received</button>
								</div>
								</div>
								</div>
		</div>
		</div>
		<!-- .animated -->
	</div> 
	
	<!-- .content -->
<div class=" clearfix"></div>



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
    var unSelectedRowList=[];
    var selectedRowList =[];
    
    $(document).ready(function() {
    	
    	
    	
    	<c:forEach items="${lrDetailsList}" var="lrDetailsList">

    	var lrHeaderId = "<c:out value="${lrDetailsList.lrHeaderId}"/>";

    	selectedRowList.push(parseInt(lrHeaderId,10));

    	</c:forEach>
    		 	
    	if(selectedRowList!=null && selectedRowList!=""){
			$('#bootstrap-data-table1 tbody tr').addClass('selected');
			
		}

	    var table = $('#bootstrap-data-table1').DataTable();
	 
	    $('#bootstrap-data-table1 tbody').on( 'click', 'tr', function () {
	   	
	    	 if ( $(this).hasClass('selected') ) {
	    		 
	    		 
	    		 
	    		 var index=selectedRowList.indexOf($(this).data('value'));
	    		 
	    		
	    		 
	    		 if($.inArray($(this).data('value'), unSelectedRowList) === -1) unSelectedRowList.push($(this).data('value'));
	    	/* 	 unSelectedRowList.push($(this).data('value')); */
	    		 
	    		 if(index >-1){
	    			 
	    			 selectedRowList.splice(index,1);
	    			 unSelectedRowList.splice(index,1);
	    			 
	    		 }
	    		 
	    		 alert("Unselected"+JSON.stringify(unSelectedRowList));
	             $(this).removeClass('selected');
	            
					
	    	 }else{
	    		 /* selectedRowList.push($(this).data('value')); */
	    		 if($.inArray($(this).data('value'), selectedRowList) === -1) selectedRowList.push($(this).data('value'));
	            
	    		 $(this).addClass('selected');
	    		 
	    		 
	            
	            
	            
	    }
	      
	    } );
	 	  
	} );
	
    
    </script>
<script type="text/javascript">

	
	function receivedMemo(){
		
		 $('#loader').addClass("loader");
		$('#bgbdy').addClass("bg-body");
		
		var memoHeaderId=document.getElementById("memoHeaderId").value;
		
		
		$.getJSON('${memoReceived}', {
			
			memoHeaderId:memoHeaderId,	
			selectedRowList:JSON.stringify(selectedRowList),
			
			ajax : 'true'
			
		}, function(data) {
			alert(data.message);
			$('#loader').addClass("hide-loader");
			 $('#bgbdy').removeClass("bg-body");
			
			
			window.open("${pageContext.request.contextPath}/showMemoReceived",'_self');
		
		});
		
	} 
	
	</script>


</body>
<div id="bgbdy"></div>
<div id="loader">
</div>


</html>