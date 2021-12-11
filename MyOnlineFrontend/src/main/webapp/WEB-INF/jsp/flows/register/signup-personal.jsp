<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="wrapper">

	<div class="container ">

		<div class="row col-md-6 col-md-offset-3">

				<div class="panel panel-primary ">

					<div class="panel-heading text-center">
						<h3>Sign Up - Personal</h3>
					</div>

					<div class="panel-body">

						<sf:form method="POST" modelAttribute="user"
							class="form-horizontal" id="registerForm">


							<div class="form-group row">
								<label class="col-md-4 col-form-label">First Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="firstName" class="form-control"
										placeholder="First Name" />
									<sf:errors path="firstName" cssClass="help-block" element="em" />
								</div>
							</div>


							<div class="form-group row">
								<label class="col-md-4 col-form-label">Last Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="lastName" class="form-control"
										placeholder="Last Name" />
									<sf:errors path="lastName" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-md-4 col-form-label">Email</label>
								<div class="col-md-8">
									<sf:input type="text" path="email" class="form-control"
										placeholder="abc@zyx.com" />
									<sf:errors path="email" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-md-4 col-form-label">Contact Number</label>
								<div class="col-md-8">
									<sf:input type="text" path="contactNumber" class="form-control"
										placeholder="XXXXXXXXXX" maxlength="10" />
									<sf:errors path="contactNumber" cssClass="help-block"
										element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-md-4 col-form-label">Password</label>
								<div class="col-md-8">
									<sf:input type="password" path="password" class="form-control"
										placeholder="Password" />
									<sf:errors path="password" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-md-4 col-form-label">Confirm Password</label>
								<div class="col-md-8">
									<sf:input type="password" path="confirmPassword"
										class="form-control" placeholder="Re-type password" />
									<sf:errors path="confirmPassword" cssClass="help-block"
										element="em" />
								</div>
							</div>

							<div class="form-group row">
								<label class="col-md-4 col-form-label">Select Role</label>
								<div class="col-md-8">
									<label class="radio-inline"> <sf:radiobutton
											path="role" value="USER" checked="checked" /> User
									</label> <label class="radio-inline"> <sf:radiobutton
											path="role" value="SUPPLIER" /> Supplier
									</label>
								</div>
							</div>

							<br />
							<div class="form-group row">
								<div class="text-center">
									<button type="submit" name="_eventId_address"
										class="btn btn-primary">
										Next - Address <span class="glyphicon glyphicon-chevron-right"></span>
									</button>
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../flows-shared/footer.jsp"%>