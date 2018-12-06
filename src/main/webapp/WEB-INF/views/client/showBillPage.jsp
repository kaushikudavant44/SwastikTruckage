<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Hub User</title>


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
	href="${pageContext.request.contextPath}/resources/assets/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>



</head>


<!-- Translate -->



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<body class="swastikBg">

	<div class="swastikForm1">
         <img src="${pageContext.request.contextPath}/resources/images/swastik.png" class="img-responsive" alt="logo">
        <!--<h2 class="text-center"> <img src="${pageContext.request.contextPath}/resources/images/swastiklogo.png" class="img-responsive" alt="SwastikLogo">Swastik <span>Truckage Co.</span></h2>-->
        <p class="text-center"><strong>Address:</strong> Plot No. 44/1/2, M.I.D.C. Satpur, Nashik-422007. </p>
        <p class="text-center"><strong>Ph No.:</strong> 2350144,2350287 &nbsp; &nbsp;<strong>Fax:</strong> 2350211</p>
        <p class="text-center"><strong>PAN No.</strong> AARFS-4904-J &nbsp; &nbsp; <strong>Account Helpline:</strong> 9822218090, 9822847774</p>
        <h4 class="text-center"><strong>GSTIN :</strong> 27AARFS4904J1ZP &nbsp; &nbsp;<strong>SAC Code :</strong> 996511</h4>
        <div class="clearfix"></div>
        <hr>
        <div class="col-sm-6">
        	<h4><strong>To, ${clientFullDetails.clientName}/strong></h4>
            <p><strong>Address :</strong> ${clientFullDetails.clientAddress}</p>
            <p><strong>State Name :</strong> ${clientFullDetails.stateName}</p>
            <p><strong>State Code :</strong> ${clientFullDetails.stateCode}</p>
        </div>
        <div class="col-sm-6">
        	<span>Please Make Payment By Cheque/ NEFT/RTGS only</span>
        	<p><strong>Bill No.:</strong> ${trBillHeader.billNo}</p>
            <p><strong>Bill Date :</strong>${trBillHeader.billDate} </p>
            <p><strong>Page No.:</strong> </p>
        </div>
        <table width="200" border="1">
  <tr>
    <td><strong>LR No</strong>.</td>
    <td><strong>LR Date</strong></td>
    <td><strong>Particular</strong></td>
    <td><strong>Vehicle No.</strong></td>
    <td><strong>Quantity</strong></td>
    <td><strong>Freight</strong></td>
    <td><strong>Local Tempo</strong></td>
    <td><strong>Hamali</strong></td>
    <td><strong>Inv No</strong></td>
    <td><strong>Amount</strong></td>
  </tr>
  <c:forEach items="${clientBillDetails}" var="clientBillDetails" varStatus="myIndex">
									
<tr>
    <td>${myIndex.index+1}</td>
    <td>${clientBillDetails.lrDate}</td>
    <td></td>
    <td>${clientBillDetails.truckNo}</td>
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
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><strong>Total</strong></td>
    <td><strong>${totalQty}</strong></td>
    <td>&nbsp;</td> 
    <td>&nbsp;</td>
    <td><strong></strong></td>
    <td><strong></strong></td>
    <td><strong>${totalBill}</strong></td>
  </tr>
</table>
<div class="clearfix"></div>
<h4 class="text-center"><strong>In Words:</strong> Seventeen Thousand Only</h4>

    <div class="table-responsive">
    	<table width="200" border="1" class="lfttxtTbl">
      <tr>
        <td colspan="2"><span class="text-uppercase"><strong>Bank Details</strong></span></td>
        <c:choose>
  		<c:when test="${trBillHeader.gstPayableBy==0}">
        <td rowspan="2" width="40%" valign="bottom"><h4><strong>GST Payable By CONSIGNOR</strong></h4></td>       
         </c:when>
        <c:when test="${trBillHeader.gstPayableBy==1}">
        <td rowspan="2" width="40%" valign="bottom"><h4><strong>GST Payable By CONSIGNEE</strong></h4></td> 
        </c:when>
        </c:choose>
      
        </tr>
      <tr>
        <td><p>BANK</p>
          <p>ACCOUNT NO.</p>
          <p>MICR</p>
          <p>RTGS CODE</p>
          <p>Email</p></td>
        <td><p>HDFC BANK, THATTE NAGAR, NASHIK</p>
          <p>00642790000250</p>
          <p>422240002</p>
          <p>HDFC0000064</p>
          <p>swastiktransportco@reddiffmail.com</p></td>
          </tr>
      </table>
    </div>
    <div class="table-responsive">
    	<table width="200" border="1" class="lfttxtTbl">
      <tr>
        <td><span class="text-uppercase"><strong>Declaration</strong></span></td>
        <td rowspan="2" width="40%" valign="bottom"><h4><strong>For Swastik transport Company</strong></h4></td>
        </tr>
      <tr>
        <td>Tax paid on reverse charge basis will be available for input tax credit if such goods and / or services are used, or will be used, for business, the service recepient (i.e, who pays reverse tax) can avail input tax credit.</td>
        </tr>
      </table>
    </div>
      
</div>
	
    
   
<!-- Bootstrap core JavaScript================================================== --> 

	
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
		src="${pageContext.request.contextPath}/resources/assets/js/vendor/jquery-2.1.4.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/chosen/chosen.jquery.min.js"></script>
		
</body>
</html>