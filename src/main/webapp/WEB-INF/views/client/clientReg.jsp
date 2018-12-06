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
<c:url var="getCityByStateId" value="/getCityByStateId" />

<div  ><jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>



    <div id="right-panel" class="right-panel">

      
        <div  ><jsp:include page="/WEB-INF/views/common/right.jsp"></jsp:include>
       
  <div class="content mt-3">
 
 <div class="form-group ">
                        <div class="col-lg-5"></div>
                         <div class="col-lg-5">
                        <p style="position: absolute; color: black; background-color: #9bf79b; border-radius: 3px;" id="messageAnimation">${message}</p>
         </div> 
         </div>
 <br>
 <div class="row">
 <form action="${pageContext.request.contextPath}/insertClientInfo" method="POST">
 
  <div class="col-lg-3">
 </div> 
 
 		<div class="col-lg-6">
					<div class="card">
						<div class="card-header">
							<h4>Client Registration</h4>
						</div>
						<div class="card-body">
							<div class="row">
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Full Name</label>
										<input required name="name" class="form-control">							
							</div>							
							</div>
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Contact No</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-phone"></i>
									</div>
									<input required class="form-control" name="contactNo">
								</div>
							</div>
							</div>
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Select State</label>
								
							<select required data-placeholder="Choose a Country..."
								class="standardSelect form-control" tabindex="1" id="stateId" name="stateId" onchange="getCityList()">
								<option>--select--</option>
                             
								<c:forEach items="${stateList}" var="stateList"
									varStatus="count">
									<option value="${stateList.stateId}"><c:out
											value="${stateList.stateName}" /></option>
								</c:forEach>
							</select>
						
							</div>
							
							</div>
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Select City</label>
								
							<select required data-placeholder="Choose a Country..."
								class="standardSelect form-control" tabindex="1" id="cityId" name="cityId" >
											
							</select>
							</div>
						</div>
							
							<div class="col-sm-12 col-md-12">
							<div class="form-group">
								<label class=" form-control-label">Address</label>
										<textarea required  class="form-control" name="address"></textarea>							
							</div>							
							</div>
							
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">Pincode</label>
										<input required class="form-control" name="pincode">							
							</div>							
							</div>
							<div class="col-sm-6 col-md-6">
							<div class="form-group">
								<label class=" form-control-label">GST</label>
										<input required class="form-control" name="gst">							
							</div>							
							</div>
							
							<br>
							<br>
							<div class="clearfix"></div>
							<br>
							<hr>
                		<div class="col-sm-12 text-center">
							
<button type="submit" class="btn btn-primary" >
										Submit
									</button>							
							</div>
							</div>
							
							</div>
							</div>
						</div>
					</div>
	<div class="col-lg-3">
	</div>			
 
 

</form> 
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
       <script
		src="${pageContext.request.contextPath}/resources/assets/js/lib/chosen/chosen.jquery.min.js"></script>
   
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
function getCityList(){
		
	var stateId=document.getElementById("stateId").value;
	
	$.getJSON('${getCityByStateId}', {
		
		stateId : stateId,
		ajax : 'true'
		
	}, function(data) {
		
		
		var html = '<option value="" disabled="disabled" selected >Choose City...</option>';
		
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			
			html += '<option value="' + data[i].cityId + '">'
					+ data[i].cityName + '</option>';
		} 
		html += '</option>';
		$('#cityId').html(html);
		
		$("#cityId").trigger("chosen:updated");

	});
	
}


    jQuery(document).ready(function() {
        jQuery(".standardSelect").chosen({
            disable_search_threshold: 10,
            no_results_text: "Oops, nothing found!",
            width: "100%"
        });
    });
</script>

</script>
</body>
</html>
