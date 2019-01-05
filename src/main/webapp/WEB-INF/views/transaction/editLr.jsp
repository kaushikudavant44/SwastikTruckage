<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Swastik Truckage</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">
<link rel="apple-touch-icon" href="apple-icon.png">
<link rel="shortcut icon" href="favicon.ico">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


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
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/scss/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- <style type="text/css">
.right {
	text-align: right;
}

.left {
	text-align: left;
}
</style> -->


<c:url var="addContaint" value="/addContaint" />
<c:url var="deleteContaint" value="/deleteContaint" />
<c:url var="addInvoiceNumber" value="/addInvoiceNumber" />
<c:url var="deleteInvoice" value="/deleteInvoice" />
<c:url var="deleteEditedInvoice" value="/deleteEditedInvoice" />
<c:url var="deleteEditedContaint" value="/deleteEditedContaint" />



</head>
<div id="loader">
		</div>
<body onload="getTotal()" id="bgbdy">


	<!-- Left Panel -->
	<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<!-- Left Panel -->


	<!-- Header-->
	<jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>
	<!-- Header-->


	<!-- <div class="breadcrumbs">
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
	</div> -->

	<div class="content mt-3">
		<div class="animated fadeIn">

			<div class="row">

				<div class="col-xs-12 col-sm-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong>Edit Created Lr</strong>
						</div>
						<div class="card-body card-block">
							<form action="${pageContext.request.contextPath}/insertEditedLR"
								method="post" id="submitLr">
								<div class="row">
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">From</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="fromId" name="fromId" class="standardSelect"
														tabindex="1" required="required">
														<option value="${lrDetails.fromId}">${lrDetails.officeName}</option>
														
													</select>
												</div>			
											</div>

											<div class="col-md-2">To:</div>
											<div class="col-md-3">
												<div class="input-group">
													 <input type="hidden" id="clientIdForAdd" name="lrHeaderId" value="${lrDetails.lrHeaderId}" />
													  <input type="hidden" id="invHeaderId" name="invHeaderId" value="${lrDetails.invHeaderId}" />
													 <input type="hidden" id="lrNo" name="lrNo" value="${lrDetails.lrNo}" />

													<input class="form-control" name="consignorAddress"
														id="consignorAddress" type="text" value="${lrDetails.consigneeAddress}" disabled /> <span
														class="error" aria-live="polite"></span>


												</div>
											</div>

											<div class="col-md-2"></div>

											<!-- <div class="col-md-1">LR No.</div>
											<div class="col-md-1">

												<div class="input-group">
													<input class="form-control" name="staffName" id="staffName"
														type="text" required value="1"
														oninvalid="setCustomValidity('Please enter name ')"
														onkeyup="try{setCustomValidity('')}catch(e){}" /> <span
														class="error" aria-live="polite"></span>

												</div>
											</div> -->
										</div>
									</div>

									&nbsp;

									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">CONSIGNOR:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="consignor" name="consignor"
														class="standardSelect" tabindex="1">
														<c:forEach items="${clientList}" var="clientList">
														<c:choose>
														<c:when test="${clientList.clientId==lrDetails.consignor }">
														<option selected value="${lrDetails.consignor}">${lrDetails.consignorName}</option>
														</c:when>
														<c:otherwise>
														<option value="${clientList.clientId}">${clientList.clientName}</option>
														</c:otherwise>
														</c:choose>
														
														</c:forEach>
														
														
													</select> <%-- <a href="${pageContext.request.contextPath}/showClientReg"><span
														style="color: blue">If client not found?</span></a> --%>
												</div>
											</div>

											<div class="col-md-2">DATE:</div>
											<div class="col-md-5">
												<div class="input-group">

													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input type="text" id="datepicker" name="lrDate" autocomplete="off"
														required="required" value="${lrDetails.lrDate}">

												</div>
											</div>

										</div>
									</div>


									&nbsp;

									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">CONSIGNEE:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="consigneeId" name="consigneeId"
														class="standardSelect" tabindex="1">
														<c:forEach items="${clientList}" var="clientList">
														<c:choose>
														<c:when test="${clientList.clientId==lrDetails.consigneeId }">
														
														<option selected value="${lrDetails.consigneeId}">${lrDetails.consigneeName}</option>
														</c:when>
														<c:otherwise>
														<option value="${clientList.clientId}">${clientList.clientName}</option>
														</c:otherwise>
														</c:choose>
													</c:forEach>
													</select> 
												</div>
											</div>

											<div class="col-md-2">TRUCK No.:</div>
											<div class="col-md-3">
												<div class="input-group">

													<%-- <input class="form-control" name="truckNo" id="truckNo" value="${lrDetails.truckNo}"
														type="text"/> <span class="error"
														aria-live="polite"></span> --%>
														
													<select id="vehId" name="vehId"
														class="standardSelect" tabindex="1">
														<option value="">select</option>
														<c:forEach items="${vehicleDetailsList}" var="vehicleDetailsList">
														<option value="${vehicleDetailsList.vehNo}">${vehicleDetailsList.vehNo}</option>
														</c:forEach>
													</select> 	

												</div>
											</div>

											<div class="col-md-2"></div>
										</div>
									</div>


									&nbsp;

									<div class="col-xs-12 col-sm-12">
										<div class="row">


											<div class="col-md-2">Payment By:</div>
											<div class="col-md-2">To Be Billed</div>
											<div class="col-md-1">
												<div class="input-group">
												<c:choose>
													<c:when test="${lrDetails.paymentBy ==0}">
													<input class="form-control" name="paymentBy" id="paymentBy"
														type="radio" value="0" checked/> <span class="error"
														aria-live="polite" ></span>
													</c:when>
													<c:otherwise>
												    <input class="form-control" name="paymentBy" id="paymentBy"
														type="radio" value="0"/> <span class="error"
														aria-live="polite"></span>
													</c:otherwise>

												</c:choose>
												</div>
											</div>
											<div class="col-md-2"></div>

											<div class="col-md-1">To Pay</div>

											<div class="col-md-1">
												<div class="input-group">
													
													<c:choose>
													<c:when test="${lrDetails.paymentBy==1}">
													<input class="form-control" name="paymentBy" id="paymentBy"
														type="radio" value="1" checked/> <span class="error"
														aria-live="polite" ></span>
													</c:when>
													<c:otherwise>
													<input class="form-control" name="paymentBy" id="paymentBy"
														type="radio" value="1"/> <span class="error"
														aria-live="polite"></span>
													</c:otherwise>

												</c:choose>
													
													

												</div>
											</div>
											
											<div class="col-md-1">Paid</div>

											<div class="col-md-1">
												<div class="input-group">
													
													<c:choose>
													<c:when test="${lrDetails.paymentBy==2}">
													<input class="form-control" name="paymentBy" id="paymentBy"
														type="radio" value="2" checked/> <span class="error"
														aria-live="polite" ></span>
													</c:when>
													<c:otherwise>
													<input class="form-control" name="paymentBy" id="paymentBy"
														type="radio" value="2"/> <span class="error"
														aria-live="polite"></span>
													</c:otherwise>

												</c:choose>
													
													

												</div>
											</div>
											
											
										</div>
									</div>

									&nbsp;

									<hr>
									<div class="col-xs-12 col-sm-12">
										<div class="row">

											<div class="col-md-2">WEIGHT</div>
											<div class="col-md-2">
												<div class="input-group">

													<input class="form-control" name="weight" id="weight"
														type="number" required min="0" value="${lrDetails.weight}" /> <span
														class="error" aria-live="polite"></span>
												</div>
											</div>

											<div class="col-md-2">FREIGHT</div>
											<div class="col-md-2">
												<div class="input-group">

													<input class="form-control" name="freight" id="freight"
														type="text" value="${lrDetails.freight}" min="0" onkeyup="getTotal()" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>

											<div class="col-md-2">GST</div>
											<div class="col-md-2">

												<div class="input-group">

													<input class="form-control" name="gst" id="gst"
														type="text" value="${lrDetails.gst}" min="0" onkeyup="getTotal()" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>


										</div>
									</div>

									&nbsp;

									<hr>
									<div class="col-xs-12 col-sm-12">
										<div class="row">



											<div class="col-md-2">HAMALI</div>
											<div class="col-md-2">

												<div class="input-group">

													<input class="form-control" name="hamali" id="hamali"
														type="text" value="${lrDetails.hamali}" min="0" onkeyup="getTotal()" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" /> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>

											<div class="col-md-2">B. C. CHARGE</div>
											<div class="col-md-2">
												<div class="input-group">

													<input class="form-control" name="bccharge" id="bccharge"
														type="text" required value="${lrDetails.bcCharge}" min="0"
														onkeyup="getTotal()" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span class="error"
														aria-live="polite"></span>
												</div>
											</div>

											<div class="col-md-2">KATA</div>
											<div class="col-md-2">
												<div class="input-group">

													<input class="form-control" name="kata" id="kata" value="${lrDetails.kata}"
														type="text" min="0" onkeyup="getTotal()" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>



										</div>
									</div>

									&nbsp;

									<hr>
									<div class="col-xs-12 col-sm-12">
										<div class="row">


											<div class="col-md-2">LOCAL TEMPO</div>
											<div class="col-md-2">

												<div class="input-group">

													<input class="form-control" name="localtempo"
														id="localtempo" value="${lrDetails.localTempo}" type="text" min="0"
														onkeyup="getTotal()" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span class="error"
														aria-live="polite"></span>

												</div>
											</div>

											<div class="col-md-2">BHARAI</div>
											<div class="col-md-2">
												<div class="input-group">

													<input class="form-control" name="bharai" id="bharai"
														type="text" min="0" required value="0"
														onkeyup="getTotal()" value="${lrDetails.bharai}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span class="error"
														aria-live="polite"></span>
												</div>
											</div>

											<div class="col-md-2">DD CHARGES</div>
											<div class="col-md-2">
												<div class="input-group">

													<input class="form-control" name="ddcharges" id="ddcharges"
														type="text" min="0" onkeyup="getTotal()" value="${lrDetails.ddCharges}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span
														class="error" aria-live="polite"></span>

												</div>
											</div>



										</div>
									</div>
									&nbsp;
									<div class="col-xs-12 col-sm-12">
										<div class="row">


											<div class="col-md-4"></div>
											<div class="col-md-4"></div>

											<div class="col-md-2">
												<strong>TOTAL</strong>
											</div>
											<div class="col-md-2">

												<div class="input-group">

													<input class="form-control" name="total" id="total"
														type="text" value="${lrDetails.total}" readonly oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span class="error"
														aria-live="polite"></span>

												</div>
											</div>

										</div>
									</div>

								</div>



								&nbsp;
								<hr>
								<strong>Invoice Details</strong>
								<hr>
								<div class="col-xs-12 col-sm-12">
									<div class="row">

										<div class="col-md-1">Invoice No.</div>
										<div class="col-md-3">
											<div class="input-group">

												<input class="form-control" name="invoiceNo" id="invoiceNo"
													type="text" value="" /> <span class="error"
													aria-live="polite"></span>
											</div>
										</div>


										<div class="col-md-2">
											<div class="input-group">

												<input type="button" onclick="addInvoice()" value="add" />

											</div>
										</div>

										<!-- 	<div class="col-md-2">Invoice Numbers</div> -->
										<div class="col-md-6">

											<div class="input-group">
												<table id="invoiceTable" class="table">
													<thead>
														<th>Sr No</th>
														<th>Invoice Numbers</th>
														<th>Action</th>
													</thead>
													<tbody>
													<c:forEach items="${transactionLrInvoiceDetailList}" var="transactionLrInvoiceDetailList" varStatus="count">
														<tr>
														<td>${count.index+1}</td>
														<td>${transactionLrInvoiceDetailList.invNo}</td>
														<td>
														<div class="fa-hover col-lg-3 col-md-6">
														<a style='cursor:pointer; color:blue;' onclick="deleteInvoice(${transactionLrInvoiceDetailList.detailId},${count.index})"><i
														class="fa fa-trash-o"></i> <span class="text-muted"></span></a>
														
														</div>
										
										</td>
														</tr>
													</c:forEach>
													</tbody>
												</table>

											</div>
										</div>

									</div>
								</div>



								&nbsp;
								<hr>
								<strong>Containt Details</strong>
								<hr>
								<div class="col-xs-12 col-sm-12">
									<div class="row">
										
										<div class="col-md-2">No. of Contains</div>
										<div class="col-md-1">
											<div class="input-group">

												<input class="form-control" name="noOfContaint"
													id="noOfContaint" type="text" value="" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/> <span
													class="error" aria-live="polite"></span>
											</div>
										</div>

										<div class="col-md-1">Goods:</div>
										<div class="col-md-3">
											<div class="input-group">
												
												<select id="goodsId" name="goodsId"
														class="standardSelect" tabindex="1">
														<option value=""></option>
														<c:forEach items="${goodsList}" var="goodsList">

															<option value="${goodsList.goodsId}">${goodsList.goodsName}
															</option>
														</c:forEach>


												</select>
												

											</div>
										</div>

										<div class="col-md-1">Description</div>
										<div class="col-md-2">

											<div class="input-group">
												<textarea class="form-control" name="description"
													id="description" type="text" value="1" row="2"></textarea>
												<span class="error" aria-live="polite"></span>

											</div>
										</div>
										<div class="col-md-1">
											<input type="button" value="add" onclick="addContaints()" />
										</div>
									</div>
								</div>



								&nbsp;
								<hr>
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Sr. No.</th>
											<th>No. of Contains</th>
											<th>Goods</th>
											<th>Description</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
						 	<c:forEach items="${lrContaintDetailsList}" var="lrContaintDetailsList" varStatus="count">
										<tr>
										<td>${count.index+1}</td>
										<td>${lrContaintDetailsList.noOfContaints}</td>
										<td>${lrContaintDetailsList.goodsName}</td>
										<td>${lrContaintDetailsList.description}</td>
										 <td><div class="fa-hover col-lg-3 col-md-6">
										<a style="cursor:pointer; color:blue;" onclick="deleteContaint(${lrContaintDetailsList.detailId},${count.index})"><i class="fa fa-trash-o"></i> <span class="text-muted"></span></a>
														
														</div>
										
										</td> 
										
										</tr>
									
									</c:forEach>
									
									</tbody>

								</table>

								<div class="col-lg-12" align="center">


									<button type="submit" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;">
										Submit</button>
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
                disable_search_threshold: 3,
                no_results_text: "Oops, nothing found!",
                width: "100%"
            });
        });
    </script>

	<script type="text/javascript">
        $(document).ready(function() {
           $('#bootstrap-data-table-export').DataTable(); 


          $("#flowcheckall").click(function () {
              $('#bootstrap-data-table tbody input[type="checkbox"]').prop('checked', this.checked);
          });
          
        } );
    </script>


	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
  $( function() {
	  $('input[id$=datepicker]').datepicker({
		    dateFormat: 'dd-mm-yy',
		    maxDate: new Date()
		});
  } );
  </script>
  
  <script type="text/javascript">
function getTotal(){
	
	var freight=document.getElementById("freight").value;
	var gst=document.getElementById("gst").value;
	
	var hamali=document.getElementById("hamali").value;
	var bccharge=document.getElementById("bccharge").value;
	var kata=document.getElementById("kata").value;
	var localtempo=document.getElementById("localtempo").value;
	var bharai=document.getElementById("bharai").value;
	var ddcharges=document.getElementById("ddcharges").value;
				
	var total=Number(freight)+Number(gst)+Number(hamali)+Number(bccharge)+Number(kata)+Number(localtempo)+Number(bharai)+Number(ddcharges);
	document.getElementById("total").value=total;
	
	
}

</script>
	
	<script type="text/javascript">
var dataTable = $('#bootstrap-data-table').DataTable();
function addContaints(){
	var noOfContaint=document.getElementById("noOfContaint").value;
	var goodsId=document.getElementById("goodsId").value;
	var description=document.getElementById("description").value;
	var goodsName=$("#goodsId option:selected").html();
	
	
$.getJSON('${addContaint}', {
		
	noOfContaint : noOfContaint,
	goodsId: goodsId,
	description: description,
	goodsName: goodsName,
	ajax : 'true'
		
	}, function(data) {
			dataTable.clear().draw();
		 $.each(
					data,
					function(key, lrContaintDetailsList) {
						
				
			  dataTable.row.add(  [key+1 ,lrContaintDetailsList.noOfContaints,  lrContaintDetailsList.goodsName, lrContaintDetailsList.description,
		                 '<a style="cursor:pointer; color:blue;" onclick="deleteContaint('+lrContaintDetailsList.detailId+','+key+')"><i class="fa fa-trash-o"></i> <span class="text-muted"></span></a>' ] ).draw();
			
					});
		

	});

}

function deleteContaint(index,key){
	
	//window.open("${pageContext.request.contextPath}/deleteContaint?index="+index,"_self");
		alert("cd");
	$.getJSON('${deleteEditedContaint}', {
		
		key:key,
		index: index,
		ajax : 'true'
			
		}, function(data) {
				
			dataTable.clear().draw();
			
				$.each(
						data,
						function(key, lrContaintDetailsList) {
			
							 dataTable.row.add(  [key+1 ,lrContaintDetailsList.noOfContaints,  lrContaintDetailsList.goodsName, lrContaintDetailsList.description,
				                 '<a style="cursor:pointer; color:blue;" onclick="deleteContaint('+lrContaintDetailsList.detailId+','+key+')"><i class="fa fa-trash-o"></i> <span class="text-muted"></span></a>' ] ).draw();
				
						});
			

		});
}
</script>



	<script type="text/javascript">
function addInvoice(){
	
	
	var invoiceNo=document.getElementById("invoiceNo").value;
	$.getJSON('${addInvoiceNumber}', {
		
			invoiceNo: invoiceNo,
			ajax : 'true'
			
		}, function(data) {
			
			$('#invoiceTable td').remove();
				
			 $.each(
						data,
						function(key, transactionLrInvoiceDetailList) {
			
							
							
							var tr = $('<tr></tr>');
							
							tr.append($('<td></td>').html(key+1));
							tr.append($('<td></td>').html(transactionLrInvoiceDetailList.invNo));
							tr.append($('<td></td>').html("<a style='cursor:pointer; color:blue;' onclick='deleteInvoice("+transactionLrInvoiceDetailList.detailId+","+key+")'><i class='fa fa-trash-o'></i> </a>"));
						
				
							$('#invoiceTable tbody').append(tr);
						
				
						});			
			 
			
		});

	}
	
	
function deleteInvoice(index,key){
	
	//window.open("${pageContext.request.contextPath}/deleteContaint?index="+index,"_self");

	$.getJSON('${deleteEditedInvoice}', {
		
		key:key,
		index: index,
			ajax : 'true'
			
		}, function(data) {
				
			$('#invoiceTable td').remove();
			
				$.each(
						data,
						function(key, transactionLrInvoiceDetailList) {
							

							var tr = $('<tr></tr>');
							
							tr.append($('<td></td>').html(key+1));
							tr.append($('<td></td>').html(transactionLrInvoiceDetailList.invNo));
							tr.append($('<td></td>').html("<a style='cursor:pointer; color:blue;' onclick='deleteInvoice("+transactionLrInvoiceDetailList.detailId+","+key+")'><i class='fa fa-trash-o'></i> </a>"));
						
							//var str="<tr><td>"+key+1+"</td><td>"+transactionLrInvoiceDetailList.invNo+"</td><td><a href='#' onclick='deleteInvoice("+key+")'><i class='fa fa-trash-o'></i> <span class='text-muted'></span></a></td></tr>";
							//dataTable.row.add(  [key+1 ,transactionLrInvoiceDetailList.invoiceNo,'<a href="#" onclick="deleteInvoice('+key+')"><i class="fa fa-trash-o"></i> <span class="text-muted"></span></a>' ] ).draw();
							$('#invoiceTable tbody').append(tr);
						});
			//	 $("#invoiceTable tbody").append(str);
			

		});
}
</script>


	<script type="text/javascript">
	function getClientAddress(){
		
		
	var clientId=document.getElementById("consigneeId").value;
	

	
	var jsList = new Array();
	<c:forEach items="${clientList}" var="clientList" varStatus="status"> 
	
	 var client = "<c:out value="${clientList.clientId}"/>";
	   if(client==clientId){
		   var clientAddress="<c:out value="${clientList.clientAddress}"/>";
		   
			document.getElementById("consignorAddress").value=clientAddress;
	   }
	</c:forEach> 
	}
	
	
	
	
	$('#submitLr').submit(function() {
		$('#loader').addClass("loader");
		$('#bgbdy').addClass("bg-body");
	});
	</script>




</body>
</html>