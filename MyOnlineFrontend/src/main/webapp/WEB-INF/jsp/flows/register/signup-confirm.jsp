<%@include file="../flows-shared/header.jsp"%>
<div class="container">

	<div class="row">

		<div class="col-md-6">

			<div class="card">

				<div class="card-heading bg-primary text-white">
					<h4>Personal Details</h4>
				</div>

				<div class="card-body">
					<div class="text-center">
						<h3>
							Name : <strong>${registerModel.user.firstName}
								${registerModel.user.lastName}</strong>
						</h3>
						<h4>
							Email : <strong>${registerModel.user.email}</strong>
						</h4>
						<h4>
							Contact : <strong>${registerModel.user.contactNumber}</strong>
						</h4>
						<h4>
							Role : <strong>${registerModel.user.role}</strong>
						</h4>
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal"
								class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span>Edit - Personal</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-6">

			<div class="card">

				<div class="card-heading bg-primary text-white">
					<h4>Billing Address</h4>
				</div>

				<div class="card-body">
					<div class="text-center">
						<p><strong>${registerModel.address.addressLineOne},</strong></p>
						<p><strong>${registerModel.address.addressLineTwo},</strong></p>
						<p><strong>${registerModel.address.city}-
									${registerModel.address.postalCode},</strong></p>
						<p><strong>${registerModel.address.state}</strong></p>
						<p><strong>${registerModel.address.country}</strong></p>
						<p>
							<a href="${flowExecutionUrl}&_eventId_address"
								class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span>Edit - Address</a>
						</p>
					</div>
				</div>

			</div>

		</div>

	</div>
	<br />
	<div class="row">
			<div class="text-center">

				<a href="${flowExecutionUrl}&_eventId_success"
					class="btn btn-lg btn-primary">Next - Success<span class="glyphicon glyphicon-chevron-right"></span></a>
		</div>

	</div>

</div>
<%@include file="../flows-shared/footer.jsp"%>