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

</style>

<c:url var="removeOffice" value="/removeOffice" />

</head>
<body>


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
					<h1>Office Details</h1>
				</div>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="page-header float-right">
				<div class="page-title">
					<ol class="breadcrumb text-right">
						<li><a href="#">Add new Office</a></li>
						<li><a href="#">Office Details</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div> -->

	<div class="content mt-3">
		<div class="animated fadeIn">
			
			<div class="row">

				<div class="col-md-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong class="card-title">List Of Offices</strong>
							<c:choose>	
							<c:when test="${operationOfAccessRight.edit==1 }">
							<strong class="card-title"><a href="${pageContext.request.contextPath}/showOfficeReg" class="an-button">Add Office</a></strong>
							</c:when>
							<c:otherwise>
							
							</c:otherwise>
							</c:choose>
						</div>
						<div class="card-body">

							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Sr. No.</th>
										<th>Name</th>
										<th>Contact No</th>
										<th>Address</th>
										<th>Fax</th>
										<th>Action</th>

									</tr>
								</thead>
								<tbody>
								<c:forEach items="${officeList}" var="officeList" varStatus="count">
									<tr>
										<td>${count.index+1 }</td>
										<td>${officeList.officeName}</td>
										<td>${officeList.officeContactNo}</td>
										<td>${officeList.officeAddress}</td>
										<td>${officeList.faxNo}</td>
										<td>
										<div class="fa-hover col-lg-3 col-md-6">
										<c:choose>
										
										<c:when test="${operationOfAccessRight.edit==1}">
										
									
										
										<a
														href="${pageContext.request.contextPath}/editOfficeDetails/${officeList.officeId}"><i
														class="fa fa-edit"></i> <span class="text-muted"></span></a>
										</c:when>
										<c:otherwise>
										
										<a href="#"><i
														class="fa fa-ban"></i> <span class="text-muted"></span></a>
										</c:otherwise>
										</c:choose>		
										</div>
										<div class="fa-hover col-lg-3 col-md-6">
										<c:choose>	
										<c:when test="${operationOfAccessRight.mdelete==1}">
														
														<a
														href="#" onclick="deleteOffice(${officeList.officeId})"><i
														class="fa fa-trash-o"></i> <span class="text-muted"></span></a>
														
														
										</c:when>
										<c:otherwise>
										
										<a href="#"><i
														class="fa fa-ban"></i> <span class="text-muted"></span></a>
										</c:otherwise>
										
										</c:choose>
										</div>
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
function editOfficeDetails(officeId){
	
	window.open("${pageContext.request.contextPath}/editOfficeDetails?officeId="+officeId,"_self");
	
}

function deleteOffice(officeId){
	
	var result=confirm("Are you sure ?");
	//var officeId=document.getElementById("stateId").value;
	if(result==true){
	$.getJSON('${removeOffice}', {
		
		officeId : officeId,
		ajax : 'true'
		
	}, function(data) {
		
		if(data==1){
			
			location.reload();
			alert("Office delete successfully");
		}

	});
	}
	
}
</script>


</body>
</html>