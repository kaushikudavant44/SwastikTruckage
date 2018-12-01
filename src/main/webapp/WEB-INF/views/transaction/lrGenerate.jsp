<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Generate LR</title>

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

<!-- <style type="text/css">
.right {
	text-align: right;
}

.left {
	text-align: left;
}
</style> -->


<c:url var="addContaint" value="/addContaint" />

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
						<li><a href="#">Office Details</a></li>

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
							<strong>Make LR</strong>
						</div>
						<div class="card-body card-block">
							<form action="${pageContext.request.contextPath}/insertOfficeStaff" method="post">
								<div class="row">
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">From</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="officeId" name="officeId" class="standardSelect" tabindex="1">
														<option value=""> </option>
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

											<div class="col-md-2">To:</div>
											<div class="col-md-3">
												<div class="input-group">

													<select id="officeId" name="officeId" class="standardSelect" tabindex="1">
														<option value=""></option>
													<c:forEach items="${officeList}" var="officeList">

															
																	<option value="${officeList.officeId}">${officeList.officeName}
																	</option>
													
														</c:forEach>
													</select>

												</div>
											</div>



											<div class="col-md-1">LR No.</div>
											<div class="col-md-1">

												<div class="input-group">
													<input class="form-control" name="staffName" id="staffName"
														type="text" required value="1"
														oninvalid="setCustomValidity('Please enter name ')"
														onchange="try{setCustomValidity('')}catch(e){}" /> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>
										</div>
									</div>
									
									&nbsp;
									
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">CONSIGNOR:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="officeId" name="clientId" class="standardSelect" tabindex="1">
														<option value=""></option>
													<c:forEach items="${clientList}" var="clientList">

															
																	<option value="${clientList.clientId}">${clientList.clientName}
																	</option>
																													</c:forEach>
													</select>
												</div>
											</div>

											<div class="col-md-2">DATE:</div>
											<div class="col-md-5">
												<div class="input-group">

													<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" id="datepicker">

												</div>
											</div>

										</div>
									</div>
									
									&nbsp;
									
									<hr>
									<div class="col-xs-12 col-sm-12">
										<div class="row">
										
											<div class="col-md-2">No. of Contains</div>
											<div class="col-md-1">
												<div class="input-group">
													
													<input class="form-control" name="noOfContaint" id="noOfContaint"
														type="number" required value="" /> <span
														class="error" aria-live="polite"></span>
												</div>
											</div>

											<div class="col-md-1">Goods:</div>
											<div class="col-md-3">
												<div class="input-group">

													<input class="form-control" name="goods" id="goods"
														type="text" /> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>
										
											<div class="col-md-1">Description</div>
											<div class="col-md-2">

												<div class="input-group">
													<textarea class="form-control" name="description" id="description"
														type="text" required value="1" row="2"></textarea> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>
											<div class="col-md-1"><input type="button" value="add" onclick="addContaints()"/></div>
										</div>
									</div>
									

								</div>

								&nbsp;
								<hr>
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered" >
									<thead>
										<tr>
											<th>Sr. No.</th>
											<th>No. of Contains</th>
											<th>Goods</th>
											<th>Description</th>
											<th>Action</th>
										</tr>
									</thead>
									<%-- <tbody>
										<c:forEach items="${staffList}" var="staffList" varStatus="count">
										<tr>
											<td>${count.index+1 }</td>
											<td></td>
											<td></td>
											<td></td>
											<td><div class="fa-hover col-lg-3 col-md-6">
													<a
														href="${pageContext.request.contextPath}/editStaffDetails"><i
														class="fa fa-edit"></i> <span class="text-muted"></span></a>
												</div>
												<div class="fa-hover col-lg-3 col-md-6">
													<a href="#" onclick="deleteStaff()"><i
														class="fa fa-trash-o"></i> <span class="text-muted"></span></a>

												</div></td>
										</tr>
										</c:forEach>


									</tbody> --%>
								</table>
								
								<div class="col-lg-12" align="center">


					<button type="submit" class="btn btn-primary"
						style="align-content: center; width: 226px; margin-left: 80px;">
						Submit</button>
				</div>
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
           $('#bootstrap-data-table-export').DataTable(); 


          $("#flowcheckall").click(function () {
              $('#bootstrap-data-table tbody input[type="checkbox"]').prop('checked', this.checked);
          });
          
        } );
    </script>


	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
  $( function() {
	  $('input[id$=datepicker]').datepicker({
		    dateFormat: 'dd-mm-yy',
		    maxDate: new Date()
		});
  } );
  </script>
	<script type="text/javascript">
function editOfficeDetails(officeId){
	
	window.open("${pageContext.request.contextPath}/editOfficeDetails?officeId="+officeId,"_self");
	
}

function deleteStaff(staffId){
	
	var result=confirm("Are you sure ?");
	//var officeId=document.getElementById("stateId").value;
	if(result==true){
	$.getJSON('${removeStaff}', {
		
		staffId : staffId,
		ajax : 'true'
		
	}, function(data) {
		
		if(data==1){
			
			location.reload();
			alert("Staff record delete successfully");
		}

	});
	}
	
}
</script>
<script type="text/javascript">
function addContaints(){
	var noOfContaint=document.getElementById("noOfContaint").value;
	var goods=document.getElementById("goods").value;
	var description=document.getElementById("description").value;
	 var dataTable = $('#bootstrap-data-table').DataTable();
	
$.getJSON('${addContaint}', {
		
	noOfContaint : noOfContaint,
		goods: goods,
		description: description,
		ajax : 'true'
		
	}, function(data) {
			dataTable.clear().draw();
		 $.each(
					data,
					function(key, transactionLrContaintDetailsList) {
						
						
		
			//var listContainers = [];
		//	listContainers=[transactionLrContaintDetailsList1.noContaints,transactionLrContaintDetailsList1.goods,transactionLrContaintDetailsList1.description];
			
			
			
			  dataTable.row.add(  [key+1 ,transactionLrContaintDetailsList.noOfContaints,  transactionLrContaintDetailsList.goods, transactionLrContaintDetailsList.description, transactionLrContaintDetailsList.noOfContaints ] ).draw();
			
					});
		

	});
	
	
  	

	
}
</script>
</body>
</html>