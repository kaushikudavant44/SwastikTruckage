<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
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
	href="${pageContext.request.contextPath}/resources/assets/scss/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>



</head>


<!-- Translate -->



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<!-- Translate -->
<!-- <script type="text/javascript"
	src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script> -->

<c:url var="getCityByStateId" value="/getCityByStateId" />
<div id="loader">
		</div>
<body id="bgbdy">


	<!-- Left Panel -->
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<!-- Left Panel -->


	<!-- Header-->
	<jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>
	<!-- Header-->



	<div class="content mt-3">
		<div class="animated fadeIn">

			<div class="row">

				<div class="col-xs-12 col-sm-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong>Update Staff Details</strong>
						</div>
						<div class="card-body card-block">
							<form action="${pageContext.request.contextPath}/insertOfficeStaff"
								method="post" id="submitStaff">
								<div class="row">
									<div class="col-md-2">
										Staff Name
									</div>
									<div class="col-md-4">
										<input type="hidden" value="${staffDetails.staffId}" name="staffId" id="staffId"/>
										<div class="input-group">
											<input class="form-control" name="staffName" id="staffName"
												type="text" required value="${staffDetails.staffName}"
												oninvalid="setCustomValidity('Please enter name ')"
												onchange="try{setCustomValidity('')}catch(e){}" /> <span
												class="error" aria-live="polite"></span>

										</div>
									</div>

									

									<div class="col-md-2">
										 contact
									</div>
									<div class="col-md-4">


										<div class="input-group">

											<input class="form-control" name="staffContactNo" id="staffContactNo"
												type="text" required
												oninvalid="setCustomValidity('Please enter name ')"
												onchange="try{setCustomValidity('')}catch(e){}" value="${staffDetails.staffContactNo}"/> <span
												class="error" aria-live="polite"></span>
										</div>
									</div>

								</div>
								&nbsp;
								<div class="row">
									<div class="col-md-2">
										Staff Office
									</div>
									<div class="col-md-4">
									<div class="input-group">
										<select id="staffOfficeId" name="staffOfficeId" class="standardSelect" tabindex="1" onchange="getCityList()">
											

											<c:forEach items="${officeList}" var="officeList">

												<c:choose>
												<c:when test="${officeList.officeId==staffDetails.staffOfficeId}">
													<option selected value="${officeList.officeId}">${officeList.officeName}
													</option>
													</c:when>
													<c:otherwise>
													<option value="${officeList.officeId}">${officeList.officeName}
													</option>
													</c:otherwise>
												</c:choose>
												
											</c:forEach>
										</select>
										</div>
									</div>

									<%-- <div class="col-md-2">
										Staff Role
									</div>
									<div class="col-md-4">
									<div class="input-group">
										<select id="roleId" name="roleId" class="standardSelect" tabindex="1">
										

											<c:forEach items="${roleList}" var="roleList">

												<c:choose>
												<c:when test="${roleList.roleId==staffDetails.roleId}">
													<option selected value="${roleList.roleId}">${roleList.roleName}
													</option>
													</c:when>
													<c:otherwise>
													<option value="${roleList.roleId}">${roleList.roleName}
													</option>
													</c:otherwise>
												</c:choose>
													
												
												
											</c:forEach> 
										</select>
									</div>
									</div> --%>
									<div class="col-md-2">
									Password
									</div>
									<div class="col-md-4">
										<div class="input-group">

											<input class="form-control" name="password" id="password" autocomplete="off"
												type="pincode" required value="${staffDetails.password}"
												oninvalid="setCustomValidity('Please enter password ')"
												onchange="try{setCustomValidity('')}catch(e){}" /> <span
												class="error" aria-live="polite"></span>
										</div>
									</div>
									
								</div>
								
							<%-- 	&nbsp;
								
								
								<div class="row">
									<div class="col-md-2">
										 Username
									</div>
									<div class="col-md-4">

										<div class="input-group">

											<input class="form-control" name="userName" id="userName"
												required value="${staffDetails.userName}"
												type="text" > <span class="error"
												aria-live="polite"></span>
										</div>
									</div>

									
								</div> --%>
								&nbsp;
								
								
								<div class="row">
									<div class="col-md-2">
										address
									</div>


									<div class="col-md-4">
						<textarea class="form-control" name="staffAddress" rows="2" id="staffAddress" autocomplete="off"
									 type="text" required >${staffDetails.staffAddress}</textarea> <span
												class="error" aria-live="polite"></span>


									</div>

									
								</div>
								&nbsp;
								<div class="col-lg-12" align="center">


									<button type="submit" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;">
										Submit
									</button>
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
				disable_search_threshold : 10,
				no_results_text : "Oops, nothing found!",
				width : "100%"
			});
		});
	</script>

<script type="text/javascript">
function getCityList(){
	
	
	var stateId=document.getElementById("stateId").value;
	
	$.getJSON('${getCityByStateId}', {
		
		stateId : stateId,
		ajax : 'true'
		
	}, function(data) {
		
		
		var html = '<option value="" disabled="disabled" selected >Choose City...</option>';
		
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			
			html += '<option value="' + data[i].cityId + '">'
					+ data[i].cityName + '</option>';
		} 
		html += '</option>';
		$('#cityId').html(html);
		
		$("#cityId").trigger("chosen:updated");

	});
	
}

$('#submitStaff').submit(function() {
	$('#loader').addClass("loader");
	$('#bgbdy').addClass("bg-body");
});



</script>

</body>
</html>