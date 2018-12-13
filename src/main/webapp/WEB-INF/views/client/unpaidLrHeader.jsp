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
						<li><a href="#">Office Details</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="content mt-3">
	<div class="form-group ">
                        <div class="col-lg-5"></div>
                         <div class="col-lg-5">
                        <p style="position: absolute; color: black; background-color: #9bf79b; border-radius: 3px;" id="messageAnimation">${message}</p>
         </div> 
         </div>
         
         <br>
	
		<div class="animated fadeIn">
			<div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Client detail</strong>
						</div>
						<div class="card-body">
<form action="${pageContext.request.contextPath}" method="GET">
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
									    <th>Sr.No</th>
									      <th>LR No</th>
									      <th>Consignee</th>
									      <th>Consignor</th>
									      
									        <th>LR Date</th>
									          <th>Particular</th>
									    <th>Vehicle No.</th>
									      <th>Quantity</th>
                                       <th>Freight</th>
                                       <th>Local Tempo</th>
                                       <th>Hamali</th>
										<th>Payment By</th>
										<th >Total</th>
										<th >Action</th>
										

									</tr>
								</thead>
								<tbody>
								<c:forEach items="${lrHeaderList}" var="lrHeaderList" varStatus="myIndex">
									
                                 <tr>
                                <td>${myIndex.index+1}</td>
                                <td>${lrHeaderList.lrNo}</td>
                                <td>${lrHeaderList.consigneeName}</td>
                                <td>${lrHeaderList.consignorName}</td>
                                 <td>${lrHeaderList.lrDate}</td>
                                  <td>${lrHeaderList.goods}</td>
                                   <td>${lrHeaderList.truckNo}</td>
                                    <td>${lrHeaderList.quantity}</td>
                                     <td>${lrHeaderList.freight}</td>
                                      <td>${lrHeaderList.localTempo}</td>
                                       <td>${lrHeaderList.hamali}</td>
						
						        <c:choose>
                              <c:when test="${lrHeaderList.paymentBy==0}">
                              
  							<td>Consignee</td>
  							
  							</c:when>
  							<c:when test="${lrHeaderList.paymentBy==1}">
                              
  								<td>Consignor</td>
  							
  							</c:when>
  							</c:choose>
						
						
						
										
										<td>${lrHeaderList.total}</td>
										
			<td> <button type="submit" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/showCollectionInfo/${lrHeaderList.total}/${lrHeaderList.lrNo}/${lrHeaderList.lrHeaderId}">
										Generate</a>
									</button>	 </tr>
										
									
									
									</c:forEach>
								</tbody>
							</table>


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

	
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>


    <script src="${pageContext.request.contextPath}/resources/assets/js/lib/chart-js/Chart.bundle.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/dashboard.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/widgets.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/lib/vector-map/jquery.vmap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/lib/vector-map/jquery.vmap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/lib/vector-map/jquery.vmap.sampledata.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/lib/vector-map/country/jquery.vmap.world.js"></script>
     <script src="${pageContext.request.contextPath}/resources/assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script>
        ( function ( $ ) {
            "use strict";

            jQuery( '#vmap' ).vectorMap( {
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: [ '#1de9b6', '#03a9f5' ],
                normalizeFunction: 'polynomial'
            } );
        } )( jQuery );
    </script>
    <script>
                        setTimeout(function() {
    $('#messageAnimation').fadeOut('slow');
}, 5000);
                        </script>
    


</body>
</html>