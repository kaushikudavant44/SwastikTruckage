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
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">
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
						<li><a href="#">Payment</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div>
	
  <div class="content mt-3">
 	 <div class="animated fadeIn">
			<div class="row">

				<div class="col-md-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong class="card-title">Bill Details</strong>
						</div>
						<div class="card-body">
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
					
						<p>
							<strong>Bill No:</strong> ${trBillHeader.billNo}
						</p>
						<p>
							<strong>Bill Date :</strong>${trBillHeader.billDate}
						</p>
						<p>
							<strong>Page No.:</strong>
						</p>

					</div>
				</td>

			</tr>
		</table> 
		
		<table id=""
								class="table table-striped table-bordered">
								<thead>
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
    <td> ${clientBillDetails.lrNo} </td>
    <td> ${clientBillDetails.lrDate} </td>
    <td>${clientBillDetails.goods}</td>
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
				<td>&nbsp;</td>
				<td><strong>${totalFreight}</strong></td>
				<td>&nbsp;</td>
				<td><strong>${totalHamali}</strong></td>
				<td><strong>&nbsp;</strong></td>
				<td><strong>${totalBill}</strong></td>
			</tr>
							</table>
<hr>
<h4>Installment</h4>
							<table id=""
								class="table table-striped table-bordered">
								<thead>
									<tr>
									    <th>SR No</th>
										<th>Date</th>
										<th>Payment Mode</th>
										<th>transaction Id</th>
										<th>Amount</th>
										
									</tr>
								</thead>
								<tbody>
<c:forEach items="${installement}" var="installement" varStatus="myIndex">
									
<tr>
    <td>${myIndex.index+1}</td>
    <td> ${installement.paymentDate} </td>
    <c:choose>
                            <c:when test="${installement.paymentMode==1}">                              
  							<td>Cash</td>  							
  							</c:when>
  							
  							<c:when test="${installement.paymentMode==2}">                            
  							<td>Check</td>  							
  							</c:when>
  							
  							<c:when test="${installement.paymentMode==3}">                            
  							<td>NEFT</td>  							
  							</c:when>
  						</c:choose>
  							
							<td>${installement.trId}</td>
    <td>${installement.amountReceived}</td>
   
  </tr>
 </c:forEach> 
			
								</tbody>
							</table>


							
						</div>
					</div>
				</div>


			</div>
		</div>



 <div class="row">

  <div class="col-lg-3">
 </div> 
 
 
 		<div class="col-lg-6">
					<div class="cardview">
						<div class="cardview-header">
							<h4>Pyment</h4>
						</div>
						<form action="${pageContext.request.contextPath}/submitPayment" method="POST">
										
						<input type="hidden" name="billHeaderId" value="${billHeaderId}" class="form-control">					
						<div class="card-body">
							<div class="row">
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Total</label>
										<input required name="total" class="form-control" value="${total}" readonly>							
							</div>							
							</div>
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Payment Type</label>
								
							<select required 
								class="standardSelect form-control" tabindex="1" id="paymentType" name="paymentType" onchange='checkPaymentType(this.value)' >
								<option>--select--</option>
                                <option value="1">cash</option>
                                <option value="2">check</option>
                                <option value="3">neft</option>
								
							</select>
						
							</div>
							
							</div>
							
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Amount</label>
										<input required name="amount" class="form-control" value="" >							
							</div>							
							</div>
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								
						<input placeholder="transaction id" class="form-control" name="trId" id="trId" style='display:none'/>							
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
	<div class="col-lg-3">
	</div>			
 

</div>
 </div>

        
  
    <div align="center" ><jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

        
    </div><!-- /#right-panel -->

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


	<script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table1').DataTable({
        	  columnDefs: [
      	        { targets: [1], className:"right" },
      	    ]
          });
        } );
    </script>
 
<script>
function checkPaymentType(val)
{
    if(val==="2"||val=="3")
    	{
       document.getElementById('trId').style.display='block';
       document.getElementById('trId').required = true; 
    	}
    else
    	{
       document.getElementById('trId').style.display='none'; 
       document.getElementById('trId').required = false;
    	}
      
}
</script>
</body>
</html>
