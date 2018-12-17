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
<link
	href="${pageContext.request.contextPath}/resources/assets/css/lib/vector-map/jqvmap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">



<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>
<body>
	<c:url var="getCityByStateId" value="/getCityByStateId" />
	<c:url var="clientNameValidation" value="/clientNameValidation" />

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

					<div class="form-group ">
						<div class="col-lg-5"></div>
						<div class="col-lg-5">
							<p
								style="position: absolute; color: black; background-color: #9bf79b; border-radius: 3px;"
								id="messageAnimation">${message}</p>
						</div>
					</div>
					<br>
					<div class="row">


						<div class="col-lg-3"></div>

						<div class="col-lg-6">
							<form
								action="${pageContext.request.contextPath}/insertClientInfo"
								method="POST">
								<div class="card">
									<div class="card-header">
										<h4>Client Registration</h4>
									</div>
									<div class="card-body">
										<div class="row">
											<div class="col-sm-6 col-md-6">
												<div class="form-group">
													<label class=" form-control-label">Full Name</label> <input
														required name="name" id="name" class="form-control"
														onblur="nameValidation()">
												</div>
												<p id="validationMsg"
													style="position: absolute; color: red;"></p>
											</div>

											<div class="col-sm-6 col-md-6">
												<div class="form-group">
													<label class=" form-control-label">Contact No</label>
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-phone"></i>
														</div>
														<input required class="form-control" name="contactNo">
													</div>
												</div>
											</div>

											<div class="col-sm-6 col-md-6">
												<div class="form-group">
													<label class=" form-control-label">Select State</label> <select
														required class="standardSelect" tabindex="1" id="stateId"
														name="stateId" onchange="getCityList()">
														<option>--select--</option>

														<c:forEach items="${stateList}" var="stateList"
															varStatus="count">
															<option value="${stateList.stateId}"><c:out
																	value="${stateList.stateName}" /></option>
														</c:forEach>
													</select>

												</div>

											</div>

											<div class="col-sm-6 col-md-6">
												<div class="form-group">
													<label class=" form-control-label">Select City</label> <select
														required class="standardSelect form-control" tabindex="1"
														id="cityId" name="cityId">

													</select>
												</div>
											</div>

											<div class="col-sm-12 col-md-12">
												<div class="form-group">
													<label class=" form-control-label">Address</label>
													<textarea required class="form-control" name="address"></textarea>
												</div>
											</div>

											<div class="col-sm-6 col-md-6">
												<div class="form-group">
													<label class=" form-control-label">Pincode</label> <input
														required class="form-control" name="pincode">
												</div>
											</div>
											<div class="col-sm-6 col-md-6">
												<div class="form-group">
													<label class=" form-control-label">GST</label> <input
														required class="form-control" name="gst">
												</div>
											</div>



											<br> <br>
											<div class="clearfix"></div>
											<br>
											<hr>
											<div class="col-sm-12 text-center">

												<button type="submit" class="btn btn-primary">
													Submit</button>
											</div>
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
	<!-- /#right-panel -->

	<!-- Right Panel -->

	


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


	<script>
		setTimeout(function() {
			$('#messageAnimation').fadeOut('slow');
		}, 5000);
	</script>
	<script>
		setTimeout(function() {
			$('#validationMsg').fadeOut('slow');
		}, 10000);
	</script>
	<script>
		function getCityList() {

			var stateId = document.getElementById("stateId").value;

			$
					.getJSON(
							'${getCityByStateId}',
							{

								stateId : stateId,
								ajax : 'true'

							},
							function(data) {

								var html = '<option value="" disabled="disabled" selected >Choose City...</option>';

								var len = data.length;
								for (var i = 0; i < len; i++) {

									html += '<option value="' + data[i].cityId + '">'
											+ data[i].cityName + '</option>';
								}
								html += '</option>';
								$('#cityId').html(html);

								$("#cityId").trigger("chosen:updated");

							});

		}
	</script>

	<script>
		function nameValidation() {

			var clientName = document.getElementById("name").value;
			alert(clientName);

			$
					.getJSON(
							'${clientNameValidation}',
							{

								clientName : clientName,
								ajax : 'true'

							},
							function(data) {

								alert(data);
								if (data == 1) {

								} else {

									document.getElementById("name").value = "";
									document.getElementById("validationMsg").innerHTML = "already exist";
								}

							});

		}
	</script>
</body>
</html>
