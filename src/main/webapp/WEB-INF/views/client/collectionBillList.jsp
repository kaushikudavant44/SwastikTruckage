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

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Data Table</strong>
						</div>
						<div class="card-body">
<form action="${pageContext.request.contextPath}/showGeneratedCollectionBills" method="GET" >
        <div class="row">
             <div class="col-sm-6 col-md-1">
             
             <label>From Date</label>
             
             </div>
              <div class="col-sm-6 col-md-2">
<input type="text" id="datepicker" name="from" value="${from}" class="form-control form-control-sm datepicker" readonly>
              
              </div>
              <div class="col-sm-6 col-md-1">
             
             <label>To Date</label>
             
             </div>
             <div class="col-sm-6 col-md-2">
             
             <input type="text" id="datepicker1" name="to" value="${to}" class="form-control form-control-sm datepicker" readonly>
             </div>
             
             <div class="col-sm-6 col-md-3">
							
             <button type="submit" class="btn btn-primary" >
				Generate
			 </button>							
							</div>
							</div>
            </form>
            
            <br>
							<table id=""
								class="table table-striped table-bordered">
								<thead>
									<tr>
									    <th>Sr No</th>
										<th>Bill Date</th>
										<th>Payment Mode</th>
										<th>transaction Id</th>
										<th >Total</th>
										<th >Details</th>

									</tr>
								</thead>
								<tbody>
								<c:forEach items="${collectionBills}" var="collectionBills" varStatus="myIndex">
									
                                 <tr>
                                <td>${myIndex.index+1}</td>
						        <td>${collectionBills.createDate}</td>
						   
						<c:choose>
                            <c:when test="${collectionBills.paymentMode==0}">                              
  							<td>Cash</td>  							
  							</c:when>
  							
  							<c:when test="${collectionBills.paymentMode==1}">                            
  							<td>Check</td>  							
  							</c:when>
  							
  							<c:when test="${collectionBills.paymentMode==2}">                            
  							<td>NEFT</td>  							
  							</c:when>
  						</c:choose>
  							
							<td>${collectionBills.trId}</td>
							<td>${collectionBills.total}</td>
										
							<td> <button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/getBillDetailsOfCollection/${collectionBills.lrHeaderId}/${collectionBills.collectionId}">
										Details</a>
									</button></td>			
					            </tr>
									
									</c:forEach>
								</tbody>
							</table>


							
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
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  $( function() {
	    $( "#datepicker1" ).datepicker();
	  } );
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