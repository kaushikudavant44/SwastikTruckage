<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<aside id="left-panel" class="left-panel">
<nav class="navbar navbar-expand-sm navbar-default">
<div class="navbar-header">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#main-menu" aria-controls="main-menu"
				aria-expanded="false" aria-label="Toggle navigation">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="./getLogin">Swastik Truckage
			</a> <a class="navbar-brand hidden" href="./"> S</a>
		</div>
		
		<div id="main-menu" class="main-menu collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/translate">
						<i class="menu-icon fa fa-dashboard"></i> DASHBOARD
				</a></li>

				<!--                     <h3 class="menu-title">UI elements</h3>/.menu-title
 -->
				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i> Masters
				</a>
					<ul class="sub-menu children dropdown-menu ">
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showOfficeReg">Add New Office</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showStaffRoleReg">Add New Role</a></li>
								
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showOfficeStaffReg">Add New Staff</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showOfficesDetails">Offices</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showStaffDetails">Staffs</a></li>	
					
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showGoodsReg">Goods Details</a></li>			
					
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showLRRegistration">Create LR</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showLrDetails">Show LR</a></li>	
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/generateMemo">Create Memo</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showMemo">Show Memo</a></li>
							
					      <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showClientReg">Add New Client</a></li>
									
							
					     <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllClientDetails">Clients</a></li>		
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showVehicleOwnerReg">Add Vehicle Owner</a></li>	
							
					   <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllVehicleOwnerDetails">Vehicle Owners</a></li>
							
					   <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showVehicleReg">Add New Vehicle</a></li>
							
					   <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllVehicleDetails">Vehicles</a></li>	
							
					   <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showVehicleDriverReg">Add Driver</a></li>	
							
					   <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllVehicleDriverDetails">Drivers</a></li>
									
							
						</ul></li>
						
						<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Billing
				</a>
					<ul class="sub-menu children dropdown-menu ">


                        <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showUnPaidClients"> Pending Bill</a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllUnPaidLr">LR Collection</a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showGeneratedClientBills">Bill List</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showGeneratedCollectionBills">LR Collection List </a></li>

					
					</ul></li>		
						
					<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Report
				</a>
					<ul class="sub-menu children dropdown-menu ">


						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showpendingPaymentLrList">Payment Pending</a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showLrListByDate">LR List</a></li>

                        <li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showPaidBills">Total Bill</a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showCollectionList">Collection List</a></li>





					</ul></li>	
						

				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Orders
				</a>
					<ul class="sub-menu children dropdown-menu ">


						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showTodaysOrder"></a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showUpdateOrderStatus"></a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showOrderHistory"></a></li>



					</ul></li>




				

				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>MyProfile
				</a>
					<ul class="sub-menu children dropdown-menu ">
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/editHubUser/1"></a></li>


					</ul>
			</ul>

		</div>


</nav>
</aside>