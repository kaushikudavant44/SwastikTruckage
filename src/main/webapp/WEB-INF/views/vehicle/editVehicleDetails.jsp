<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html>
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Sufee Admin - HTML5 Admin Template</title>
<meta name="description" content="Sufee Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="apple-icon.png">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/favicon.ico">


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
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>



<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->




</head>
<body>
	

	<div><jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>



		<div id="right-panel" class="right-panel">


			<div><jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>

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
									<li><a href="#">Add New Client</a></li>

								</ol>
							</div>
						</div>
					</div>
				</div>


				 <div class="content mt-3">
					<div class="row"> 


				<div class="content mt-3">
					<div class="animated fadeIn">

						<div class="row">

							<div class="col-xs-12 col-sm-12">
								<div class="cardview">
									<div class="cardview-header">
										<strong>Edit Vehicle Details</strong>
									</div>
									<div class="card-body card-block">
<form action="${pageContext.request.contextPath}/insertVehicleInfo" method="POST">
						<input type="hidden" name="vehicleId" value="${vehicleDetails.vehId}">
						<div class="card-body">
							<div class="row">
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Vehicle No</label>
										<input required name="vehicleNo" class="form-control" value="${vehicleDetails.vehNo}">							
							</div>							
							</div>
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Select Owner</label>
								
							<select required data-placeholder="Choose a Owner..."
								class="standardSelect form-control" tabindex="1" id="ownerId" name="ownerId">
								<option>--select--</option>
                             
								<c:forEach items="${vehicleOwners}" var = "vehicleOwners">
									   <c:choose>
                                            <c:when test = "${vehicleOwners.ownerId==vehicleDetails.ownerId}">
                                                <option selected  value ="${vehicleOwners.ownerId}">${vehicleOwners.ownerName }</option>
                                            </c:when>
                                            <c:otherwise>
                 				                 <option  value ="${vehicleOwners.ownerId}">${vehicleOwners.ownerName }</option>
                                            </c:otherwise>
                                       </c:choose>
				                     </c:forEach>
							</select>
						
							</div>
							
							</div>
							
							
							
							<br>
							<br>
							<div class="clearfix"></div>
							<hr>
                		<br>
							<hr>
                		<div class="col-sm-12 text-center">
							
<button type="submit" class="btn btn-primary" >
										Submit
									</button>							
							</div>
							</div>
							</div>
							</form>
									</div>
								</div>
								<div class="col-lg-3"></div>




							</div>
						</div>
					</div>


					<div align="center"><jsp:include
							page="/WEB-INF/views/common/footer.jsp"></jsp:include>

					</div>
					<!-- .content -->
				</div>
				</div>
				</div>
				</div>
				</div>
				</div>
			
				
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
							disable_search_threshold : 2,
							no_results_text : "Oops, nothing found!",
							width : "100%"
						});
					});
				</script>


				


</body>

</html>
