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
							href="${pageContext.request.contextPath}/showLRRegistration">Generate LR</a></li>	
							
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
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Report
				</a>
					<ul class="sub-menu children dropdown-menu ">


						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showDistReport"></a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showItemwiseReport"></a></li>


						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showCatwiseReport"></a></li>





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