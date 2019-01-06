<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Swastik Truckage</title>


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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/cardview.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/lib/chosen/chosen.min.css">	

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
 <c:url var="getBillListByClientId" value="/getBillListByClientId" />
 <c:url var="getLrByBillHeader" value="/getLrByBillHeader" />

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
						<li><a href="#">Bill Detaila</a></li>
						
					</ol>
				</div>
			</div>
		</div>
	</div>
	

	<div class="content mt-3">
		<div class="animated fadeIn">
		
		
		
				<div class="row">

				<div class="col-xs-12 col-sm-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong>Search LR DateWise</strong>
						</div>
						<div class="card-body card-block">
					
				
        <div class="row">
             <div class="col-sm-6 col-md-1">          
                  <label>From Date </label>
             </div>
             
             <div class="col-sm-6 col-md-2">
              <input type="text" id="datepicker" name="" readonly value="" class="form-control form-control-sm datepicker" >             
             </div>
             
              <div class="col-sm-6 col-md-1">  
             <label>To Date </label>
             </div>
             
              <div class="col-sm-6 col-md-2">
          <input type="text" id="datepicker1" name="to"  value=""  readonly class="form-control form-control-sm datepicker" >
            
             </div>
             <div class="col-sm-6 col-md-1">          
                  <label>Clinet </label>
             </div>
             <div class="col-sm-6 col-md-4">          
                 <select id="clientId" 
														class="standardSelect">
														<option value=""></option>
														<c:forEach items="${clientList}" var="clientList">


															<option value="${clientList.clientId}">${clientList.clientName}
																</option>
														</c:forEach>
													</select> 
             </div>
             
             <div class="col-sm-6 col-md-1">
							
             <button type="button" class="btn btn-primary" onclick="getBill()">
				Generate
			 </button>							
							</div>
							</div>
						</div>


					</div>




				</div>

			</div>
		
	
		
		<!-- Devide -->
		
		
			<div class="row">

				<div class="col-md-12">
					<div class="cardview">
						<div class="cardview-header">
							<strong class="card-title">Data Table</strong>
						</div>
						<div class="card-body">

							<table id="billList"
								class="table table-striped table-bordered">
								<thead>
									<tr>
									    <th>Bill No</th>
										<th>Bill Date</th>
										<th>Bill total</th>
										<th>Payment By</th>
										<th>Action</th>
										
									</tr>
								</thead>
								<tbody>
								
								
								</tbody>
							</table>

<div class="col-sm-12 text-center">

													<button type="button" class="btn btn-primary" style="color:white;">
														 <a href="${pageContext.request.contextPath}/showExcel/2" style="color:white;">excel</a></button>
												</div>
							
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
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>			
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/chosen/chosen.jquery.min.js"></script>
	<script>
		$(function() {
			$('input[id$=datepicker]').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
		
		$(function() {
			$('input[id$=datepicker1]').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
		
	</script>
	

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
          $('#bootstrap-data-table1').DataTable({
        	  columnDefs: [
      	        { targets: [1], className:"right" },
      	    ]
          });
        } );
    </script>
 
   <script>
   

   function getBill()
   {	 
   	
   	var clientId = document.getElementById("clientId").value;
   	var fromDate = document.getElementById("datepicker").value;
   	var toDate = document.getElementById("datepicker1").value;
   	
   	if(clientId!="" && fromDate!="" && toDate!="")
   		{
   	 $
   		.getJSON(
   				'${getBillListByClientId}',
   				{
   					clientId : clientId,
   					fromDate : fromDate,
   					toDate : toDate,
   					
   					ajax : 'true'
   				},
   				function(data) {		
   					
   					if(data!=null)
   						{
   						$('#billList td').remove();
   						$.each(
   								data,
   									function(key, data) {

   					var tr = $('<tr></tr>');
   					
   					tr.append($('<td></td>').html(data.billNo));
   					tr.append($('<td></td>').html(data.billDate));
   					tr.append($('<td></td>').html(data.billTotal));
   					
   					if(data.billPayableBy==0)
   						{
   					tr.append($('<td></td>').html("To Be Billed"));
   						}
   					else if(data.billPayableBy==1)
   					{
   				tr.append($('<td></td>').html("To Pay"));
   					}
   					  										  					
tr.append($('<td></td>').html('<div class="panel-heading" role="tab"  id="h'+data.billNo+'"> <a data-toggle="collapse" data-parent="#accordion" href="#c'+data.billNo+'" aria-expanded="true" aria-controls="c'+data.billNo+'" onclick="getLr('+data.billNo+','+data.billHeaderId+')">  submit </a> </div>'));   			   	        	
    
var tr1 = $('<tr></tr>');
tr1.append($('<td colspan="5"></td>').html(' <div id="c'+data.billNo+'" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="h'+data.billNo+'">  <div class="panel-body"> <table width="100%" border="1" id="t'+data.billNo+'"> <tr> <th scope="col">lr No</th> <th scope="col">Date</th><th scope="col">Consignee</th><th scope="col">Consignor</th><th scope="col">Quantity</th><th scope="col">Total</th> </tr><tbody></tbody></table></div></div>'));
   	     $('#billList tbody').append(tr);
   	  $('#billList tbody').append(tr1); 
   	  
   								})
   		   						
   								
   								}
   					else
   						{
   						alert("No LR Found");
   						}
   				 	 
   				
   						
   						}) 
   	 
   		}
   	else
   		{
   		alert("Please Select Date And Client");
   		}
   } 
   
   
   
   function getLr(id,billHeaderId)
   {	 
		$('#t'+id+' td').remove();
   	 $
   		.getJSON(
   				'${getLrByBillHeader}',
   				{
   					billHeaderId : billHeaderId,
   					   					
   					ajax : 'true'
   				},
   				function(data) {		
   					
   					   	$.each(
   								data,
   									function(key, data) {

   					var tr = $('<tr></tr>');
   					
   					tr.append($('<td></td>').html(data.lrNo));
   					tr.append($('<td></td>').html(data.lrDate));
   					tr.append($('<td></td>').html(data.consigneeName));
   					tr.append($('<td></td>').html(data.consignorName));
   					tr.append($('<td></td>').html(data.quantity));
   					tr.append($('<td></td>').html(data.total));
   					
   				  				 
   				$('#t'+id+' tbody').append(tr);
   				 
   								})
   } )
   
   }
   </script>


</body>
</html>




