<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row ">
		<c:if test="${not empty message}">
			<div class="col-xs-12 col-md-offset-1 col-md-10">
				<div class="alert alert-success alert-dismissible" role="alert">
					${message}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</c:if>

		<div class="container  col-md-10 col-md-offset-1 ">
			<div class="card ">

				<div class="Card-heading bg-primary text-white"
					style="text-align: center;">
					<h1>Product Management</h1>
				</div>

				<div class="card-body ">
					<sf:form method="post" modelAttribute="product"
						enctype="multipart/form-data"
						action="${contextRoot}/manage/manage/product">
						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="name"> Enter
								Product Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="brand"> Enter
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Product Brand" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="unitPrice">
								Enter Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price in &#8377;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="pname">
								Available Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" id="quantity" path="quantity"
									placeholder="Available quantity" class="form-control" />
								<sf:errors path="quantity" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="description">
								Enter Product Description </label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" id="description"
									rows="5" placeholder="Enter product description :"
									class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="pname">
								Upload File</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" />
							</div>
						</div>


						<div class="form-group row">
							<label class="col-md-4 col-form-label"> Select Category </label>
							<div class="col-md-8">
								<sf:select path="categoryId" id="category" items="${categories}"
									itemLabel="categoryName" itemValue="categoryId"
									class="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<div style="text-align:center;">
								<div style=" display:inline-block;">	
									<c:if test="${product.id == 0}">
										<button type="button" data-toggle="modal"
										data-target="#myCategoryModal" class="btn btn-warning btn-lg">
										Add Category</button>
									</c:if>
								</div>
								<div style="display:inline-block;">
									<sf:hidden path="id" />
									<sf:hidden path="code" />
									<sf:hidden path="supplierId" />
									<sf:hidden path="active" />
									<sf:hidden path="purchases" />
									<sf:hidden path="views" />
									<input type="submit" name="submit" value="submit" id="submit"
										class="btn btn-primary btn-lg">
								</div>
								
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary text-white text-center  "
					style="font-family: sans-serif; font-weight: bold">
					<h2 class="modal-title " id="myModalLebel">New Category</h2>

				</div>
				<div class="modal-body">
					<sf:form id="categoryForm" class="form-horizontal"
						modelAttribute="category"  method="POST"
						action="${contextRoot}/manage/add/category">

						<div class="form-group row">
							<label class="control-label col-md-4">Category Name</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="categoryName" class="form-control"
									placeholder="Enter category name" />
								<sf:errors path="categoryName" cssClass="help-block" 
									element="em"/>
							</div>
						</div>


						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="description">
								Category Description </label>
							<div class="col-md-8 validate">
								<sf:textarea type="text" path="categoryDescription"
									id="description" rows="4" class="form-control"
									placeholder="Enter category description" />
								<sf:errors path="categoryDescription" cssClass="help-block" 
									element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<div class="text-center">
								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="row">
		<div class="col-md-12">
			<h1>Available Products</h1>
		</div>
		
		<div class="col-md-12">
			<table id="adminProductsTable" class="table table-condensed table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>	
</div>