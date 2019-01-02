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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
	

<style type="text/css">
.right {
	text-align: right;
}

.left {
	text-align: left;
}
</style>



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
						<li><a href="#">Bill Detaila</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div>
	

	<div class="content mt-3">
		<div class="animated fadeIn">
		
		
		
				<div class="row">

				<div class="col-xs-12 col-sm-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong>Search LR DateWise</strong>
						</div>
						<div class="card-body card-block">
					
					<form action="${pageContext.request.contextPath}/getDataLrListByDateAndVehicleWise" method="GET">
        <div class="row">
             <div class="col-sm-6 col-md-1">          
                  <label>From Date </label>
             </div>
             
             <div class="col-sm-6 col-md-2">
              <input type="text" id="datepicker" name="from" value="${from}" class="form-control form-control-sm datepicker" >             
             </div>
              <div class="col-sm-6 col-md-1">
             </div>
              <div class="col-sm-6 col-md-1">  
             <label>To Date </label>
             </div>
             
              <div class="col-sm-6 col-md-2">
          <input type="text" id="datepicker1" name="to" value="${to}" class="form-control form-control-sm datepicker" >
            
             </div>
             <div class="col-sm-6 col-md-1">
              <label>Vehicle Number</label>
             </div>
              <div class="col-sm-6 col-md-2">
              
              			<select id="vehNo" name="vehNo" class="standardSelect"
													 required="required">
														<option value=""></option>
															<c:forEach items="${vehicleDetailsList}" var="vehicleDetailsList">

															<c:choose>
																<c:when
																	test="${vehicleDetailsList.vehNo==vehicleDetailsList.vehNo}">
																		<option selected value="${vehicleDetailsList.vehNo}">${vehicleDetailsList.vehNo}</option>
																	
																</c:when>
																<c:otherwise>
																	<option value="${vehicleDetailsList.vehNo}">${vehicleDetailsList.vehNo}</option>
																	
																</c:otherwise>
															</c:choose>

														</c:forEach>
													</select>
              	
        				
            
             </div>
             
             
             <div class="col-sm-6 col-md-3">
							
             <button type="submit" class="btn btn-primary" >
				Generate
			 </button>							
							</div>
							</div>
            </form>
					
					
						</div>


					</div>




				</div>

			</div>
		
		
		
		
		
		
		
		
		
		
		<!-- Devide -->
		
		
			<div class="row">

				<div class="col-md-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong class="card-title">Data Table</strong>
						</div>
						<div class="card-body">

            <div class="row">
             <div class="col-sm-6 col-md-6">          
                  <label>Total Collection : </label>${totalLr}
             </div>
              <div class="col-sm-6 col-md-6">          
                  <label>Total Bill : </label>${totalBill}
             </div>
             </div>
							<table id="bootstrap-data-table1"
								class="table table-striped table-bordered">
								<thead>
									<tr>
									    <th>LR No</th>
										<th>LR Date</th>
										<th>Payment By</th>
										<th >Total</th>
									
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lrList}" var="lrList" varStatus="count">
									
						<tr>
						
						    <td>${lrList.lrNo}</td>
							<td>${lrList.lrDate}</td>
							
										 <c:choose>
                              <c:when test="${lrList.paymentBy==0}">
                              
  							<td>To Be Bill</td>
  							
  							</c:when>
  							<c:when test="${lrList.paymentBy==1}">
                              
  							<td>To Pay</td>
  							
  							</c:when>
  							<c:when test="${lrList.paymentBy==2}">
                              
  							<td>Paid</td>
  							
  							</c:when>
  							
  							</c:choose>
										
							<td>${lrList.total}</td>
										
					   </tr>
									
									</c:forEach>
								</tbody>
							</table>

<div class="col-sm-12 text-center">

													<button type="button" class="btn btn-primary" style="color:white;">
														 <a href="${pageContext.request.contextPath}/showExcel/5" style="color:white;">excel</a></button>
												</div>
							
						</div>
						
					</div>
				</div>


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
		$(function() {
			$('input[id$=datepicker]').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
		
		$(function() {
			$('input[id$=datepicker1]').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
		
	</script>
	


	<script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table1').DataTable({
        	  columnDefs: [
      	        { targets: [1], className:"right" },
      	    ]
          });
        } );
    </script>
 
   


</body>
</html>




