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
<c:url var="lrDetailsByLrNo" value="/lrDetailsByLrNo" />

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
					<div class="card">
						<div class="card-header">
							<strong>Search By LR No</strong>
						</div>
						<div class="card-body card-block">

       <%--  <div class="row">
             <div class="col-sm-6 col-md-1">
             
             <label>Bill To :</label>
             
             </div>
              <div class="col-sm-6 col-md-2">
<input type="text"  value="${clientDetails.billingName}" class="form-control form-control-sm " readonly>
              
              </div>
              <div class="col-sm-6 col-md-1">
             </div>
              <div class="col-sm-6 col-md-1">
             
             <label>GSTIN :</label>
             
             </div>
             <div class="col-sm-6 col-md-2">
             
             <input type="text"  name="to" value="${clientDetails.gstin}" class="form-control form-control-sm" readonly>
             </div>
             <div class="col-sm-6 col-md-1">
             </div>
                    <div class="col-sm-6 col-md-1">
             
             <label>ContactNo :</label>
             
             </div>
              <div class="col-sm-6 col-md-2">
<input type="text"  value="${clientDetails.clientContactNo}" class="form-control form-control-sm " readonly>
              
              </div>
            
             
			</div> --%>
			
			<div class="row">
          <div class="col-sm-6 col-md-1">             
             <label>LR No :</label>
             
             </div>
              <div class="col-sm-6 col-md-2">
<input type="text"  value="" class="form-control form-control-sm" id="lrNo" name="lrNo">             
              </div>
              
               <div class="col-sm-6 col-md-1">
             </div>
             
             <div class="col-sm-6 col-md-3">
							
             <button type="button" class="btn btn-primary" onclick="addLR()">
				ADD
			 </button>							
							</div>
                 </div>
						
	          </div>

            </div>

	  </div>

</div>
		
		
		
			<div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<div class="row">
             <div class="col-sm-6 col-md-1">
             
             <label>Bill To :</label>
             
             </div>
              <div class="col-sm-6 col-md-2">
<input type="text"  value="${clientDetails.billingName}" class="form-control form-control-sm " readonly>
              
              </div>
              <div class="col-sm-6 col-md-1">
             </div>
              <div class="col-sm-6 col-md-1">
             
             <label>GSTIN :</label>
             
             </div>
             <div class="col-sm-6 col-md-2">
             
             <input type="text"  name="to" value="${clientDetails.gstin}" class="form-control form-control-sm" readonly>
             </div>
             <div class="col-sm-6 col-md-1">
             </div>
                    <div class="col-sm-6 col-md-1">
             
             <label>ContactNo :</label>
             
             </div>
              <div class="col-sm-6 col-md-2">
<input type="text"  value="${clientDetails.clientContactNo}" class="form-control form-control-sm " readonly>
              
              </div>
            
             
			</div>
									</div>
						<div class="card-body">
<form action="${pageContext.request.contextPath}/saveClientBillDetails" method="GET" id="generateBill">
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
									   
										<th>Lr No</th>
										<th>Payment By</th>
										<th >Total</th>
										

									</tr>
								</thead>
								 <tbody>
								
								
								
								</tbody>
							</table>

<div class="col-sm-12 text-center">
							
<button type="submit" class="btn btn-primary" >
										Generate
									</button>							
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
                        setTimeout(function() {
    $('#messageAnimation').fadeOut('slow');
}, 5000);
                        </script>
    

<script>

function addLR()
{	 
	
	var lrNo = document.getElementById("lrNo").value; 
	$('#bootstrap-data-table td').remove();
	 $
		.getJSON(
				'${lrDetailsByLrNo}',
				{
					lrNo : lrNo,
					
					ajax : 'true'
				},
				function(data) {		
					
					if(data!=null)
{
					var tr = $('<tr></tr>');
					
					tr.append($('<td></td>').html(data.lrNo));
					if(data.paymentBy==0)
						{
					tr.append($('<td></td>').html("Consignee"));
						}
					else(data.paymentBy==1)
					{
				tr.append($('<td></td>').html("Consignor"));
					}
					
					tr.append($('<td></td>').html(data.total));
													
				 	 $('#bootstrap-data-table tbody').append(tr);
				}
				else
					{
					alert("Bill Has Been Already Generated");
					}

				})  
      
	 
} 


function validateType()
{
	
	 if($('input[name=0]:checked').length > 0 && $('input[name=1]:checked').length > 0)
 	{
 	alert("Select Either Consignee or Consigner");
 	location.load();
 	}
     else
 	{
     if($('input[name=0]:checked').length > 0 || $('input[name=1]:checked').length > 0)	 
    	 {
    	 $('#generateBill').submit();
    	 }
     else
    	 {
    	 alert("minimum one selection is required");
    	 }
 	} 
 	
    
}
</script>


</body>
</html>