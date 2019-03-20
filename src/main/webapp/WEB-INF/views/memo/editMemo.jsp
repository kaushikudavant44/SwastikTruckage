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
	<%-- <link
	href="${pageContext.request.contextPath}/resources/assets/css/style.css"
	rel='stylesheet' type='text/css'> --%>

<style type="text/css">
.right {
	text-align: right;
}

.left {
	text-align: left;
}

 table.dataTable tbody tr.selected {
        color: white !important;
        background-color: #5172a0 !important;  /* Not working */
    }
    
    




</style>

<c:url var="getVehicalOwnerDetails" value="/getVehicalOwnerDetails" />
<c:url var="editMemoDetails" value="/editMemoDetails" />
<c:url var="addLrInEditedMemo" value="/addLrInEditedMemo" />

</head>
<body>


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
						<li><a href="#">Memo Details</a></li>
						
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
							<strong>Edit Memo</strong>
						</div>
						<div class="card-body card-block">
							<form action=""
								method="post">
								<div class="row">
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-md-2">From</div>
											<div class="col-md-3">
											<input type="hidden" id="staffId" name="staffId" value="${staffDetails.staffId}" />
											<input type="hidden" id="vehId" name="vehId" value="${getMemoDeatails.vehId}" />
											<input type="hidden" id="memoNo" name="memoNo" value="${getMemoDeatails.memoNo}"/>
											<input type="hidden" id="memoHeaderId" name="memoHeaderId" value="${getMemoDeatails.memoHeaderId}"/>
											<input type="hidden" id="toId" name="toId" value="${getMemoDeatails.toId}"/> 
												<div class="input-group">
												
												
													<select id="fromId" name="fromId" class="standardSelect"
														tabindex="1" required="required">
														<option value=""></option>
														<c:forEach items="${officeList}" var="officeList">

															<c:choose>
																<c:when
																	test="${officeList.officeId==staffDetails.staffOfficeId}">
																	<option selected value="${officeList.officeId}">${officeList.officeName}
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${officeList.officeId}" disabled>${officeList.officeName}
																	</option>
																</c:otherwise>
															</c:choose>

														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="col-md-2">Vehical No.:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="ownerId" name="ownerId"
														class="standardSelect" tabindex="1"
														onchange="getVehicalOwner()">
													
														<option value=""></option>
													<c:forEach items="${vehicalDetailsList}" var="vehicalDetailsList">
													
														<c:choose>
														<c:when test="${vehicalDetailsList.vehId==getMemoDeatails.vehId}">
														<option selected value="${vehicalDetailsList.ownerId}">${vehicalDetailsList.vehNo}</option>
														</c:when>
														<c:otherwise>
														<option value="${vehicalDetailsList.ownerId}">${vehicalDetailsList.vehNo}</option>
														</c:otherwise>
														</c:choose>
													</c:forEach>	


													</select> <a href="${pageContext.request.contextPath}/showVehicleReg"><span
														style="color: blue">If Vehical not found?</span></a>
												</div>
											</div>
											

											<div class="col-md-2"></div>

											
										</div>
									</div>

									
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											

											

											<div class="col-md-2">Vehical Owner:</div>
											<div class="col-md-3">
												<div class="input-group">
												
													<input type="text" id="vehicalOwner" value="${vehicleOwners.ownerName}"  disabled/>
												
												</div>
											</div>
											
											<div class="col-md-2">Driver:</div>
											<div class="col-md-3">
												<div class="input-group">
													<select id="driverId" name="driverId"
														class="standardSelect" tabindex="1"
														onchange="getVehicalOwner()">
													
														<option value=""></option>
													<c:forEach items="${vehicleDriverList}" var="vehicleDriverList">
														
														<c:choose>
														<c:when test="${vehicleDriverList.driverId==getMemoDeatails.driverId}">
														<option selected value="${vehicleDriverList.driverId}">${vehicleDriverList.driverName}</option>
														</c:when>
														<c:otherwise>
														<option value="${vehicleDriverList.driverId}">${vehicleDriverList.driverName}</option>
														</c:otherwise>
														</c:choose>
													
													</c:forEach>	


													</select> <a href="${pageContext.request.contextPath}/showVehicleDriverReg"><span
														style="color: blue">If driver not found?</span></a>
												</div>
											</div>
											<div class="col-md-2"></div>
										</div>
									</div>


									
								</div>							
							</form>
						</div>


					</div>




				</div>

			</div>
		
		
			
			<div class="row">
			
			

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Memo Details</strong>
							
						</div>
						<hr>
						
			<div class="row">
			
						<div class="col-md-4 text-right"><strong>Add Extra LR</strong></div>
											<div class="col-md-4">
												<div class="input-group">
													<input type="text" id="lrNo" name="lrNo" value="" style="width:100%" />
													
												</div>
											</div>
											
									
											<div class="col-md-4">
												<div class="input-group">
													<button type="button" id="addLr" value="" onclick="getReturnLrDetails()" style="background-color: rgb(51, 65, 102); color:#fff; border:none; padding:2px 20px">ADD</button>
													
												</div>
											</div>
											</div>
											<hr>
						<div class="card-body">

							<table id="bootstrap-data-table1"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										
										<th>Sr. No.</th>
										<th>Office Name</th>
										<th>LR Number</th>
										<th>Lr Date</th>
										<th>Consignor</th>
										<th>Consignee</th>
										<th>Particular</th>
										<th>Quantity</th>
										<th>Total Amount</th>
										<th>Payment By</th>
										

									</tr>
								</thead>
								<tbody>
						<c:forEach items="${lrDetailsList}" var="lrDetailsList" varStatus="count">
									<tr data-value="${lrDetailsList.lrHeaderId}" class="selected">
										
										<td>${count.index+1 }</td>
										<td>${lrDetailsList.officeName}</td>
										<td>${lrDetailsList.lrNo}</td>
										<td>${lrDetailsList.lrDate}</td>
										<td>${lrDetailsList.consignor}</td>
										<td>${lrDetailsList.consignee}</td>
										<td>${lrDetailsList.particular}</td>
										<td>${lrDetailsList.quantity}</td>
										<td>${lrDetailsList.amount}</td>
										<td>
										<c:choose>
										
										<c:when test="${lrDetailsList.paymentBy==0}">
										To Be bill
										</c:when>
										<c:otherwise>
										To pay
										</c:otherwise>
										</c:choose>
										
										</td>
										
										<%-- <td><input type="button" value="edit" onclick="editOfficeDetails()"/><input type="button" value="delete" onclick="deleteOffice(${officeList.officeId})"/></td> --%>
									</tr>
								</c:forEach>
							<!-- getAllOfficelrDetailsList -->

							<%-- 	<c:forEach items="${getAllOfficelrDetailsList}" var="getAllOfficelrDetails" varStatus="count">
									
									<c:set var="lrHeader11" value=""/>
									
									
									<c:forEach items="${lrDetailsList}" var="lrDetails" >
										
										<c:if test="${getAllOfficelrDetails.lrHeaderId==lrDetails.lrHeaderId}">
										
									<c:set var="lrHeader11" value="selected"/>
										
										</c:if>
										
										
										
								</c:forEach>
									
	
								<tr data-value="${getAllOfficelrDetails.lrHeaderId}" class="${lrHeader11}" >
										
										<td>${count.index+1 }</td>
										<td>${getAllOfficelrDetails.officeName}</td>
										<td>${getAllOfficelrDetails.lrNo}  ${lrHeader11}</td>
										<td>${getAllOfficelrDetails.lrDate}</td>
										<td>${getAllOfficelrDetails.consignor}</td>
										<td>${getAllOfficelrDetails.consignee}</td>
										<td>${getAllOfficelrDetails.particular}</td>
										<td>${getAllOfficelrDetails.quantity}</td>
										<td>${getAllOfficelrDetails.amount}</td>
										<td>
										<c:choose>
										
										<c:when test="${getAllOfficelrDetails.paymentBy==0}">
										To Be bill
										</c:when>
										<c:otherwise>
										To pay
										</c:otherwise>
										</c:choose>
										
										</td>
										
										<td><input type="button" value="edit" onclick="editOfficeDetails()"/><input type="button" value="delete" onclick="deleteOffice(${officeList.officeId})"/></td>
									</tr>
			
								</c:forEach> --%>


								</tbody>
							</table>

						</div>
					</div>
				</div>


			</div>
			<div class="row">
			<div class="col-lg-12" align="center">
			<div class="card">
						<div class="card-header">

									<button type="submit" class="btn btn-primary"
										style="align-content: center; width: 226px; margin-left: 80px;" onclick="saveMemoDetails()">
										Submit</button>
								</div>
								</div>
								</div>
		</div>
		</div>
		<!-- .animated -->
	</div>
	<!-- .content -->
<div class=" clearfix"></div>



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
          $('#bootstrap-data-table1').DataTable();
        } );
    </script>
    
    <script type="text/javascript">
    var unSelectedRowList=[];
    var selectedRowList =[];
    
    $(document).ready(function() {
    	
    	
    	
    	<c:forEach items="${lrDetailsList}" var="lrDetailsList">

    	var lrHeaderId = "<c:out value="${lrDetailsList.lrHeaderId}"/>";

    	var lrNo = "<c:out value="${lrDetailsList.lrNo}"/>";
    	
    	selectedRowList.push(parseInt(lrHeaderId,10));
    	
		
    	</c:forEach>
    		 	
 	if(selectedRowList!=null && selectedRowList!=""){
			$('#bootstrap-data-table1 tbody tr').addClass('selected');
			
		}

	    var table = $('#bootstrap-data-table1').DataTable();
	 
	    $('#bootstrap-data-table1 tbody').on( 'click', 'tr', function () {
	   	
	    	 if ( $(this).hasClass('selected') ) {
	    		 
	    		 
	    		 
	    		 var index=selectedRowList.indexOf($(this).data('value'));
	    		 
	    	
	    		 
	    		 if($.inArray($(this).data('value'), unSelectedRowList) === -1) unSelectedRowList.push($(this).data('value'));
	    	/* 	 unSelectedRowList.push($(this).data('value')); */
	    		 
	    		 if(index >-1){
	    			 
	    			 selectedRowList.splice(index,0);
	    			 unSelectedRowList.splice(index,0);
	    			 
	    		 }
	    		 
	    		
	             $(this).removeClass('selected');
	            
					
	    	 }else{
	    		 /* selectedRowList.push($(this).data('value')); */
	    		 if($.inArray($(this).data('value'), selectedRowList) === -1) selectedRowList.push($(this).data('value'));
	            
	    		 $(this).addClass('selected');
	    	
	    }
	      
	    } );
	 	  
	} );
	
    
    </script>
<script type="text/javascript">

	
	function saveMemoDetails(){
		
		 $('#loader').addClass("loader");
		$('#bgbdy').addClass("bg-body");
		var officeId=document.getElementById("fromId").value;
		
		var toId=document.getElementById("toId").value;
		
		var ownerId=$("#ownerId option:selected").html();
		
		var driverId=document.getElementById("driverId").value;
		
		var staffId=document.getElementById("staffId").value;
				
		var memoNo=document.getElementById("memoNo").value;
		
		var memoHeaderId=document.getElementById("memoHeaderId").value;
			
		$.getJSON('${editMemoDetails}', {
			
			memoHeaderId:memoHeaderId,
			memoNo:memoNo,
			officeId:officeId,
			toId:toId,
			ownerId: ownerId,
			driverId:driverId,
			staffId:staffId,
			unSelectedRowList:JSON.stringify(unSelectedRowList),
			selectedRowList:JSON.stringify(selectedRowList),
			
			ajax : 'true'
			
		}, function(data) {
			
			
			/* alert(data.message); */
			
			 $('#loader').addClass("hide-loader");
			 $('#bgbdy').removeClass("bg-body");
			window.open("${pageContext.request.contextPath}/showMemo",'_self');
		
		});
		
	}
	
	</script>
<script type="text/javascript">

function getVehicalOwner(){
	
	var ownerId=document.getElementById("ownerId").value;
	
	
	$.getJSON('${getVehicalOwnerDetails}', {
		
		ownerId: ownerId,
		ajax : 'true'
		
	}, function(data) {
		
		
		document.getElementById("vehicalOwner").value=data.ownerName;
	});
}

</script>

<script type="text/javascript">

var selectedLrHeaderId=[];
var srNo=document.getElementById("bootstrap-data-table1").getElementsByTagName("tr").length-1;



function getReturnLrDetails(){
			
	var lrNo=document.getElementById("lrNo").value;
	
	$.getJSON('${addLrInEditedMemo}', {
		
		lrNo: lrNo,
		ajax : 'true'
		
	}, function(data) {
		
		
		selectedRowList.push(data.lrHeaderId);
		
						srNo++;
						var tr = $('<tr id="'+data.lrHeaderId+'" class="selected"></tr>');
						tr.append($('<td></td>').html(srNo));
						tr.append($('<td></td>').html(data.officeName));
						tr.append($('<td></td>').html(data.lrNo));
						tr.append($('<td></td>').html(data.lrDate));
						tr.append($('<td></td>').html(data.consignor));
						tr.append($('<td></td>').html(data.consignee));
						tr.append($('<td></td>').html(data.particular));
						tr.append($('<td></td>').html(data.quantity));
						tr.append($('<td></td>').html(data.amount));
						if(data.paymentBy==0){
						tr.append($('<td></td>').html("To Be bill"));
						}else if(data.paymentBy==1){
							tr.append($('<td></td>').html("To Pay"));
						}else{
							tr.append($('<td></td>').html("Paid"));
						}
						/* <c:if test="${operationOfAccessRight.mdelete==1}"> 
						tr.append($('<td></td>').html("<a style='cursor:pointer; color:blue;' onclick='deleteLr("+data.lrHeaderId+")'><i class='fa fa-trash-o'></i> </a>"));
						</c:if> */
			
						$('#bootstrap-data-table1 tbody').append(tr);
					
						alert("Lr "+data.lrNo+" added successfully");
					});			
		 
		
	
	
}

</script>

</body>
<div id="bgbdy"></div>
<div id="loader">
</div>


</html>