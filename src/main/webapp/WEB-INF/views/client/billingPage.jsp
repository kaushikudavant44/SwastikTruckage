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
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<script
	src="${pageContext.request.contextPath}/resources/assets/js/billing/ie-emulation-modes-warning.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link
	href="${pageContext.request.contextPath}/resources/assets/css/lib/billing.css"
	rel="stylesheet" type="text/css">
	
	
</head>
<body class="swastikBg">

	<div class="swastikForm1">
		<%-- <img
			src="${pageContext.request.contextPath}/resources/images/swastik.png"
			style="display: block; margin-left: auto; margin-right: auto; width: 50%;"
			alt="logo"> --%>
		<!--<h2 class="text-center"> <img src="images/swastiklogo.png" class="img-responsive" alt="SwastikLogo">Swastik <span>Truckage Co.</span></h2>-->
		 <div class="col-sm-12" style="margin-top:80px">

    
       </div>
	
		<p class="text-center">
			<strong>Address:</strong> ${companyDetails.address}
		</p>
		<p class="text-center">
			<strong>Ph No.:</strong> ${companyDetails.contactNo1},${companyDetails.contactNo2} &nbsp; &nbsp;<strong>Fax:</strong>
			2350211
		</p>
		<p class="text-center">
			<%-- <strong>PAN No.</strong> ${companyDetails.panNo} --%> &nbsp; &nbsp; <strong>Account
				Helpline:</strong> ${companyDetails.helplineNo}
		</p>



		<table width="100%" border="1">
			<tr>
				<td><h4 class="text-center">
						<strong>GSTIN :</strong> ${companyDetails.gstin} &nbsp; &nbsp;<strong>SAC
							Code :</strong> ${companyDetails.sacCode}
					</h4></td>

			</tr>


		</table>



		<table width="100%" border="0">
			<tr>
				<td border="0" align="left">
					<div class="col-sm-6">
						<h4>
							<strong>To, ${clientFullDetails.clientName}</strong>
						</h4>
						<p>
							<strong>Address :</strong> ${clientFullDetails.clientAddress}
						</p>
						<p>
							<strong>State Name :</strong> ${clientFullDetails.stateName}
						</p>
						<p>
							<strong>State Code :</strong> ${clientFullDetails.stateCode}
						</p>
					</div>
				</td>
				<td border="0" align="left">

					<div class="col-sm-6">
						<span>Please Make Payment By Cheque/ NEFT/RTGS only</span>
						<p>
							<strong>Bill No.:</strong> ${trBillHeader.billNo}
						</p>
						<p>
							<strong>Bill Date :</strong>${trBillHeader.billDate}
						</p>
						<!-- <p>
							<strong>Page No.:</strong>
						</p> -->

					</div>
				</td>

			</tr>
		</table>





		<table width="200" border="1">
			<tr>
				<td><strong>LR No</strong>.</td>
				<td><strong>LR Date</strong></td>
				<td><strong>Station</strong></td>
				<td><strong>Receiver Name</strong></td>
				<td><strong>Particular</strong></td>
				<td><strong>Quantity</strong></td>
				<td><strong>Freight</strong></td>
				<td><strong>Local Tempo</strong></td>
				<td><strong>Hamali</strong></td>
				<td><strong>Inv No</strong></td>
				<td><strong>Amount</strong></td>
			</tr>
  <c:forEach items="${clientBillDetails}" var="clientBillDetails" varStatus="myIndex">
									
<tr>
    <td> ${clientBillDetails.lrNo} </td>
    <td> ${clientBillDetails.lrDate} </td>
    <c:if test="${clientBillDetails.paymentBy==0}">
    <td> ${clientBillDetails.consigneeAddress}</td>
    <td> ${clientBillDetails.consigneeName}</td>
    </c:if>
    <c:if test="${clientBillDetails.paymentBy==1}">
    <td> ${clientBillDetails.consignorName}</td>
    <td>${clientBillDetails.consignorAddress}</td>
    </c:if>
    <td>${clientBillDetails.goods}</td>
    <td>${clientBillDetails.quantity}</td>
    <td>${clientBillDetails.freight}</td>
    <td>${clientBillDetails.localTempo}</td>
    <td>${clientBillDetails.hamali}</td>
    <td>
     <c:forEach items="${clientBillDetails.invoiceDetailList}" var="invoiceDetailList" varStatus="loop">
    ${invoiceDetailList.invNo}<c:if test="${!loop.last}">,</c:if>
    </c:forEach>
    </td>
    <td>${clientBillDetails.total}</td>
  </tr>
 </c:forEach> 
			
			<tfoot>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><strong>Total</strong></td>
				<td>&nbsp;</td>
				<td><strong>${totalFreight}</strong></td>
				<td>&nbsp;</td>
				<td><strong>${totalHamali}</strong></td>
				<td><strong>&nbsp;</strong></td>
				<td><strong id="number">${totalBill}</strong></td>
			</tfoot>
		</table>
		<div class="clearfix"></div>
		
		<h4 class="text-left" style="margin-left: 30px;" >
			<strong >In Words: </strong><span id="words"></span>
		</h4>

		<div class="table-responsive">
			<table width="200" border="1" class="lfttxtTbl">
				<tr>
					<td colspan="2"><span class="text-uppercase"><strong>Bank
								Details</strong></span></td>
					<td rowspan="2" width="40%" valign="bottom"><h4>
					
					<c:choose>
  		<c:when test="${clientBillDetails[0].paymentBy==1}">
      <strong>GST Payable By CONSIGNOR</strong>       
         </c:when>
        <c:when test="${clientBillDetails[0].paymentBy==0}">
       <strong>GST Payable By CONSIGNEE</strong>
        </c:when>
        </c:choose>
							
						</h4></td>
				</tr>
				<tr>
					<td><p>BANK</p>
						<p>ACCOUNT NO.</p>
						<p>MICR</p>
						<p>RTGS CODE</p>
						<p>Email</p></td>
					 <td><p>${companyDetails.bankName} </p>
          <p>${companyDetails.accNo} </p>
          <p>${companyDetails.micrNo} </p>
          <p>${companyDetails.rtgsCode} </p>
          <p>${companyDetails.email} </p></td>
				</tr>
			</table>
		</div>
		<div class="table-responsive">
			<table width="200" border="1" class="lfttxtTbl">
				<tr>
					<td><span class="text-uppercase"><strong>Declaration</strong></span></td>
					<td rowspan="2" width="40%" valign="bottom"><h4>
							<strong>For ${companyDetails.companyName} Company</strong>
						</h4></td>
				</tr>
				<tr>
					<td>Tax paid on reverse charge basis will be available for
						input tax credit if such goods and / or services are used, or will
						be used, for business, the service recepient (i.e, who pays
						reverse tax) can avail input tax credit.</td>
				</tr>
			</table>
		</div>
		

	</div>



	<!-- Bootstrap core JavaScript================================================== -->
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/billing/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/billing/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/billing/ie10-viewport-bug-workaround.js"></script>
		
		<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/chosen/chosen.jquery.min.js"></script>
		<script type="text/javascript">
		
		var a = ['','One ','Two ','Three ','Four ', 'Five ','Six ','Seven ','Eight ','Nine ','Ten ','Eleven ','Twelve ','Thirteen ','Fourteen ','Fifteen ','Sixteen ','Seventeen ','Eighteen ','Nineteen '];
		var b = ['', '', 'Twenty','Thirty','Forty','Fifty', 'Sixty','Seventy','Eighty','Ninety'];

		function inWords (num) {
		    if ((num = num.toString()).length > 9) return 'overflow';
		    n = ('000000000' + num).substr(-9).match(/^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
		    if (!n) return; var str = '';
		    str += (n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'Crore ' : '';
		    str += (n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'Lakh ' : '';
		    str += (n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'Thousand ' : '';
		    str += (n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'Hundred ' : '';
		    str += (n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]]) + 'only ' : '';
		    return str;
		}

		var totalAmount=document.getElementById('number').innerHTML;
		    
		totalAmount=totalAmount.split(".");
		
		document.getElementById('words').innerHTML = inWords(totalAmount[0]);
		//    document.getElementById('words').innerHTML;
		</script>
</body>
</html>
