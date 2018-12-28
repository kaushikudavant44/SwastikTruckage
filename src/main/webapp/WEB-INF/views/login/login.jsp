<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Swastik Truckage</title>
<meta name="viewport" content="width=device-width">
<meta name="mobile-web-app-capable" content="yes">

<!--===============================================================================================-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/favicon.ico">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/fonts/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/fonts/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/css/util.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/css/main.css">
<!--===============================================================================================-->


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<style type="text/css">

.image {
    position:relative;
    width:400px;
    height:400px;
}
.image img {
    width:100%;
    vertical-align:top;
}
.image:after {
    content:'\A';
    position:absolute;
    width:100%; height:100%;
    top:0; left:0;
    background:rgba(0,0,0,0.6);
    opacity:0;
    transition: all 0.5s;
    -webkit-transition: all 0.5s;
}
.image:hover:after {
    opacity:1;
}

</style>

</head>
<body>

	<div class="limiter">


		<div class="container-login100"
			style=" background-image: url('${pageContext.request.contextPath}/resources/images/login_back.jpg'); background-size: cover;

top: 0;
left: 0;
width: 100%;
height: 100%;
z-index: -2;
">
			<div class="wrap-login100">
				<span style="color: red;" id="messageAnimation">${message}</span>
				<form class="login100-form validate-form"
					action="${pageContext.request.contextPath}/staffLoginProcess"
					method="post">


					<img alt=""
						src="${pageContext.request.contextPath}/resources/images/swastik_logo.png"
						style="display: block; margin-left: auto; margin-right: auto; width: 35%; height: 40%">

					<br> <span class="login100-form-title p-b-26">Login </span>


					<div class="wrap-input100 validate-input"
						data-validate="Enter Mobile No">
						<input class="input100" type="text" name="contactNo"
							autocomplete="off"> <span class="focus-input100"
							data-placeholder="Mobile No"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<span class="btn-show-pass"> <i class="zmdi zmdi-eye"></i>
						</span> <input class="input100" type="password" name="password"
							autocomplete="off"> <span class="focus-input100"
							data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Sign In</button>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>



	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/js/popper.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/newlogin.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/resources/assets/vendor/jquery/jquery-3.2.1.min.js"></script>

	<script>
		setTimeout(function() {
			$('#messageAnimation').fadeOut('slow');
		}, 5000);
	</script>


	<script type="text/javascript">
		if ($("#userName").val().length !== 0
				&& $.trim($('#userName').val()) !== ''
				&& $("#password").val().length !== 0
				&& $.trim($('#password').val()) !== '') {

			$('#submitLogin').removeAttr('disabled');
		} else {
			$('#submitLogin').attr('disabled', "");
		}
	</script>


</body>
</html>