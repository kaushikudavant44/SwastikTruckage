<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html > <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sufee Admin - HTML5 Admin Template</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/cs-skin-elastic.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/scss/style.css">
    <link href="${pageContext.request.contextPath}/resources/assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>
<body>
<c:url var="deleteClientById" value="/deleteClientById" />

<div  ><jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>


    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <div  ><jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>
        
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
                            <li class="active">Dashboard</li>
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
 
 <div class="row">

				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Lr Details</strong>
						</div>
						  <form action="${pageContext.request.contextPath}/saveClientBillDetails" method="GET" id="generateBill">
						<div class="card-body">
            
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
									    <th>select</th>
										<th>Lr No</th>
										<th>Payment By</th>
										<th >Total</th>
										

									</tr>
								</thead>
								<tbody>
								<c:forEach items="${transactionLrHeader}" var="transactionLrHeader" varStatus="count">
									
						<tr>
						
						<c:choose>
                              <c:when test="${transactionLrHeader.paymentBy==0}">
                              
  							<td><input type="checkbox" value="${transactionLrHeader.lrHeaderId}" name="${transactionLrHeader.paymentBy}"></td>
  							
  							</c:when>
  							<c:when test="${transactionLrHeader.paymentBy==1}">
                              
  							<td><input type="checkbox" value="${transactionLrHeader.lrHeaderId}" name="${transactionLrHeader.paymentBy}"></td>
  							
  							</c:when>
  							</c:choose>
						
						
						
							
							<td>${transactionLrHeader.lrNo}</td>
										 <c:choose>
                              <c:when test="${transactionLrHeader.paymentBy==0}">
                              
  							<td>Consignee</td>
  							
  							</c:when>
  							<c:when test="${transactionLrHeader.paymentBy==1}">
                              
  							<td>Consignor</td>
  							
  							</c:when>
  							</c:choose>
										
										<td>${transactionLrHeader.total}</td>
										
										
									</tr>
									
									</c:forEach>
								</tbody>
							</table>                       
						</div>
						<div class="col-sm-12 text-center">
							
<button type="button" class="btn btn-primary" onclick="validateType()">
										Generate
									</button>							
							</div>
						</form>
					</div>
				</div>


			</div>

 </div>
</div>
        
  
    <div align="center" ><jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

        </div> <!-- .content -->
    </div><!-- /#right-panel -->

    <!-- Right Panel -->
    
    
    

   
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
    

<script>

function deleteClient(clientId){
	
	
	if(confirm("Delete Slected Item?!!"))
		{
	$.getJSON('${deleteClientById}', {
		
		clientId : clientId,
		ajax : 'true'
		
	}, function(data) {
		
		if(data.message=="success"){
			
			location.reload();
			alert("Client record delete successfully");
		}

	});
	}
	
}

function validateType()
{
	
	 if($('input[name=0]:checked').length > 0 && $('input[name=1]:checked').length > 0)
 	{
 	alert("failed");
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
    	 alert("please select ");
    	 }
 	} 
 	
    
}
function checkAdult(age) {
    return age == 1;
}

function myFunction() {
  alert(ages.every(checkAdult));
}
</script>
</body>
</html>
