<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<title>Swastik Truckage</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/assets/lr/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<script
	src="${pageContext.request.contextPath}/resources/assets/lr/js/ie-emulation-modes-warning.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link
	href="${pageContext.request.contextPath}/resources/assets/lr/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<style>
.t-table {
 border: 1px solid black;
 height: 500px;
 width: 100%;
 border-collapse: collapse;
}
.t-table td {
 border: 1px solid black;
 
}
.t-table td:empty {
 border-left: 0;
 border-right: 0;
}
.t-table th {

border: 1px solid black;

}

</style>
<body class="swastikBg">

	<div class="swastikForm">

		<div class="col-sm-3" style="padding-top: 80px;">
		
		<p style="text-align: left; width: auto" >
				<strong> <font size="4">Memo No.: ${getMemoDeatails.memoNo}</font>
				</strong>
			</p>
			
			<p style="text-align: left">
				<strong> <font size="4">Date : ${getMemoDeatails.createdDate}</font>
				</strong>
			</p>
			
		
		</div>
		<div class="col-sm-6" style="margin-left: 0px">

			<h5 class="text-center" style="padding: 1px; margin: 1px;">Subject
				to Mumbai Jurisdiction</h5>
			<img
				src="${pageContext.request.contextPath}/resources/images/swastik.png"
				class="img-responsive" alt="logo">
			<!--<h2 class="text-center"> <img src="images/swastiklogo.png" class="img-responsive" alt="SwastikLogo">Swastik <span>Truckage Co.</span></h2>-->
			<p class="text-center">
				<strong>Address:</strong> ${getMemoDeatails.officeAddress}
			</p>


		</div>

		<div class="col-sm-3" style="margin-top: 30px;">


			<p class="text-center">
				<strong>Phone No.:</strong> 23427812 / 23427962 / 23440860 <strong>
					<br> Tele Fax:
				</strong> 23440857
			</p>


		</div>
		<div class="clearfix"></div>

		<table width="100%" style="border: 1px solid black;">
			<tr height="30px;">
				<th style="padding-left: 10px;" width="38%">Vehicle Owner : ${getMemoDeatails.ownerName}
					</th>
				<th width="37%">Drivers Name :  ${getMemoDeatails.driverName}</th>
			</tr>

		</table>
		
		<div class="clearfix"></div>
		<table width="100%">
			<tr height="30px;"
				style="border-top: 0px; border-left: 1px solid #000000; border-right: 1px solid #000000;">
				<th width="38%" style="padding-left: 10px;">License No
					: ${getMemoDeatails.licenseNo}</th>
				<th width="37%">Vehicle No : ${getMemoDeatails.vehNo}</th>

			</tr>

		</table>
		
		<div class="clearfix"></div>
		
		<table width="100%" style="border: 1px solid black;">
			<tr height="30px;">
				<th style="padding-left: 10px;" width="38%">From : ${getMemoDeatails.fromOffice}
					</th>
				<th width="37%">To : ${getMemoDeatails.toOffice}</th>
			</tr>

		</table>
		
		
		&nbsp;
		<table class="t-table">
			<tr style="line-height: 20px; height: 20px;">
				<th align="center">Sr No.</th>
				<th>Lr No.</th>
				<th>Consignor</th>
				<th>Consignee</th>
				<th>Delivery location</th>
				<th>Goods</th>
				<th>No. of Quant.</th>
				<th>Payment By</th>
			</tr>
			<c:forEach items="${lrDetailsList }" var="lrDetailsList" varStatus="count">
			<tr style="line-height: 20px; height: 20px;">
				
				<td align="center">${count.index+1}</td>
				<td align="center">${lrDetailsList.lrNo}</td>
				<td align="center">${lrDetailsList.consignor}</td>
				<td align="center">${lrDetailsList.consignee}</td>
				<td align="center">${lrDetailsList.clientAddress}</td>
				<td align="center">${lrDetailsList.particular}</td>
				<td align="center">${lrDetailsList.quantity}</td>
				
				<c:choose>
				<c:when test="${lrDetailsList.paymentBy==0}">
				<td align="center">to be billed</td>
				</c:when>
				<c:otherwise>
				<td align="center">to pay</td>
				</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
			<tr>
   <td></td>
   <td></td>
   <td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
 </tr>

		</table>
		<%-- <div class="col-sm-8" style="padding-left: 0px;">

			<br>
			<table width="100%" border="1">
				<tr>
					<th width="33%"><strong>No. of Containts</strong></th>
					<th width="33%" align="center"><strong>Good</strong></th>
					<th width="33%" align="center"><strong>Description</strong></th>
				</tr>
				<c:forEach items="${lrContaintDetailsList}"
					var="lrContaintDetailsList" varStatus="count">
					<tr>
						<td class="containtTd" align="center">${lrContaintDetailsList.noOfContaints}</td>
						<td class="containtTd" align="center">${lrContaintDetailsList.goodsName}</td>
						<td class="containtTd" align="center">${lrContaintDetailsList.description}</td>
					</tr>
				</c:forEach>
			</table>

			<div class="col-sm-8">

				<h5>
					<strong>Invoice No.: </strong>
					<c:forEach items="${transactionLrInvoiceDetailList}"
						var="transactionLrInvoiceDetailList" varStatus="count">${transactionLrInvoiceDetailList.invNo},</c:forEach>
				</h5>
				<h5>
					<strong>GSTIN :27AARFS4904J1ZP </strong>
				</h5>

				<p class="red">Tax Paid on reverse charge basis will be
					available for input tax credit if such goods and/or service are
					used, or will be used, for business. The service recepient(i.e who
					plays reverse tax) can avail input tax credit.</p>

			</div>
		<!-- 	<div class="col-sm-4 padding0">
				<h5>
					<strong> SAC Code: 996511</strong>
				</h5>
				<h5>
					<strong>PAN No.: AARFS4904J</strong>
				</h5>
				<h5>www.swastiktransport.com</h5>
				<h5>Email: swastiktransportco@rediffmail.com</h5>
				<h5>Helpline No.: 9890362111</h5>

			</div> -->

		</div> --%>
		<div class="col-sm-4" style="padding-right: 0px;">
			<%-- <table width="100%" border="1">
				<tr>
					<td class="leftwd"><strong>WEIGHT</strong></td>
					<td align="right">${lrDetails.weight}</td>
				</tr>

			</table> --%>
		<%-- 	<br>
			<table width="100%" border="1">

				<tr>
					<td class="leftwd">FREIGHT</td>
					<td align="right">${lrDetails.freight}</td>
				</tr>
				<tr>
					<td class="leftwd">GST</td>
					<td align="right">${lrDetails.gst}</td>
				</tr>
				<tr>
					<td class="leftwd">HAMALI</td>
					<td align="right">${lrDetails.hamali}</td>
				</tr>
				<tr>
					<td class="leftwd">B.C. CHARGE</td>
					<td align="right">${lrDetails.bcCharge}</td>
				</tr>
				<tr>
					<td class="leftwd">KATA</td>
					<td align="right">${lrDetails.kata}</td>
				</tr>
				<tr>
					<td class="leftwd">LOCAL TEMPO</td>
					<td align="right">${lrDetails.localTempo}</td>
				</tr>
				<tr>
					<td class="leftwd">BHARAI</td>
					<td align="right">${lrDetails.bharai}</td>
				</tr>
				<tr>
					<td class="leftwd">DD CHARGES</td>
					<td align="right">${lrDetails.ddCharges}</td>
				</tr>
				<tr>
					<td class="leftwd">TOTAL</td>
					<td align="right">${lrDetails.total}</td>
				</tr>
			</table>
 --%>


		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		
		<div class="col-sm-12 text-right padding0 padding1">
			<h4>Receiver's Sign: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For Swastik
				Truckage Co.</h4>
		</div>

	</div>


	<!-- Bootstrap core JavaScript================================================== -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/lr/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/lr/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/lr/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
