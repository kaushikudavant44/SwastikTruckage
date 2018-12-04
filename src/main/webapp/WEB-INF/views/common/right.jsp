<%@page pageEncoding="UTF-8"%>


<div id="right-panel" class="right-panel">

	<header id="header" class="header" style="height: 58px;">

		<div class="header-menu">

			<div class="col-sm-7">
				<a id="menuToggle" class="menutoggle pull-left"><i
					class="fa fa fa-tasks"></i></a>
				<div class="header-left">


				</div>
			</div>

			<div class="col-sm-5">
				<div class="user-area dropdown float-right">

					<div align="right" style="align-self: center; align-content: center; align-items: center; vertical-align: middle;">

					
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" class="dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<img class="user-avatar rounded-circle"
							src="${pageContext.request.contextPath}/resources/images/user.png"
							alt="User Avatar">
						</a>

						<div class="user-menu dropdown-menu">
							<a class="nav-link" href="#"><i class="fa fa- user"></i>My
								Profile</a> <a class="nav-link" href="#"><i class="fa fa- user"></i>Notifications
								<span class="count">13</span></a> <a class="nav-link" href="#"><i
								class="fa fa -cog"></i>Settings</a> <a class="nav-link"
								href="${pageContext.request.contextPath}/logout"><i
								class="fa fa-power -off"></i>Logout</a>
						</div>
					</div>
				</div>




			</div>
		</div>

	</header>
	<!-- /header -->