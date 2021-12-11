<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<%@include file="./shared/sidebar.jsp"%>
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userclickallproducts == true }">
						<script>
							window.category_Id = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userclickcategoryproducts == true }">
						<script>
							window.category_Id = '${category.categoryId}';
						</script>
						
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active"> ${category.categoryName } </li>
						</ol>
					</c:if>	
				</div>
			</div>
			
			
			<div class="col-lg-12">
				<table id="productTable" class="table table-condensed table-striped table-hover">
					<thead>
						<tr>
							<th></th>
							<th>PRODUCT NAME</th>
							<th>PRODUCT BRAND</th>
							<th>UNIT PRICE</th>
							<th>AVAILABLE QUANTITY</th>
							<th></th>
						</tr>
					</thead>
					
					<tfoot>
						<tr>
							<th></th>
							<th>PRODUCT NAME</th>
							<th>PRODUCT BRAND</th>
							<th>UNIT PRICE</th>
							<th>AVAILABLE QUANTITY</th>
							<th></th>
						</tr>
					</tfoot>
					
				
				</table>
			
			</div>
		</div>
	</div>
</div>


