<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 
 <c:set var="flag2" value="2"/>
 <c:forEach items="${sessionScope.navBarMainMenuList}" var="navBarMainMenu">
 
 <c:set var="flag" value="1"/>
 
 <c:if test="${flag2==1}">
 
 <c:set var="flag2" value="2"/>
 </ul>
 </li>
 
 </c:if>

 
<%--  <c:if test="${flag==1}"> --%>
   
			<%-- 	<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i> ${navBarMainMenu.menuName}
				</a> --%>
					<%-- </c:if> --%>
					
					  <c:forEach items="${sessionScope.navBarSubMainMenuList}" var="navBarSubMainMenu" varStatus="count">
					<c:if test="${navBarSubMainMenu.menuId==navBarMainMenu.menuId}">
					
					
					<c:if test="${flag==1}">
					 <c:set var="flag2" value="1"/>
					<c:set var="flag" value="0"/>
					<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i> ${navBarMainMenu.menuName}
				</a>
					<ul class="sub-menu children dropdown-menu ">
					</c:if>
					
						 
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/${navBarSubMainMenu.subMenuUrl}">${navBarSubMainMenu.subMenuName}</a></li>
								
					 
						
						
						  
					
					 </c:if>
						</c:forEach>
						
							 
						</c:forEach>
						
					<%-- 	<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Lr Details
				</a>
					<ul class="sub-menu children dropdown-menu ">
					
					<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showLRRegistration">Create LR</a></li>
							
					<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showLrDetails">View LR List</a></li>
							
					<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showRecievedLrDetails">Mark as Delivered</a></li>			

					</ul></li>
					
					
					
					<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Memo Details
				</a>
					<ul class="sub-menu children dropdown-menu ">
					
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/generateMemo">Create Memo</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showMemo">View Memo List</a></li>
							
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showMemoReceived">Memo Received Entry</a></li>


					
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
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>Local Memo
				</a>
					<ul class="sub-menu children dropdown-menu ">


						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showCreateMemo">Create Local Memo</a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllLocalMemo">Show All Local Memo</a></li>

						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/showAllReceivedLr"></a></li>



					</ul></li> 

 --%>


				

			<%-- 	<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> <i class="menu-icon fa fa-table"></i>MyProfile
				</a>
					<ul class="sub-menu children dropdown-menu ">
						<li class="active"><i class="fa fa-puzzle-piece"></i><a
							href="${pageContext.request.contextPath}/editHubUser/1"></a></li>


					</ul>
			</li> --%>

		</div>


</nav>
</aside>