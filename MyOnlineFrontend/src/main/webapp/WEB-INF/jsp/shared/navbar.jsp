<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
<script>
	window.userRole= '${userModel.role}'
</script>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/">Online Shopping</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${contextRoot}/aboutus">About</a></li>
				<li><a href="${contextRoot}/services">Services</a></li>
				<li><a href="${contextRoot}/contact">Contact</a></li>
				<li><a href="${contextRoot}/product/show/all/products">All
						Product</a></li>

				<security:authorize access="hasAuthority('ADMIN')">
					<li><a href="${contextRoot}/manage/product">Manage Product</a></li>
				</security:authorize>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="signup"><a class="nav-link"
						href="${contextRoot}/register">Sign Up </a>
					</li>
					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextRoot}/login">Login</a>
					</li>
				</security:authorize>
						
				<security:authorize access="isAuthenticated()">
					<li class="dropdown" id="userModel">
						<a class=" dropdown-toggle" href="javascript:void(0)"
							id="dropdownMenu1" data-toggle="dropdown">
							${userModel.fullname}
						</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<security:authorize access="hasAuthority('USER')">
								<li id="cart">
									<a href="${contextRoot}/cart/show"> 
										<span class="glyphicon glyphicon-shopping-cart"></span>&#160;
										<span class="badge">${userModel.cart.cartLines}</span> - 
											&#8377;${userModel.cart.grandTotal}
									</a>
								</li>
								<li role="separator" class="divider"></li>
							</security:authorize>
							
							<li id="logout"><a href="${contextRoot}/custom-logout">Logout</a></li>
						</ul>
					</li>
				</security:authorize>
			
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>