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
<link href="${pageContext.request.contextPath}/resources/assets/lr/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/resources/assets/lr/js/ie-emulation-modes-warning.js" type="text/javascript"></script> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link
	href="${pageContext.request.contextPath}/resources/assets/lr/css/style.css"
	rel="stylesheet" type="text/css"></head> 
	

<body class="swastikBg">

	<div class="swastikForm">
    <!-- <div class="col-sm-12 text-center">
        	<p><strong>Phone No.:</strong> 23427812 / 23427962 / 23440860</p>
            <p><strong>Tele Fax:</strong> 23440857</p>
        </div>
        <div class="clearfix"></div> -->

       
        <div class="col-sm-12" style="margin-top:140px">

   <p class="text-left"><strong>Address:</strong> ${lrDetails.officeAddress}   &nbsp; &nbsp; &nbsp; &nbsp; <strong>Phone No.:</strong> 2362111 / 2350287 / 2350144 <strong>  Tele Fax:</strong> 2350211</p>
</div>
        <div class="col-sm-0" style="margin-top:140px">

    
       </div>

        <div class="col-sm-5" style="margin-top:0px;">


       


</div>            
        <div class="clearfix"></div>

<table class="printFormat"  width="100%"  style="border: 1px solid black;">
  <tr height="20px;">
    <th style="padding-left:10px;" width="38%">FROM :  ${lrDetails.officeName}</th>
    <th width="37%">TO :  ${lrDetails.consigneeAddress}</th>
<th width="25%">LR No.: ${lrDetails.lrNo}</th>

  </tr>
  
</table>

<table  class="printFormat"  width="100%">
  <tr  height="20px;" style="border-top:0px; border-left: 1px solid #000000; border-right: 1px solid #000000;">
    <th width="75%"  style="padding-left:10px;">CONSIGNOR : ${lrDetails.consignorName}</th>
    <th width="25%">DATE : ${lrDetails.lrDate}</th>

  </tr>
  
</table>

<table  class="printFormat"  width="100%">
  <tr height="20px;" style="border-top:1px solid #000000; border-bottom:1px solid #000000;  border-left: 1px solid #000000; border-right: 1px solid #000000;" >
    <th width="75%" style="padding-left:10px;" >CONSIGNEE : ${lrDetails.consigneeName}</th>
    <th width="25%"> TRUCK No. :  ${lrDetails.truckNo}</th>

  </tr>
  
</table>


        <div class="col-sm-8" style="padding-left:0px;">

<br>
       	  <table   class="printFormat"  width="100%" border="1"  >
        	  <tr height="10px;">
        	    <th width="33%"><strong>No. of Containts</strong></th>
        	    <th width="33%" align="center"><strong>Good</strong></th>
        	    <th width="33%" align="center"><strong>Description</strong></th>
      	    </tr>
      	    <tbody>
           <c:forEach items="${lrContaintDetailsList}" var="lrContaintDetailsList" varStatus="count"> 
             <tr height="1px;">
              <td width="10%"  class="containtTd" align="center">${lrContaintDetailsList.noOfContaints}</td>
              <td width="10%" class="containtTd" align="center">${lrContaintDetailsList.goodsName}</td>
              <td width="10%" class="containtTd" align="center">${lrContaintDetailsList.description}</td>
            </tr>
           
			</c:forEach>
			</tbody>
			 <tfoot>
			<tr>
			<td align="center"><strong>Total = ${containtTotal}</strong></td>
			<td></td>
			<td></td>
			</tr>
			</tfoot>
          </table>

          <div class="col-sm-8">

          	<h5><strong>Invoice No.: </strong><c:forEach items="${transactionLrInvoiceDetailList}" var="transactionLrInvoiceDetailList" varStatus="count">${transactionLrInvoiceDetailList.invNo},</c:forEach> </h5>
            <h5><strong>GSTIN :27BERP38138B1Z2 </strong></h5>

     <p class="red">Tax Paid on reverse charge basis will be available for input tax credit if such goods and/or service are used, or will be used, for business. The service recepient(i.e who plays reverse tax) can avail input tax credit.</p>

          </div>
          <div class="col-sm-4 padding0">
          	<!-- <h5><strong> SAC Code: 996511</strong> </h5> -->
            <h5><strong>PAN No.: BERPS8138B</strong> </h5>
            <h5>www.swastiktransport.com</h5>
          <h5>Email: swastiktruckage@gmail.com</h5>
          <h5>Helpline No.: 9890362111</h5>


          </div>
        </div>
        <div class="col-sm-4" style="padding-right:0px;">
       	  <table width="100%" border="1">
        	  <tr>
        	    <td class="leftwd" ><strong>WEIGHT</strong></td>
        	    <td align="right">${lrDetails.weight}</td>
      	    </tr>
        	
          </table>
          <br>
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



        </div>
       
 <br>
        <div class="col-sm-12 text-right padding0 padding1">
        <h4> Receiver's Sign:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For Swastik Truckage Co.</h4>
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
