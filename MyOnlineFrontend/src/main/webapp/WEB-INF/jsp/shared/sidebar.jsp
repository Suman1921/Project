<div class="col-md-3">
	<p class="lead">Online Shopping</p>
	<div class="list-group">
		<c:forEach items="${categories}" var="category">
			<a href="${contextRoot}/product/show/category/${category.categoryId}/products" class="list-group-item">${category.categoryName}</a> 
		</c:forEach>
	</div>
</div>