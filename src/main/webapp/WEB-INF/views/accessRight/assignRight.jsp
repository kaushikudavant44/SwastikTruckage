<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
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
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">

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

</head>
<body >

<c:url var="getAccessrightByStaffId" value="/getAccessrightByStaffId" />

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
						<li><a href="#">Table</a></li>
						<li class="active">Data table</li>
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
					<form action="${pageContext.request.contextPath}/submitAccessRight" method="post">
					
						<div class="card-header">
							<strong class="card-title">Data Table</strong>
						</div>
						<div class="row">
						<div class="col-md-2">
									 
									</div>
									<div class="col-md-2">
										Staff Office
									</div>
						<div class="col-md-4">
									<div class="input-group">
										<select id="staffOfficeId" name="staffOfficeId" class="standardSelect" tabindex="1" onchange="getAccessRight()" >
											<option value=""></option>

											<c:forEach items="${officeStaffList}" var="officeStaff">

												
													<option value="${officeStaff.staffId}">${officeStaff.staffName}
													</option>
												
												
											</c:forEach>
										</select>
										</div>
									</div>
									</div>
									
						<div class="card-body">

							<table id=" "
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Main Module</th>
										<th>Sub Module</th>
										<th>Add</th>
										<th >View</th>
										<th>Edit</th>
										<th >Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${navBarMainMenuList}" var="navBarMainMenu" varStatus="count">
									<tr>
									<c:set var="length" value="${fn:length(navBarMainMenu.navBarSubMainMenuList)}"/>
									<c:if test="${length==0}">
									<c:set var="length" value="1"/>
									</c:if>
										<td rowspan="${length}">${navBarMainMenu.menuName}</td>
										<!-- <td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										</tr> -->
									<c:forEach items="${navBarMainMenu.navBarSubMainMenuList}" var="navBarSubMainMenu" varStatus="count1">
								 <c:if test="${count1.index!=0}">
								 <tr>
								 </c:if>
									
							 
										<td>${navBarSubMainMenu.subMenuName}</td>
										<td><input type="checkbox" value="add" id="add${navBarSubMainMenu.subMenuId}" name="${navBarSubMainMenu.subMenuId}"></td>
										<td><input type="checkbox" value="view" id="view${navBarSubMainMenu.subMenuId}" name="${navBarSubMainMenu.subMenuId}"></td>
										<td><input type="checkbox" value="edit" id="edit${navBarSubMainMenu.subMenuId}" name="${navBarSubMainMenu.subMenuId}"></td>
										<td><input type="checkbox" value="delete" id="delete${navBarSubMainMenu.subMenuId}" name="${navBarSubMainMenu.subMenuId}"></td>
									</tr>
									</c:forEach> 
									</c:forEach>
 
								</tbody>
							</table>




							<!-- <table id="bootstrap-data-table1"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th width="25%">Product Name</th>
										<th width="12%" class="center">Order Qty</th>
									</tr>
								</thead>

							</table> -->
							<input type="submit" value="submit">
</form>

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

	<script type="text/javascript">
	
	
	jQuery(document).ready(function() {
		jQuery(".standardSelect").chosen({
			disable_search_threshold : 10,
			no_results_text : "Oops, nothing found!",
			width : "100%"
		});
	});
 


        $(document).ready(function() {
          $('#bootstrap-data-table1').DataTable({
        	  columnDefs: [
      	        { targets: [1], className:"right" },
      	    ]
          });
        } );
    </script>
    
	<script type="text/javascript"> 

	
	
	function getAccessRight(){
var staffOfficeId=document.getElementById("staffOfficeId").value;
$('input:checkbox').removeAttr('checked');
	$.getJSON('${getAccessrightByStaffId}', {
		
		staffOfficeId : staffOfficeId,
		ajax : 'true'
		
	}, function(data) {
		 
		
		 
		 $.each(
					data,
					function(key, list) {
						
						if(list.view==1)
							{
							document.getElementById("view"+list.subMenuId).checked=true;
							}
						

						if(list.edit==1)
							{
							document.getElementById("edit"+list.subMenuId).checked=true;
							}

						if(list.add==1)
							{
							document.getElementById("add"+list.subMenuId).checked=true;
							}

						if(list.mdelete==1)
							{
							document.getElementById("delete"+list.subMenuId).checked=true;
							}
					})
		
						

	});
	
	}

</script>

</body>
</html>