<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Swastik Truckage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">
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


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/menu.css">

<link
	href="${pageContext.request.contextPath}/resources/assets/css/lib/vector-map/jqvmap.min.css"
	rel="stylesheet">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

</head>



<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>


<body onload="setData()">

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

					<div class="col-xs-12 col-sm-12">

						<div class="col-sm-6 col-lg-4">
							<div class="card text-white bg-flat-color-2">
								<div class="card-body pb-0" align="center">

									<h4 class="mb-0">
										<span class="count" style="font-size: 50px;">${lrCount}</span>
									</h4>
									<p style="font-size: 18px; font-weight: bold; color: white;">
										<font color="white">Created Lr's</font>
									</p>

								</div>
							</div>
						</div>



						<div class="col-sm-6 col-lg-4">
							<div class="card text-white bg-flat-color-2">
								<div class="card-body pb-0" align="center">

									<h4 class="mb-0">
										<span class="count" style="font-size: 50px;">${pendingBillCount}</span>
									</h4>
									<p style="font-size: 18px; font-weight: bold; color: white;">
										<font color="white">Pending Bills</font>
									</p>

								</div>
							</div>
						</div>


						<div class="col-sm-6 col-lg-4">
							<div class="card text-white bg-flat-color-2">
								<div class="card-body pb-0" align="center">

									<h4 class="mb-0">
										<span class="count" style="font-size: 50px;">${pendingLrCount}</span>
									</h4>
									<p style="font-size: 18px; font-weight: bold; color: white;">
										<font color="white">Pending Lr Delivery</font>
									</p>

								</div>
							</div>
						</div>

					</div>

					<!-- <div class="col-xs-12 col-sm-12">

						<div class="col-sm-6 col-lg-4">
							<div class="card text-white bg-flat-color-3">
								<div class="card-body pb-0" align="center">

									<h4 class="mb-0">
										<span class="count" style="font-size: 50px;">4</span>
									</h4>
									<p style="font-size: 18px; font-weight: bold; color: white;">
										<font color="white">No Orders</font>
									</p>

								</div>
							</div>
						</div>



						<div class="col-sm-6 col-lg-4">
							<div class="card text-white bg-flat-color-3">
								<div class="card-body pb-0" align="center">

									<h4 class="mb-0">
										<span class="count" style="font-size: 50px;">2</span>
									</h4>
									<p style="font-size: 18px; font-weight: bold; color: white;">
										<font color="white">Order Forward Pending</font>
									</p>

								</div>
							</div>
						</div>




					</div> -->


					<!-- <div class="col-xs-12 col-sm-12">
						<div class="card">
							<div class="card-header">
								<strong>Distributor And Order Total</strong>
							</div>
							<div class="card-body card-block">

								<div id="columnchart_material"></div>

							</div>
						</div>
					</div>


					<div class="col-xs-12 col-sm-9">
						<div class="card">
							<div class="card-header">
								<strong>Category And Order Qty</strong>
							</div>
							<div class="card-body card-block">

								<div id="columnchart_material2"></div>

							</div>
						</div>
					</div> -->



					<div class="col-xs-12 col-sm-12">
						<div class="cardview">
							<div class="cardview-header">
								<strong>Last 15 Days Created Lr</strong>
							</div>
							<div class="card-body card-block">


								<div id="linechart_material"></div>

							</div>
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
		src="${pageContext.request.contextPath}/resources/assets/js/dashboard.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/widgets.js"></script>



	<script>
	
	var lrCount;
	var lrDate;
	var lrDateWiseCount = [];
	
	<c:forEach items="${lrGraphList}" var="lrGraphList">
	
	
	lrCount = "<c:out value="${lrGraphList.lrCount}"/>";
	
	
	
	lrDate = "<c:out value="${lrGraphList.lrDate}"/>";

	lrDateWiseCount.push([lrDate,parseInt(lrCount,10)]);

	</c:forEach>
	
	
	
		function setData() {

			
			// Bar Chart 1
		/* 	google.charts.load('current', {
				'packages' : [ 'bar' ]
			});
			google.charts.setOnLoadCallback(drawChart);

			function drawChart() {
				var data = google.visualization.arrayToDataTable([
						[ 'Distributor', 'Todays Order', ' Previous Order 1',
								'Previous Order 2' ], [ 'D1', 1000, 400, 200 ],
						[ 'D2', 1170, 460, 250 ], [ 'D3', 660, 1120, 300 ],
						[ 'D4', 800, 1000, 900 ], [ 'D5', 1170, 460, 250 ],
						[ 'D6', 660, 1120, 300 ], [ 'D7', 800, 1600, 900 ],

				]);

				var options = {
					chart : {
						title : '',
						subtitle : '',
					}
				};

				var chart = new google.charts.Bar(document
						.getElementById('columnchart_material'));

				chart.draw(data, google.charts.Bar.convertOptions(options));
			}

			
			// Bar chart 2
				google.charts.load('current', {
				'packages' : [ 'bar' ]
			});
			google.charts.setOnLoadCallback(drawChart2);

			function drawChart2() {
				var data = google.visualization.arrayToDataTable([
						[ 'Category', 'Order Qty' ], [ 'Cat 1', 1000 ],
						[ 'Cat 2', 1170 ], [ 'Cat 3', 660 ],[ 'Cat 4', 660 ],[ 'Cat 5', 660 ],
					
				]);

				var options = {
					chart : {
						title : '',
						subtitle : '',
					}
				};

				var chart = new google.charts.Bar(document
						.getElementById('columnchart_material2'));

				chart.draw(data, google.charts.Bar.convertOptions(options));
			}
			
			 */
			
			
			// Line Chart

			google.charts.load('current', {
				'packages' : [ 'line' ]
			});
			google.charts.setOnLoadCallback(drawChart3);
			
			
			
			function drawChart3() {

				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Day');
				data.addColumn('number', 'LR');
				/* data.addColumn('number', 'Cat 2');
				data.addColumn('number', 'Cat 3');
				data.addColumn('number', 'Cat 4'); */

			  	 data.addRows(lrDateWiseCount);  
			  	/*	 data.addRows([ [ "1", 15 ],
						[ "2", 25],
						[ "3", 10],
						[ "4", 20],
						[ "5", 40 ],
						[ "6", 50]

				]); */
				var options = {
					chart : {
						title : '',
						subtitle : ''
					}

				};

				var chart = new google.charts.Line(document
						.getElementById('linechart_material'));

				chart.draw(data, google.charts.Line.convertOptions(options));
			}

		}
	</script>


</body>
</html>
